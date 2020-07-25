package com.example.lookfan.presenter.impl;

import com.example.lookfan.presenter.inter.IDescPresenter;
import com.example.lookfan.view.DescView;

import org.jetbrains.annotations.NotNull;

public class DescPresenter implements IDescPresenter {
    private DescView mCallback = null;

    @Override
    public void registerCallback(DescView callback) {
        if (callback != null) {
            mCallback = callback;
        }
    }

    @Override
    public void unRegisterCallback(DescView callback) {
        mCallback = null;
    }

    @Override
    public void loadData() {

    }

    @Override
    public void loadData(@NotNull String url) {

    }
}
