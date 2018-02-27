package megha.mvvm_arch.Room_Persistance;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Megha Chauhan on 26-Feb-18.
 */
@Database(entities = {UserEntity.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
    public abstract  UserDao userDao();

    public static  AppDatabase getAppDatabase(Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"user-database")
                        .allowMainThreadQueries()
                        .build();
        }
        return INSTANCE;
    }

    public  static void destroyInstance(){
        INSTANCE=null;
    }

}
