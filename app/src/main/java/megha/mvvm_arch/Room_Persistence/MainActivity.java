package megha.mvvm_arch.Room_Persistence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import megha.mvvm_arch.R;

public class MainActivity extends AppCompatActivity {
    EditText first,last,age;
    Button insert,delete,viewAll;
    UserEntity userEntity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert=findViewById(R.id.insert);
        delete=findViewById(R.id.delete);
        viewAll=findViewById(R.id.viewBtn);
        age=findViewById(R.id.ageTxt);
        first=findViewById(R.id.firstTxt);
        last=findViewById(R.id.lastTxt);
        userEntity =new UserEntity(first.getText().toString(),last.getText().toString(),age.getText().toString());

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userEntity.setFirstName(first.getText().toString());
                userEntity.setLastName(last.getText().toString());
                userEntity.setAge(age.getText().toString());
                 Runnable runnable=new Runnable() {
                   @Override
                   public void run() {

                       AppDatabase.getInstance(MainActivity.this).userDao().insert(userEntity);
                   }
               };
               Thread thread=new Thread(runnable);
               thread.start();
                first.setText(" ");
                last.setText(" ");
                age.setText(" ");
            }
        });

        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ViewAllActivity.class);
                startActivity(intent);
            }
        });


    }



}
