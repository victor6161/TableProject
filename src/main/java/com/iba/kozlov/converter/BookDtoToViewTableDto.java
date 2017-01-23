package com.iba.kozlov.converter;

import com.iba.kozlov.dto.BookDto;
import com.iba.kozlov.viewDto.ViewTableDto;

public class BookDtoToViewTableDto {
	
	public ViewTableDto convert(BookDto bookDto){
		ViewTableDto viewDto=new ViewTableDto();
		viewDto.setAuthor(bookDto.getAuthor());
		viewDto.setBookname(bookDto.getBookname());
		viewDto.setPrice(bookDto.getPrice());
		viewDto.setUsername(bookDto.getUserDto().getUsername());
		return viewDto;
	}
	

}
