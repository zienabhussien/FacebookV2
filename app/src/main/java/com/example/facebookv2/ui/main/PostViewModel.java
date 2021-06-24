package com.example.facebookv2.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.facebookv2.data.PostsClient;
import com.example.facebookv2.pojo.PostModel;

import java.util.List;


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
   private static final String TAG = "PostViewModel";
    MutableLiveData<List<PostModel>> postMutableLiveData = new MutableLiveData<>();

    CompositeDisposable compositeDisposable = new CompositeDisposable();
     public void getPosts(){
      Single<List<PostModel>> observable = PostsClient.getINSTANCE().getPosts()
            .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread());

     compositeDisposable.add( observable.subscribe(o -> postMutableLiveData.setValue(o),
             e -> Log.d(TAG, "getPosts: "+e) ) );

     }

 @Override
 protected void onCleared() {
  super.onCleared();
  compositeDisposable.clear();
 }
}
