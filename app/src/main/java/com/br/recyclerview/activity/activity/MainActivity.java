package com.br.recyclerview.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.br.recyclerview.R;
import com.br.recyclerview.activity.RecyclerItemClickListener;
import com.br.recyclerview.activity.adapter.Adapter;
import com.br.recyclerview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //listagem de filmes
        this.criarFilmes();


        //configurar adapter
        Adapter adapter = new Adapter(listaFilmes);

        //configurar recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(getApplicationContext(),"Item pressionado:" + filme.getTituloFilme(),Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(getApplicationContext(),"Click longo:[" + filme.getTituloFilme(),Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {


                            }
                        }
                )
        );



    }
    public void criarFilmes(){

        Filme filme = new Filme("titulo","genero", "2018");
        listaFilmes.add(filme);

        filme = new Filme("Filme 1","genero 1", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Filme 2","genero 2", "2016");
        listaFilmes.add(filme);

        filme = new Filme("Filme 3","genero 3", "2015");
        listaFilmes.add(filme);

        filme = new Filme("Filme 4","genero 4", "2014");
        listaFilmes.add(filme);

        filme = new Filme("Filme 5","genero 5", "2013");
        listaFilmes.add(filme);

        filme = new Filme("Filme 6","genero 6", "2012");
        listaFilmes.add(filme);

        filme = new Filme("Filme 7","genero 7", "2011");
        listaFilmes.add(filme);

        filme = new Filme("Filme 8","genero 8", "2010");
        listaFilmes.add(filme);

    }

}
