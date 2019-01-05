package com.test.headydemo.ui.product

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.headydemo.R
import com.test.headydemo.inflate
import com.test.headydemo.model.Rankings
import kotlinx.android.synthetic.main.fragment_subcat_dialog_item.view.*

/**
 * Created by Furqan on 05-01-2019.
 */
class FilterAdapter(private val fragment: FilterDialogFragment, private val rankings: List<Rankings>) :
    RecyclerView.Adapter<FilterAdapter.SubCatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCatViewHolder {
        val view = parent.inflate(R.layout.fragment_subcat_dialog_item)
        return SubCatViewHolder(view)
    }

    override fun getItemCount(): Int = rankings.size

    override fun onBindViewHolder(holder: SubCatViewHolder, position: Int) {
        holder.bindFilter(rankings[position])
    }

    inner class SubCatViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        val view = v
        lateinit var ranking: Rankings

        init {
            view.setOnClickListener(this)
        }

        fun bindFilter(ranking: Rankings) {
            this.ranking = ranking
            view.txtSubCat.text = ranking.ranking

        }


        override fun onClick(p: View?) {
            fragment.filter(ranking.products,adapterPosition)
        }


    }

}