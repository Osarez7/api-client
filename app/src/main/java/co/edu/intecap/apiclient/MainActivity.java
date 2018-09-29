package co.edu.intecap.apiclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.List;

import co.edu.intecap.apiclient.http.ApiClient;
import co.edu.intecap.apiclient.http.ApiService;
import co.edu.intecap.apiclient.model.User;
import co.edu.intecap.apiclient.model.UserDetail;
import co.edu.intecap.apiclient.model.UserResponse;
import co.edu.intecap.apiclient.model.UsersResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btnRequest;
    private ApiService apiService;
    private final String TAG = MainActivity.class.getSimpleName();
    private Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRequest = findViewById(R.id.btn_request);
        apiService = ApiClient.getClient().create(ApiService.class);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: ");
                apiService.getUsers(1).enqueue(new Callback<UsersResponse>() {
                    @Override
                    public void onResponse(Call<UsersResponse> call, Response<UsersResponse> response) {
                        Log.d(TAG, "onResponse: " + gson.toJson(response.body()));
                    }

                    @Override
                    public void onFailure(Call<UsersResponse> call, Throwable t) {

                    }
                });
            }
        });
    }
}
