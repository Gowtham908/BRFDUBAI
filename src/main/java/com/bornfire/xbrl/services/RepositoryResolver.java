package com.bornfire.xbrl.services;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.bornfire.xbrl.entities.BRBS.*;

@Component
public class RepositoryResolver {

    @Autowired
    private BRF14_Detailrep brf14DetailRep;
    
    @Autowired
	BRF31_DetailRep brf31_DetailRep;
    
    @Autowired
	BRF32B_DetailRepo brf32b_detailrepo;
    
    @Autowired
	BRF81DetailRep brf81DetailRep;
    
    @Autowired
	BRF51_Detailrep brf51detailrep;

    @Autowired
	BRF52_Detailrep brf52detailrep;
    
    @Autowired
	BRF53_DetailRep brf53detailrep;
    
    @Autowired
	BRF54_DetailRep brf54detailrep;
    
    @Autowired
	BRF56_DetailRepo  brf56DetailRep;
    
    @Autowired
	BRF57_DetailRepo brf57_DetailRepo;
    
    @Autowired
	BRF59DetailRep brf59DetailRep;
    
    @Autowired
	BRF60_DetailRep brf60_DetailRep;
    
    @Autowired
	BRF62DetailRepo brf62DetailRepo;
    
    @Autowired 
	 BRF64_DetailRepo brf64_detailrepo;
    
    @Autowired
	BRF65_DetailRepo brf65DetailRep;
    
    @Autowired
	BRF67_DetailRep brf67_DetailRep;
    
    @Autowired
	BRF68_DetailRepo brf68_DetailRepo;
    
    @Autowired
	BRF1_DetaiRep BRF1_DetaiRep1;
	/*
	 * @Autowired BRF69_DetailRepo brf69_detailrepo;
	 * 
	 * @Autowired BRF70_DetailRepo brf70_Detailrepo;
	 * 
	 * @Autowired BRF71_DetailRepo brf71_detailrepo;
	 */
    
    @Autowired 
	BRF73_DetailRepo brf73_detailrepo;
    
    @Autowired
	BRF74_DetailRepo brf74_detailrepo;
    
    @Autowired
	BRF76_DetailRepo brf76_detailrepo;
    
    @Autowired 
	 BRF77_DetailRepo brf77_detailrepo;
    
    @Autowired
	BRF78_DetailRepo brf78_detailrepo;
    
    @Autowired 
	 BRF79_Detailrepo brf79_detailrepo;
    
    @Autowired
	BRF80_Detailrepo brf80_detailrepo;
    
	/*
	 * @Autowired BRF81DetailRep brf81DetailRep1;
	 */
    
    @Autowired
	BRF82DetailRep brf82DetailRep;
    
    @Autowired 
	BRF83_DetailRepo brf83_detailrepo;
    
    @Autowired
	BRF84_DetailRepo brf84_detailrepo;
    
    @Autowired
	BRF85_DetailRepo brf85_detailrepo;
    @Autowired
	BRF86_Detailrepo brf86_detailrepo;
    
    @Autowired 
	 BRF87_DetailRepo brf87_detailrepo;
    @Autowired
	BRF88_DetailRepo brf88_detailrepo;
    
    @Autowired 
	 BRF92_DetailRepo brf92_detailrepo;
    
    @Autowired
	BRF93_Detailrep BRF93_Detailrep;
    
    @Autowired 
	 BRF95_DetailRepo brf95_detailrepo;
    
    @Autowired
	BRF96_DetailRepo brf96_detailrepo;
    
    @Autowired
	BRF99_DetailRepo brf99_Detailrep;
    
    @Autowired
	BRF100_DetailRep brf100_DetailRep;
    
    @Autowired
	BRF101_DetaiRep BRF101_DetaiRep1;
    
    @Autowired
	BRF102_DetailRep brf102Detailrep;
    
    @Autowired
	BRF103_DetailRep brf103_DetailRep;
    
    @Autowired
	BRF104_DetailRepo brf104_detailrepo;
    
    @Autowired
	BRF105_DetailRepo brf105_detailrepo;
    
    @Autowired
	BRF106DETAIL_Repo bRF106DETAIL_Repo;
    
    @Autowired
	BRF107_DetailRepo brf107_detailrepo;
    
    @Autowired
	BRF109_DetailRepo brf109_detailrepo;
    
    @Autowired
	BRF94_Detailrep brf94_Detailrep;
    
