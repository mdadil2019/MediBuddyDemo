package com.mdadil2019.medibuddydemo.fragments

import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mdadil2019.medibuddydemo.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dashboard_card_view.*
import kotlinx.android.synthetic.main.dashboard_card_view.view.*
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        populateLayout()
    }

    fun populateLayout(){

        val title = cvList.findViewById<TextView>(R.id.tvTitleCardView)
        title.text = "List"
        title.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_icon_awesome_list_alt, 0, 0);
        cvList.findViewById<TextView>(R.id.tvDescriptionCardView).text = "Show list of user"

        cvList.setOnClickListener {
            changeFragment(ListFragment())
        }

        cvCreate.setOnClickListener {
            Toast.makeText(context!!,"Oops... We are still working on it",Toast.LENGTH_LONG).show()
        }

        cvSearch.setOnClickListener {
            Toast.makeText(context!!,"Oops... We are still working on it",Toast.LENGTH_LONG).show()
        }

        cvDelete.setOnClickListener {
            Toast.makeText(context!!,"Oops... We are still working on it",Toast.LENGTH_LONG).show()
        }


        cvCreate.findViewById<TextView>(R.id.tvTitleCardView).text = "Create"
        cvCreate.tvTitleCardView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_icon_material_create_new_folder, 0, 0);
        cvCreate.tvDescriptionCardView.text = "Create new users"

        cvSearch.tvTitleCardView.text= "Search"
        cvSearch.tvTitleCardView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_icon_awesome_search, 0, 0);
        cvSearch.tvDescriptionCardView.text = "Search the users"

        cvDelete.tvTitleCardView.text = "Delete"
        cvDelete.tvDescriptionCardView.text = "Delete the user"
        cvDelete.tvTitleCardView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_icon_material_delete, 0, 0);

    }

    fun changeFragment(fragment : Fragment){
        fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainer,fragment)?.commit()
    }
}