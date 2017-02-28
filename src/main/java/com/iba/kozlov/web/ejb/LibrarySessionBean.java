package com.iba.kozlov.web.ejb;

import javax.ejb.Stateless;

import lombok.Getter;

@Stateless
public class LibrarySessionBean implements LibrarySessionBeanLocal {
    @Getter
	String test="ejb Test";
    
    public LibrarySessionBean(){
     
    }
    
   
}
