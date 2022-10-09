package com.example.bottom_navigation_com_activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class perfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomNavigatio_perfil);

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
                        irParaInicio();
                        break;
                    case 2:
                        irParaServicos();
                        break;
                    case 3:
                        irParaAgenda();
                        break;
                    case 4:
                        nome = "perfil";
                        break;
                    default: nome = "";
                }
                //Toast.makeText(inicioActivity.this, "pagina de: "+ nome, Toast.LENGTH_SHORT).show();
            }

        });
        //começando com a pagina home selecionada
        bottomNavigation.show(4, true);
    }
    public void irParaInicio(){
        Intent intent = new Intent(perfilActivity.this, inicioActivity.class);
        startActivity(intent);
        finish();
    }
    public void irParaServicos(){
        Intent intent = new Intent(perfilActivity.this, servicosActivity.class);
        startActivity(intent);
        finish();
    }
    public void irParaAgenda(){
        Intent intent = new Intent(perfilActivity.this, agendaActivity.class);
        startActivity(intent);
        finish();
    }
}