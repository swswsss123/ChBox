package com.example.checkbook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.checkbook.R
import com.example.checkbook.db.dao.model.NoteModel
import com.example.checkbook.screens.start.StartFragment
import kotlinx.android.synthetic.main.item.view.*

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var listNote = emptyList<NoteModel>()
    //один из врянтов форм записи View
    class NoteViewHolder(view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false) //передаем наш item
        return NoteViewHolder(view)  //передаем в  class NoteViewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.itemView.item_title.text = listNote[position].tile  //добавляем текст в наш title
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    fun setList(list:List<NoteModel>){
        listNote = list
        notifyDataSetChanged()  //обновление информации в адаптери

    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
      //  ПЕРЕДАЕМ ДАННЫЕ СО СТАРТ ФРАГМЕНТА В ДЕТАИЛ ФРАГМЕНТ
        holder.itemView.setOnClickListener {
            StartFragment.clikNote(listNote[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}