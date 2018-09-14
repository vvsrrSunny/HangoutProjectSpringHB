package com.ho.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate.HibernateTemplate;

public class OperationsUti {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HangoutEntry getHangout(String id) {
		
	}
}
