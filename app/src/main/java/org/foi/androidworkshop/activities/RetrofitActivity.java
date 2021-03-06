package org.foi.androidworkshop.activities;

import org.foi.androidworkshop.BuildConfig;
import org.foi.androidworkshop.R;
import org.foi.androidworkshop.adapters.PokemonAdapter;
import org.foi.androidworkshop.models.BaseResponse;
import org.foi.androidworkshop.models.Pokemon;
import org.foi.androidworkshop.network.ApiService;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends BaseActivity {

    public static final String ERROR = "ERROR";

    private ApiService service;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_retrofit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.rv_pokemons);

        initRetrofit();
        makeApiCall();
    }

    private void initRetrofit() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        service = retrofit.create(ApiService.class);
    }

    private void makeApiCall() {
        Call<BaseResponse<List<Pokemon>>> call = service.getPokemon();

        final Callback<BaseResponse<List<Pokemon>>> callback = new Callback<BaseResponse<List<Pokemon>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<Pokemon>>> call, Response<BaseResponse<List<Pokemon>>> response) {
                hideProgress();
                populateRecyclerView(response.body().getResults());
            }

            @Override
            public void onFailure(Call<BaseResponse<List<Pokemon>>> call, Throwable t) {
                //This is for the dumb user
                showError(getString(R.string.network_request_error));

                //This is for the developers
                Log.d(ERROR, t.getMessage());
            }
        };

        showProgress();
        call.enqueue(callback);
    }

    private void populateRecyclerView(List<Pokemon> pokemons) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PokemonAdapter(pokemons));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                onBackPressed();
                break;
            
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
