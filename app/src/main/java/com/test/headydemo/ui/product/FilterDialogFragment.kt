package com.test.headydemo.ui.product

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.headydemo.HeadyDemoApp
import com.test.headydemo.R
import com.test.headydemo.helper.Filter
import com.test.headydemo.model.Products
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_subcat_dialog.*

class FilterDialogFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_subcat_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title.text = getString(R.string.filte)
        list.layoutManager = LinearLayoutManager(context)

        HeadyDemoApp.database?.rankingDao()?.getAllProductRanking()!!.subscribeOn(
            Schedulers.io()
        ).observeOn(AndroidSchedulers.mainThread())
            .subscribe { rankings ->
                list.adapter = FilterAdapter(this@FilterDialogFragment, rankings)
            }
    }

    companion object {
        lateinit var filter: Filter
        fun newInstance(filter: Filter): FilterDialogFragment {
            this.filter = filter
            return FilterDialogFragment()
        }

    }

    fun filter(products: List<Products>, type: Int) {
        filter.sortedBy(products, type)
        dismiss()
    }

}
