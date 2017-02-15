package com.iba.kozlov.web.writer;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.iba.kozlov.db.dto.WriterDto;


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
			List<WriterDto> writerDto =controller.writerService.readWriters();
			List<TableRowBean> writerBean = new ArrayList<>();

			for (WriterDto writer : writerDto) {
				writerBean.add(controller.mapper.WriterDtoToTableRowBean(writer));
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
		controller.writerService
				.editWriter(controller.mapper.TableRowBeanToWriterDto(controller.writerMainBean.getEditorBean()));
	}

	public void onEditOpen() {
		LOGGER.info("onEditOpen" + controller.writerMainBean.getSelectedWriter());
		controller.writerMainBean.setEditorBean(controller.writerMainBean.getSelectedWriter());

	}

	public void onSearch() {

		LOGGER.info("onSearch");

		if (controller.writerMainBean.getAuthorSearch() != null) {
			LOGGER.info("1");
			TableRowBean writerSearch = controller.writerMainBean.getAuthorSearch();

			List<WriterDto> resultSearch = controller.writerService
					.searchWriters(controller.mapper.TableRowBeanToWriterDto(writerSearch));

			List<TableRowBean> writer = new ArrayList<>();
			for (WriterDto writerDto : resultSearch) {
				writer.add(controller.mapper.WriterDtoToTableRowBean(writerDto));
			}
			controller.writerMainBean.setTableRowBeanList(writer);

		} else {
			controller.writerMainBean.setTableRowBeanList(getWriters());
		}

	}

	public void onAddOpen() {
		controller.writerMainBean.setEditorBean(new TableRowBean());
		
	}
}
