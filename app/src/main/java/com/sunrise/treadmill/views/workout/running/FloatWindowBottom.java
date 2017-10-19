package com.sunrise.treadmill.views.workout.running;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.sunrise.treadmill.R;
import com.sunrise.treadmill.interfaces.services.FloatWindowBottomCallBack;
import com.sunrise.treadmill.interfaces.services.RunningActivityBottomCallBack;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ChuHui on 2017/10/11.
 */

public class FloatWindowBottom extends ConstraintLayout {
    private FloatWindowBottomCallBack windowBottomCallBack;

    public FloatWindowBottom(Context context) {
        this(context, null);
    }

    public FloatWindowBottom(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FloatWindowBottom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.float_window_workout_running_bottom, this, true);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.workout_running_level_up)
    public void levelUp() {
        if (windowBottomCallBack != null) {
            windowBottomCallBack.onLevelUp();
        }
    }

    @OnClick(R.id.workout_running_level_down)
    public void levelDown() {
        if (windowBottomCallBack != null) {
            windowBottomCallBack.onLevelDown();
        }
    }

    @OnClick(R.id.workout_running_windy)
    public void windyChange() {
        if (windowBottomCallBack != null) {
            windowBottomCallBack.onWindyClick();
        }
    }

    @OnClick(R.id.workout_running_stop)
    public void sportStop() {
        if (windowBottomCallBack != null) {
            windowBottomCallBack.onStopClick();
        }
    }

    public void setWindowBottomCallBack(FloatWindowBottomCallBack callBack) {
        this.windowBottomCallBack = callBack;
    }
}