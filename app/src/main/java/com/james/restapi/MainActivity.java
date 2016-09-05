package com.james.restapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.james.restapi.adapter.CompanyAdapter;
import com.james.restapi.api.Api;
import com.james.restapi.model.Company;
import com.james.restapi.model.CompanyResponse;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.recyclerView)
    RecyclerView mRv;

    private CompanyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new CompanyAdapter();
        mRv.setAdapter(adapter);
        mRv.setLayoutManager(new LinearLayoutManager(this));


        Api.getInstance().getApiInterface().getCompanies("", 1, 20).enqueue(new Callback<CompanyResponse>() {
            @Override
            public void onResponse(Call<CompanyResponse> call, Response<CompanyResponse> response) {
                int code = response.code();
                Log.d(TAG, "code " + code);

                switch (code){
                    case 200:{
                        List<Company> companies = response.body().getResponse().getItems();
                        Log.d(TAG, "companies size " +companies.size());
                        adapter.setItems(companies);

                        break;

                    }

                    default: {
                        Log.e(TAG, "something error");
                    }
                }



            }

            @Override
            public void onFailure(Call<CompanyResponse> call, Throwable t) {
                Log.e(TAG, "error " + t.getMessage());
            }
        });

        ///

    }


    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
