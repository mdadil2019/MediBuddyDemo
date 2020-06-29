package com.mdadil2019.medibuddydemo.repo

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.mdadil2019.medibuddydemo.repo.local.MediBuddyDatabase
import com.mdadil2019.medibuddydemo.repo.local.model.User
import com.mdadil2019.medibuddydemo.repo.remote.Networking
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.io.File

class UserRepository(private val context : Context, private val owner : LifecycleOwner) {

    private val disposable = CompositeDisposable()
    private val db = MediBuddyDatabase.getInstance(context)
    fun requestData(onResult : (Boolean)->Unit){
        disposable.add(Networking.create(File(""), 1024 * 10)
            .requestUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({
                onResult(true)
                it.result.forEach{
                    db.userDao().insertUser(it)
                }
            },{
                onResult(false)
                Timber.e("Failed --> $it")
            })
        )
    }

    @SuppressLint("CheckResult")
    fun getDataAvailability(onSuccess: (Boolean?)->Unit){
        db.userDao().getUsers().observe(owner, Observer {
            onSuccess(!it.isEmpty())
        })
    }

    fun getUserData(onSuccess : (List<User>)-> Unit) {
        db.userDao().getUsers().observe(owner, Observer {
            onSuccess(it)
        })
    }

    fun onClear(){
        disposable.dispose()
    }
}