package com.example.checkbook.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.checkbook.APP
import com.example.checkbook.R
import com.example.checkbook.databinding.FragmentDetailBinding
import com.example.checkbook.db.dao.model.NoteModel


class DetailFragment : Fragment() {

    lateinit var binding:FragmentDetailBinding
    lateinit var carrentNote:NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        carrentNote = arguments?.getSerializable("note") as NoteModel   ///Сборка обратно в NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init(){
        //удаляем данные
        val vieModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        //Передаем в наши поля данные
        binding.tvTitelDetail.text = carrentNote.tile
        binding.tvDescDetail.text = carrentNote.descriptor

        //удаление записи
        binding.btnDelit.setOnClickListener {
            vieModel.delite(carrentNote){}
        }

        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }
    }

}