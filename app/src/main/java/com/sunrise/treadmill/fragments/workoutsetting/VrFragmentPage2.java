package com.sunrise.treadmill.fragments.workoutsetting;

import android.view.View;
import android.widget.TextView;

import com.sunrise.treadmill.GlobalSetting;
import com.sunrise.treadmill.R;
import com.sunrise.treadmill.activity.workoutsetting.VirtualRealityActivity;
import com.sunrise.treadmill.base.BaseFragment;
import com.sunrise.treadmill.interfaces.workout.setting.OnVrSelectReturn;
import com.sunrise.treadmill.utils.LanguageUtils;
import com.sunrise.treadmill.utils.TextUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

/**
 * Created by ChuHui on 2017/9/26.
 */

public class VrFragmentPage2 extends BaseFragment {
    private OnVrSelectReturn onVrSelectReturn;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_workout_vr_page_2;
    }

    @Override
    public void clearObj() {
        onVrSelectReturn = null;
        parentView = null;
    }
    @Override
    protected void init() {
        onVrSelectReturn = (OnVrSelectReturn) getActivity();
    }

    @Override
    protected void setTextStyle() {
        List<TextView> txtList = new ArrayList<TextView>();
        txtList.add((TextView) getParentView().findViewById(R.id.workout_mode_vr_name_5_1));
        txtList.add((TextView) getParentView().findViewById(R.id.workout_mode_vr_name_5_2));
        txtList.add((TextView) getParentView().findViewById(R.id.workout_mode_vr_name_6_1));
        txtList.add((TextView) getParentView().findViewById(R.id.workout_mode_vr_name_6_2));
        txtList.add((TextView) getParentView().findViewById(R.id.workout_mode_vr_name_7_1));
        txtList.add((TextView) getParentView().findViewById(R.id.workout_mode_vr_name_7_2));
        txtList.add((TextView) getParentView().findViewById(R.id.workout_mode_vr_name_8_1));
        txtList.add((TextView) getParentView().findViewById(R.id.workout_mode_vr_name_8_2));
        if (GlobalSetting.AppLanguage.equals(LanguageUtils.zh_CN)) {
            TextUtils.setTextTypeFace(txtList, TextUtils.Microsoft(getContext()));
        } else {
            TextUtils.setTextTypeFace(txtList, TextUtils.Arial(getContext()));
        }
    }

    @OnClick({R.id.workout_mode_vr_img_5, R.id.workout_mode_vr_img_6, R.id.workout_mode_vr_img_7, R.id.workout_mode_vr_img_8})
    public void onVRSelect(View view) {
        int selectVR;
        switch (view.getId()) {
            default:
                selectVR = VirtualRealityActivity.SELECT_NOTHING;
                break;
            case R.id.workout_mode_vr_img_5:
                selectVR = VirtualRealityActivity.TG_VALUE_5;
                break;
            case R.id.workout_mode_vr_img_6:
                selectVR = VirtualRealityActivity.TG_VALUE_6;
                break;
            case R.id.workout_mode_vr_img_7:
                selectVR = VirtualRealityActivity.TG_VALUE_7;
                break;
            case R.id.workout_mode_vr_img_8:
                selectVR = VirtualRealityActivity.TG_VALUE_8;
                break;
        }
        if (selectVR != VirtualRealityActivity.SELECT_NOTHING) {
            onVrSelectReturn.onVRSelect(selectVR);
        }
    }
}