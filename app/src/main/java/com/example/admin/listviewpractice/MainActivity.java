package com.example.admin.listviewpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etName,etSubject;
    Button btAdd;
    ListView listView;
    MyAdapter myAdapter;
    int counter=0;
    ArrayList<Student> arrayList;

    public class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.row,parent,false);
            Student student = arrayList.get(position);
            TextView tv1 = (TextView)view.findViewById(R.id.tv1);
            TextView tv2 = (TextView)view.findViewById(R.id.tv2);
            TextView tv3 = (TextView)view.findViewById(R.id.tv3);
            tv1.setText(student.getSno());
            tv2.setText(student.getName());
            tv3.setText(student.getSubject());
            return view;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etSubject = (EditText) findViewById(R.id.etSubject);
        btAdd = (Button) findViewById(R.id.btAdd);
        listView = (ListView) findViewById(R.id.listview);
        myAdapter = new MyAdapter();
        arrayList = new ArrayList<>();
        listView.setAdapter(myAdapter);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                String name = etName.getText().toString();
                String subject = etSubject.getText().toString();
                Student student = new Student(""+counter,name,subject);
                arrayList.add(student);
                etName.setText("");
                etSubject.setText("");
                myAdapter.notifyDataSetChanged();
                etName.requestFocus();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String name = arrayList.get(position).getName();
                String subject = arrayList.get(position).getSubject();
                Intent intent = new Intent(MainActivity.this,Second.class);
                intent.putExtra("name",name);
                intent.putExtra("subject",subject);
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayList.remove(position);
                myAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
