package com.casanova.component;

import javax.inject.Singleton;

import com.casanova.factory.JsonParserLamdaFactory;
import com.casanova.module.NitriteDBModule;

import dagger.Component;

@Component(modules = NitriteDBModule.class)
@Singleton
public interface JsonParserLambdaComponent {
	
	JsonParserLamdaFactory buildJsonParserLambdaFactory();

}
