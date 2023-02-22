package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.room.databinding.ActivityMainBinding

class MainActivityvar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var db = mobile.getInstance(this)
        binding.add.setOnClickListener {
            var mobile = mobiledb(
                binding.name.text.toString(),
                binding.price.text.toString().toInt(),
                binding.edtmobile.rating
            )

        }

        binding.show.setOnClickListener {
            db = mobile.getInstance(this)
            var list = db.mobile().getmobile()
            adepetr=mobileAdepetr(list)
            binding.recymobile.layoutManager=LinearLayoutManager(this)
            binding.recymobile.adapter= adepetr

        }
    }
    companion object{
        lateinit var adepetr:mobileAdepetr
        lateinit var binding:ActivityMainBinding
        lateinit var db:mobile

        fun update(){
            var list =db.mobile().getmobile()
            adepetr = mobileAdepetr(list)
            binding.recymobile.adapter= adepetr
        }
    }

}
