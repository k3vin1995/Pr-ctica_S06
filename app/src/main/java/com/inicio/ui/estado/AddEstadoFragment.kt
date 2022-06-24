package com.inicio.ui.estado

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.inicio.R
import com.inicio.databinding.FragmentAddEstadoBinding
import com.inicio.databinding.FragmentEstadoBinding
import com.inicio.model.Estado
import com.inicio.viewmodel.EstadoViewModel

class AddEstadoFragment : Fragment() {

    private lateinit var estadoViewModel: EstadoViewModel
    private var _binding: FragmentAddEstadoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        estadoViewModel = ViewModelProvider(this)[EstadoViewModel::class.java]
        _binding = FragmentAddEstadoBinding.inflate(inflater,container,false)

        binding.btAdd.setOnClickListener { addEstado() }
        return binding.root
    }

    private fun addEstado() {
        val nombreEstado=binding.etNombreEstado.text.toString()
        val pais=binding.etPais.text.toString()
        val capital=binding.etCapital.text.toString()
        val poblacion=binding.etPoblacion.text.toString()
        val coordenadas=binding.etCoordenadas.text.toString()

        if(nombreEstado.isNotEmpty()) {
            val estado = Estado(0,nombreEstado,pais,capital,0.0,0.0)
            estadoViewModel.addEstado(estado)
            Toast.makeText(requireContext(),getString(R.string.estadoAdded),Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addEstadoFragment_to_nav_estado)

        } else {
            Toast.makeText(requireContext(),getString(R.string.noData),Toast.LENGTH_SHORT).show()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}