package com.example.finalproject.Network;

import com.example.finalproject.Database.Entities.Folder;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface API {
    @GET("folders")
    Call<List<Folder>> getAll();

    @POST("folders")
    Call<Folder> postFolder(@Body Folder folder);

    @DELETE("/folders/{id}")
    Call<Folder> deleteFolder(@Path("id") int id);

    @PUT("/folders/{id}")
    Call<Folder> updateFolder(@Path("id") int id, @Body Folder folder);
}
