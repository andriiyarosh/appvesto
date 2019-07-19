package com.example.appvesto.model.models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.appvesto.Type
import com.example.appvesto.contract.AppleFirebaseInterface
import com.example.appvesto.Data
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import java.io.IOException

class FirebaseModelImpl: AppleFirebaseInterface.AppleFirebaseModel {

    private var url = "https://firebase.google.com/products/#develop-products"
    private var data: MutableLiveData<ArrayList<Data>> = MutableLiveData()
    private var dataArray: ArrayList<Data> = ArrayList()

    override fun receiveData() {

        Log.i("model_header", "!!!!")
        GlobalScope.launch {

            try {

                parseWebpage()
                Log.i("model_header", "___")

            }catch (e: IOException) {}

        }

    }

    private fun parseWebpage () {

        val document: org.jsoup.nodes.Document? = Jsoup.connect(url).get()
        val elements: Elements? = document
            ?.select("header[class=card__header]")
        elements?.let {
            for (i: Int in 0 until elements.size) {
                val link: String? = document
                    .select("h2")
                    ?.eq(i)
                    ?.text()
                Log.i("model_header", link)
                if(link != null) {
                    dataArray.add(Data(Type.FIREBASE.toInt(), link, " "))
                }
            }
            if (dataArray.size != 0) {
                data.postValue(dataArray)
            }
        }

    }

    override fun getData(): MutableLiveData<ArrayList<Data>> = data

    override fun clearData() {
        data = MutableLiveData()
        dataArray.clear()
    }
}