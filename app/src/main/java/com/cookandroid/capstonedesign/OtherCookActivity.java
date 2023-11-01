package com.cookandroid.capstonedesign;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class OtherCookActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_cook);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();;
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setHomeAsUpIndicator(R.drawable.hamburger_button_foreground);
        actionBar.setTitle("오늘의 메뉴 추천");

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();

                int id = menuItem.getItemId();
                String title = menuItem.getTitle().toString();

                if(id == R.id.action_item1) {
                    Intent intent = new Intent(OtherCookActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else if(id == R.id.action_item2) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.weather.go.kr/w/weather/forecast/short-term.do"));
                    startActivity(intent);
                }
                else if(id == R.id.action_item3) {
                    Intent intent = new Intent(OtherCookActivity.this,OtherCookActivity.class);
                    startActivity(intent);
                }
                else if(id == R.id.action_item4) {
                    moveTaskToBack(true); // 태스크를 백그라운드로 이동
                    finishAndRemoveTask(); // 액티비티 종료 + 태스크 리스트에서 지우기
                    System.exit(0);
                }

                return true;
            }
        });


        Button searchBtn = (Button) findViewById(R.id.SearchBtn);
        FrameLayout frameLayout1 = (FrameLayout) findViewById(R.id.FrameLayout1);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.FrameLayout2);
        FrameLayout frameLayout3 = (FrameLayout) findViewById(R.id.FrameLayout3);
        FrameLayout frameLayout4 = (FrameLayout) findViewById(R.id.FrameLayout4);

        //db연결 미완성으로 임시 데이터 생성
        Map<String,FrameLayout> recipeMap = new HashMap<>();
        recipeMap.put("전",frameLayout1);
        recipeMap.put("김밥",frameLayout2);
        recipeMap.put("샌드위치",frameLayout3);
        recipeMap.put("볶음밥",frameLayout4);
        ArrayList<String> recipeLst = new ArrayList<String>();
        recipeLst.add("전");
        recipeLst.add("김밥");
        recipeLst.add("샌드위치");
        recipeLst.add("볶음밥");

        AutoCompleteTextView input = (AutoCompleteTextView) findViewById(R.id.Input);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,recipeLst);
        input.setAdapter(adapter);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //재검색 시 출력하기 위해 전부 visible로 초기화
                for(String key : recipeMap.keySet()) {
                    recipeMap.get(key).setVisibility(View.VISIBLE);
                }
                //입력값 String 형식으로 받기
                String inputData = input.getText().toString();
                //입력값 빈칸일 시 경고 메세지 출력
                if(inputData.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "검색어를 입력해주세요.",Toast.LENGTH_SHORT).show();
                }
                //입력값에 해당하는 framelayout 제외 gone처리
                else {
                    for(String key : recipeMap.keySet()) {
                        if(!key.equals(inputData)) {
                            recipeMap.get(key).setVisibility(View.GONE);
                        }
                    }
                }

            }
        });

        Button recipeBtn1,recipeBtn2,recipeBtn3,recipeBtn4;
        recipeBtn1 = (Button) findViewById(R.id.RecipeBtn1);
        recipeBtn2 = (Button) findViewById(R.id.RecipeBtn2);
        recipeBtn3 = (Button) findViewById(R.id.RecipeBtn3);
        recipeBtn4 = (Button) findViewById(R.id.RecipeBtn4);

        recipeBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtherCookActivity.this,RecipeActivity.class);
                startActivity(intent);
            }
        });

        recipeBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtherCookActivity.this,RecipeActivity.class);
                startActivity(intent);
            }
        });

        recipeBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtherCookActivity.this,RecipeActivity.class);
                startActivity(intent);
            }
        });

        recipeBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtherCookActivity.this,RecipeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
