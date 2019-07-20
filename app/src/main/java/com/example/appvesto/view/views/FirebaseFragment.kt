package com.example.appvesto.view.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appvesto.R
import com.example.appvesto.contract.AppleFirebaseInterface
import com.example.appvesto.Data
import com.example.appvesto.presenter.FirebasePresenterImpl
import com.example.appvesto.view.Adapter
import kotlinx.android.synthetic.main.fragment_firebase.*

class FirebaseFragment : Fragment(), AppleFirebaseInterface.AppleFirebaseView {

    private lateinit var adapter: Adapter
    private lateinit var presenter: AppleFirebaseInterface.AppleFirebasePresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_firebase, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter = FirebasePresenterImpl(this)
    }

    override fun initRecycler() {

        fragment_firebase_rv.layoutManager = LinearLayoutManager(context)
        adapter = Adapter()
        fragment_firebase_rv.adapter = adapter

    }

    override fun initListener() {

        fragment_firebase_button.setOnClickListener {
            fragment_firebase_button.isClickable = false
            updateData()
        }
        fragment_firebase_swipe.setOnRefreshListener {
            updateData()
        }

    }

    override fun insertData() {

        presenter.getData()
            .observe(this, Observer<ArrayList<Data>> { t ->
                if (t != null) {
                    adapter.addData(t)
                    stopRefreshLayout()
                    fragment_firebase_button.isClickable = true
                }
            })

    }

    private fun updateData() {
        fragment_firebase_swipe.isRefreshing = true
        presenter.clearData()
        adapter.clearData()
        presenter.receiveData()
    }

    private fun stopRefreshLayout() {
        fragment_firebase_swipe.isRefreshing = false
    }

}
