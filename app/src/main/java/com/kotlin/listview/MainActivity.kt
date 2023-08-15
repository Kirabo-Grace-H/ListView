package com.kotlin.listview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.kotlin.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mylist = binding.myList
        val countrylist = listOf("Uganda","Kenya","Tanzania","England","Egypt","Hungary","Canada",
            "Brazil","Rwanda","Burundi")
        val citylist = listOf("Kampala","Nairobi","Dar-es-Salam","London","Cairo","Budapest","Montreal",
        "Brasil","Kigali","Bujumbura")
        //this arrayAdapter is for single item view
        //val arrayAdapter = ArrayAdapter(this,R.layout.list_item_layout,R.id.countryTV,countrylist)

        //arrayAdapter with multiple item view
        val arrayAdapter = NewAdapter(this,countrylist,citylist)
        mylist.adapter=arrayAdapter
    }
}
class NewAdapter(context: Context, val countrylist:List<String>,val citylist:List<String>):
    ArrayAdapter<String>(context,R.layout.list_item_layout,R.id.countryTV,countrylist){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)

        val countrytv = view.findViewById<TextView>(R.id.countryTV)
        countrytv.text = countrylist[position]
        val citytv = view.findViewById<TextView>(R.id.cityTV)
        citytv.text=citylist[position]
        return view
    }
    }

