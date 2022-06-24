package com.inicio.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.inicio.databinding.EstadoFilaBinding
import com.inicio.model.Estado
import com.inicio.ui.estado.EstadoFragmentDirections

class EstadoAdapter : RecyclerView.Adapter<EstadoAdapter.EstadoViewHolder>() {

    private var listaEstados = emptyList<Estado>()

    inner class EstadoViewHolder(private val itemBinding: EstadoFilaBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun dibuja(estado: Estado) {
            itemBinding.tvNombreEstado.text = estado.nombreEstado
            itemBinding.tvPais.text = estado.pais
            itemBinding.tvCapital.text = estado.capital
            itemBinding.tvPoblacion.text = estado.poblacion.toString()
            itemBinding.tvCoordenadas.text = estado.coordenadas.toString()

//            itemBinding.vistaFila.setOnClickListener{
//                val accion = EstadoFragmentDirections.actionNavEstadoToAddEstadoFragment(estado)
//                itemView.findNavController().navigate(accion)
//            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstadoViewHolder {
        val itemBinding = EstadoFilaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EstadoViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: EstadoViewHolder, position: Int) {
        val lugar = listaEstados[position]
        holder.dibuja(lugar)
    }

    override fun getItemCount(): Int {
        return listaEstados.size

    }

    fun setData(estados : List<Estado>) {
        this.listaEstados = estados

        notifyDataSetChanged()
    }
}