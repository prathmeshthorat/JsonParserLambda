package com.casanova.module;

import org.dizitart.no2.Nitrite;

import dagger.Module;
import dagger.Provides;

@Module
public class NitriteDBModule {
	
	@Provides
	public static Nitrite provideNitriteDBModuleNitrite() {
		Nitrite dbNitrite = Nitrite.builder().compressed().filePath("/tmp/test.db").openOrCreate("user", "root");
		return dbNitrite;
			
	}
}
