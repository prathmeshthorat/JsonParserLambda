package com.casanova.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.casanova.dto.RestaurantCollection;

public interface JsonParserLamdaService {

	public boolean process(RestaurantCollection restaurantCollection, Context context);
}
