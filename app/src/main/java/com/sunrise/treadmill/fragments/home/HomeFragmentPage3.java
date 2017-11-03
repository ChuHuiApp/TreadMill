package com.sunrise.treadmill.fragments.home;

import android.view.View;

import com.sunrise.treadmill.Constant;
import com.sunrise.treadmill.R;
import com.sunrise.treadmill.base.BaseFragment;
import com.sunrise.treadmill.interfaces.home.OnModeSelectReturn;

import butterknife.OnClick;

/**
 * Created by ChuHui on 2017/9/12.
 */

public class HomeFragmentPage3 extends BaseFragment {
    private OnModeSelectReturn selectReturn;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_page_3;
    }

    @Override
    protected void init() {
        selectReturn = (OnModeSelectReturn) getActivity();
    }
    @Override
    public void recycleObject() {
    }
    public void setSelectReturn(OnModeSelectReturn selectReturn){
        this.selectReturn=selectReturn;
    }

    @OnClick({R.id.home_app_mode_mp3, R.id.home_app_mode_mp4, R.id.home_app_mode_avin,
            R.id.home_app_mode_twitter, R.id.home_app_mode_screen_mirror, R.id.workout_mode_quick_start})
    public void onMediaClick(View view) {
        switch (view.getId()) {
            default:
                break;
            case R.id.home_app_mode_mp3:
                selectReturn.onMediaStart(Constant.MODE_MEDIA_MP3);
                break;
            case R.id.home_app_mode_mp4:
                selectReturn.onMediaStart(Constant.MODE_MEDIA_MP4);
                break;
            case R.id.home_app_mode_avin:
                selectReturn.onMediaStart(Constant.MODE_MEDIA_AVIN);
                break;
            case R.id.home_app_mode_twitter:
                selectReturn.onMediaStart(Constant.MODE_MEDIA_TWITTER);
                break;
            case R.id.home_app_mode_screen_mirror:
                selectReturn.onMediaStart(Constant.MODE_MEDIA_SCREEN_MIRROR);
                break;
            case R.id.workout_mode_quick_start:
                selectReturn.onWorkOutSetting(Constant.MODE_QUICK_START);
                break;
        }
    }
}
