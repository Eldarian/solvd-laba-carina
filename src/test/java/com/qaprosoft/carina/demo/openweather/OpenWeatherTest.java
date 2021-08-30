package com.qaprosoft.carina.demo.openweather;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.openweather.GetCurrentWeatherInTownMethod;
import org.testng.annotations.Test;

public class OpenWeatherTest implements IAbstractTest {

    @Test
    public void testGetWeatherByTownName() {
        GetCurrentWeatherInTownMethod gettownWeatherMethod = new GetCurrentWeatherInTownMethod();
        gettownWeatherMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
    }
}
