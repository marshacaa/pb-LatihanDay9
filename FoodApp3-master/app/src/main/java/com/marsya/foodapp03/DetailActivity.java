package com.marsya.foodapp03;

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
        String tambahan = getIntent().getStringExtra("tambahan");
        String waktu = getIntent().getStringExtra("waktu");
        int totalPembayaran = getIntent().getIntExtra("totalPembayaran", 0);

        // Menampilkan data pesanan dan total pembayaran
        TextView tvTipePS = findViewById(R.id.tvTipePS);
        TextView tvTambahan = findViewById(R.id.tvTambahan);
        TextView tvWaktu = findViewById(R.id.tvWaktu);
        TextView tvTotalPembayaran = findViewById(R.id.tvTotalPembayaran);

        tvTipePS.setText("Tipe PS: " + tipePS);
        tvTambahan.setText("Tambahan: " + tambahan); // Tampilkan tambahan di TextView yang sesuai
        tvWaktu.setText("Waktu: " + waktu); // Tampilkan waktu di TextView yang sesuai
        tvTotalPembayaran.setText("Total Pembayaran: Rp " + totalPembayaran);
    }
}
