package Fragments

import Adapters.PoemAdapter
import Model.PoemModel
import Utils.MyData
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_poems_display.view.*
import uz.ashom.sms_sherlar.R

class PoemsDisplayFragment : Fragment() {

    lateinit var root:View
    lateinit var list: ArrayList<PoemModel>
    lateinit var adapter: PoemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_poems_display, container, false)

        root.btn_back.setOnClickListener{
            root.findNavController().navigate(R.id.mainFragment)
        }

        var type = arguments?.getString("type")

        list = ArrayList()

        if (type == "love"){
            list = MyData.lovePoemsList
            root.sms1.text = "Love Poems"
        }

        if (type == "miss"){
            list = MyData.missPoems
            root.sms1.text = "Miss Poems"
        }

        if (type == "congrats"){
            list = MyData.congratsPoems
            root.sms1.text = "Congratulation"
        }

        if (type == "parents"){
            list = MyData.parentsPoems
            root.sms1.text = "Parent Poems"
        }

        if (type == "friends"){
            list = MyData.friendPoems
            root.sms1.text = "Friends Poems"
        }

        if (type == "joke"){
            list = MyData.jokePoems
            root.sms1.text = "Joke Poems"
        }

        adapter = PoemAdapter(root.context, list)

        root.poems_recyclerView.adapter = adapter

        return root
    }
}