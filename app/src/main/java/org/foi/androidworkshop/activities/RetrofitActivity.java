package org.foi.androidworkshop.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.foi.androidworkshop.R;
import org.foi.androidworkshop.adapters.PokemonAdapter;
import org.foi.androidworkshop.models.BaseResponse;
import org.foi.androidworkshop.models.Pokemon;
import org.foi.androidworkshop.network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    public static final String ERROR = "ERROR";

    private ApiService service;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        recyclerView = (RecyclerView) findViewById(R.id.rvPokemons);

        initRetrofit();
        makeApiCall();
    }

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);
    }

    private void makeApiCall() {
        Call<BaseResponse<List<Pokemon>>> call = service.getPokemon();

        Callback<BaseResponse<List<Pokemon>>> callback = new Callback<BaseResponse<List<Pokemon>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<Pokemon>>> call, Response<BaseResponse<List<Pokemon>>> response) {
                populateRecyclerView(response.body().getResults());
            }

            @Override
            public void onFailure(Call<BaseResponse<List<Pokemon>>> call, Throwable t) {
                Log.e(ERROR, t.getMessage());
            }
        };

        call.enqueue(callback);
    }

    private void populateRecyclerView(List<Pokemon> pokemons) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PokemonAdapter(pokemons));
    }
}
