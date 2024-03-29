package com.example.appvesto.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appvesto.R
import com.example.appvesto.Type
import com.example.appvesto.Data
import com.example.appvesto.view.ViewHolder
import kotlinx.android.synthetic.main.item_apple.view.*
import kotlinx.android.synthetic.main.item_firebase.view.*

class Adapter : RecyclerView.Adapter<ViewHolder>() {

    private var data: ArrayList<Data> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View
        return when (viewType) {
            Type.FIREBASE.toInt() -> {
                v = LayoutInflater.from(parent.context).inflate(R.layout.item_firebase, parent, false)
                Log.i("view_test_firebase", "created")
                ViewHolder(v)
            }
            else -> {
                v = LayoutInflater.from(parent.context).inflate(R.layout.item_apple, parent, false)
                Log.i("view_test_apple", "created")
                ViewHolder(v)
            }
        }
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val data: Data = this.data[position]
        if (data.type == Type.FIREBASE.toInt()) {
            holder.itemView.item_firebase_tv.text = data.header
            Log.i("view_test_firebase", "binded")
        } else if (data.type == Type.APPLE.toInt()) {
            holder.itemView.item_apple_header.text = data.header
            holder.itemView.item_apple_link.text = data.link
            Log.i("view_test_apple", data.link)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when (data[position].type) {
            Type.FIREBASE.toInt() -> {
                Type.FIREBASE.toInt()
            }
            else -> {
                Type.APPLE.toInt()
            }
        }
    }

    fun addData(data: ArrayList<Data>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    fun clearData() {
        this.data.clear()
        notifyDataSetChanged()
    }


}