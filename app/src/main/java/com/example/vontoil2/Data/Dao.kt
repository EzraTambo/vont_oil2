package com.example.vontoil2.Data

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

interface Dao {

    interface UserDao {
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        fun  addUser(user:User)

        @Query("SELECT * FROM user_table ORDER BY id ASC")
        fun readAllData(): LiveData<List<User>>

        @Query("SELECT * FROM user_table where firstName = (:userId) and password = (:password)")
        fun login (userId:String, password:String):User

        @Query("Select * FROM user_table where firstName = (:firstName) and password = (:password) ")
        //select all the records in the database that has the firstname and password that the user has given
        fun loginuser(firstName:String , password: String):User

        @Query("DELETE FROM user_table WHERE id LIKE :id")
        fun delete(id: Int): Int

        //Update methods must either return void or return int (the number of updated rows).
        @Update(onConflict = OnConflictStrategy.REPLACE)
        fun update(user: User): Int
}
}