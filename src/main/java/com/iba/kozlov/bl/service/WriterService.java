package com.iba.kozlov.bl.service;


import java.util.List;

import org.apache.log4j.Logger;



import com.iba.kozlov.db.dao.WriterDao;
import com.iba.kozlov.db.dao.WriterSearchCriteria;

import com.iba.kozlov.db.dto.WriterDto;



public class WriterService {
	private static final Logger LOGGER = Logger.getLogger(WriterService.class);
	private WriterDao writerDao=new WriterDao();
	public int findIdBySurname(String writerSurname) {
		LOGGER.info("findIdBySurname method");
		
		List<WriterDto> writerDto = writerDao.read(null);
		
		for(WriterDto writer:writerDto){
			if(writer.getSurname().equals(writerSurname)){
				return writer.getId();
			}
		}
		return 0;
	}
	public List<WriterDto> readWriters(){
		LOGGER.info("readWriters");
		return writerDao.read(null);
		
	}
	public void createWriter(WriterDto writerDto){
		LOGGER.info("createWriter");
		writerDao.createWriter(writerDto);
	}
	public void editWriter(WriterDto writerDto) {
		LOGGER.info("editWriter");
		writerDao.updateWriter(writerDto);
	}
	public List<WriterDto> searchWriters(WriterDto writerDto) {
		LOGGER.info("searchWriter");
		WriterSearchCriteria writerSearchCriteria=new WriterSearchCriteria();
		writerSearchCriteria.setWriterId(writerDto.getId());
		return writerDao.read(writerSearchCriteria);
	}
}
