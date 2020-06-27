package com.mdadil2019.medibuddydemo

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.mdadil2019.medibuddydemo.adapters.UserAdapter
import com.mdadil2019.medibuddydemo.repo.UserRepository
import com.mdadil2019.medibuddydemo.repo.local.model.User

class ListFragmentViewModel(private val userRepository: UserRepository) : ViewModel() {

    init {
        userRepository.requestData()
    }

    fun setAdapter(recyclerView: RecyclerView){
        val userAdapter = UserAdapter(mutableListOf<User>())
        recyclerView.adapter = userAdapter
        userRepository.getUserData {
            it.forEach { user->
                userAdapter.addUser(user)
            }
            userAdapter.notifyDataSetChanged()
        }
    }
}