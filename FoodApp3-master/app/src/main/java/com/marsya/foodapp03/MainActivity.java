package com.marsya.foodapp03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgTipePS, rgPilihanMakanan;
    private Button btnPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgTipePS = findViewById(R.id.rgTipePS);
        rgPilihanMakanan = findViewById(R.id.tvPilihanMakan);
        btnPesan = findViewById(R.id.btnPesan);

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tipePS = getSelectedTipePS();
                String pilihanMakanan = getSelectedPilihanMakanan();

                // Cek tambahan dan waktu agar tidak null
                String tambahan = "";  // Ubah ke nilai yang sesuai jika perlu
                String waktu = "";  // Ubah ke nilai yang sesuai jika perlu

                // Menghitung total pembayaran berdasarkan tipe PS
                int hargaPerJam = 0;
                switch (tipePS) {
                    case "PS5":
                        hargaPerJam = 10000;
                        break;
                    case "PS4":
                        hargaPerJam = 8000;
                        break;
                    case "PS3":
                        hargaPerJam = 5000;
                        break;
                    case "PSVR":
                        hargaPerJam = 2000;
                        break;
                }

                int totalPembayaran = hargaPerJam;

                // Menambahkan biaya makanan jika dipilih
                switch (pilihanMakanan) {
                    case "Indomie":
                        totalPembayaran += 7000;
                        break;
                    case "Mie Ayam":
                        totalPembayaran += 10000;
                        break;
                    case "Siomay":
                        totalPembayaran += 5000;
                        break;
                }

                // Format total pembayaran ke dalam Rupiah (Rp)
                NumberFormat formatRupiah = NumberFormat.getCurrencyInstance();
                String totalPembayaranFormatted = formatRupiah.format(totalPembayaran);

                // Mengirim data ke DetailActivity
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("tipePS", tipePS);
                intent.putExtra("pilihanMakanan", pilihanMakanan);
                intent.putExtra("tambahan", tambahan);
                intent.putExtra("waktu", waktu);
                intent.putExtra("totalPembayaran", totalPembayaranFormatted);
                startActivity(intent);
            }
        });
    }

    private String getSelectedTipePS() {
        int selectedTipePSId = rgTipePS.getCheckedRadioButtonId();
        RadioButton selectedTipePS = findViewById(selectedTipePSId);
        return selectedTipePS.getText().toString();
    }

    private String getSelectedPilihanMakanan() {
        int selectedPilihanMakananId = rgPilihanMakanan.getCheckedRadioButtonId();
        RadioButton selectedPilihanMakanan = findViewById(selectedPilihanMakananId);
        return selectedPilihanMakanan.getText().toString();
    }
}