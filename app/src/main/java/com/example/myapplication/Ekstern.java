package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Ekstern extends AppCompatActivity implements View.OnClickListener  {
    public static final String NameFile = "namafile.txt";
    Button addfile, change, read, removefile;
    TextView textBaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intern);
        addfile = findViewById(R.id.buat);
        change = findViewById(R.id.ubah);
        read = findViewById(R.id.membacaFile);
        removefile = findViewById(R.id.hapus);
        textBaca = findViewById(R.id.teks);

        addfile.setOnClickListener(this);
        change.setOnClickListener(this);
        read.setOnClickListener(this);
        removefile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        cobajalankan(v.getId());
    }

    private void cobajalankan(int id) {
        switch (id) {
            case R.id.buat:
                addfile();
                break;
            case R.id.ubah:
                change();
                break;
            case R.id.membacaFile:
                read();
                break;
            case R.id.hapus:
                removefile();
                break;
        }
    }

    void addfile(){
        String isiFile = "Coba Isi Data File Text";
        File file = new File(getExternalFilesDir(null), NameFile);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file,true);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    void change(){
        String change = "Update Isi Data File Text";
        File file = new File(getExternalFilesDir(null), NameFile);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(change.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void read(){
        File sdcard = getExternalFilesDir(null);
        File file = new File(sdcard, NameFile);
        if (file.exists()) {
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while (line != null) {
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
            }
            textBaca.setText(text.toString());
        }
    }

    void removefile(){
        File file = new File(getExternalFilesDir(null),NameFile);
        if (file.exists()) {
            file.delete();
        }
    }
}