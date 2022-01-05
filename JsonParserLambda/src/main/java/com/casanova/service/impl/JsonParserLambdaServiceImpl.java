package com.casanova.service.impl;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.casanova.dto.Restaurant;
import com.casanova.dto.RestaurantCollection;
import com.casanova.service.JsonParserLamdaService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParserLambdaServiceImpl implements JsonParserLamdaService {
	private static  LambdaLogger logger;
	protected ObjectMapper mapper;
	protected Nitrite db;

	public JsonParserLambdaServiceImpl(ObjectMapper mapper, Nitrite db) {
		this.mapper = mapper;
		this.db = db;
	}

	@Override
	public boolean process(RestaurantCollection restaurantCollection, Context context) {
		if (!db.isClosed()) {
			
			//NitriteCollection collection = db.getCollection("restaurant");
			ObjectRepository<Restaurant> restRepository = db.getRepository(Restaurant.class);
			logger = context.getLogger();
			logger.log("Inserting record in db.\n");
			for(Restaurant r: restaurantCollection.restaurants) {
				restRepository.insert(r);
				db.commit();
			}
			System.out.println(restRepository.find().totalCount()+"\n");;
			
			return true;
		}
		return false;
	}

}
