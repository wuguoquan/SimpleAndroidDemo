package com.example.wugq.simpleandroiddemo.common.view;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by wugq on 2017/8/27.
 */
public class CommonTabBean implements CustomTabEntity {

    private int selectedIcon;
    private int unselectedIcon;
    private String title;

    public CommonTabBean(String title) {
        this.title = title;
    }

    public CommonTabBean(String title, int selectedIcon, int unselectedIcon) {
        this.selectedIcon = selectedIcon;
        this.unselectedIcon = unselectedIcon;
        this.title = title;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabUnselectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabSelectedIcon() {
        return unselectedIcon;
    }
}
