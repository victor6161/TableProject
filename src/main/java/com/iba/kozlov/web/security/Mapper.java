package com.iba.kozlov.web.security;

import java.util.Base64;

import com.iba.kozlov.db.dto.ReaderDto;
import com.iba.kozlov.web.application.RegistrationBean;

public class Mapper {
	public ReaderDto registrationBeanToReaderDto(RegistrationBean registrationBean){
		ReaderDto readerDto = new ReaderDto();
		readerDto.setLogin(registrationBean.getLogin());
		
		String password = registrationBean.getPassword();
		byte[] passArrayByte = password.getBytes();
		String encoded = Base64.getEncoder().encodeToString(passArrayByte);
		
		readerDto.setPassword(encoded);
		readerDto.setName(registrationBean.getName());
		readerDto.setSurname(registrationBean.getSurname());
		//readerDto.setRole(role);
		
		
		return readerDto;
	}

}
