package com.smartorders.order_service.feign_error;

import org.springframework.stereotype.Component;

import feign.Request;
import feign.Response;
import feign.RetryableException;
import feign.Request.HttpMethod;
import feign.codec.ErrorDecoder;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

	@Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == 503) {
        	return new RetryableException(
                    response.status(),
                    "Inventory Service unavailable",
                    (HttpMethod) response.request().httpMethod(),
                    (Throwable) null,
                    (Long) null,
                    response.request()
                );
        }

        return new RuntimeException("Generic Feign error: " + methodKey + ": " + response.status());
    }
}
