package com.mdadil2019.medibuddydemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.mdadil2019.medibuddydemo.adapters.UserAdapter
import com.mdadil2019.medibuddydemo.repo.UserRepository
import com.mdadil2019.medibuddydemo.repo.local.model.User

class ListFragmentViewModel(private val userRepository: UserRepository) : ViewModel() {

    var isApiRequestSuccess = MutableLiveData<Boolean>()
    var isDataAvaiable : Boolean = false
    init {


        userRepository.getDataAvailability {
            isDataAvaiable = it ?: false
            if(!isDataAvaiable){
                userRepository.requestData{
                    isApiRequestSuccess.postValue(it)
                }
            }
        }

    }

    fun setAdapter(recyclerView: RecyclerView){
        val userAdapter = UserAdapter(mutableListOf<User>())
        recyclerView.adapter = userAdapter
        userRepository.getUserData {
            it.forEach { user->
                userAdapter.addUser(user)
            }
//            if(!it.isEmpty()){
//                isDataAvailable.postValue(true)
//            }
            userAdapter.notifyDataSetChanged()
        }
    }

    fun retry(){
        userRepository.requestData{
            isApiRequestSuccess.postValue(it)
        }
    }

    override fun onCleared() {
        super.onCleared()
//        userRepository.onClear()
    }
}