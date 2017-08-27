package com.example.wugq.simpleandroiddemo.duanzi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.VolleyError;
import com.example.wugq.simpleandroiddemo.R;
import com.example.wugq.simpleandroiddemo.common.net.VolleyHelper;
import com.example.wugq.simpleandroiddemo.common.net.VolleyResponseCallback;
import com.example.wugq.simpleandroiddemo.duanzi.api.DuanziApi;
import com.example.wugq.simpleandroiddemo.duanzi.bean.DuanziBean;
import com.example.wugq.simpleandroiddemo.duanzi.utils.GsonHelper;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * Created by wugq on 2017/8/27.
 */
public class DuanziFragment extends Fragment {

    RecyclerView mRvShowDuanzi;
    SwipeRefreshLayout mRefresh;

    public static DuanziFragment newInstance() {
        return new DuanziFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_duanzi, container, false);
        mRvShowDuanzi = (RecyclerView) view.findViewById(R.id.duanzi_rv_show_duanzi);
        mRefresh = (SwipeRefreshLayout) view.findViewById(R.id.duanzi_refresh);
        initView();
        initRefresh();
        return view;
    }

    private void initRefresh() {
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
        VolleyHelper.sendHttpGet(getActivity(), DuanziApi.GET_DUANZI, new VolleyResponseCallback() {
            @Override
            public void onSuccess(String response) {
                List<DuanziBean> mDuanziBeanList = GsonHelper.getDuanziBeanList(response);
                mDuanziBeanList.remove(3);
                mRvShowDuanzi.setLayoutManager(new LinearLayoutManager(getActivity()));
                mRvShowDuanzi.setAdapter(new DuanziAdapter(DuanziFragment.this, mDuanziBeanList));
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
