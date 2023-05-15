package org.sergius.testerapi;

import io.restassured.response.Response;

import java.util.function.Function;

public class ResponseProcessor {
    Response original;
    public ResponseProcessor(Response original) {
        this.original = original;
    }

    public <R> R extractResponseAs(Class<R> rClass) {
        return original.body().as(rClass);
    }

    public <R> ResponseProcessor perform(Function<Response, R> function) {
        function.apply(original);
        return this;
    }
}
