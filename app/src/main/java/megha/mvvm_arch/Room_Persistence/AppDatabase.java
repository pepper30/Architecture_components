package megha.mvvm_arch.Room_Persistence;

import android.app.Application;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Megha Chauhan on 01-Mar-18.
 */
@Database(entities = {UserEntity.class},version = 1)
public abstract class AppDatabase extends RoomDatabase{

    public abstract UserDao userDao();
    public static AppDatabase instance;

    public static AppDatabase getInstance(Context context){
        if(instance==null) {
            instance = Room.databaseBuilder(context.getApplicationContext()
                    , AppDatabase.class, "user-database").allowMainThreadQueries().build();
        }

        return instance;
    }

    public static void destroyInstance(){
        instance=null;
    }
}
