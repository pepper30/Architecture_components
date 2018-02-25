package megha.mvvm_arch.LiveData_LD;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import megha.mvvm_arch.R;

public class LiveTimerActiivty extends AppCompatActivity {
    TextView textView;
    LiveViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_timer_actiivty);
        textView=findViewById(R.id.textView);
        viewModel= ViewModelProviders.of(this).get(LiveViewModel.class);

        Observer<Long> observer=new Observer<Long>() {
            @Override
            public void onChanged(@Nullable Long aLong) {
                String text=LiveTimerActiivty.this.getResources().getString(R.string.seconds,aLong);
                textView.setText(text);

            }
        };
        viewModel.getElapsedTime().observe(this,observer);
    }
}
