package com.bornfire.xbrl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bornfire.xbrl.entities.Personal_DBR_Entity;
import com.bornfire.xbrl.entities.Personal_DBR_Entity;
import com.bornfire.xbrl.entities.Personal_DBR_Repo;
import com.bornfire.xbrl.entities.Personal_INCOME_Entity;
import com.bornfire.xbrl.entities.Personal_INCOME_Repo;
import com.bornfire.xbrl.entities.SCORE_CALCULATION_ENTITY;
import com.bornfire.xbrl.entities.SCORE_CALCULATION_REPO;
import com.bornfire.xbrl.entities.SCORE_CARD_PERSONAL_LOAN_ENTITY;
import com.bornfire.xbrl.entities.SCORE_CARD_PERSONAL_LOAN_REPO;

@Service
public class ScorecardService {

	
	
	  @Autowired
	     SCORE_CARD_PERSONAL_LOAN_REPO scoreCardPersonalLoanRepo;

	    @Autowired
	     SCORE_CALCULATION_REPO scoreCalculationRepo;

	    @Autowired
	     Personal_DBR_Repo personalDBRRepo;

	    @Autowired
	     Personal_INCOME_Repo personalIncomeRepo;

	    public List<SCORE_CARD_PERSONAL_LOAN_ENTITY> getPersonalLoanCUSIDList() {
	        return scoreCardPersonalLoanRepo.getCUSIDlist();
	    }

	    public List<SCORE_CALCULATION_ENTITY> getScoreCalculationList() {
	        return scoreCalculationRepo.getDBRlist();
	    }

	    public List<Personal_DBR_Entity> getPersonalDBRList() {
	        return personalDBRRepo.getDBRlist();
	    }

	    public List<Personal_INCOME_Entity> getPersonalIncomeList() {
	        return personalIncomeRepo.getDBRlist();
	    }

	    public void saveScoreCard(SCORE_CARD_PERSONAL_LOAN_ENTITY entity) {
	        scoreCardPersonalLoanRepo.save(entity);
	    }
}
