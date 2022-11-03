package com.example.tekber.week6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    EditText txtNama, txtNrp, txtIpk;
    TextView txtRes;
    RadioButton rbLaki, rbPuan;
    ArrayList<Mahasiswa> alMhs = new ArrayList<>();
    RecyclerView rvMahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mapping VALUE dari tampilan XML
        txtNama = findViewById(R.id.txtNama);
        txtNrp = findViewById(R.id.txtNrp);
        rbLaki = findViewById(R.id.rbLaki);
        rbPuan = findViewById(R.id.rbPuan);
        txtIpk = findViewById(R.id.txtIpk);
        //txtRes = findViewById(R.id.txtRes);
        rvMahasiswa = findViewById(R.id.rvMahasiswa);
    }

    public void klikOk(View v)
    {
        // Ambil VALUE dari hasil mapping
        String nama = String.valueOf(txtNama.getText());
        String nrp = String.valueOf(txtNrp.getText());
        boolean jk = rbLaki.isChecked();
        double ipk = Double.parseDouble(String.valueOf(txtIpk.getText()));

        // Simpan data di ArrayList, sekalian buat objek baru di class Mahasiswa
        alMhs.add(new Mahasiswa(nama, nrp, jk, ipk));

        // Tampilkan hasilnya
        // txtRes.setText(String.valueOf(alMhs));

        MahasiswaAdapter ma = new MahasiswaAdapter(alMhs);
        rvMahasiswa.setAdapter(ma);
        rvMahasiswa.setLayoutManager(new LinearLayoutManager(this));
    }
}