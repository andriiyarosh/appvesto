package com.example.appvesto.contract

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface FlutterInterface {

    interface FlutterView {

        fun initView()
        fun updateViewData()

    }

    interface FlutterPresenter {

        fun receiveLatestVersion()
        fun getVersion(): MutableLiveData<Double>

    }

    interface FlutterModel {

        fun receiveLatestVersion()
        fun getVersion(): MutableLiveData<Double>

    }

}