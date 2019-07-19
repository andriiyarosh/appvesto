package com.example.appvesto.presenter

import androidx.lifecycle.MutableLiveData
import com.example.appvesto.contract.AppleFirebaseInterface
import com.example.appvesto.model.models.AppleModelImpl
import com.example.appvesto.Data

class ApplePresenterImpl(_view: AppleFirebaseInterface.AppleFirebaseView): AppleFirebaseInterface.AppleFirebasePresenter {

    private var view: AppleFirebaseInterface.AppleFirebaseView = _view
    private var model: AppleModelImpl = AppleModelImpl()

    init {
        view.initRecycler()
        view.initListener()
    }

    override fun receiveData() {
        model.receiveData()
        view.insertData()
    }

    override fun getData(): MutableLiveData<ArrayList<Data>> = model.getData()


    override fun clearData() = model.clearData()
}