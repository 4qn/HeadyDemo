package com.test.headydemo.ui.category

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.headydemo.R
import com.test.headydemo.inflate
import com.test.headydemo.model.Categories
import kotlinx.android.synthetic.main.item_category.view.*
import java.util.*

/**
 * Created by Furqan on 03-01-2019.
 */
class CategoryAdapter(private val activity: MainActivity, private val categories: List<Categories>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = parent.inflate(R.layout.item_category)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindCategory(categories[position])
    }

    inner class CategoryViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        val view = v
        lateinit var category: Categories

        init {
            view.setOnClickListener(this)
        }

        fun bindCategory(category: Categories) {
            this.category = category
            view.layoutCategory.setBackgroundColor(pickRandomColor())
            view.txtCategory.text = category.name
        }

        private fun pickRandomColor(): Int {
            val random = Random()
            return Color.rgb(
                random.nextInt(256), random.nextInt(256),
                random.nextInt(256)
            )
        }

        override fun onClick(p: View?) {
            showSubCat(category.child_categories)
        }

        private fun showSubCat(childCategoriesIds: ArrayList<Int>) {
            val subCatDialogFragment =
                SubCatDialogFragment.newInstance(childCategoriesIds)
            subCatDialogFragment.show(activity.supportFragmentManager, subCatDialogFragment.tag)
            /* childCategoriesIds.forEach {
                 HeadyDemoApp.database?.categoryDao()?.getCategoryById(it)!!.subscribeOn(Schedulers.io())
                     .observeOn(AndroidSchedulers.mainThread())
                     .subscribe { cat ->
                         subCat.add(cat)
                     }

             }*/
            /* HeadyDemoApp.database?.categoryDao()?.getSubCategories(childCategoriesIds)!!.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe { cat ->
                     subCat.addAll(cat)
                     Log.d("TAG", " size is${subCat.size}")
                 }
 */
        }
    }
}