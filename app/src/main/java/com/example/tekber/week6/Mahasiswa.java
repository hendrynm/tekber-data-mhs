package com.example.tekber.week6;

public class Mahasiswa
{
    private String nama;
    private String nrp;
    private boolean jk;
    private double ipk;

    public Mahasiswa(String nama, String nrp, boolean jk, double ipk)
    {
        this.nama = nama;
        this.nrp = nrp;
        this.jk = jk;
        this.ipk = ipk;
    }

    public String getNama()
    {
        return nama;
    }

    public void setNama(String nama)
    {
        this.nama = nama;
    }

    public String getNrp()
    {
        return nrp;
    }

    public void setNrp(String nrp)
    {
        this.nrp = nrp;
    }

    public boolean isJk()
    {
        return jk;
    }

    public void setJk(boolean jk)
    {
        this.jk = jk;
    }

    public double getIpk()
    {
        return ipk;
    }

    public void setIpk(double ipk)
    {
        this.ipk = ipk;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" +
                "\nNama: '" + nama + '\'' +
                "\nNRP: '" + nrp + '\'' +
                "\nJenis kelamin:" + ((jk) ? "Laki-laki" : "Perempuan") +
                "\nIPK: " + ipk +
                "}\n\n";
    }
}
