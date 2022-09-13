package com.example.eco_project_20

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/*
class Custom_RecyclerView_Adapter(var mlist:List<ItemviewHolder>):RecyclerView.Adapter<Custom_RecyclerView_Adapter.MyViewHodler>() {
    class MyViewHodler(Itemview:View):RecyclerView.ViewHolder(Itemview){
        var image:ImageView=itemView.findViewById(R.id.imageview1)
        var text:TextView=itemView.findViewById(R.id.textView1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHodler {

        var view=LayoutInflater.from(parent.context).inflate(R.layout.fragment_home,null,false)
        return MyViewHodler(view)

    }

    override fun onBindViewHolder(holder: MyViewHodler, position: Int) {
        var ItemviewHolder=mlist[position]
        holder.image.setImageResource(ItemviewHolder.image)
        holder.text.text=ItemviewHolder.text
    }

    override fun getItemCount(): Int {
        return mlist.size
    }
}*/
