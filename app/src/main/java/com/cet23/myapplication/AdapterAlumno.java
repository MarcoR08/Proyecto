package com.cet23.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdapterAlumno extends RecyclerView.Adapter<AdapterAlumno.ViewHolder>{

List<Alumno> alumnos;
Context context;
OnClickListener listener;

    public AdapterAlumno(List<Alumno> alumnos, OnClickListener listener) {
        this.alumnos = alumnos;
        this.listener = listener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Alumno alumno = alumnos.get(i);
        viewHolder.txtnombre.setText(alumno.getNombre());
        viewHolder.txtncontrol.setText(alumno.getNo_control());
        viewHolder.setOnclickListenert(alumno,listener);
    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtnombre;
        TextView txtncontrol;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtnombre= itemView.findViewById(R.id.txtnombre);
            txtncontrol= itemView.findViewById(R.id.txtnocontrol);
            view = itemView;
        }
        void setOnclickListenert(final Alumno alumno, final OnClickListener listener){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickListener(alumno);
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onLongClickListenert(alumno);
                    return true;
                }
            });

        }


    }


    public interface OnClickListener{
        void onClickListener(Alumno alumno);
        void onLongClickListenert(Alumno alumno);


    }
}
