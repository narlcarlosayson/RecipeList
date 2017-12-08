package com.sayson.narl.recipelist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recView = findViewById<RecyclerView>(R.id.recyclerV)
        recView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val recipUsers = ArrayList<User>()

        recipUsers.add(User(recipeName = "Cannoli",description = "Learn how to make cannoli with our easy-to-follow recipe. A classic Italian pastry with a crisp shell and creamy, sweet ricotta filling, it's a moreish treat"))
        recipUsers.add(User(recipeName = "Braised rabbit pappardelle",description = "Slow-cook rich game into a delicious ragu to serve with ribbon pasta - stock and wine will keep the lean meat moist"))
        recipUsers.add(User(recipeName = "Fig & prosciutto pizzettas",description = "Impress when entertaining with these mini pizzas topped with creamy mozzarella, sweet fruit and salty Italian ham"))
        val adapt = CustomAdapt(recipUsers,applicationContext)
        recView.adapter = adapt
    }
}
