package megha.mvvm_arch.viewModel_VM;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Megha Chauhan on 23-Feb-18.
 */

public class ChronometerViewModel extends ViewModel {
    private Long startTime;

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(final Long startTime) {
        this.startTime = startTime;
    }



}
