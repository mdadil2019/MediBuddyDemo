package com.mdadil2019.medibuddydemo.fragments

import android.graphics.Color
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.mdadil2019.medibuddydemo.ListFragmentViewModel
import com.mdadil2019.medibuddydemo.MyViewModelFactory
import com.mdadil2019.medibuddydemo.R
import com.mdadil2019.medibuddydemo.repo.UserRepository
import kotlinx.android.synthetic.main.list_fragment.*

class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: ListFragmentViewModel
    private lateinit var userRepository : UserRepository
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userRepository = UserRepository(context!!,viewLifecycleOwner)
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!, MyViewModelFactory(ListFragmentViewModel::class){
            ListFragmentViewModel(userRepository)
        }).get(ListFragmentViewModel::class.java)

        rvUsers.layoutManager = LinearLayoutManager(context!!)
        viewModel.setAdapter(rvUsers)
        viewModel.isApiRequestSuccess.observe(viewLifecycleOwner, Observer{
            if(it == false){
                if(!viewModel.isDataAvaiable){
                    Snackbar.make(view!!,"Unable to fetch data", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Try Again") {
                            viewModel.retry()
                        }.setTextColor(Color.WHITE).show()
                }

            }

        })
    }

    override fun onStop() {
        super.onStop()
//        fragmentManager?.beginTransaction()?.remove(this)?.commit()
    }



}