package com.galaxe.listviewcolorselector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    lateinit var listv: ListView
    lateinit var color: TextView
    lateinit var sublay: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arr : Array<String> = resources.getStringArray(R.array.colors)
        sublay = findViewById(R.id.lay2);
        listv =findViewById(R.id.myList)
        color = findViewById(R.id.output)

        var arrayadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arr)

        listv.adapter = arrayadapter

        listv.setOnItemClickListener(this)
    }
    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        var newString = "Your selected color is "
        var selectedColor = p0?.getItemAtPosition(p2) as String
        newString += selectedColor
        color.text = newString
        //sublay.setBackgroundColor(getResources().getColor(R.color.red))
        color.setTextColor(ResourcesCompat.getColor(getResources(), R.color.black, null))
        when (selectedColor){
            "Black" -> {
                sublay.setBackgroundColor(getResources().getColor(R.color.black))
                color.setTextColor(ResourcesCompat.getColor(getResources(), R.color.white, null))
            }
            "Red" -> sublay.setBackgroundColor(getResources().getColor(R.color.red))
            "Orange" -> sublay.setBackgroundColor(getResources().getColor(R.color.orange))
            "Blue" -> sublay.setBackgroundColor(getResources().getColor(R.color.blue))
            "Green" -> sublay.setBackgroundColor(getResources().getColor(R.color.green))
            "Experimental" -> {
                sublay.setBackgroundResource(R.drawable.gradiation)
                color.setTextColor(ResourcesCompat.getColor(getResources(), R.color.white, null))

            }


        }

    }
}