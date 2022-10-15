package com.hilguener.gotcharacters.ui.charlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hilguener.gotcharacters.R
import com.hilguener.gotcharacters.model.api.CharResult
import com.hilguener.gotcharacters.model.api.CharactersResponseItem
import kotlinx.android.synthetic.main.card_char_search.view.*
import java.text.FieldPosition

class CharListAdapter(val charClick: (Int) -> Unit): RecyclerView.Adapter<CharListAdapter.SearchViewHolder>() {
    var charList: List<CharactersResponseItem> = emptyList<CharactersResponseItem>()

    fun setData(list : List<CharactersResponseItem>) {
        charList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_char_search, parent, false))
    }

    override fun getItemCount(): Int {
        return charList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int){
        val char = charList[position]
        holder.itemView.charText.text = "${position + 1} - ${char.firstName +" "+ char.lastName}"

        holder.itemView.setOnClickListener{ charClick (char.id)}
    }

    class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}