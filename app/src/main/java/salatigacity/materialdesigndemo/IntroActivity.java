package salatigacity.materialdesigndemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import salatigacity.materialdesigndemo.adapter.PageIntroAdapter;
import salatigacity.materialdesigndemo.fragment.DescriptionsFragment;
import salatigacity.materialdesigndemo.fragment.RegisterFragment;
import salatigacity.materialdesigndemo.fragment.WelcomeFragment;

/**
 * Created by ssh on 6/13/2017.
 */

public class IntroActivity extends AppCompatActivity{

    private ViewPager page_intro;
    private PageIntroAdapter adapter;
    private List<Fragment> fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_into);

        fragment = new ArrayList<>();
        fragment.add(new WelcomeFragment());
        fragment.add(new DescriptionsFragment());
        fragment.add(new RegisterFragment());

        page_intro = (ViewPager)findViewById(R.id.page_intro);
        adapter = new PageIntroAdapter(getSupportFragmentManager(), fragment);
        page_intro.setAdapter(adapter);

        final View dot_one = findViewById(R.id.dot_one);
        final View dot_two = findViewById(R.id.dot_two);
        final View dot_three = findViewById(R.id.dot_three);

        page_intro.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 1){
                    dot_one.setBackgroundResource(R.drawable.rounded_background);
                    dot_two.setBackgroundResource(R.drawable.rounded_origin);
                    dot_three.setBackgroundResource(R.drawable.rounded_background);
                }else if(position == 2){
                    dot_one.setBackgroundResource(R.drawable.rounded_background);
                    dot_three.setBackgroundResource(R.drawable.rounded_origin);
                    dot_two.setBackgroundResource(R.drawable.rounded_background);
                }else if (position == 0){
                    dot_two.setBackgroundResource(R.drawable.rounded_background);
                    dot_one.setBackgroundResource(R.drawable.rounded_origin);
                    dot_three.setBackgroundResource(R.drawable.rounded_background);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
