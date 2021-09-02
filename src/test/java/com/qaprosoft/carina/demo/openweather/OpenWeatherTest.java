package com.qaprosoft.carina.demo.openweather;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.openweather.GetCurrentWeatherInTownMethod;
import com.qaprosoft.carina.demo.api.openweather.GetDailyWeatherMethod;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
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
    public void testGetWeatherInUnexistingTown() {
        GetCurrentWeatherInTownMethod api = new GetCurrentWeatherInTownMethod();
        api.getProperties().replace("q", "Nyasvizh", "Wrongtown");
        api.addUrlParameter("q", api.getProperties().getProperty("q"));
        api.addUrlParameter("appid", api.getProperties().getProperty("appid"));
        String rs = api.callAPI().asString();

        JsonPath jsonPath = new JsonPath(rs);
        int cod = jsonPath.getInt("cod");
        String message = jsonPath.getString("message");
        Assert.assertEquals(message, "city not found");
        Assert.assertEquals(cod, 404);
    }

    @Test
    public void testGetWeatherByTownId() {
        GetCurrentWeatherInTownMethod api = new GetCurrentWeatherInTownMethod();
        api.addUrlParameter("appid", api.getProperties().getProperty("appid"));
        api.addUrlParameter("id", api.getProperties().getProperty("townid"));
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = api.callAPI().asString();
        api.validateResponseAgainstSchema("api/openweather/_get/rs_gen.schema");
        JsonPath path = new JsonPath(rs);
        String id = path.getString("id");
        Assert.assertEquals(id, api.getProperties().getProperty("townid"));
    }

    @Test
    public void testDailyForecast() {
        GetDailyWeatherMethod api = new GetDailyWeatherMethod();
        api.addUrlParameter("appid", api.getProperties().getProperty("appid"));
        api.addUrlParameter("lat", api.getProperties().getProperty("lat"));
        api.addUrlParameter("lon", api.getProperties().getProperty("lon"));
        api.addUrlParameter("exclude", "hourly,minutely");
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
    }
}
