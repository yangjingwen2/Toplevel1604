package com.androidxx.yangjw.day39_mvp_demo.presenter;

import com.androidxx.yangjw.day39_mvp_demo.model.CustomModel;
import com.androidxx.yangjw.day39_mvp_demo.model.IUserModel;
import com.androidxx.yangjw.day39_mvp_demo.model.UserModel;
import com.androidxx.yangjw.day39_mvp_demo.view.IUserView;

/**
 * Created by yangjw on 2016/8/26.
 */
public class UserPresenter implements IUserPresenter{

    IUserModel userModel = new CustomModel();
    IUserView mUserView;

    public UserPresenter(IUserView mUserView) {
        this.mUserView = mUserView;
    }

    public void getName() {
        String name = userModel.getName();
        if (name.length() > 6) {
            mUserView.setText(name);
        } else {
            mUserView.setText("无效字符串");
        }
    }
}
