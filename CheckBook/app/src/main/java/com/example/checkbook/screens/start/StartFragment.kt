package com.example.checkbook.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.checkbook.APP
import com.example.checkbook.R
import com.example.checkbook.adapter.NoteAdapter
import com.example.checkbook.databinding.FragmentStartBinding
import com.example.checkbook.db.dao.model.NoteModel


class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStartBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun  init(){

        //получаем доступ к view model
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        viewModel.initDatabase()
        recyclerView = binding.rcNotes
        adapter = NoteAdapter()
        recyclerView.adapter = adapter

        viewModel.getAllNotes().observe(viewLifecycleOwner) { listNotes ->

            adapter.setList(listNotes.asReversed())
        }
        binding.btnNext.setOnClickListener {
            APP.navController.navigate(R.id.action_startFragment_to_addNoteFragment)
        }
    }
    companion object{
        fun clikNote(noteModel:NoteModel){
            val bundle = Bundle()
            bundle.putSerializable("note",noteModel)
            APP.navController.navigate(R.id.action_startFragment_to_detailFragment,bundle)
        }
    }

}