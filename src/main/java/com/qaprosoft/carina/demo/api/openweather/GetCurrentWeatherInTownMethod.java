package com.qaprosoft.carina.demo.api.openweather;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;

import java.util.Properties;

public class GetCurrentWeatherInTownMethod extends AbstractApiMethodV2 {
    public GetCurrentWeatherInTownMethod() {
        super(null, "api/openweather/_get/rs.json", "api/openweather/nyasvizhrequest.properties");
    }
}
