package com.casanova.factory;

import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import org.dizitart.no2.Nitrite;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class JsonParserLamdaFactory_Factory implements Factory<JsonParserLamdaFactory> {
  private final Provider<Nitrite> dbProvider;

  public JsonParserLamdaFactory_Factory(Provider<Nitrite> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public JsonParserLamdaFactory get() {
    return new JsonParserLamdaFactory(dbProvider.get());
  }

  public static JsonParserLamdaFactory_Factory create(Provider<Nitrite> dbProvider) {
    return new JsonParserLamdaFactory_Factory(dbProvider);
  }

  public static JsonParserLamdaFactory newInstance(Nitrite db) {
    return new JsonParserLamdaFactory(db);
  }
}
