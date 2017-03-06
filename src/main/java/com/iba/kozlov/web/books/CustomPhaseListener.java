package com.iba.kozlov.web.books;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.log4j.Logger;

import com.iba.kozlov.bl.service.BookService;
import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.web.application.ApplicationBean;
import com.iba.kozlov.web.application.BookBean;

public class CustomPhaseListener implements PhaseListener {
	private static final Logger LOGGER = Logger.getLogger(CustomPhaseListener.class);
	ApplicationBean applBean = null;
	@EJB
	BookService bookService;
	Mapper mapper = new Mapper();

	public List<BookBean> getBookBean() {
		List<BookDto> bookDto = bookService.readBooks();
		List<BookBean> bookBean = new ArrayList<>();
		for (BookDto book : bookDto) {
			bookBean.add(mapper.bookDtoToBean(book));
		}
		return bookBean;
	}

	@Override
	public void afterPhase(PhaseEvent event) {

	}

	@Override
	public void beforePhase(PhaseEvent event) {
		LOGGER.info("beforePhase");
		PartialViewContext pvc = FacesContext.getCurrentInstance().getPartialViewContext();
		if (pvc.isAjaxRequest()) {
			LOGGER.info("ajax");
		} else {
			LOGGER.info("not ajax");
			applBean = (ApplicationBean) FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(
					FacesContext.getCurrentInstance(), "#{applicationBean}", ApplicationBean.class);
			applBean.setBookBeans(getBookBean());
		}

	}

	@Override
	public PhaseId getPhaseId() {

		return PhaseId.RENDER_RESPONSE;
	}

}
