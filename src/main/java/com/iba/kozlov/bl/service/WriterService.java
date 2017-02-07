package com.iba.kozlov.bl.service;


import java.util.List;

import org.apache.log4j.Logger;


import com.iba.kozlov.db.dao.BookSearchCriteria;
import com.iba.kozlov.db.dao.WriterDao;

import com.iba.kozlov.db.dto.WriterDto;


public class WriterService {
	private static final Logger LOGGER = Logger.getLogger(BookServiceImpl.class);
	private WriterDao writerDao=new WriterDao();
	public int findIdBySurname(String writerSurname) {
		LOGGER.info("findIdBySurname method");
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria();
		List<WriterDto> writerDto = writerDao.read(bookSearchCriteria);
		
		for(WriterDto writer:writerDto){
			if(writer.getSurname().equals(writerSurname)){
				return writer.getId();
			}
		}
		return 0;
	}
	public List<WriterDto> readWriters(){
		return writerDao.read(new BookSearchCriteria());
		
	}
	public void createWriter(WriterDto writerDto){
		writerDao.createWriter(writerDto);
	}

}
