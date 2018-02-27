package megha.mvvm_arch.Room_Persistance;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import megha.mvvm_arch.R;
import megha.mvvm_arch.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUserBinding userActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_user);

        userActivityBinding.insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              DataIntializer.inserUser(AppDatabase.getAppDatabase(UserActivity.this));
            }
        });

        userActivityBinding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataIntializer.DeleteUser(AppDatabase.getAppDatabase(UserActivity.this));
            }
        });


    }
}
