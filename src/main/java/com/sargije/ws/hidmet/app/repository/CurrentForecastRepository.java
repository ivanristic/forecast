package com.sargije.ws.hidmet.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sargije.ws.hidmet.app.model.CurrentForecastModel;


@Transactional
public interface CurrentForecastRepository extends CrudRepository<CurrentForecastModel, Long>{	
	 
	List<CurrentForecastModel> findByActive(Long active);	

}
