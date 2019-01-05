package com.test.headydemo.ui.category

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.headydemo.HeadyDemoApp
import com.test.headydemo.R;
import com.test.headydemo.R.id.list
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_subcat_dialog.*
import java.util.ArrayList

const val ARG_SUB_CAT_IDS = "subCatIds"


/**
 *
 * A fragment that shows a list of items as a modal bottom sheet.
 *
 * You can show this modal bottom sheet from your activity like this:
 * <pre>
 *    SubCatDialogFragment.newInstance(30).show(supportFragmentManager, "dialog")
 * </pre>
 *
 * You activity (or fragment) needs to implement [SubCatDialogFragment.Listener].
 */
class SubCatDialogFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_subcat_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.layoutManager = LinearLayoutManager(context)
        val childCategoriesIds = arguments?.getIntegerArrayList(ARG_SUB_CAT_IDS)
        title.text =getString(R.string.sub_cat)
        HeadyDemoApp.database?.categoryDao()?.getSubCategories(childCategoriesIds as ArrayList<Int>)!!.subscribeOn(
            Schedulers.io()
        )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { cat ->
                list.adapter = SubCatAdapter(this@SubCatDialogFragment, cat)
            }
    }


    companion object {
        fun newInstance(childCategoriesIds: ArrayList<Int>): SubCatDialogFragment =
            SubCatDialogFragment().apply {
                arguments = Bundle().apply {
                    putIntegerArrayList(ARG_SUB_CAT_IDS, childCategoriesIds)
                }
            }

    }
}
