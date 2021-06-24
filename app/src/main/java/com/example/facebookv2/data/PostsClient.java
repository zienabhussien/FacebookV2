package com.example.facebookv2.data;

import com.example.facebookv2.pojo.PostModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    public static final String BASE_URL="https://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static PostsClient INSTANCE;

    public PostsClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);

    }

    public static PostsClient getINSTANCE() {
        if(null==INSTANCE)
            INSTANCE = new PostsClient();
        return INSTANCE;
    }

    public Single<List<PostModel>> getPosts(){

        return postInterface.getPosts();
    }
}
