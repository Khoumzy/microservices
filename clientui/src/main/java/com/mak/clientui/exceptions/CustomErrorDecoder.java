package com.mak.clientui.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder defaultDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {

        if( response.status() == 404 ){
            return new EntityNotFound("Entity not found");
        }
        return defaultDecoder.decode(s, response);
    }
}
