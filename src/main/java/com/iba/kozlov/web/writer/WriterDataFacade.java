package com.iba.kozlov.web.writer;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.db.dto.WriterDto;
import com.iba.kozlov.web.application.WriterBean;

import com.iba.kozlov.web.writers.view.TableRowBean;

public class WriterDataFacade {
	private static final Logger LOGGER = Logger.getLogger(WriterDataFacade.class);
	private WriterController controller;

	public WriterDataFacade(WriterController pController) {
		controller = pController;
	}

	public void initData() {
		controller.writerMainBean.setTableRowBeanList(getWriters());

	}

	public List<TableRowBean> getWriters() {
		
		List<TableRowBean> writerBean = new ArrayList<>();

		for (WriterBean writer : controller.applicationBean.getWriterBeans()) {
			writerBean.add(controller.mapper.WriterBeanToTableRowBean(writer));
		}
		return writerBean;
	}

	public void add() {

		WriterDto writer = controller.mapper.TableRowBeanToWriterDto(controller.writerMainBean.getAddBean());
		LOGGER.info("writer" + writer.toString());
		controller.writerService.createWriter(writer);

		controller.writerMainBean.setTableRowBeanList(getWriters());

		controller.writerMainBean.getAddBean().setName(null);
		controller.writerMainBean.getAddBean().setSurname(null);
		controller.writerMainBean.getAddBean().setCountry(null);
	}

	public void edit() {
		controller.writerService.editWriter(controller.mapper.TableRowBeanToWriterDto(controller.writerMainBean.getEditorBean()));
	}

	public void onEditOpen() {
		LOGGER.info("onEditOpen" + controller.writerMainBean.getSelectedWriter());
		controller.writerMainBean.setEditorBean(controller.writerMainBean.getSelectedWriter());

		
	}

	public void onSearch() {
		
/*		LOGGER.info("onSearch");
		BookDto bookDto = new BookDto();

		if (controller.writerMainBean.getSearchBean().getAuthorSearch() != null) {
			LOGGER.info("1");
			List<WriterBean> writersSearch = controller.writerMainBean.getSearchBean().getAuthorSearch();
			List<WriterDto> result = new ArrayList<>();
			for (WriterBean writer : writersSearch) {
				LOGGER.info("2 "+writer.toString());
				result.add(controller.mapper.writerBeanToDto(writer));
			}
			bookDto.setWriters(result);

		}
		

		List<BookDto> resultSearch = controller.writerService.searchWriters(bookDto);

		List<TableRowBean> viewTableDto = new ArrayList<>();
		for (BookDto bookDtoItem : resultSearch) {
			viewTableDto.add(controller.mapper.bookDtoToViewTableDto(bookDtoItem));
		}
		controller.writerMainBean.setTableRowBeanList(viewTableDto);*/
	}
}
