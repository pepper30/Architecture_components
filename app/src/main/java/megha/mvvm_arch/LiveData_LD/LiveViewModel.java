package megha.mvvm_arch.LiveData_LD;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.SystemClock;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Megha Chauhan on 25-Feb-18.
 */

public class LiveViewModel extends ViewModel {
        private static final int ONE_SEC=1000;



    private MutableLiveData<Long> elapsedTime=new MutableLiveData<>();
        private long intialTime;

    public LiveViewModel() {
        intialTime= SystemClock.elapsedRealtime();
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                long value=(SystemClock.elapsedRealtime()-intialTime)/1000;
                elapsedTime.postValue(value);
            }
        },ONE_SEC,ONE_SEC);
    }

    public MutableLiveData<Long> getElapsedTime() {
        return elapsedTime;
    }

}
