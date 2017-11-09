package com.sunrise.treadmill.activity.workoutrunning;

import android.widget.ImageView;

import com.sunrise.treadmill.Constant;
import com.sunrise.treadmill.R;
import com.sunrise.treadmill.bean.Level;
import com.sunrise.treadmill.dialog.workoutrunning.WarmUpDialog;
import com.sunrise.treadmill.interfaces.workout.running.DialogWarmUpClick;
import com.sunrise.treadmill.utils.DateUtil;
import com.sunrise.treadmill.utils.ImageUtils;
import com.sunrise.treadmill.utils.ThreadPoolUtils;
import com.sunrise.treadmill.views.workout.LevelView;

import java.util.List;

/**
 * Created by ChuHui on 2017/9/27.
 */

public class FitnessTestRunningActivity extends BaseRunningActivity implements DialogWarmUpClick {

    private int showWarmTimes = -1;

    @Override
    public void init() {
        super.init();
        ImageUtils.changeImageView((ImageView) bottomView.findViewById(R.id.workout_running_level_up), R.drawable.btn_sportmode_up_3);
        ImageUtils.changeImageView((ImageView) bottomView.findViewById(R.id.workout_running_level_down), R.drawable.btn_sportmode_down_3);
    }

    @Override
    protected void setUpInfo() {
        //这里获取到的是目标运行分钟数
        runningTimeTarget = Integer.valueOf(workOutInfo.getTime());
        //这里获取已经运行的时间 以秒为单位
        runningTimeTotal = Integer.valueOf(workOutInfo.getRunningTime());

        //累加形式 计算时间
        isCountDownTime = false;
        headView.setTimeValue(DateUtil.getFormatMMSS(runningTimeTotal));

        avgLevelTime = 60;
        timerMissionTimes = (int) runningTimeTotal / (int) avgLevelTime;

        tgLevel = timerMissionTimes % LevelView.columnCount;

        headView.setLevelValue(workOutInfo.getLevelList().get(timerMissionTimes).getLevel());

        runningDistanceTarget = Integer.valueOf(workOutInfo.getDistance());
        runningDistanceTotal = Integer.valueOf(workOutInfo.getRunningDistance());
        runningDistanceSurplus = runningDistanceTarget - runningDistanceTotal;
        headView.setDistanceValue(runningDistanceTotal + "");

        runningCaloriesTarget = Integer.valueOf(workOutInfo.getCalories());
        runningCaloriesTotal = Integer.valueOf(workOutInfo.getRunningCalories());
        runningCaloriesSurplus = runningCaloriesTarget - runningCaloriesTotal;
        headView.setCaloriesValue(runningCaloriesTotal + "");

        headView.setPulseValue(runningPulseTarget + "");

        headView.setWattValue(valueWatt + "");

        headView.setSpeedValue(valueSpeed + "");
    }

    @Override
    public void onStartTypeA() {
        drawLevelView();
        bindServer();
        showCountDownDialog();
    }

    @Override
    public void onStartTypeB() {
        drawLevelView();
        bindServer();
        runningTimer.start();
    }

    @Override
    public void onStartTypeC() {

    }

    @Override
    public void onLevelUp() {

    }

    @Override
    public void onLevelDown() {
    }

    @Override
    public void animationStopped() {
        if (showWarmTimes == -1) {
            showWarmUpDialog();
            showWarmTimes = 1;
            return;
        }
        if (runningTimer != null) {
            runningTimer.start();
        }
    }

    @Override
    public void onWarmUpSkip() {
        if (runningTimer != null) {
            runningTimer.start();
        }
    }

    @Override
    public void timerTick() {
        runningTimeTotal++;
        headView.setTimeValue(DateUtil.getFormatMMSS(runningTimeTotal));
        //切换到下一阶段的Level
        if (runningTimeTotal % avgLevelTime == 0) {
            //特殊地方将阶段时间间隔由60秒缩减到15秒
            avgLevelTime = 15;
            timerMissionTimes++;
            tgLevel++;
            if (!isCountDownTime) {
                //累加时间时才触发
                if (timerMissionTimes % LevelView.columnCount == 0) {
                    tgLevel = 0;
                    List<Level> arr = workOutInfo.getLevelList();
                    for (int i = 0; i < LevelView.columnCount; i++) {
                        Level level = new Level();
                        level.setLevel(1);
                        arr.add(level);
                    }
                    workOutInfo.setLevelList(arr);
                    levelView.setLevelList(workOutInfo.getLevelList());
                }
            }
            moveBuoy();
        }
    }

    /**
     * 热身运动
     */
    private void showWarmUpDialog() {
        ThreadPoolUtils.runTaskOnThread(new Runnable() {
            @Override
            public void run() {
                WarmUpDialog dialog = new WarmUpDialog();
                dialog.show(fragmentManager, Constant.TAG);
            }
        });
    }

}