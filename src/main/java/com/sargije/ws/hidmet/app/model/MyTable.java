package com.sargije.ws.hidmet.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.ParameterMode;
import javax.persistence.Table;


@Entity
@Table(schema="hidmet", name = "MyTable")
@NamedStoredProcedureQueries({
   @NamedStoredProcedureQuery(name = "in_test", 
                              procedureName = "in_only_test",
                              parameters = {
                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class)
						                              }),
 @NamedStoredProcedureQuery(name = "out_test", 
						   procedureName = "in_and_out_test",
						   resultClasses = MyTable.class,
						   parameters = {
						      @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class),
						      @StoredProcedureParameter(mode = ParameterMode.OUT, name = "outParam1", type = String.class)
						   })
})
public class MyTable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	Long id;

}