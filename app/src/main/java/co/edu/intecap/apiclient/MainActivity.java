package co.edu.intecap.apiclient;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

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
    private ImageView ivAvatar;
    private TextView tvUserName;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRequest = findViewById(R.id.btn_request);
        tvUserName = findViewById(R.id.tv_user_name);
        ivAvatar = findViewById(R.id.iv_user);

        apiService = ApiClient.getClient().create(ApiService.class);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: ");
                progressDialog = ProgressDialog.show(MainActivity.this, "Cargando", "Esperando respuesta...");
                apiService.getUserByID(generateRandomId(1, 12)).enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        User user = response.body().getData();

                        Picasso.get()
                                .load(user.getAvatarUrl())
                                .resize(50, 50)
                                .centerCrop()
                                .into(ivAvatar);


                        tvUserName.setText(user.getFirstName() + " "+ user.getLastName());

                        progressDialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        progressDialog.dismiss();
                    }
                });
            }
        });
    }

    private int generateRandomId(int min , int max){
        return new Random().nextInt((max - min) + 1) + min;
    }
}
