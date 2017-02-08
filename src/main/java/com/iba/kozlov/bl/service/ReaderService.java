package com.iba.kozlov.bl.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.iba.kozlov.db.dao.BookSearchCriteria;
import com.iba.kozlov.db.dao.ReaderDao;
import com.iba.kozlov.db.dto.ReaderDto;



public class ReaderService {
	private static final Logger LOGGER = Logger.getLogger(ReaderService.class);
	private ReaderDao readDao=new ReaderDao();
	public List<ReaderDto> readReaders(){
		
		return readDao.read(new BookSearchCriteria());
	}
}