    @Autowired
	BRF181DETAIL_Repo bRF181DETAIL_Repo;
    
    @Autowired
	BRF200_DETAILREPO bRF200_DETAILREPO;
    
    @Autowired
	BRF205_DetailRep brf205_DetailRep;
    
    @Autowired
	BRF206DETAIL_Repo bRF206DETAIL_Repo;
    
    @Autowired
	BRF207_DetailRepo brf207_detailrepo;
    
    @Autowired
	BRF208_DetailRepo brf208_detailrepo;
    
    @Autowired
	BRF209_DetailRepo brf209_detailrepo;
    
    @Autowired
	BRF210_DetailRepo brf210_Detailrepo;
    
    @Autowired
	BRF1_DetaiRep BRF1_DetaiRep2;
    
    @Autowired
	BRF2_DetaiRep BRF2_DetaiRep1;
    
    @Autowired
	BRF3_DetaiRep bRF3_DetaiRep;
    
    @Autowired
	BRF4_DetaiRep BRF4_DetaiRep1;
    
    @Autowired
	BRF7_DetailRep bRF7_DetailRep;
    
    @Autowired
	BRF8_DetaiRep bRF8_DetaiRep;
    
    @Autowired
	BRF9_DetaiRep1 BRF9_DetaiRep1;
    
    @Autowired
	BRF10DetailRep brf10DetailRep;
    
    @Autowired
	BRF11_DetaiRep BRF11_DetaiRep;
    
    @Autowired
	BRF12_DETAIL_REPO brf12_DETAIL_REPO;
    
    @Autowired
	BRF13_DetaiRep1 BRF13_DetaiRep1;
    
    @Autowired
	BRF14_Detailrep brf14detailrep;
    
	/*
	 * @Autowired BRF31_DetailRep brf31_DetailRep;
	 */
    
    @Autowired
	BRF32_DetailRepo brf32_detailrepo;
    
    @Autowired
	BRF33_DetailRep BRF33_DetailRep1;
    
    @Autowired 
	 BRF34_DetailRepo brf34_detailrepo;
    
    @Autowired
	BRF35_DetaiRep BRF35_DetaiRep;
    
    @Autowired
	BRF37_DetaiRep BRF37_DetaiRep;
    
    @Autowired
	BRF38_DetaiRep BRF38_DetaiRep;
    
    @Autowired
	BRF39_DetaiRep BRF39_DetaiRep;
    
    @Autowired
	BRF40_DetailRep brf40_DetailRep;
    
    @Autowired
	BRF41DetailRepo brf41DetailRepo;
	
    @Autowired 
  	 BRF42_DetailRepo brf42_detailrepo;
    
    @Autowired
	BRF43_DetailRep brf43_detailrepo;
    
    @Autowired
	BRF44_DetailRep brf44DetailRep;
    
    @Autowired
	BRF45_DetailRepo brf45_detailrepo;
    
    @Autowired
	BRF46_DetailRepo brf46_detailrepo;
    
    @Autowired
	BRF47B_DetailRep BRF47B_DetailRep;
    
	@Autowired
	BRF48_DetailRepo brf48_detailrepo;
	
	@Autowired 
	BRF50_DetailRepo brf50_detailrepo;
	
	@Autowired
	BRF49_DetailRepo brf49_detailrepo;
	
	@Autowired
	BRF151_DetailRepo  brf151DetailRep;
	
	@Autowired 
	BRF152_DetailRepo brf152_detailrepo;
	
	@Autowired
	BRF153_DetailRepo brf153_detailrepo;
	
	@Autowired
	BRF154_DetailRep BRF154_DetailRep;
	
	@Autowired
	BRF155_DetailRep BRF155_DetailRep;
	
	@Autowired
	BRF156_DetailRepo brf156_Detailrep;
    // Add all your repositories here
    private final Map<Class<?>, JpaRepository<?, ?>> repoMap = new HashMap<>();

