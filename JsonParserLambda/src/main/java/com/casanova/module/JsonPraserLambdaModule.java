package com.casanova.module;

import javax.inject.Singleton;

import org.dizitart.no2.Nitrite;

import com.casanova.factory.JsonParserLamdaFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class JsonPraserLambdaModule {

	@Provides
	@Singleton
	public JsonParserLamdaFactory provideJsonParserLamdaFactory(Nitrite db) {
		return new JsonParserLamdaFactory(db);
	}

}
