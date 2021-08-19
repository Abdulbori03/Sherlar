package Fragments

import Model.PoemModel
import Utils.MyData
import Utils.MySharedPreference
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_main.view.*
import uz.ashom.sms_sherlar.R

class MainFragment : Fragment() {

    lateinit var root : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        MyData.lovePoemsList.clear()
        MyData.missPoems.clear()
        MyData.congratsPoems.clear()
        MyData.parentsPoems.clear()
        MyData.friendPoems.clear()
        MyData.jokePoems.clear()

        MyData.lovePoemsList.add(
            PoemModel("Love So Amazing", "My love for you is like the raging sea,\n" +
                    "So powerful and deep it will forever be.\n" +
                    "Through storm, wind, and heavy rain,\n" +
                    "It will withstand every pain.", "Love Poems")
        )

        MyData.missPoems.add(
            PoemModel("From My Heart", "A million stars up in the sky.\n" +
                    "One shines brighter - I can't deny.\n" +
                    "A love so precious, a love so true,\n" +
                    "a love that comes from me to you.", "Miss and Pain")
        )

        MyData.congratsPoems.add(PoemModel("Not Fair For Me", "All poetry is not created equal\n" +
                "Not all poetry can rise above\n" +
                "Above all AllPoetry nurtures\n" +
                "All poetry with love.", "Congratulation Poems"))

        MyData.parentsPoems.add(
            PoemModel("Mom and Dad", "You teach me right from wrong.\n" +
                    "And when I’m sad you sing to me that special song.\n" +
                    "You tell me everything I need to know.\n" +
                    "And when I need you, you’re always there, all set to go.\n" +
                    "So when I’m all blue and sad, I call on you, my mom and dad.", "About Parents")
        )

        MyData.friendPoems.add(
            PoemModel("Friendship", "I’ve discovered a way to stay friends forever—\n" +
                    "There’s really nothing to it.\n" +
                    "I simply tell you what to do\n" +
                    "And you do it!!", "About Friends")
        )

        MyData.jokePoems.add(
            PoemModel("Funny Situations", "I've hunted near, I've hunted far\n" +
                    "I even looked inside my car.\n" +
                    "I've lost my glasses, I'm in need,\n" +
                    "To have them now so I can read.", "Joke Poems")
        )

        root = inflater.inflate(R.layout.fragment_main, container, false)

        MySharedPreference.init(context)

        root.fav_number.text = MySharedPreference.objectString.size.toString()

        root.love_card.setOnClickListener{
            var type = "love"

            root.findNavController().navigate(R.id.poemsDisplayFragment, bundleOf("type" to type))

        }

        root.miss_card.setOnClickListener {
            var type = "miss"

            root.findNavController().navigate(R.id.poemsDisplayFragment, bundleOf("type" to type))
        }

        root.congrats_card.setOnClickListener {
            var type = "congrats"

            root.findNavController().navigate(R.id.poemsDisplayFragment, bundleOf("type" to type))
        }

        root.parents_card.setOnClickListener {
            var type = "parents"

            root.findNavController().navigate(R.id.poemsDisplayFragment, bundleOf("type" to type))
        }

        root.friends_card.setOnClickListener {
            var type = "friends"

            root.findNavController().navigate(R.id.poemsDisplayFragment, bundleOf("type" to type))
        }

        root.jokes_card.setOnClickListener {
            var type = "joke"

            root.findNavController().navigate(R.id.poemsDisplayFragment, bundleOf("type" to type))
        }

        root.fav_card.setOnClickListener {
            root.findNavController().navigate(R.id.favouritesFragment)
        }

        return root
    }
}