package megha.mvvm_arch.Room_Persistence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import megha.mvvm_arch.R;

public class ViewAllActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                recyclerView=findViewById(R.id.recycle);
                RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                userAdapter=new UserAdapter(AppDatabase.getInstance(ViewAllActivity.this).userDao().getAll());
                userAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(userAdapter);
            }
        };

            Thread thread=new Thread(runnable);
            thread.start();
        }
    }

