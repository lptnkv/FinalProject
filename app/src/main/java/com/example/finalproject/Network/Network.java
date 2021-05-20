package com.example.finalproject.Network;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.finalproject.Database.Entities.Folder;
import com.example.finalproject.MainActivity;
import com.example.finalproject.Repo.FolderRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    Retrofit retrofit;
    API api;
    private static Network instance;

    public Network(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://immense-everglades-11344.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.api = retrofit.create(API.class);
    }

    public LiveData<List<Folder>> getFolders(){
        Call<List<Folder>> call = api.getAll();
        MutableLiveData<List<Folder>> data = new MutableLiveData<>();
        call.enqueue(new Callback<List<Folder>>() {
            @Override
            public void onResponse(Call<List<Folder>> call, Response<List<Folder>> response) {
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Folder>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return data;
    }


    public void getFolders(Handler handler){
        Call<List<Folder>> call = api.getAll();
        call.enqueue(new Callback<List<Folder>>() {
            @Override
            public void onResponse(Call<List<Folder>> call, Response<List<Folder>> response) {
                Message msg = new Message();
                msg.obj = response.body();
                handler.sendMessage(msg);
            }

            @Override
            public void onFailure(Call<List<Folder>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    public void postFolder(Folder folder, Handler handler){
        api.postFolder(folder).enqueue(new Callback<Folder>() {
            @Override
            public void onResponse(Call<Folder> call, Response<Folder> response) {
                getFolders(handler);
            }

            @Override
            public void onFailure(Call<Folder> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    public void postFolder(Folder folder){
        api.postFolder(folder).enqueue(new Callback<Folder>() {
            @Override
            public void onResponse(Call<Folder> call, Response<Folder> response) {
            }

            @Override
            public void onFailure(Call<Folder> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void updateFolder(Folder folder, Handler handler){
        api.updateFolder(folder.getId(), folder).enqueue(new Callback<Folder>() {
            @Override
            public void onResponse(Call<Folder> call, Response<Folder> response) {
                getFolders(handler);
            }

            @Override
            public void onFailure(Call<Folder> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void deleteFolder(Folder folder, Handler handler){
        api.deleteFolder(folder.getId()).enqueue(new Callback<Folder>() {
            @Override
            public void onResponse(Call<Folder> call, Response<Folder> response) {
                getFolders(handler);
            }

            @Override
            public void onFailure(Call<Folder> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void deleteFolder(Folder folder){
        api.deleteFolder(folder.getId()).enqueue(new Callback<Folder>() {
            @Override
            public void onResponse(Call<Folder> call, Response<Folder> response) {

            }

            @Override
            public void onFailure(Call<Folder> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public static Network getInstance(){
        if (instance == null){
            instance = new Network();
        }
        return instance;
    }
}
