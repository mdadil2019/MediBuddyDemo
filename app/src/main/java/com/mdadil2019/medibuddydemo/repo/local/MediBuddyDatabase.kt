package com.mdadil2019.medibuddydemo.repo.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mdadil2019.medibuddydemo.repo.local.dao.UserDao
import com.mdadil2019.medibuddydemo.repo.local.model.User

@Database(entities = [User::class], version = 1)
abstract class MediBuddyDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        const val DB_NAME = "medibuddy.db"

        @Volatile
        private var INSTANCE: MediBuddyDatabase? = null

        fun getInstance(context: Context): MediBuddyDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MediBuddyDatabase::class.java,
                        DB_NAME
                    ).build()
                    return INSTANCE!!
                }
            }
            return INSTANCE!!
        }

    }
}