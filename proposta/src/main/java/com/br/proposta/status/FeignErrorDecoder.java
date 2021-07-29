package com.br.proposta.status;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        var status = HttpStatus.resolve(response.status());
        return FeignStatus.convert(status).exceptionHandler();
    }
}