package com.qaprosoft.carina.demo.api.restful_booker;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetBookingMethod extends AbstractApiMethodV2 {
    public GetBookingMethod() {
        super(null, "api/booker/rs-get-booking.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