    @PostConstruct
    public void init() {
        repoMap.put(BRF14_DETAIL_ENTITY.class, brf14DetailRep);
        repoMap.put(BRF31_DETAIL_ENTITY.class, brf31_DetailRep);
        repoMap.put(BRF32B_DETAIL_ENTITY.class, brf32b_detailrepo);
        repoMap.put(BRF81_DETAIL_ENTITY.class, brf81DetailRep);
        
        
        repoMap.put(BRF51_DETAIL_ENTITY.class, brf51detailrep);
        repoMap.put(BRF52_DETAIL_ENTITY.class, brf52detailrep);
        repoMap.put(BRF53_DETAIL_ENTITY.class, brf53detailrep);
        repoMap.put(BRF54_DETAIL_ENTITY.class, brf54detailrep);
        repoMap.put(BRF56_DETAIL_ENTITY.class, brf56DetailRep);
        
        repoMap.put(BRF57_DETAIL_ENTITY.class, brf57_DetailRepo);
        repoMap.put(BRF59_DETAIL_ENTITY.class, brf59DetailRep);
        repoMap.put(BRF60_DETAIL_ENTITY.class, brf60_DetailRep);
        repoMap.put(BRF62_DETAILENTITY.class, brf62DetailRepo);
        repoMap.put(BRF64_DETAIL_ENTITY.class, brf64_detailrepo);
        
        repoMap.put(BRF65_DETAIL_ENTITY.class, brf65DetailRep);
        
        repoMap.put(BRF67_DETAIL_ENTITY.class, brf67_DetailRep);
        repoMap.put(BRF68_DETAIL_ENTITY.class, brf68_DetailRepo);
		
        repoMap.put(BRF73_DETAIL_ENTITY.class, brf73_detailrepo);
        repoMap.put(BRF74_DETAIL_ENTITY.class, brf74_detailrepo);
        repoMap.put(BRF76_DETAIL_ENTITY.class, brf76_detailrepo);
        repoMap.put(BRF77_DETAIL_ENTITY.class, brf77_detailrepo);
        repoMap.put(BRF78_DETAIL_ENTITY.class, brf78_detailrepo);
        repoMap.put(BRF79_DETAIL_ENTITY.class, brf79_detailrepo);
        repoMap.put(BRF80_DETAIL_ENTITY.class, brf80_detailrepo);
       
        repoMap.put(BRF82_DETAIL_ENTITY.class, brf82DetailRep);
        
        repoMap.put(BRF83_DETAIL_ENTITY.class, brf83_detailrepo);
        repoMap.put(BRF84_DETAIL_ENTITY.class, brf84_detailrepo);
        
        repoMap.put(BRF85_DETAIL_ENTITY.class, brf85_detailrepo);
        repoMap.put(BRF86_DETAIL_ENTITY.class, brf86_detailrepo);
        repoMap.put(BRF87_DETAIL_ENTITY.class, brf87_detailrepo);
        repoMap.put(BRF88_DETAIL_ENTITY.class, brf88_detailrepo);
        repoMap.put(BRF92_DETAIL_ENTITY.class, brf92_detailrepo);
        repoMap.put(BRF93_DETAIL_ENTITY.class, BRF93_Detailrep);
        
        repoMap.put(BRF094_DETAIL_ENTITY.class, brf94_Detailrep);
        repoMap.put(BRF95_DETAIL_ENTITY.class, brf95_detailrepo);
        repoMap.put(BRF96_DETAIL_ENTITY.class, brf96_detailrepo);
        repoMap.put(BRF99_DETAIL_ENTITY.class, brf99_Detailrep);
        repoMap.put(BRF100_DETAIL_ENTITY.class, brf100_DetailRep);
        repoMap.put(BRF101_DETAIL_ENTITY.class, BRF101_DetaiRep1);
        repoMap.put(BRF102_DETAIL_ENTITY.class, brf102Detailrep);
        repoMap.put(BRF103_DETAIL_ENTITY.class, brf103_DetailRep);
        repoMap.put(BRF104_DETAIL_ENTITY.class, brf104_detailrepo);
        repoMap.put(BRF105_DETAIL_ENTITY.class, brf105_detailrepo);
        repoMap.put(BRF106_DETAIL_ENTITY.class, bRF106DETAIL_Repo);
        repoMap.put(BRF107_DETAIL_ENTITY.class, brf107_detailrepo);
        repoMap.put(BRF109_DETAIL_ENTITY.class, brf109_detailrepo);
        
        repoMap.put(BRF106_DETAIL_ENTITY.class, bRF106DETAIL_Repo);
        repoMap.put(BRF107_DETAIL_ENTITY.class, brf107_detailrepo);
        repoMap.put(BRF109_DETAIL_ENTITY.class, brf109_detailrepo);
        repoMap.put(BRF181_DETAIL_ENTITY.class, bRF181DETAIL_Repo);
        repoMap.put(BRF200_DETAIL_ENTITY.class, bRF200_DETAILREPO);
       
        repoMap.put(BRF205_DETAIL_ENTITY.class, brf205_DetailRep);
        repoMap.put(BRF206_DETAIL_ENTITY.class, bRF206DETAIL_Repo);
        repoMap.put(BRF207_DETAIL_ENTITY.class, brf207_detailrepo);
        repoMap.put(BRF208_DETAIL_ENTITY.class, brf208_detailrepo);
        repoMap.put(BRF209_DETAIL_ENTITY.class, brf209_detailrepo);
        repoMap.put(BRF210_DETAIL_ENTITY.class, brf210_Detailrepo);
      
        repoMap.put(BRF1_DETAIL_ENTITY.class, BRF1_DetaiRep2);
        repoMap.put(BRF2_DETAIL_ENTITY.class, BRF2_DetaiRep1);
        repoMap.put(BRF003_ENTITY.class, bRF3_DetaiRep);
        repoMap.put(BRF4_DETAIL_ENTITY.class, BRF4_DetaiRep1);
        
        repoMap.put(BRF7_DETAIL_ENTITY.class, bRF7_DetailRep);
        repoMap.put(BRF8_DETAIL_ENTITY.class, bRF8_DetaiRep);
        repoMap.put(BRF9_DETAIL_ENTITY.class, BRF9_DetaiRep1);
        repoMap.put(BRF10_DETAIL_ENTITY.class, brf10DetailRep);
        
        repoMap.put(BRF11_DETAIL_ENTITY.class, BRF11_DetaiRep);
        repoMap.put(BRF12_DETAIL_ENTITY.class, brf12_DETAIL_REPO);
        repoMap.put(BRF13_DETAIL_ENTITY.class, BRF13_DetaiRep1);
        repoMap.put(BRF14_DETAIL_ENTITY.class, brf14detailrep);
        
       
        repoMap.put(BRF32B_DETAIL_ENTITY.class, brf32_detailrepo);
        repoMap.put(BRF33_DETAIL_ENTITY.class, BRF33_DetailRep1);
        repoMap.put(BRF34_DETAIL_ENTITY.class, brf34_detailrepo);
        repoMap.put(BRF35_DETAIL_ENTITY.class, BRF35_DetaiRep);
        repoMap.put(BRF37_DETAIL_ENTITY.class, BRF37_DetaiRep);
        repoMap.put(BRF38_DETAIL_ENTITY.class, BRF38_DetaiRep);
        repoMap.put(BRF39_DETAIL_ENTITY.class, BRF39_DetaiRep);
        repoMap.put(BRF40_DETAIL_ENTITY.class, brf40_DetailRep);
        repoMap.put(BRF41_DETAILENTITY.class, brf41DetailRepo);
        repoMap.put(BRF42_DETAIL_ENTITY.class, brf42_detailrepo);
        repoMap.put(BRF43_DETAIL_ENTITY.class, brf43_detailrepo);
        repoMap.put(BRF44_DETAIL_ENTITY.class, brf44DetailRep);
        repoMap.put(BRF45_DETAIL_ENTITY.class, brf45_detailrepo);
        repoMap.put(BRF46_DETAIL_ENTITY.class, brf46_detailrepo);
        repoMap.put(BRF47B_DETAIL_ENTITY.class, BRF47B_DetailRep);
        
        repoMap.put(BRF48_DETAIL_ENTITY.class, brf48_detailrepo);
        repoMap.put(BRF49_DETAIL_ENTITY.class, brf49_detailrepo);
        repoMap.put(BRF50_DETAIL_ENTITY.class, brf50_detailrepo);
        
        repoMap.put(BRF151_DETAIL_ENTITY.class, brf151DetailRep);
        repoMap.put(BRF152_DETAIL_ENTITY.class, brf152_detailrepo);
        repoMap.put(BRF153_DETAIL_ENTITY.class, brf153_detailrepo);
        repoMap.put(BRF154_DETAIL_ENTITY.class, BRF154_DetailRep);
        repoMap.put(BRF155_DETAIL_ENTITY.class, BRF155_DetailRep);
        repoMap.put(BRF156_DETAILENTITY.class, brf156_Detailrep);
        // Add other entity->repository mappings here
    }

    @SuppressWarnings("unchecked")
    public <T> JpaRepository<T, Object> resolveRepository(Class<?> entityClass) {
        JpaRepository<?, ?> repository = repoMap.get(entityClass);
        if (repository == null) {
            return null;
        }
        return (JpaRepository<T, Object>) repository;
    }
}
