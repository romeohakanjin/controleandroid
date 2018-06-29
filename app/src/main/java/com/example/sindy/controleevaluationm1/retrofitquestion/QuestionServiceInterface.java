package com.example.sindy.controleevaluationm1.retrofitquestion;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuestionServiceInterface {
    @GET("/2.2/questions?order=desc&sort=activity&site=stackoverflow")
    Call<StackExchange> superStackExchange();
}
