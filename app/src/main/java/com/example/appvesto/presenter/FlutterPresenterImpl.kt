package com.example.appvesto.presenter

import com.example.appvesto.contract.FlutterInterface
import com.example.appvesto.model.models.FlutterModelImpl
import com.example.appvesto.view.views.FlutterFragment

class FlutterPresenterImpl(_view: FlutterFragment): FlutterInterface.FlutterPresenter {

    private var view: FlutterInterface.FlutterView = _view
    private var model: FlutterModelImpl = FlutterModelImpl()

    init {
        view.initView()
    }

    override fun receiveLatestVersion() {
        model.receiveLatestVersion()
        view.updateViewData()
    }

    override fun getVersion() = model.getVersion()
}