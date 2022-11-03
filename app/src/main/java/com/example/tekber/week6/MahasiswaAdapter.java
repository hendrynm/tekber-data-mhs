package com.example.tekber.week6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter <MahasiswaAdapter.ViewHolder>
{
    ArrayList<Mahasiswa> alMhs;

    public MahasiswaAdapter(ArrayList<Mahasiswa> alMhs)
    {
        this.alMhs = alMhs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View mahasiswaView = inflater.inflate(R.layout.item_mahasiswa, parent, false);

        return new ViewHolder(mahasiswaView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Mahasiswa mhs = alMhs.get(position);
        //TextView tvMahasiswa = holder.txtMahasiswa;
        //tvMahasiswa.setText(String.valueOf(mhs));

        holder.tampilNama.setText(mhs.getNama());
        holder.tampilNrp.setText(mhs.getNrp());
        holder.tampilJk.setText((mhs.isJk()) ? "Laki-laki" : "Perempuan");
        holder.tampilIpk.setText(String.valueOf(mhs.getIpk()));
    }

    @Override
    public int getItemCount()
    {
        return alMhs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        // public TextView txtMahasiswa;
        TextView tampilNama, tampilNrp, tampilJk, tampilIpk;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            //txtMahasiswa = (TextView) itemView.findViewById(R.id.txtMahasiswa);
            tampilNama = itemView.findViewById(R.id.tampilNama);
            tampilNrp = itemView.findViewById(R.id.tampilNrp);
            tampilJk = itemView.findViewById(R.id.tampilJk);
            tampilIpk = itemView.findViewById(R.id.tampilIpk);
        }
    }
}
