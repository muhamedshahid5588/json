package com.example.localstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
ArrayList<String>arrayList = new ArrayList<>();
ArrayAdapter<String>arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);

        String studentsubject= "{\"d\":{\"__type\":\" MCTest.ProcResponse\",\"Status\":\"200\",\"ID\":\"1\",\"Message\":\" Get Subjects Masters\",\"DATA\":" +
                "[[\n" +
                "{\"id\":\"1\",\"SubjectName\":\"English\",\"MaxMark\":\"50\"},\n" +
                "{\"id\":\"2\",\"SubjectName\":\"Malayalam\",\"MaxMark\":\"50\"},\n" +
                "{\"id\":\"3\",\"SubjectName\":\"Hindi\",\"MaxMark\":\"50\"},\n" +
                "{\"id\":\"4\",\"SubjectName\":\"Mathamatics\",\"MaxMark\":\"50\"},\n" +
                "{\"id\":\"5\",\"SubjectName\":\"Physics\",\"MaxMark\":\"50\"},\n" +
                "{\"id\":\"6\",\"SubjectName\":\"Chemistry\",\"MaxMark\":\"50\"},\n" +
                "{\"id\":\"7\",\"SubjectName\":\"Biology\",\"MaxMark\":\"50\"},\n" +
                "{\"id\":\"8\",\"SubjectName\":\"History\",\"MaxMark\":\"50\"},\n" +
                "{\"id\":\"9\",\"SubjectName\":\"IT\",\"MaxMark\":\"25\"}]],\n"+
                "}}";


     try {
         JSONObject jsonObj = new JSONObject(studentsubject);
         JSONObject object = jsonObj.getJSONObject("d");
         String type = object.getString("--type");
         String status = object.getString("Status");
         String id = object.getString("ID");
         String message = object.getString("Message");

         JSONArray subject = object.getJSONArray("DATA");

         String data = subject.toString();


     for (int i=0; i<subject.length(); i++){
         JSONObject jsonObject=subject.getJSONObject(i);
         String idd= jsonObject.getString("id");
         String subjectname= jsonObject.getString("SubjectName");
         String maxMark= jsonObject.getString("MaxMark");

         arrayList.add(idd + ") " + subjectname + " || " + maxMark);
     }
     }catch (JSONException jsonException) {
         jsonException.printStackTrace();
     }

arrayAdapter=new ArrayAdapter<>(this,
        android.R.layout.simple_list_item_1,arrayList);
     listView.setAdapter(arrayAdapter);





    }
}