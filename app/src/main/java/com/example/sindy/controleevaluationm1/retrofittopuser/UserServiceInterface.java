package com.example.sindy.controleevaluationm1.retrofittopuser;

import com.example.sindy.controleevaluationm1.retrofitquestion.StackExchange;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserServiceInterface {
    @GET("/2.2/users?order=desc&sort=reputation&site=stackoverflow")
    Call<TopUsers> superStackExchange();
}
