package com.github.ihoyong.mvvmexample.viewholder

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.github.ihoyong.mvvmexample.R
import com.github.ihoyong.mvvmexample.model.AgodaItem
import kotlinx.android.synthetic.main.main_item.view.*

class MainViewHolder(view: View, private val context: Context) : RecyclerView.ViewHolder(view) {


    private val container = view.findViewById<ConstraintLayout>(R.id.main_item_container)
    private val image = view.findViewById<ImageView>(R.id.main_item_iv_image)
    private val name = view.findViewById<TextView>(R.id.main_item_tv_name)
    private val score = view.findViewById<TextView>(R.id.main_item_tv_score)
    private val dailyRate = view.findViewById<TextView>(R.id.main_item_tv_dailyRate)
    private val discount = view.findViewById<TextView>(R.id.main_item_tv_discount)
    private val wifi = view.findViewById<TextView>(R.id.main_item_tv_wifi)
    private val breakFast = view.findViewById<TextView>(R.id.main_item_tv_breakFast)

    fun bind(item: AgodaItem) {

        container.setOnClickListener { }


        Glide.with(context)
                .load(item.imageUrl)
                .apply(requestOptions)
                .into(image)

        name.text = item.name
        score.text = "평점- " + item.score.toString()
        dailyRate.text = item.dailyRate.toString() + " 달러"
        discount.text = item.discountPrecent.toString() + " %"
        wifi.text = convertWifi(item.wifi)
        breakFast.text = convertBreakFast(item.breakfast)
    }

    fun convertWifi(wifi: Boolean): String {
        if (wifi) {
            return "와이파이 : 제공"
        } else {
            return "와이파이 : 미제공"
        }
    }

    fun convertBreakFast(bf: Boolean): String {
        if (bf) {
            return "아침 : 제공"
        } else {
            return "아침 : 미제공"
        }
    }

    private val requestOptions = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.NONE)
}