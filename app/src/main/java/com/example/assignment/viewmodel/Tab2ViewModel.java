package com.example.assignment.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.assignment.model.User;
import com.example.assignment.model.UserDao;
import com.example.assignment.model.UserDatabase;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Tab2ViewModel extends AndroidViewModel {
    public MutableLiveData<List<User>> users = new MutableLiveData<>();
    UserDao dao = UserDatabase.getInstance(getApplication()).userDao();

    private CompositeDisposable disposable = new CompositeDisposable();

    public Tab2ViewModel(@NonNull Application application) {
        super(application);
    }

    public void saveToDatabase(User user){
        dao.insert(user).subscribeOn(Schedulers.io()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {
            }
            @Override
            public void onComplete() {
            }
            @Override
            public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                e.printStackTrace();
            }
        });

    }


}