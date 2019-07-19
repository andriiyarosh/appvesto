package com.example.appvesto.presenter

import androidx.lifecycle.MutableLiveData
import com.example.appvesto.contract.AppleFirebaseInterface
import com.example.appvesto.model.models.FirebaseModelImpl
import com.example.appvesto.Data

class FirebasePresenterImpl (_view: AppleFirebaseInterface.AppleFirebaseView): AppleFirebaseInterface.AppleFirebasePresenter {

    var firebaseInterface: AppleFirebaseInterface.AppleFirebaseView = _view
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