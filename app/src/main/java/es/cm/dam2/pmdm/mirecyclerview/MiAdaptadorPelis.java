package es.cm.dam2.pmdm.mirecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.cm.dam2.pmdm.mirecyclerview.data.Pelicula;

public class MiAdaptadorPelis extends RecyclerView.Adapter<MiAdaptadorPelis.MiViewHolder> {
    private List<Pelicula> dataPelis;
    private Context contex;

    public class MiViewHolder extends RecyclerView.ViewHolder{
        public ImageView imagen;
        public TextView nombrePelicula;
        public TextView anioPelicula;
        public MiViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.caratula);
            nombrePelicula = itemView.findViewById(R.id.nombrePeli);
            anioPelicula = itemView.findViewById(R.id.anioPeli);
        }
    }

    public MiAdaptadorPelis(List<Pelicula> pelis, Context cont){
        this.dataPelis = new ArrayList<>();
        this.dataPelis = pelis;
        this.contex = cont;
    }

    @NonNull
    @Override
    public MiAdaptadorPelis.MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_peli, parent, false);
        return new MiViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptadorPelis.MiViewHolder holder, int position) {
        Pelicula peli = this.dataPelis.get(position);
        holder.nombrePelicula.setText(peli.getNombre());
        holder.anioPelicula.setText(peli.getAnio().toString());
        holder.imagen.setImageDrawable(holder.imagen.getContext().getDrawable(peli.getRecursoImagen()));

    }

    @Override
    public int getItemCount() {
        return this.dataPelis.size();
    }
}
