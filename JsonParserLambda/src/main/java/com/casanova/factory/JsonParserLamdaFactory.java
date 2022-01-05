package com.casanova.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.dizitart.no2.Nitrite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.casanova.service.JsonParserLamdaService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParserLamdaFactory {

	private static  LambdaLogger log;
	private Nitrite nitriteDb;
	private static final String CLASS_NAME = "com.casanova.service.impl.JsonParserLambdaServiceImpl";
	private static Map<String, JsonParserLamdaService> serviceMap = new HashMap<>();

	@Inject
	public JsonParserLamdaFactory(Nitrite db) {
		this.nitriteDb = db;
	}

	public JsonParserLamdaService getJsonParserLamdaService(ObjectMapper mapper, Context context)
			throws RuntimeException {
		log = context.getLogger();
		log.log("Inside getJsonParserLamdaService \n");

		if (!serviceMap.containsKey(CLASS_NAME)) {
			try {
				Class<?> clazz = Class.forName(CLASS_NAME);

				JsonParserLamdaService service = buildJsonParserLambdaService(clazz, mapper, nitriteDb, context);
				serviceMap.put(CLASS_NAME, service);
				if (null == service) {
					log.log("null object returned for name: "+ CLASS_NAME);
					throw new RuntimeException("null object returned for name: " + CLASS_NAME);
				}
			} catch (ClassNotFoundException e) {
				log.log("null object returned for name: "+ CLASS_NAME);
				throw new RuntimeException("null object returned for name: " + CLASS_NAME);
			}
		}
		return serviceMap.get(CLASS_NAME);
	}

	private JsonParserLamdaService buildJsonParserLambdaService(Class<?> clazz, ObjectMapper mapper, Nitrite db,
			Context context) throws RuntimeException {

		JsonParserLamdaService service = null;
		try {
			service = (JsonParserLamdaService) clazz.getConstructor(ObjectMapper.class, Nitrite.class)
					.newInstance(mapper, db);

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			log.log(e.getMessage());
			throw new RuntimeException(e);
		}

		return service;
	}

}
