package com.example.seventh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OnBoardActivity extends AppCompatActivity {

    private ViewPagerAdapter adapter;
    private ViewPager pager;
    private Button btnStart;
    private ImageView darkThing, anotherThing;
    private TextView firsText;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);

        pager = findViewById(R.id.vp_onboard);
        btnStart = findViewById(R.id.btn_start);
        darkThing = findViewById(R.id.firs_page_img);
        firsText = findViewById(R.id.main_bank_text_txt);
        btnNext = findViewById(R.id.btn_next);
        anotherThing = findViewById(R.id.count_img);

        initButton();

        List<OnBoardModel>list = new ArrayList<>();
        list.add(new OnBoardModel(null, null, R.drawable.bumajnik));
        list.add(new OnBoardModel("Smart Wallet", "Managing your money can be the easiest thing you do all day.", R.drawable.bumajnik));
        list.add(new OnBoardModel("Effortless Budgeting", "Customize your budget categories and stay on top pf your spending 24/7.", R.drawable.meshok_deneg));
        list.add(new OnBoardModel("Automatic Saving", "Set your saving goal, and let Empower figure out how to get you there.", R.drawable.svinka_kopilka));
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnNext.getText() == "Start"){
                            Intent intent = new Intent(OnBoardActivity.this, MainActivity.class);
                            startActivity(intent);
                        }else {
                            pager.setCurrentItem(position + 1);
                        }
                    }
                });

                if (position == 0){
                    btnStart.setVisibility(View.VISIBLE);
                    darkThing.setVisibility(View.VISIBLE);
                    firsText.setVisibility(View.VISIBLE);
                    btnNext.setVisibility(View.GONE);
                    anotherThing.setVisibility(View.GONE);
                }else if (position == 1){
                    btnNext.setTextColor(getResources().getColor(R.color.white));
                    btnNext.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    btnNext.setVisibility(View.VISIBLE);
                    btnStart.setVisibility(View.GONE);
                    darkThing.setVisibility(View.GONE);
                    firsText.setVisibility(View.GONE);
                    anotherThing.setVisibility(View.VISIBLE);
                    anotherThing.setImageResource(R.drawable.one);
                }else if (position == 2){
                    btnNext.setTextColor(getResources().getColor(R.color.dark_purple));
                    btnNext.setBackgroundColor(getResources().getColor(R.color.white));
                    btnNext.setText("Next");
                    anotherThing.setImageResource(R.drawable.two);
                }else if (position == 3){
                    btnNext.setTextColor(getResources().getColor(R.color.white));
                    btnNext.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    btnNext.setText("Start");
                    anotherThing.setImageResource(R.drawable.three);
                }else {
                    btnStart.setVisibility(View.GONE);
                    darkThing.setVisibility(View.GONE);
                    firsText.setVisibility(View.GONE);
                }

            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void initButton() {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(1);
            }
        });
    }
}