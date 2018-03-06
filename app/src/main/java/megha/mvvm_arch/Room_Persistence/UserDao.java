package megha.mvvm_arch.Room_Persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Megha Chauhan on 01-Mar-18.
 */
@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<UserEntity> getAll();

    @Insert
    void insert(UserEntity ... userEntities);

    @Delete
    void delete(UserEntity userEntity);
}
