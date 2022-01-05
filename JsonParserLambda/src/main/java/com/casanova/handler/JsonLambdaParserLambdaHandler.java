package com.casanova.handler;

import java.io.IOException;
import java.io.InputStream;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.casanova.component.DaggerJsonParserLambdaComponent;
import com.casanova.dto.RestaurantCollection;
import com.casanova.factory.JsonParserLamdaFactory;
import com.casanova.service.JsonParserLamdaService;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;



public class JsonLambdaParserLambdaHandler implements RequestHandler<InputStream, Boolean> {

	private static JsonParserLamdaFactory factory;
	private static final ObjectMapper mapper;
	private static  LambdaLogger logger ;

	
	static {
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		factory = DaggerJsonParserLambdaComponent.create().buildJsonParserLambdaFactory();
	}

	@Override
	public Boolean handleRequest(InputStream input, Context context) {
		logger = context.getLogger();  
		logger.log("Inside JsonLambdaParserLambdaHandler class::\n");

		try {
			RestaurantCollection restaurantList = mapper.readValue(input, RestaurantCollection.class);
			logger.log("Getting sample Id: "+restaurantList.restaurants.get(0).id+"\n");
			JsonParserLamdaService jsonParserLamdaService = factory.getJsonParserLamdaService(mapper, context);
			return jsonParserLamdaService.process(restaurantList, context)? Boolean.TRUE : Boolean.FALSE;
			

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return Boolean.FALSE;
	}

}
