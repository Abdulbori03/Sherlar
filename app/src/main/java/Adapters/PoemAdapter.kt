package Adapters

import Model.PoemModel
import Utils.MyData
import Utils.MySharedPreference
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottomsheet_layout.*
import kotlinx.android.synthetic.main.poem_item.view.*
import uz.ashom.sms_sherlar.R

class PoemAdapter(var context: Context, var list: ArrayList<PoemModel>) : RecyclerView.Adapter<PoemAdapter.MyViewHolder>() {

    inner class MyViewHolder(var itemView2: View) : RecyclerView.ViewHolder(itemView2) {
        fun onBind(model: PoemModel, position: Int) {
            itemView2.txt_name.text = list[position].poemName
            itemView2.txt_poem.text = list[position].poem

            itemView2.setOnClickListener{
                var bottomSheetDialog = BottomSheetDialog(context)
                bottomSheetDialog.setContentView(LayoutInflater.from(context).inflate(R.layout.bottomsheet_layout, null, false))

                bottomSheetDialog.txt_name_bottom.text = list[position].poemName
                bottomSheetDialog.txt_poem_bottom.text = list[position].poem

                bottomSheetDialog.btn_add_to_fav.setOnClickListener{
                    MyData.favoritePoems.add(list[position])

                    MySharedPreference.init(context)

                    MySharedPreference.objectString = MyData.favoritePoems

                    Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()
                }

                bottomSheetDialog.show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.poem_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}