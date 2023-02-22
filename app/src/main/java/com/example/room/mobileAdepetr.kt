package com.example.room

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class mobileAdepetr(list: List<mobiledb>) :RecyclerView.Adapter<mobileAdepetr.MobileHolder>() {
  lateinit var Context:Context
  var list=list


    class MobileHolder(itemView: View) : ViewHolder(itemView) {


        var id =itemView.findViewById<TextView>(R.id.tvId)
        var name =itemView.findViewById<TextView>(R.id.tvName)
        var price =itemView.findViewById<TextView>(R.id.tvPrice)
        var reting=itemView.findViewById<RatingBar>(R.id.rtmobile)
        var delete=itemView.findViewById<ImageView>(R.id.ivDelete)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MobileHolder {
        Context=parent.context
        return MobileHolder (LayoutInflater.from(parent.context).inflate(R.layout.mobile,parent,false))
    }

    override fun getItemCount(): Int {
     return list.size
    }

    override fun onBindViewHolder(holder: MobileHolder, position: Int) {
       var db=mobile.getInstance(Context)
        holder.id.text= list[position].id.toString()
        holder.name.text= list[position].name.toString()
        holder.price.text= list[position].price.toString()
        holder.reting.rating= list[position].rating


        holder.delete.setOnClickListener {
            var Dialog=Dialog(Context)
            Dialog.setContentView(R.layout.update_mobile)

            var edtname=Dialog.findViewById<EditText>(R.id.edtName)
            var edtprice=Dialog.findViewById<EditText>(R.id.edtPrice)
            var edtrate=Dialog.findViewById<RatingBar>(R.id.edtRate)
            var update=Dialog.findViewById<Button>(R.id.btnUpdate)

            edtname.setText(list.get(position).name)
            edtprice.setText(list.get(position).price)
            edtrate.rating=(list.get(position).rating)

            update.setOnClickListener {
                var data=mobiledb(edtname.text.toString(),edtprice.text.toString().toInt(), edtrate.rating)
                data.id=list[position].id

                db.mobile().updatemobile(data)
                Dialog.dismiss()
                MainActivityvar.update()

            }

        }
        holder.delete.setOnClickListener {
            db.mobile().deletemobile(list[position])
            MainActivityvar.update()
        }



    }


}