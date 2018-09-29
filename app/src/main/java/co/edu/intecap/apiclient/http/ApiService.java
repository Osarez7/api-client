package co.edu.intecap.apiclient.http;

import co.edu.intecap.apiclient.model.UserDetail;
import co.edu.intecap.apiclient.model.UserResponse;
import co.edu.intecap.apiclient.model.UsersResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("users")
    Call<UsersResponse> getUsers(@Query("page") int page);


    @GET("users/{id}")
    Call<UserResponse> getUserByID(@Path("id") long id);


    @FormUrlEncoded
    @POST("users")
    Call<UserDetail> createUser(@Field("name") String name, @Field("job") String job);

    @FormUrlEncoded
    @PUT("users/{id}")
    Call<UserDetail> updateUser(@Path("id") long id, @Field("name") String name, @Field("job") String job);

    @GET("users/{id}")
    Call<String> deleteUserByID(@Path("id") long id);
}
