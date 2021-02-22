package com.example.myrecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private TextView miTextView;
    private RecyclerView myRecyclerView;

    List<RecetaDTO> listaRecetas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //miTextView = findViewById(R.id.textView2);

        GetRequest();

    }

    void GetRequest(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://192.168.0.60:8000/recipesapp/backend/1/receta";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for(int i = 0; i < response.length(); i++){

                            try{

                                String nombre = response.getJSONObject(i).getString("nombre");
                                String descripcion = response.getJSONObject(i).getString("descripcion");

                                listaRecetas.add(new RecetaDTO(nombre, descripcion));

                            }catch(JSONException e){
                                e.printStackTrace();
                            }

                        }

                        MyRecyclerViewAdapter myAdapter = new MyRecyclerViewAdapter(listaRecetas, MainActivity.this);

                        //relaciona RecyclerViewAdapter con recicler view (el del xml)
                        RecyclerView recyclerView = findViewById(R.id.recyclerView);
                        recyclerView.setAdapter(myAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                        //miTextView.setText(response.toString());

                        Log.d("GET REQUEST", "PETICION GET CONSEGUIDA");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //miTextView.setText(error.toString());
                        Log.d("GET REQUEST", error.toString());
                    }
                });

        queue.add(jsonArrayRequest);
    }
}