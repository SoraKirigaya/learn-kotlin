package com.raywenderlich.listmaker

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var listPositionTextView: TextView = itemView.findViewById<TextView>(R.id.itemNumber)
    var listTitleTextView: TextView = itemView.findViewById<TextView>(R.id.itemString)

}