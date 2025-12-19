package com.bornfire.xbrl.services;


import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.Session;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.entities.Rampop_Entity;
import com.bornfire.xbrl.entities.Rompop_repo;

@Service
@Transactional
@ConfigurationProperties("output")


public class RatingService {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	Rompop_repo romrepo;
	
	
	public List<Rampop_Entity>  getAbsenteesFrom(String parameters) {
		System.out.println("2");
		
		List<Rampop_Entity> san= romrepo.getstatusList(parameters);
		for(Rampop_Entity a: san) {
			Rampop_Entity b=new Rampop_Entity();
		
			
		}
		System.out.println("sanjeev testing" +san);
		String msg="hi sanjeev";
		
	return san;




}
}
