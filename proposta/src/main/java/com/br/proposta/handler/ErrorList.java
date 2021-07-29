package com.br.proposta.handler;



import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ErrorList {

    private int status;
    private Instant instant = Instant.now();
    private List<FieldError> fieldErrors = new ArrayList<>();

    public ErrorList(int status) {
        this.status = status;
    }



    public void addFieldError(FieldError error){
        this.fieldErrors.add(error);
    }

    public int getStatus() {
        return status;
    }

    public Instant getInstant() {
        return instant;
    }



    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }
}