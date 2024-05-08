package com.marsya.marsyaquiz1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class DetailActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newactivity);

        // Mendapatkan data dari intent
        String tipePS = getIntent().getStringExtra("tipePS");
        String pilihanMakanan = getIntent().getStringExtra("pilihanMakanan");
        String typeTambahan = getIntent().getStringExtra("typeTambahan");
        String jamPengambilan = getIntent().getStringExtra("jamPengambilan");
        int totalPembayaran = getIntent().getIntExtra("totalPembayaran", 0);

        // Menampilkan data pesanan dan total pembayaran
        TextView tvTipePS = findViewById(R.id.tvTipePS);
        TextView tvPilihanMakanan = findViewById(R.id.tvTambahan);
        TextView tvTypeTambahan = findViewById(R.id.tvTambahan);
        TextView tvJamPengambilan = findViewById(R.id.tvWaktu);
        TextView tvTotalPembayaran = findViewById(R.id.tvTotalPembayaran);

        tvTipePS.setText("Tipe PS: " + tipePS);
        tvPilihanMakanan.setText("Pilihan Makanan: " + pilihanMakanan);
        tvTypeTambahan.setText("Type Tambahan: " + typeTambahan);
        tvJamPengambilan.setText("Jam Pengambilan: " + jamPengambilan);
        tvTotalPembayaran.setText("Total Pembayaran: Rp " + totalPembayaran);
        }
        }
