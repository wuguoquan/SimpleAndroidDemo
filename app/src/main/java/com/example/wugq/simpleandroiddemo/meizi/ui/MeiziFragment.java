package com.example.wugq.simpleandroiddemo.meizi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.VolleyError;
import com.example.wugq.simpleandroiddemo.R;
import com.example.wugq.simpleandroiddemo.common.net.VolleyHelper;
import com.example.wugq.simpleandroiddemo.common.net.VolleyResponseCallback;
import com.example.wugq.simpleandroiddemo.meizi.api.MeiziApi;
import com.example.wugq.simpleandroiddemo.meizi.bean.MeiziBean;
import com.example.wugq.simpleandroiddemo.meizi.utils.GsonHelper;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wugq on 2017/8/27.
 */
public class MeiziFragment extends Fragment {

    RecyclerView mRvShowMeizi;
    SwipeRefreshLayout mRefresh;

    List<MeiziBean> meiziBeanList = new ArrayList<>();
    private static String response = "";

    public static MeiziFragment newInstance() {
        return new MeiziFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meizi, container, false);
        mRvShowMeizi = (RecyclerView) view.findViewById(R.id.meizi_rv_show_meizi);
        mRefresh = (SwipeRefreshLayout) view.findViewById(R.id.meizi_refresh);
        initView();
        refreshMeizi();
        return view;
    }

    /**
     * 刷新当前界面
     */
    private void refreshMeizi() {
        mRefresh.setColorSchemeResources(R.color.colorPrimary);
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initView();
                mRefresh.setRefreshing(false);
            }
        });
    }

    private void initView() {

        VolleyHelper.sendHttpGet(getActivity(), MeiziApi.getMeiziApi(), new VolleyResponseCallback() {
            @Override
            public void onSuccess(String s) {
                response = s;
                meiziBeanList = GsonHelper.getMeiziBean(response);
                mRvShowMeizi.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                Collections.shuffle(meiziBeanList);
                mRvShowMeizi.setAdapter(new MeiziAdapter(meiziBeanList, MeiziFragment.this));
            }

            @Override
            public void onError(VolleyError error) {
                Logger.d(error);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
