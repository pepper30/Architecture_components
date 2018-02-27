package megha.mvvm_arch.Room_Persistance;

import android.os.AsyncTask;

/**
 * Created by Megha Chauhan on 27-Feb-18.
 */

public class DataIntializer {
    private static final  String TAG=DataIntializer.class.getName();

    public static void inserUser(AppDatabase db){
        UserEntity userEntity=new UserEntity();
        userEntity.setFirstName(userEntity.getFirstName());
        userEntity.setLastName(userEntity.getLastName());
        userEntity.setAge(userEntity.getAge());

        InsertTask insertTask=new InsertTask(db);
        insertTask.execute(userEntity);
    }

    public static void DeleteUser(AppDatabase db){
        UserEntity userEntity=new UserEntity();
        userEntity.getAge();
        userEntity.getLastName();
        userEntity.getFirstName();

        DeleteTask deleteTask=new DeleteTask(db);
        deleteTask.execute(userEntity);
    }

}

class InsertTask extends AsyncTask<UserEntity,Void,Void> {
    private final AppDatabase db;

    InsertTask(AppDatabase db) {
        this.db = db;
    }

    @Override
    protected Void doInBackground(UserEntity... userEntities) {
        db.userDao().insertAll(userEntities);
        return null;
    }
}

class DeleteTask extends AsyncTask<UserEntity,Void,Void>{
        private  final AppDatabase db;

    DeleteTask(AppDatabase db) {
        this.db = db;
    }

    @Override
    protected Void doInBackground(UserEntity... userEntities) {
        db.userDao().deleteUserByInfo();
        return null;
    }
}

