package Fragments

import Adapters.PoemAdapter
import Model.PoemModel
import Utils.MySharedPreference
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_favourites.view.*
import uz.ashom.sms_sherlar.R

class FavouritesFragment : Fragment() {

    lateinit var list: ArrayList<PoemModel>
    lateinit var adapter: PoemAdapter
    lateinit var root:View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        MySharedPreference.init(context)

        root = inflater.inflate(R.layout.fragment_favourites, container, false)

        list = ArrayList()

        list = MySharedPreference.objectString

        adapter = PoemAdapter(root.context, list)

        root.poems_recyclerView_fav.adapter = adapter

        return root
    }
}