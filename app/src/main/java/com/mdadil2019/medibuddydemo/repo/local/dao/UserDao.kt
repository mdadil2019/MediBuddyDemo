package com.mdadil2019.medibuddydemo.repo.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mdadil2019.medibuddydemo.repo.local.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user : User)

    @Query("SELECT * FROM user")
    fun getUsers() : LiveData<List<User>>

    @Delete
    fun deleteUser(user : User)

}