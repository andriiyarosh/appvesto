package com.example.appvesto.contract

import androidx.lifecycle.MutableLiveData
import com.example.appvesto.Data

interface AppleFirebaseInterface {

    interface AppleFirebaseView {

        fun initRecycler()
        fun initListener()
        fun insertData()

    }

    interface AppleFirebasePresenter {

        fun receiveData()
        fun getData(): MutableLiveData<ArrayList<Data>>
        fun clearData()

    }

    interface AppleFirebaseModel {

        fun receiveData()
        fun getData(): MutableLiveData<ArrayList<Data>>
        fun clearData()

    }

}