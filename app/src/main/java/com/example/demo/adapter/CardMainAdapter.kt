package com.example.demo.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import com.example.demo.activity.DetailActivity
import com.example.demo.model.UserDataClass
import com.squareup.picasso.Picasso


class CardMainAdapter : RecyclerView.Adapter<CardMainAdapter.ViewHolder>() {

    var mItems: ArrayList<UserDataClass> = ArrayList()
    lateinit var context: Context

    fun cardMainAdapter(item: ArrayList<UserDataClass>) {
        this.mItems = item
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mItems[position]
        holder.bind(item, position, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        context = parent.context
        return ViewHolder(layoutInflater.inflate(R.layout.card_item_view, parent, false))
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvTitle = view.findViewById(R.id.tvTitle) as TextView
        private val tvType = view.findViewById(R.id.tvType) as TextView
        private val tvSiteAdmin = view.findViewById(R.id.tvInfoSite) as TextView
        private val imgUser = view.findViewById(R.id.ivUserIconMain) as ImageView
        private val cardView = view.findViewById(R.id.cardView) as CardView

        fun bind(data: UserDataClass, position: Int, context: Context) {
            tvTitle.text = data.login
            tvType.text = data.type
            tvSiteAdmin.text =
                context.resources.getString(R.string.site) + " : " + data.site_admin.toString()
            Picasso.get().load(data.avatar_url).into(imgUser)

            cardView.setOnClickListener {
                val intent = Intent(context.applicationContext, DetailActivity::class.java)
                intent.putExtra("username", data.login)
                context.startActivity(intent)
            }
        }
    }
}
