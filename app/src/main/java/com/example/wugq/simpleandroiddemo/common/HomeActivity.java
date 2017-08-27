package com.example.wugq.simpleandroiddemo.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wugq.simpleandroiddemo.R;
import com.example.wugq.simpleandroiddemo.common.view.CommonPagerAdapter;
import com.example.wugq.simpleandroiddemo.common.view.CommonTabBean;
import com.example.wugq.simpleandroiddemo.duanzi.ui.DuanziFragment;
import com.example.wugq.simpleandroiddemo.meizi.ui.MeiziFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wugq on 2017/8/27.
 */
public class HomeActivity extends AppCompatActivity{

    ViewPager mHomeVp;
    CommonTabLayout mHomeTabLayout;
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    ImageView mIvDraw;
    TextView mTvNormal;
    TextView mTvCenter;
    ImageView mIvMenu;
    LinearLayout mContactsTabRl;

    private static final int[] SELECTED_ICONS = new int[]{R.drawable.diary_selected, R.drawable.duanzi_selected, R.drawable.meizi_selected};
    private static final int[] UN_SELECTED_ICONS = new int[]{R.drawable.diary_unselected, R.drawable.duanzi_unselected, R.drawable.meizi_unselected};
    private static final String[] TITLES = new String[]{"日记", "段子", "妹子"};

    private List<Fragment> mFragments;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mHomeVp = (ViewPager) findViewById(R.id.home_view_pager);
        mHomeTabLayout = (CommonTabLayout) findViewById(R.id.home_tab_layout);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.home_dl);
        mNavigationView = (NavigationView) findViewById(R.id.home_navigation_view);
        mIvDraw = (ImageView) findViewById(R.id.home_iv_draw);
        mTvNormal = (TextView) findViewById(R.id.home_tv_title_normal);
        mTvCenter = (TextView) findViewById(R.id.home_tv_title_center);
        mIvMenu = (ImageView) findViewById(R.id.home_iv_menu);
        mContactsTabRl = (LinearLayout) findViewById(R.id.contacts_tab_rl);

        initTabLayout();
        initVierPager();
        initToolbar();
    }

    private void initToolbar() {
        mIvDraw.setVisibility(View.GONE);
        mIvMenu.setVisibility(View.GONE);
        mTvCenter.setVisibility(View.VISIBLE);
        mTvNormal.setVisibility(View.GONE);
    }

    private void initVierPager() {
        mFragments = new ArrayList<>();
        mFragments.add(MeiziFragment.newInstance());
        mFragments.add(DuanziFragment.newInstance());
        mFragments.add(MeiziFragment.newInstance());
        CommonPagerAdapter adapter = new CommonPagerAdapter(getSupportFragmentManager(), mFragments);
        mHomeVp.setAdapter(adapter);
    }

    private void initTabLayout() {
        ArrayList<CustomTabEntity> tabEntityList = new ArrayList<>();
        for (int i = 0; i < TITLES.length; i++) {
            tabEntityList.add(new CommonTabBean(TITLES[i]
                    , SELECTED_ICONS[i]
                    , UN_SELECTED_ICONS[i]));
        }

        mHomeTabLayout.setTabData(tabEntityList);
        mHomeTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mHomeVp.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        mHomeVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mHomeTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mHomeVp.setOffscreenPageLimit(4);
        mHomeVp.setCurrentItem(1);
    }

//    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//    @Subscribe
//    public void startUpdateDiaryActivity(StartUpdateDiaryEvent event) {
//        DiaryBean diaryBean = event.getDiaryBean();
//        String title = diaryBean.getTitle();
//        String content = diaryBean.getContent();
//        String tag = diaryBean.getTag();
//        UpdateDiaryActivity.startActivity(this, title, content, tag);
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // TODO: 在主页面按返回键时弹出对话框，提示用户是否退出程序
    }
}
