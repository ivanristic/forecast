package com.sargije.ws.hidmet.app.endpoints;

import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.sargije.ws.hidmet.GetCurrentForecastRequest;
import com.sargije.ws.hidmet.GetCurrentForecastResponse;
import com.sargije.ws.hidmet.app.faults.ServiceFaultException;
import com.sargije.ws.hidmet.app.model.CurrentForecastModel;
import com.sargije.ws.hidmet.app.model.MyTable;
import com.sargije.ws.hidmet.app.repository.CurrentForecastRepository;
import com.sargije.ws.hidmet.app.repository.MyTableRepository;
import com.sargije.ws.hidmet.entities.City;
import com.sargije.ws.hidmet.entities.CurrentForecast;
import com.sargije.ws.wsfaults.FaultMessage;
import com.sargije.ws.hidmet.app.faults.*;

@Endpoint
public class ForecastsEndpoint {
	private static final String NAMESPACE_URI = "http://www.sargije.com/ws/hidmet";
	
	@Autowired
	MyTableRepository myTableRepository;

	@Autowired
	CurrentForecastRepository currentForecastRepository;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCurrentForecastRequest")
	@ResponsePayload
	public GetCurrentForecastResponse getCurrentForecastResponse(@RequestPayload GetCurrentForecastRequest request) {
	/*	throw new ServiceFaultException("ERROR",new FaultMessage(
                "NOT_FOUND", "Beer with id: not found."));*/
		// And to call the method -
		//String  test = myTableRepository.inOutTest("ulazni string");
		 
		// myTableRepository.inOnlyTest("test");
		GetCurrentForecastResponse response = new GetCurrentForecastResponse();
		
		ListIterator<CurrentForecastModel> currentForecastData = currentForecastRepository.findByActive(1l).listIterator();
		//ListIterator<BankAccount> bankAccount = bankAccounts.listIterator();
		while(currentForecastData.hasNext()){
			
			CurrentForecastModel currentForecastModel = currentForecastData.next();
			
			CurrentForecast currentForecast = new CurrentForecast();
			
			City city = new City();
			
			city.setCityId(currentForecastModel.getCity().getCityId());
			city.setCityName(currentForecastModel.getCity().getCityName());
			
			currentForecast.setCurrentWeatherId(currentForecastModel.getCurrentWeatherId());			
			currentForecast.setDescription(currentForecastModel.getDescription());
			currentForecast.setFeelsLike(currentForecastModel.getFeelsLike());
			currentForecast.setHumidity(currentForecastModel.getHumidity());
			currentForecast.setImage(currentForecastModel.getImage());
			currentForecast.setPresure(currentForecastModel.getPresure());
			currentForecast.setTemperature(currentForecastModel.getTemperature());
			currentForecast.setWindDirection(currentForecastModel.getWindDirection());
			currentForecast.setWindSpeed(currentForecastModel.getWindSpeed());
			currentForecast.setCity(city);
			
			response.getForecast().add(currentForecast);
			
		}
		//response.setCountry(countryRepository.findCountry(request.getName()));

		return response;
	}
}
