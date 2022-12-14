package com.example.bottom_navigation_com_activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.StatusBarManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import java.util.ArrayList;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.bottom_navigation_com_activitys.adapters_todos_slides.carroselFotosAdapter;


public class inicioActivity extends AppCompatActivity {

     ViewPager viewPager;
    ArrayList<Integer> images = new ArrayList<>();
    carroselFotosAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        //barra de notificacoes preta
        this.getWindow().setStatusBarColor(getResources().getColor(R.color.fundo_header));

        //resolvendo carrosel de fotos
        viewPager = findViewById(R.id.viewPager_carroselFotos_inicio);
        images.add(R.drawable.foto_carrosel1);
        images.add(R.drawable.foto_carrosel1);
        images.add(R.drawable.foto_carrosel1);

        adapter = new carroselFotosAdapter(this, images);
        viewPager.setAdapter(adapter);

        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomNavigatio_inicio);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_baseline_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_baseline_dashboard));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_watch));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_baseline_person));

        //se clicar em alguma opcao do menu(obrigatorio)
        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                //Toast.makeText(MainActivity.this, "clicou em "+ item.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        //se clicar novamente em alguma opcao do menu(obrigatorio para nao crashar)
        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                //Toast.makeText(MainActivity.this, "clicou de novo em "+ item.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        //quando animacao do menu for concluida(obrigatorio para nao crashar)
        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                String nome = "";
                Fragment fragment = null;
                switch (item.getId()){
                    case 1:
                        nome = "inicio";
                        break;
                    case 2:
                        irParaServicos();
                        break;
                    case 3:
                        irParaAgenda();
                        break;
                    case 4:
                        irParaPerfil();
                        break;
                    default: nome = "";
                }
                //Toast.makeText(inicioActivity.this, "pagina de: "+ nome, Toast.LENGTH_SHORT).show();
            }

        });
        //come??ando com a pagina home selecionada
        bottomNavigation.show(1, true);
    }

    public void irParaServicos(){
        Intent intent = new Intent(inicioActivity.this, servicosActivity.class);
        startActivity(intent);
        finish();
    }
    public void irParaAgenda(){
        Intent intent = new Intent(inicioActivity.this, agendaActivity.class);
        startActivity(intent);
        finish();
    }
    public void irParaPerfil(){
        Intent intent = new Intent(inicioActivity.this, perfilActivity.class);
        startActivity(intent);
        finish();
    }

    public void agendar(View v){
        Intent intent = new Intent(inicioActivity.this, servicosActivity.class);
        startActivity(intent);
        finish();
    }
    public void minhaAgenda(View v){
        Intent intent = new Intent(inicioActivity.this, agendaActivity.class);
        startActivity(intent);
        finish();
    }
}