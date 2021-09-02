package com.qaprosoft.carina.demo.api.openweather;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetDailyWeatherMethod extends AbstractApiMethodV2
{
    public GetDailyWeatherMethod() {
        super(null, null, "api/openweather/nyasvizhrequest.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
