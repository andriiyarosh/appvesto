package com.example.appvesto.presenter

import androidx.lifecycle.MutableLiveData
import com.example.appvesto.contract.FirebaseInterface
import com.example.appvesto.model.models.FirebaseModelImpl
import com.example.appvesto.model.objects.Data

class FirebasePresenterImpl (_view: FirebaseInterface.FirebaseView): FirebaseInterface.FirebasePresenter {

    var firebaseInterface: FirebaseInterface.FirebaseView = _view
    var model: FirebaseModelImpl = FirebaseModelImpl()

    init {
        firebaseInterface.initRecycler()
        firebaseInterface.initListener()
    }

    override fun receiveData() {
        model.receiveData()
        firebaseInterface.insertData()
    }

    override fun getData(): MutableLiveData<ArrayList<Data>> = model.getData()

    override fun clearData() = model.clearData()
}