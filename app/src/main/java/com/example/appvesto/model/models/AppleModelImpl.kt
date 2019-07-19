package com.example.appvesto.model.models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.appvesto.constants.Constants
import com.example.appvesto.contract.AppleInterface
import com.example.appvesto.model.objects.Data
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import java.io.IOException

class AppleModelImpl : AppleInterface.AppleModel {

    private var url = " https://apple.com"
    private var liveData: MutableLiveData<ArrayList<Data>> = MutableLiveData()
    private var dataArray: ArrayList<Data> = ArrayList()

    override fun receiveData() {

        Log.i("model_header", "!!!!")
        GlobalScope.launch {

            try {
                parseWebpage()
                Log.i("model_header", "___")

            } catch (e: IOException) {
            }

        }

    }

    private fun parseWebpage() {

        val document: org.jsoup.nodes.Document? = Jsoup.connect(url).get()
        val elements: Elements? = document
            ?.select("a")
        if (elements != null) {
            for (i: Int in 0 until elements.size) {
                val header: String? = elements.eq(i)
                    .text()
                val link: String? = elements.eq(i)
                    .attr("href")
                Log.i("model_header", link)
                if (link != null && header !=null) {
                    dataArray.add(Data(Constants.APPLE, header, link))
                }
            }
            if (dataArray.size != 0) {
                liveData.postValue(dataArray)
            }
        }

    }

    override fun getData(): MutableLiveData<ArrayList<Data>> = liveData

    override fun clearData() {
        liveData = MutableLiveData()
        dataArray.clear()
    }

}