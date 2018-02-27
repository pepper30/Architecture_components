package megha.mvvm_arch.Room_Persistance;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Megha Chauhan on 26-Feb-18.
 */
@Dao
public interface UserDao {

    @Query("Select * from user")
    List<UserEntity> getAll();

    @Insert
    void insertAll(UserEntity...users);

   @Query("Delete from user where first_Name like :firstName and last_Name like :lastName and age like :age")
    void deleteUserByInfo();

}
