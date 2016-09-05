package com.james.restapi.api;

import com.james.restapi.model.CompanyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("companies/search")
    Call<CompanyResponse> getCompanies(@Query("searchstring") String searchstring,
                                       @Query("pageindex") int pageindex,
                                       @Query("pagesize") int pagesize);

}
