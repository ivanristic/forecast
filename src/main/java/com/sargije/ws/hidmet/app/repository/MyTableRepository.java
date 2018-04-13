package com.sargije.ws.hidmet.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sargije.ws.hidmet.app.model.CurrentForecastModel;
import com.sargije.ws.hidmet.app.model.MyTable;

public interface MyTableRepository extends CrudRepository<MyTable, Long> {
    
	@Procedure(name = "in_test")
    void inOnlyTest(@Param("inParam1") String inParam1);   
   
	
	@Procedure(name = "out_test")	
	String inOutTest(@Param("inParam1") String inParam1);
    
 }