package com.example.appvesto.view.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.appvesto.R
import com.example.appvesto.contract.FlutterInterface
import com.example.appvesto.presenter.FlutterPresenterImpl
import kotlinx.android.synthetic.main.fragment_flutter.*

class FlutterFragment : Fragment(), FlutterInterface.FlutterView {

    private lateinit var flutterPresenter: FlutterPresenterImpl

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_flutter, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        flutterPresenter = FlutterPresenterImpl(this)
    }

    override fun initView() {
        fragment_flutter_button.setOnClickListener {
            flutterPresenter.receiveLatestVersion()
        }
    }

    override fun updateViewData() {
        val observer = Observer<Double> {
            version ->
                fragment_flutter_tv.text = version.toString()

        }
        flutterPresenter.getVersion().observe(this, observer)

    }
}
