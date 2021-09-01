package com.qaprosoft.carina.demo.openweather;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.openweather.GetCurrentWeatherInTownMethod;
import io.restassured.path.json.JsonPath;
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
        api.addUrlParameter("q", api.getProperties().getProperty("q"));
        api.addUrlParameter("appid", api.getProperties().getProperty("appid"));
        api.callAPI();
        api.validateResponseAgainstSchema("api/openweather/_get/rs_gen.schema");
    }

    @Test
    public void testGetWeatherByTownName() {
        GetCurrentWeatherInTownMethod api = new GetCurrentWeatherInTownMethod();
        LOGGER.info(api.getProperties().getProperty("appid"));
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.addUrlParameter("q", api.getProperties().getProperty("q"));
        api.addUrlParameter("appid", api.getProperties().getProperty("appid"));
        api.callAPI();
        api.validateResponse();
    }

    @Test
    public void testGetWeatherInUnexistingTown() {
        GetCurrentWeatherInTownMethod api = new GetCurrentWeatherInTownMethod();
        api.getProperties().replace("q", "Nyasvizh", "Wrongtown");
        api.addUrlParameter("q", api.getProperties().getProperty("q"));
        api.addUrlParameter("appid", api.getProperties().getProperty("appid"));
        api.callAPI();

        //TODO add validations
    }

    @Test
    public void testGetWeatherByTownId() {

    }

    @Test
    public void testDailyForecast() {

    }
}
