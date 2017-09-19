package com.sunrise.treadmill.fragments.factory;

import android.widget.TextView;

import com.sunrise.treadmill.GlobalSetting;
import com.sunrise.treadmill.R;
import com.sunrise.treadmill.base.BaseFragment;
import com.sunrise.treadmill.utils.LanguageUtils;
import com.sunrise.treadmill.utils.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChuHui on 2017/9/14.
 */

public class Factory2FragmentCard3 extends BaseFragment {

    @Override
    public int getLayoutId() {
        return R.layout.factory2_fragment_card_3;
    }

    @Override
    protected void setTextStyle() {
        List<TextView> txtList = new ArrayList<TextView>();

        txtList.add((TextView) getParentView().findViewById(R.id.factory2_card3_1_usb));
        txtList.add((TextView) getParentView().findViewById(R.id.factory2_card3_2_updating));
        txtList.add((TextView) getParentView().findViewById(R.id.factory2_card3_2_not_shut_down));
        txtList.add((TextView) getParentView().findViewById(R.id.factory2_card3_3_download_failed));

        if (GlobalSetting.AppLanguage.equals(LanguageUtils.zh_CN)) {
            TextUtils.setTextTypeFace(txtList, TextUtils.MicrosoftBold(getContext()));
        } else {
            TextUtils.setTextTypeFace(txtList, TextUtils.ArialBold(getContext()));
        }
    }

    @Override
    protected void init() {

    }
}