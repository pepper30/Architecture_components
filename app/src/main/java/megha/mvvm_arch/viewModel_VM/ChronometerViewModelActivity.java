package megha.mvvm_arch.viewModel_VM;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;

import megha.mvvm_arch.R;

public class ChronometerViewModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometer_view_model);

        ChronometerViewModel viewModel = ViewModelProviders.of(this).get(ChronometerViewModel.class);
        Chronometer chronometer = findViewById(R.id.chronometer);

        if (viewModel.getStartTime() == null) {
            long startTime = SystemClock.elapsedRealtime();
            viewModel.setStartTime(startTime);
            chronometer.setBase(startTime);
        } else {
            chronometer.setBase(viewModel.getStartTime());
        }

        chronometer.start();
    }
}
