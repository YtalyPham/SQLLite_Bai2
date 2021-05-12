package com.example.sqllite_baib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private DataCity db;
    private ArrayAdapter listViewAdapter;
    private String temp;
    private Button btnAdd;

    private EditText editText;


    private int index=0;
    List<City> list1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DataCity(MainActivity.this);

//        db.addCity(new City(1,"Đà Lạt"));
//        db.addCity(new City(2,"Buôn Mê Thuộc"));
//        db.addCity(new City(3,"Cần Thơ"));


        listView= findViewById(R.id.listView);


        list1=db.getAllCity();


        listViewAdapter= new ArrayAdapter<>(this,R.layout.item_tp,R.id.tvName,list1);
        listView.setAdapter(listViewAdapter);
        editText=findViewById(R.id.editText);

        btnAdd= findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=list1.size();
                temp= String.valueOf(editText.getText());
                db.addCity(new City(i+1,temp));
                recreate();
            }
        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                index =i;
//                ImageButton btnEdit= findViewById(R.id.btnEdit);
//                ImageButton btnDelete= findViewById(R.id.btnDelete);
//
//                btnEdit.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        int tam= db.getId(index);
//                        Toast.makeText(MainActivity.this,tam+"here",Toast.LENGTH_SHORT);
//                        db.deleteCity(tam);
//                        recreate();
//                    }
//                });


//                btnEdit.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        temp= String.valueOf(editText.getText());
//                        tam.setName(temp);
//                        db.updateCity(tam);
//                        recreate();
//                    }
//                });
//            }
//        });













    }
}