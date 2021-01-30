package com.gerald.smartchurch;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class MyAppIntro extends AppIntro {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //First Slider
        addSlide(AppIntroFragment.newInstance("Registration", " In Smart church App you can able to connect or register in order to be member of our church, and to participate in our events" ,
                R.drawable.registration_icon, ContextCompat.getColor(getApplicationContext(),R.color.thirdColor)));

        //Second Slider
        addSlide(AppIntroFragment.newInstance("Prayer Request", " Smart Church App it help you to request for prayer, and to join in different groups of prayer you want",
                R.drawable.prayer_icon, ContextCompat.getColor(getApplicationContext(),R.color.thirdColor)));


        //Third Slider
        addSlide(AppIntroFragment.newInstance("Ministries", " Smart Church App also, it give you chance to joining in groups, in order to share different things like prayers and so on.",
                R.drawable.group_icon, ContextCompat.getColor(getApplicationContext(),R.color.thirdColor)));
        setFadeAnimation();

        sharedPreferences = getApplicationContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if(sharedPreferences!= null){
            boolean checkShared = sharedPreferences.getBoolean("checkStated", false);

            if (checkShared == true){
                startActivity(new Intent(getApplicationContext(), LandingPage.class));
                finish();
            }
        }

    }

   @Override
    public void onSkipPressed (Fragment currentFragment){
        super.onSkipPressed(currentFragment);
        //Do something when user can tap skip button
       startActivity(new Intent(getApplicationContext(), LandingPage.class));
       editor.putBoolean("checkStated", false);
       //when you write commit() it means introduction it will never appear again until app lunched again.
       finish();

   }

    @Override
    public void onDonePressed (Fragment currentFragment){
        super.onDonePressed(currentFragment);
        //Do something when user can tap done button
        startActivity(new Intent(getApplicationContext(), LandingPage.class));
        editor.putBoolean("checkStated", true);
        // when you write commit() it means introduction it will never appear again until app lunched again.
        finish();

    }
}