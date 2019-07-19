package com.example.appvesto.model.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appvesto.contract.FlutterInterface
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import java.io.IOException
import java.lang.NumberFormatException

class FlutterModelImpl : FlutterInterface.FlutterModel {

    private var url = "https://flutter.dev/"
    private var version: MutableLiveData<Double> = MutableLiveData()

    override fun receiveLatestVersion() {

        GlobalScope.launch {

            try {

                parseWebpage()

            }catch (e: IOException) {}

        }

    }

    private fun parseWebpage() {

        val document: org.jsoup.nodes.Document? = Jsoup.connect(url).get()
        val element: Elements? = document
            ?.select("div[class=site-banner site-banner--default]")
        val title: String? = element?.select("a")?.eq(0)?.text()
        title?.let {
            val words = title.split(" ")
            for (s in words) {
                try {
                    version.postValue(s.toDouble())
                } catch (e: NumberFormatException) {
                    continue
                }
            }
            Log.i("model_ver", version.toString())
        }

    }

    override fun getVersion(): MutableLiveData<Double>{
        return version
    }

}