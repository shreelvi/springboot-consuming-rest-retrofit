package com.example.consumingrest.service;

import com.example.consumingrest.Quote;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

@Service
public class SampleApi {

    private ApiService service;


    public SampleApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://quoters.apps.pcfone.io/api/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        this.service = retrofit.create(ApiService.class);
    }

    public Quote getQuote() throws IOException {
        Call<Quote> retrofitCall = service.getRandomQuote();

        Response<Quote> quoteResponse = retrofitCall.execute();

        if (!quoteResponse.isSuccessful()) {
            throw new IOException(quoteResponse.errorBody() != null
                    ? quoteResponse.errorBody().string() : "Unknown error");
        }

        return quoteResponse.body();
    }
}
