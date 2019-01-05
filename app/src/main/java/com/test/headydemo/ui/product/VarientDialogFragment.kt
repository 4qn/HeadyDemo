package com.test.headydemo.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.test.headydemo.R
import com.test.headydemo.model.Variants
import kotlinx.android.synthetic.main.fragment_subcat_dialog.*
import java.util.*

/**
 * Created by Furqan on 05-01-2019.
 */
const val ARG_VARIANTS = "variants"

class VarientDialogFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_subcat_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title.text = getString(R.string.variant)
        val variants = arguments?.getParcelableArrayList<Variants>(ARG_VARIANTS)
        list.layoutManager = LinearLayoutManager(context)

        list.adapter = VarientAdapter(this@VarientDialogFragment, variants!!)

    }

    companion object {
        fun newInstance(variants: ArrayList<Variants>): VarientDialogFragment =
            VarientDialogFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_VARIANTS, variants)
                }
            }

    }

}
