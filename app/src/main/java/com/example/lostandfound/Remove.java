package com.example.lostandfound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Remove extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    TextView Get_Post,Get_Name,Get_Phone,Get_Dec,Get_Date,Get_Location;
    Button Remove_Item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        Intent getMyintent=getIntent();
        String get_id=getMyintent.getStringExtra("ID");
        String get_Post=getMyintent.getStringExtra("Type");
        String get_Name=getMyintent.getStringExtra("Name");
        String get_Phone=getMyintent.getStringExtra("Phone");
        String get_Dec=getMyintent.getStringExtra("Dec");
        String get_Date=getMyintent.getStringExtra("Date");
        String get_Location=getMyintent.getStringExtra("Loc");

        databaseHelper=new DatabaseHelper(this);

        Get_Post=findViewById(R.id.Post);
        Get_Name=findViewById(R.id.N_ame);
        Get_Phone=findViewById(R.id.phone);
        Get_Dec=findViewById(R.id.decription);
        Get_Date=findViewById(R.id.date);
        Get_Location=findViewById(R.id.loc);
        Remove_Item=findViewById(R.id.button);

        Get_Post.setText(get_Post);
        Get_Name.setText(get_Name);
        Get_Phone.setText(get_Phone);
        Get_Dec.setText(get_Dec);
        Get_Date.setText(get_Date);
        Get_Location.setText(get_Location);

        Remove_Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=databaseHelper.getWritableDatabase();
                db.delete("MyTable","id=?",new String[]{get_id});
                Intent intent=new Intent(Remove.this,Showlostandfound.class);
                startActivity(intent);
            }
        });
    }
}