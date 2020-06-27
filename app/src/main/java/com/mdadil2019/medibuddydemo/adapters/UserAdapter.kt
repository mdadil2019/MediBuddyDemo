package com.mdadil2019.medibuddydemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mdadil2019.medibuddydemo.R
import com.mdadil2019.medibuddydemo.adapters.UserAdapter.UserItemViewHolder
import com.mdadil2019.medibuddydemo.databinding.UserItemBinding
import com.mdadil2019.medibuddydemo.repo.local.model.User

class UserAdapter(private var users : MutableList<User>) : RecyclerView.Adapter<UserItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        val binding = DataBindingUtil.inflate<UserItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.user_item, parent, false)

        return UserItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return this.users.size
    }

    fun addUser(user : User){
        users.add(user)
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        holder.onBind(users[position])
    }

    inner class UserItemViewHolder(val binding : UserItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun onBind(user : User){
            binding.user = user
        }
    }
}