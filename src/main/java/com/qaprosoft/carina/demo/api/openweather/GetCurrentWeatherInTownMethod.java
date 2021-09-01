package com.qaprosoft.carina.demo.api.openweather;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Properties;


public class GetCurrentWeatherInTownMethod extends AbstractApiMethodV2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public GetCurrentWeatherInTownMethod() {
        super(null, "api/openweather/_get/rs.json", "api/openweather/nyasvizhrequest.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
