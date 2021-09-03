package com.qaprosoft.carina.demo.api.restful_booker;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostCreateBookingMethod extends AbstractApiMethodV2 {
    public PostCreateBookingMethod() {
        super("api/booker/rq-post-booking.json", "api/booker/rs-post-booking.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
