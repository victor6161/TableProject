package com.iba.kozlov.web.books;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

import com.iba.kozlov.db.dto.BookDto;

import com.iba.kozlov.db.dto.WriterDto;

import com.iba.kozlov.web.application.WriterBean;
import com.iba.kozlov.web.books.view.TableRowBean;
import com.iba.kozlov.web.component.ChartBean;

public class BookDataFacade implements Serializable {
	private static final Logger LOGGER = Logger.getLogger(BookDataFacade.class);

	private static final long serialVersionUID = -5823792094177216548L;

	private BookController controller;

	public BookDataFacade(BookController pController) {
		controller = pController;

	}

	public void postProcessXLS(Object document) {
		LOGGER.info("1");
		HSSFWorkbook wb = (HSSFWorkbook) document;
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow headerRow = sheet.getRow(0);
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setFont(font);
		for (int i = 0; i < headerRow.getPhysicalNumberOfCells() - 1; i++) {
			sheet.autoSizeColumn(i);
			headerRow.getCell(i).setCellStyle(style);
		}

		
		for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
			LOGGER.info("2");
			HSSFRow row = sheet.getRow(i);
			Cell cell = row.getCell(row.getPhysicalNumberOfCells() - 1);
			LOGGER.info(row.getPhysicalNumberOfCells());
			if (cell != null) {
				if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
					cell.setCellType(Cell.CELL_TYPE_BLANK);
				}
			}
		}
	}

	public void initData() {

		controller.mainBean.setTableRowBeanList(getTable());

		controller.mainBean.getEditorBean().setWriters(controller.applicationBean.getWriters());
		controller.mainBean.getAddBean().setWriters(controller.applicationBean.getWriters());

		controller.mainBean.setTotalPrice(totalCost());
		controller.mainBean.setAmount(getTable().size());
		controller.getDataModel().setChartValue(setMostPopularWriter());
	}

	private Integer totalCost() {
		Integer totalPrice = 0;
		List<TableRowBean> table = getTable();
		for (TableRowBean row : table) {
			totalPrice += row.getPrice();
		}
		return totalPrice;
	}

	public List<TableRowBean> getTable() {
		List<BookDto> bookDto = controller.bookService.readBooks();

		List<TableRowBean> viewTableDto = new ArrayList<>();
		for (BookDto bookDtoItem : bookDto) {
			viewTableDto.add(controller.mapper.bookDtoToViewTableDto(bookDtoItem));
		}
		return viewTableDto;
	}

	public void editBook() {
		controller.bookService.editBooks(controller.mapper.editorBeanToBookDto(controller.mainBean.getEditorBean()));
		controller.mainBean.setTableRowBeanList(getTable());
	}

	public void onSearch() {
		LOGGER.info("onSearch");
		BookDto bookDto = new BookDto();

		if (controller.mainBean.getSearchBean().getAuthorSearch() != null) {
			LOGGER.info("1");
			List<WriterBean> writersSearch = controller.mainBean.getSearchBean().getAuthorSearch();
			List<WriterDto> result = new ArrayList<>();
			for (WriterBean writer : writersSearch) {
				LOGGER.info("2 " + writer.toString());
				result.add(controller.mapper.writerBeanToDto(writer));
			}
			bookDto.setWriters(result);

		}
		if (controller.mainBean.getSearchBean().getReaderSearch() != null) {
			bookDto.setReader(controller.mapper.readerBeanToDto(controller.mainBean.getSearchBean().getReaderSearch()));
		}
		if (controller.mainBean.getSearchBean().getBookSearch() != null) {

			bookDto.setId(controller.mainBean.getSearchBean().getBookSearch().getId());
		}

		List<BookDto> resultSearch = controller.bookService.searchBooks(bookDto);

		List<TableRowBean> viewTableDto = new ArrayList<>();
		for (BookDto bookDtoItem : resultSearch) {
			viewTableDto.add(controller.mapper.bookDtoToViewTableDto(bookDtoItem));
		}
		controller.mainBean.setTableRowBeanList(viewTableDto);

	}

	public void onEditOpen() {
		Mapper mapper = new Mapper();
		BookDto bookDto = mapper.viewTableDtoToBookDto(controller.mainBean.getSelectedBook());
		LOGGER.info("onEditOpen" + bookDto.toString());

		List<WriterBean> writerBean = new ArrayList<WriterBean>();// �� ���� �
																	// ������
																	// ��������
																	// mainBean
																	// , ���
																	// �����������
																	// , ������
																	// ���������
		writerBean = controller.mainBean.getEditorBean().getWriters();

		controller.mainBean.setEditorBean(mapper.bookDtoToEditorBean(bookDto));

		controller.mainBean.getEditorBean().setWriters(writerBean);
		LOGGER.info("onEditOpen" + controller.mainBean.getSelectedBook().getWriterBean().toString());

		controller.mainBean.getEditorBean().setWriter(controller.mainBean.getSelectedBook().getWriterBean());

	}

	public void add() {

		BookDto book = controller.mapper.addBeanToBookDto(controller.mainBean.getAddBean());
		LOGGER.info("book" + book.toString());
		controller.bookService.addBooks(book);
		Integer amount = controller.mainBean.getAmount();
		Integer totalPrice = controller.mainBean.getTotalPrice();
		totalPrice += controller.mainBean.getAddBean().getPrice();
		amount++;
		LOGGER.info("amount" + amount);
		controller.mainBean.setAmount(amount);
		controller.mainBean.setTotalPrice(totalPrice);
		controller.mainBean.setTableRowBeanList(getTable());

	}

	public void onAddOpen() {
		LOGGER.info("onAddOpen");
		controller.mainBean.getAddBean().setBookname("");
		controller.mainBean.getAddBean().setPrice(0);
		controller.mainBean.getAddBean().setWriter(new WriterBean());

	}

	public List<ChartBean> setMostPopularWriter() {
		List<BookDto> bookAll = controller.bookService.readBooks();
		List<WriterDto> writerAll = controller.writerService.readWriters();
		List<ChartBean> chartValue = new ArrayList<>();
		int amountBooksByWriter;
		for (WriterDto writer : writerAll) {
			amountBooksByWriter = 0;
			for (BookDto book : bookAll) {
				if (book.getWriter().getId() == writer.getId()) {
					amountBooksByWriter++;
				}
			}
			chartValue.add(new ChartBean(writer.getSurname(), amountBooksByWriter));

		}
		Collections.sort( chartValue);
		return chartValue;
	
		
	}

}
