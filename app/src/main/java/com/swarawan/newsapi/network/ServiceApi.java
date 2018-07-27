package com.swarawan.newsapi.network;

import com.swarawan.newsapi.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rioswarawan on 2/2/18.
 */

public interface ServiceApi {

    @GET("/v2/top-headlines")
    Call<NewsResponse> getTopHeadlines(@Query("country") String country,
                                       @Query("category") String category,
                                       @Query("apiKey") String apiKey);
}
