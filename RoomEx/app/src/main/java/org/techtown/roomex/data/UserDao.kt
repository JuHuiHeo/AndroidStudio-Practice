package org.techtown.roomex.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    // OnConflictStrategy.IGNORE = 동일한 아이디가 있을 시 무시
   @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun addUser(user : User)

   @Query("SELECT * FROM user_table ORDER BY id ASC")
   fun readAllData() : LiveData<List<User>>

}