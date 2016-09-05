package com.james.restapi.model;

public class CompanyResponse {

    int result;
    CompanyObject response;

    CompanyResponse(){

    }

    public CompanyObject getResponse() {
        return response;
    }

    public int getResult() {
        return result;
    }
}
