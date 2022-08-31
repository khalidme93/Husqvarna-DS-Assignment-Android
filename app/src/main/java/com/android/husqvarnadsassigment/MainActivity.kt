package com.android.husqvarnadsassigment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.khalidelkilany.husqvarnadsassigment.R
import com.android.husqvarnadsassigment.RecyclerListFragment

class MainActivity : AppCompatActivity(), Communicator {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentA = RecyclerListFragment()
        supportFragmentManager.beginTransaction().replace(android.R.id.content, fragmentA).commit()
    }

    override fun passDataCom(id:Int) {
        val bundle = Bundle()
        bundle.putInt("id", id)
        val transaction= this.supportFragmentManager.beginTransaction()
        val fragmentB = RecyclerListFragmentMoviesDetails()
        fragmentB.arguments = bundle
        transaction.replace(android.R.id.content, fragmentB)
        transaction.commit()
    }

    override fun backButton() {
        val fragmentA = RecyclerListFragment()
        supportFragmentManager.beginTransaction().replace(android.R.id.content, fragmentA).commit()

    }

}

















