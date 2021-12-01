package com.example.vontoil2.Data

import androidx.lifecycle.LiveData

class Repository {

    class UserRepository (private val userDao: Dao.UserDao) {

        val readAllData: LiveData<List<User>> = userDao.readAllData()


        suspend fun addUser(user: User){
            userDao.addUser(user)
        }
    }
}

