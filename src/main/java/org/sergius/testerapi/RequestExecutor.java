package org.sergius.testerapi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestExecutor {

    public ResponseProcessor post(RequestSpecification reqSpec, ResponseSpecification respSpec) {
        return send(Method.POST, reqSpec, respSpec);
    }

    public ResponseProcessor get(RequestSpecification reqSpec, ResponseSpecification respSpec) {
        return send(Method.GET, reqSpec, respSpec);
    }

    public ResponseProcessor delete(RequestSpecification reqSpec, ResponseSpecification respSpec) {
        return send(Method.DELETE, reqSpec, respSpec);
    }

    public ResponseProcessor put(RequestSpecification reqSpec, ResponseSpecification respSpec) {
        return send(Method.PUT, reqSpec, respSpec);
    }

    public ResponseProcessor patch(RequestSpecification reqSpec, ResponseSpecification respSpec) {
        return send(Method.PATCH, reqSpec, respSpec);
    }

    private ResponseProcessor send(Method method, RequestSpecification reqSpec, ResponseSpecification respSpec) {
        return new ResponseProcessor(RestAssured.given()
                .spec(reqSpec)
                .expect()
                .spec(respSpec)
                .when()
                .request(method));
    }
}
