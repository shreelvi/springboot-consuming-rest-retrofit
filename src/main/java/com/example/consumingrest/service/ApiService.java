package com.example.consumingrest.service;

import com.example.consumingrest.Quote;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("random")
    Call<Quote> getRandomQuote();
}
