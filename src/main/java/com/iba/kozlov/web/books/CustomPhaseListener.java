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
import com.iba.kozlov.bl.service.ReaderService;
import com.iba.kozlov.bl.service.WriterService;
import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.db.dto.ReaderDto;
import com.iba.kozlov.db.dto.WriterDto;
import com.iba.kozlov.web.application.ApplicationBean;
import com.iba.kozlov.web.application.BookBean;
import com.iba.kozlov.web.application.ReaderBean;
import com.iba.kozlov.web.application.WriterBean;
import com.iba.kozlov.web.books.view.MainBean;
import com.iba.kozlov.web.books.view.TableRowBean;

public class CustomPhaseListener implements PhaseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1525317892440855268L;
	private static final Logger LOGGER = Logger.getLogger(CustomPhaseListener.class);
	ApplicationBean applBean = null;
	BookController bookController=null;
	

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
			applBean.init();
			bookController = (BookController) FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(
					FacesContext.getCurrentInstance(), "#{bookController}", BookController.class);
			bookController.init();
		}

	}

	@Override
	public PhaseId getPhaseId() {

		return PhaseId.RENDER_RESPONSE;
	}

}
