package com.example.appvesto.contract

import androidx.lifecycle.MutableLiveData
import com.example.appvesto.model.objects.Data

interface AppleInterface {

    interface AppleView {

        fun initRecycler()
        fun initListener()
        fun insertData()

    }

    interface ApplePresenter {

        fun receiveData()
        fun getData(): MutableLiveData<ArrayList<Data>>
        fun clearData()

    }

    interface AppleModel {

        fun receiveData()
        fun getData(): MutableLiveData<ArrayList<Data>>
        fun clearData()

    }

}