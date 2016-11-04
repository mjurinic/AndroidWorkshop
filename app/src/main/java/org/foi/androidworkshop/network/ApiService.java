package org.foi.androidworkshop.network;

import org.foi.androidworkshop.models.BaseResponse;
import org.foi.androidworkshop.models.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/api/v2/pokemon")
    Call<BaseResponse<List<Pokemon>>> getPokemon();
}
