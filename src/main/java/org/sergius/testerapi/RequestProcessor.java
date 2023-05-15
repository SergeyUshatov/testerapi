package org.sergius.testerapi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.Map;
import java.util.stream.Collectors;

public class RequestProcessor {

    public <BODY> ResponseProcessor sendPost(String url, BODY body, RequestSpecification baseReqSpec, ResponseSpecification respSpec) {
        return new RequestExecutor().post(new RequestSpecBuilder()
                        .addRequestSpecification(baseReqSpec)
                        .setBasePath(url)
                        .setBody(body)
                        .build(), respSpec);
    }

    public ResponseProcessor sendGet(String url, RequestSpecification baseReqSpec, ResponseSpecification respSpec) {
        return new RequestExecutor().get(new RequestSpecBuilder()
                .addRequestSpecification(baseReqSpec)
                .setBasePath(url)
                .build(), respSpec);
    }

    public ResponseProcessor sendGet(String url, Map<String, ?> queryParams, RequestSpecification baseReqSpec, ResponseSpecification respSpec) {
        String quesryParamsAsString = queryParams.keySet()
                .stream()
                .map(key -> key + "=" + queryParams.get(key))
                .collect(Collectors.joining("&"));

        return new RequestExecutor().get(new RequestSpecBuilder()
                .addRequestSpecification(baseReqSpec)
                .setBasePath(url + "?" + quesryParamsAsString)
                .build(), respSpec);
    }

    public <BODY> ResponseProcessor sendPut(String url, BODY body, RequestSpecification baseReqSpec, ResponseSpecification respSpec) {
        return new RequestExecutor().put(new RequestSpecBuilder()
                .addRequestSpecification(baseReqSpec)
                .setBasePath(url)
                .setBody(body)
                .build(), respSpec);
    }

    public <BODY> ResponseProcessor sendPatch(String url, BODY body, RequestSpecification baseReqSpec, ResponseSpecification respSpec) {
        return new RequestExecutor().patch(new RequestSpecBuilder()
                .addRequestSpecification(baseReqSpec)
                .setBasePath(url)
                .setBody(body)
                .build(), respSpec);
    }

    public ResponseProcessor sendDelete(String url, RequestSpecification baseReqSpec, ResponseSpecification respSpec) {
        return new RequestExecutor().delete(new RequestSpecBuilder()
                .addRequestSpecification(baseReqSpec)
                .setBasePath(url)
                .build(), respSpec);
    }
}
