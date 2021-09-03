package com.qaprosoft.carina.demo.restful_booker;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.restful_booker.GetBookingMethod;
import com.qaprosoft.carina.demo.api.restful_booker.PostCreateBookingMethod;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class RestfulBookerTest implements IAbstractTest {
    @Test
    public void testGetBookingRequest() {
        GetBookingMethod getMethod = new GetBookingMethod();
        getMethod.request.pathParam("id", 5);
        getMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getMethod.callAPI();
    }

    @Test
    public void testPostBookingRequest() {
        PostCreateBookingMethod postMethod = new PostCreateBookingMethod();
        postMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        JsonPath rs = new JsonPath(postMethod.callAPI().asString());
        postMethod.validateResponse();
        int bookingid = rs.getInt("bookingid");

        GetBookingMethod getMethod = new GetBookingMethod();
        getMethod.request.pathParam("id", bookingid);
        getMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getMethod.callAPI();
        getMethod.validateResponse();
    }
}
