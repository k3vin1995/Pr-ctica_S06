package com.inicio.ui.estado

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.inicio.R
import com.inicio.databinding.FragmentUpdateEstadoBinding
import com.inicio.databinding.FragmentEstadoBinding
import com.inicio.model.Estado
import com.inicio.viewmodel.EstadoViewModel

class UpdateEstadoFragment : Fragment() {

    private val args by navArgs<UpdateEstadoFragmentArgs>()

    private lateinit var estadoViewModel: EstadoViewModel
    private var _binding: FragmentUpdateEstadoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        estadoViewModel = ViewModelProvider(this)[EstadoViewModel::class.java]
        _binding = FragmentUpdateEstadoBinding.inflate(inflater,container,false)

        binding.etNombreEstado.setText(args.estado.nombreEstado)
        binding.etPais.setText(args.estado.pais)
        binding.etCapital.setText(args.estado.capital)

        binding.btActualizar.setOnClickListener { updateEstado() }

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun updateEstado() {
        val nombreEstado=binding.etNombreEstado.text.toString()
        val pais=binding.etPais.text.toString()
        val capital=binding.etCapital.text.toString()

        if(nombreEstado.isNotEmpty()) {
            val estado = Estado(args.estado.id,nombreEstado,pais,capital,0.0,0.0)
            estadoViewModel.updateEstado(estado)
            Toast.makeText(requireContext(),getString(R.string.estadoUpdated),Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateEstadoFragment_to_nav_estado)
        } else {
            Toast.makeText(requireContext(),getString(R.string.noData),Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_delete) {
            deleteEstado()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteEstado() {
        val consulta = AlertDialog.Builder(requireContext())

        consulta.setTitle(R.string.delete)
        consulta.setMessage(getString(R.string.seguroBorrar)+"${args.estado.nombreEstado}?")

        consulta.setPositiveButton(getString(R.string.si)) {_,_ ->
            estadoViewModel.deleteEstado(args.estado)
            findNavController().navigate(R.id.action_updateEstadoFragment_to_nav_estado)
        }
        consulta.setNegativeButton(getString(R.string.no)) {_,_ ->}

        consulta.create().show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}