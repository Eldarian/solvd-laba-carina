package com.qaprosoft.carina.demo.openweather;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.openweather.GetCurrentWeatherInTownMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class OpenWeatherTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testGetWeatherByTownNameBySchema() {
        GetCurrentWeatherInTownMethod api = new GetCurrentWeatherInTownMethod();
        LOGGER.info(api.getProperties().getProperty("appid"));
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponseAgainstSchema("api/openweather/_get/rs.schema");
    }

    @Test
    public void testGetWeatherByTownName() {
        GetCurrentWeatherInTownMethod api = new GetCurrentWeatherInTownMethod();
        LOGGER.info(api.getProperties().getProperty("appid"));
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponse();
    }

    @Test
    public void testGetWeatherInUnexistingTown() {
        GetCurrentWeatherInTownMethod api = new GetCurrentWeatherInTownMethod();

    }
}
