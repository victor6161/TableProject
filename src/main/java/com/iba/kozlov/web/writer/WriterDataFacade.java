package com.iba.kozlov.web.writer;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.iba.kozlov.db.dto.WriterDto;
import com.iba.kozlov.web.writers.view.AddBean;
import com.iba.kozlov.web.writers.view.EditorBean;
import com.iba.kozlov.web.writers.view.SearchBean;
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
		List<WriterDto> writerDto = controller.writerService.readWriters();
		List<TableRowBean> writerBean = new ArrayList<>();

		for (WriterDto writer : writerDto) {
			writerBean.add(controller.mapper.writerDtoToTableRowBean(writer));
		}
		return writerBean;

	}

	public void add() {

		WriterDto writer = controller.mapper.addBeanToWriterDto(controller.writerMainBean.getAddBean());
		LOGGER.info("writer" + writer.toString());
		controller.writerService.createWriter(writer);

		controller.writerMainBean.setTableRowBeanList(getWriters());
		controller.writerMainBean.getAddBean().setName(null);
		controller.writerMainBean.getAddBean().setSurname(null);
		controller.writerMainBean.getAddBean().setCountry(null);
	}

	public void edit() {
		controller.writerService
				.editWriter(controller.mapper.editBeanToWriterDto(controller.writerMainBean.getEditorBean()));
		controller.writerMainBean.setTableRowBeanList(getWriters());
	}

	public void onEditOpen() {
		LOGGER.info("onEditOpen" + controller.writerMainBean.getSelectedWriter());
	
		WriterDto writerDto = controller.mapper.tableRowBeanToWriterDto(controller.writerMainBean.getSelectedWriter());
		EditorBean editorBean= controller.mapper.writerDtoToEditBean(writerDto);
		controller.writerMainBean.setEditorBean(editorBean);

	}

	public void onSearch() {

		LOGGER.info("onSearch");

		if (controller.writerMainBean.getAuthorSearch() != null) {
			LOGGER.info("1");
			SearchBean writerSearch = controller.writerMainBean.getAuthorSearch();

			List<WriterDto> resultSearch = controller.writerService
					.searchWriters(controller.mapper.searchBeanToWriterDto(writerSearch));

			List<TableRowBean> writer = new ArrayList<>();
			for (WriterDto writerDto : resultSearch) {
				writer.add(controller.mapper.writerDtoToTableRowBean(writerDto));
			}
			controller.writerMainBean.setTableRowBeanList(writer);

		} else {
			controller.writerMainBean.setTableRowBeanList(getWriters());
		}

	}

	public void onAddOpen() {
		controller.writerMainBean.setAddBean(new AddBean());

	}
}
