package com.neppplus.gudoc_in.adapters.categories

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.neppplus.gudoc_in.R
import com.neppplus.gudoc_in.datas.SmallCategoryData

class CategoryListRecyclerViewAdapterForAll(
    val mContext: Context, val mList: List<SmallCategoryData>
) : RecyclerView.Adapter<CategoryListRecyclerViewAdapterForAll.SmallCategoryViewHolder>() {

    inner class SmallCategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtSmallCategory = view.findViewById<TextView>(R.id.txtSmallCategory)

        fun bind(data: SmallCategoryData) {
            txtSmallCategory.text = data.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmallCategoryViewHolder {
        val row =
            LayoutInflater.from(mContext).inflate(R.layout.category_list_item_for_all, parent, false)
        return SmallCategoryViewHolder(row)
    }

    override fun onBindViewHolder(holder: SmallCategoryViewHolder, position: Int) {
        val data = mList[position]
        holder.bind(data)
    }

    override fun getItemCount() = mList.size

}