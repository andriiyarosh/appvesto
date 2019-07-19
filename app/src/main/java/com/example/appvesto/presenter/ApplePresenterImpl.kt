package com.example.appvesto.presenter

import androidx.lifecycle.MutableLiveData
import com.example.appvesto.contract.AppleInterface
import com.example.appvesto.model.models.AppleModelImpl
import com.example.appvesto.model.objects.Data

class ApplePresenterImpl(_view: AppleInterface.AppleView): AppleInterface.ApplePresenter {

    private var view: AppleInterface.AppleView = _view
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