package com.example.checkbook.screens.addnote

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.checkbook.APP
import com.example.checkbook.R
import com.example.checkbook.databinding.FragmentAddNoteBinding
import com.example.checkbook.db.dao.model.NoteModel


class AddNoteFragment : Fragment() {

    lateinit var binding: FragmentAddNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddNoteBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init(){

        // тут мы берем данные для заметки
        val viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)
        binding.btnAdd.setOnClickListener {
            val title = binding.etAddTitle.text.toString()
            val description =binding.etAddDescription.text.toString()

            viewModel.insert(NoteModel(tile = title, descriptor = description)){}
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }

        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
    }

}