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
import com.example.appvesto.presenter.ApplePresenterImpl
import com.example.appvesto.view.Adapter
import kotlinx.android.synthetic.main.fragment_apple.*

class AppleFragment : Fragment(), AppleFirebaseInterface.AppleFirebaseView {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var presenter: AppleFirebaseInterface.AppleFirebasePresenter
    private lateinit var adapter: Adapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_apple, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter = ApplePresenterImpl(this)
    }

    override fun initRecycler() {

        linearLayoutManager = LinearLayoutManager(context)
        fragment_apple_rv.layoutManager = linearLayoutManager
        adapter = Adapter()
        fragment_apple_rv.adapter = adapter

    }

    override fun initListener() {

        fragment_apple_button.setOnClickListener{
            updateData()
        }
        fragment_apple_swipe.setOnRefreshListener {
            updateData()
        }

    }

    override fun insertData() {

        presenter.getData()
            .observe(this, Observer<ArrayList<Data>> { t ->
                if (t != null) {
                    adapter.addData(t)
                    stopRefreshLayout()
                }
            })

    }

    private fun updateData() {
        fragment_apple_swipe.isRefreshing = true
        presenter.clearData()
        adapter.clearData()
        presenter.receiveData()
    }

    private fun stopRefreshLayout() {
        fragment_apple_swipe.isRefreshing = false
    }

}
