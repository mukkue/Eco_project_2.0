package com.example.eco_project_20

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.navigation.NavigationView
import org.json.JSONArray


class Home_page2 : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        val data = ArrayList<ItemViewModel>()
        //  setTitle(R.string.title_activity_home_page)
        var queue = Volley.newRequestQueue(this)
        var recyclerView: RecyclerView = findViewById(R.id.Recylerview_)
        var nav_view: NavigationView = findViewById(R.id.nav_demo)
        var drawerLayout: DrawerLayout = findViewById(R.id.mydrawer)
        toggle = ActionBarDrawerToggle(
            this, drawerLayout,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val stringRequest = StringRequest(Request.Method.GET, "http://www.golusewakpark.xyz/Registraion.asmx/categorypagapi",
            { response ->
                var jsonArray=JSONArray(response)
                for (i in 0..jsonArray.length()-1) {
                    var jsonObject = jsonArray.getJSONObject(i)

                    var name=jsonObject.getString("cname")
                    var  img="http://www.golusewakpark.xyz/upload/"+jsonObject.getString("cimage")
                    data.add(ItemViewModel(img,name))
                    recyclerView.layoutManager=GridLayoutManager(applicationContext,2)


                 var aadapter=   product_Database(data, applicationContext)

                    recyclerView.adapter=aadapter
                }
            },
            {

                Toast.makeText(applicationContext, ""+ error(message = "Nothing"), Toast.LENGTH_SHORT).show()
            })

        queue.add(stringRequest)

              /*  var adapter= baseContext.let {

                    for (i in 1..10) {

                        data.add(ItemViewModel( R.drawable.ic_launcher_foreground,"Item " + i ))

                        recyclerView.layoutManager=GridLayoutManager(applicationContext,2)

                    }
                    product_Database(data) }

        recyclerView.adapter=adapter*/

       nav_view.setNavigationItemSelectedListener(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.nav_home -> {
                Toast.makeText(this, "" + menuItem.title, Toast.LENGTH_SHORT).show()
                true
            }
            R.id.nav_gallery -> {
                Toast.makeText(this, "" + menuItem.title, Toast.LENGTH_SHORT).show()
                true
            }
            R.id.nav_slideshow -> {
                Toast.makeText(this, "" + menuItem.title, Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                false
            }
        }
        return super.onOptionsItemSelected(menuItem);

    }
}