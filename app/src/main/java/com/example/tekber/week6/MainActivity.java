/*******************************************
 * TUGAS PENGGANTI UTS
 * Nama     : Hendry Naufal Marbella
 * NRP      : 05211940000089
 * Kelas    : Teknologi Bergerak - P
 *******************************************/
package com.example.tekber.week6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    EditText txtNama, txtNrp, txtIpk;
    RadioButton rbLaki, rbPuan;
    ArrayList<Mahasiswa> alMhs = new ArrayList<>();
    RecyclerView rvMahasiswa;
    DatabaseReference firebase = FirebaseDatabase.getInstance().getReference("mhs");

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
        rvMahasiswa = findViewById(R.id.rvMahasiswa);
    }

    public void klikOk(View v)
    {
        // Ambil VALUE dari hasil mapping
        String nama = String.valueOf(txtNama.getText());
        String nrp = String.valueOf(txtNrp.getText());
        boolean jk = rbLaki.isChecked();
        double ipk = Double.parseDouble(String.valueOf(txtIpk.getText()));

        /*******************************************
         * WEEK 9
         * Simpan data di ArrayList, sekalian
         * buat objek baru di class Mahasiswa
         *******************************************
        alMhs.add(new Mahasiswa(nama, nrp, jk, ipk));

        MahasiswaAdapter ma = new MahasiswaAdapter(alMhs);
        rvMahasiswa.setAdapter(ma);
        rvMahasiswa.setLayoutManager(new LinearLayoutManager(this));

         *******************************************/

        /*******************************************
         * Tugas Pengganti UTS
         * Simpan dan tampilkan data
         * pakai Firebase
         *******************************************/

        /**
         * Simpan Data ke Firebase menggunakan bantuan
         * Class MahasiswaDatabase dengan parameter
         * nama, nrp, jenis kelamin, dan ipk.
         */
        MahasiswaDatabase md = new MahasiswaDatabase(nama, nrp, jk, ipk);
        md.kirimDataBaru();

        /**
         * Buat sebuah Listener untuk setiap perubahan
         * yang terjadi dalam Firebase.
         */
        firebase.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                /**
                 * Hapus data yang ada di ArrayList karena setiap
                 * fungsi onDataChange terpanggil, semua data akan
                 * terpanggil.
                 */
                alMhs.clear();

                /**
                 * Karena data Firebase terpanggil semua, maka
                 * lakukan mapping untuk setiap data.
                 */
                for(DataSnapshot data: snapshot.getChildren())
                {
                    /**
                     * Firebase secara default akan mengembalikan dalam
                     * bentuk Object jika jenis value tidak didefinisikan.
                     *
                     * @param nama String
                     * @param nrp String
                     */
                    String nama = data.child("nama").getValue(String.class);
                    String nrp = data.child("nrp").getValue(String.class);

                    /**
                     * Karena Firebase return data dalam tipe non-primitif,
                     * maka lakukan Casting data ke tipe primitif agar sesuai
                     * dengan Constructor.
                     *
                     * @param jk ubah Boolean ke boolean
                     * @param ipk ubah Double ke double
                     */
                    boolean jk = Boolean.TRUE.equals(data.child("jk").getValue(Boolean.class));
                    double ipk = data.child("ipk").getValue(Double.class).doubleValue();

                    /**
                     * Simpan data ke ArrayList yang sudah dibuat pada
                     * pertemuan sebelumnya
                     */
                    alMhs.add(new Mahasiswa(nama, nrp, jk, ipk));
                }
                /**
                 * Tampilkan data yang sudah ada dalam bentuk
                 * Recycler View
                 */
                MahasiswaAdapter ma = new MahasiswaAdapter(alMhs);
                rvMahasiswa.setAdapter(ma);
                rvMahasiswa.setLayoutManager(new LinearLayoutManager(v.getContext()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }
}
