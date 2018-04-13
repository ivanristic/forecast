package com.sargije.ws.hidmet.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sargije.ws.hidmet.app.model.Forecast;



@Transactional
public interface ForecastRepository extends CrudRepository<Forecast, Long>{	
	List<Forecast> findByActive(Long active);
}
