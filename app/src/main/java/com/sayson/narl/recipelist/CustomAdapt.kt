package com.sayson.narl.recipelist
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
/**
 * Created by Lran on 12/8/2017.
 */

class   CustomAdapt(val userList: ArrayList<User>, context: Context) : RecyclerView.Adapter<CustomAdapt.ViewHolder>() {

    var ttext = context
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val recipUser : User = userList[position]
        holder?.textViewName?.text = recipUser.recipeName
        holder?.textViewName2?.text = recipUser.description
        holder!!.textViewName.text =  recipUser.recipeName
        holder.textViewName2.text = recipUser.description

        holder.onCustomItemClick(object :ClickI{
            override fun onCustomItemClick(view: View, pos: Int) {
                if (pos == 0 ) {
                    val intent = Intent(ttext, Recipe1::class.java)
                    ttext.startActivity(intent);
                }
                if (pos == 1 ) {
                    val intent = Intent(ttext, Recipe2::class.java)
                    ttext.startActivity(intent);
                }
                if (pos == 2 ) {
                    val intent = Intent(ttext, Recipe3::class.java)
                    ttext.startActivity(intent);
                }


            }
        })


    }





    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.recipelayout, parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }



    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(v: View?) {
            this.customItemClick!!.onCustomItemClick(v!!, adapterPosition)
        }

        val textViewName: TextView
        val textViewName2: TextView
        val linearLayout: LinearLayout
        var customItemClick: ClickI?=null

        init {
            textViewName = itemView.findViewById<TextView>(R.id.textViewHandle)
            textViewName2 = itemView.findViewById<TextView>(R.id.textViewdest)
            linearLayout = itemView.findViewById<LinearLayout>(R.id.LinearLayout)
            itemView.setOnClickListener(this)
        }

        fun onCustomItemClick(itemClickListener: ClickI){
            this.customItemClick= itemClickListener
        }
    }


}