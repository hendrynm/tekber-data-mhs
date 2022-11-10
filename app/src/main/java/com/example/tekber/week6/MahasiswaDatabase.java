package com.example.tekber.week6;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MahasiswaDatabase
{
    /**
     * Definisikan lokasi penyimpanan Firebase (.../mhs)
     */
    DatabaseReference firebase = FirebaseDatabase.getInstance().getReference("mhs");
    String nama, nrp;
    boolean jk;
    double ipk;

    /**
     * Construktor default untuk kelas Mahasiswa Database
     * @param nama String   : nama lengkap mahasiswa
     * @param nrp String    : nrp mahasiswa
     * @param jk boolean    : jenis kelamin mahasiswa
     *           true       : Laki-laki
     *           false      : Perempuan
     * @param ipk double    : nilai IPK mahasiswa
     */
    public MahasiswaDatabase(String nama, String nrp, boolean jk, double ipk)
    {
        this.nama = nama;
        this.nrp = nrp;
        this.jk = jk;
        this.ipk = ipk;
    }

    public void kirimDataBaru()
    {
        /**
         * Karena di No-SQL tidak ada Primary Key, buat Node dengan
         * @param kunci berupa auto-generated value (unique)
         *
         * Lakukan penyimpanan data ke Firebase pada Node
         * yang sudah dibuat.
         */
        String kunci = String.valueOf(firebase.push().getKey());

        firebase.child(kunci).child("nama").setValue(nama);
        firebase.child(kunci).child("nrp").setValue(nrp);
        firebase.child(kunci).child("jk").setValue(jk);
        firebase.child(kunci).child("ipk").setValue(ipk);
    }
}
