package com.example.laptrinhdidong_lab7_4_5;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.jar.Attributes;

public class mainActivity_item extends AppCompatActivity {
    private EditText editTextName;
    private Button btnAdd, btnRemove, btnCancel;
    private ListView listView;
    private List<item> listitem;
    private ItemAdapter adapter;
    private int index;
    private DatabaseHandler_Item db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //getid
    editTextName = findViewById(R.id.editname);
    btnAdd = findViewById(R.id.buttonAdd);
    btnRemove= findViewById(R.id.buttonRemove);
    btnCancel=findViewById(R.id.buttonCancel);
    listView = findViewById(R.id.idlistView);

    db = new DatabaseHandler_Item(this);
    //loaddata
loadDataToListview();
        //oclick
     btnAdd.setOnClickListener(new View.OnClickListener()
     {

         @Override
         public void onClick(View view) {
             String name = editTextName.getText().toString().trim();
             if(name.isEmpty())
             {
                 Toast.makeText(mainActivity_item.this,"Vui lòng nhập tên",Toast.LENGTH_LONG).show();
                 return;
             }
             db.addContact(new item(name));
             loadDataToListview();
              editTextName.setText("");
              Toast.makeText(mainActivity_item.this,"bạn vừa thêm "+name,Toast.LENGTH_LONG).show();

         }
     });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index=i;
                item Item =db.getitem(listitem.get(index).getId());
                editTextName.setText(Item.getPutname());
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextName.getText().toString().isEmpty())
                {
                    Toast.makeText(mainActivity_item.this, "Bạn chưa chọn tên cần xóa", Toast.LENGTH_SHORT).show();
                }
                db.deleteContact(listitem.get(index).getId());
                loadDataToListview();
                editTextName.setText("");
                Toast.makeText(mainActivity_item.this, "Bạn xóa thành công", Toast.LENGTH_SHORT).show();

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editTextName.setText(" ");
                loadDataToListview();
            }
        });


    }
    public void loadDataToListview(){
        listitem = db.getAllContacts();
        adapter= new ItemAdapter(mainActivity_item.this,R.layout.listview_item,listitem);
        listView.setAdapter(adapter);
    }
}
