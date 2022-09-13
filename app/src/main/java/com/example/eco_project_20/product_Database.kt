package com.example.eco_project_20

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class product_Database(
    var mlist:List<ItemViewModel>, var context: Context): RecyclerView.Adapter<product_Database.MyviewHolder>() {
    class MyviewHolder(itemview: View):RecyclerView.ViewHolder(itemview) {

        var text:TextView=itemview.findViewById(R.id.textView1)
        var imageview:ImageView=itemview.findViewById(R.id.Imageview1)
        var cc:CardView=itemview.findViewById(R.id.cc)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {

        var view=LayoutInflater.from(parent.context).inflate(R.layout.product_img,null,false)
        return MyviewHolder(view)

    }
    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {

        var ItemViewModel=mlist[position]
        holder.text.text=ItemViewModel.text
        Glide.with(context).load(ItemViewModel.image).into(holder.imageview);
        holder.cc.setOnClickListener {
            var intent=Intent(context,MainActivity2::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivities(arrayOf(intent))
        }

    }
    override fun getItemCount(): Int {
        return mlist.size
    }
}