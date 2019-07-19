package com.example.appvesto.contract

import androidx.lifecycle.MutableLiveData
import com.example.appvesto.model.objects.Data

interface FirebaseInterface {

    interface FirebaseView {

        fun initRecycler()
        fun initListener()
        fun insertData()

    }

    interface FirebasePresenter {

        fun receiveData()
        fun getData(): MutableLiveData<ArrayList<Data>>
        fun clearData()

    }

    interface FirebaseModel {

        fun receiveData()
        fun getData(): MutableLiveData<ArrayList<Data>>
        fun clearData()

    }

}