package com.example.diceroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public static final Random randint = new Random();
    public void generateRandom(View view){
        ImageView firstImage =(ImageView) findViewById(
                R.id.first_image_view);
        ImageView secondImage =(ImageView) findViewById(
                R.id.second_image_view);
        int rand1 = randint.nextInt(6) + 1;
        int rand2 = randint.nextInt(6) + 1;
        int img1 = getResources().getIdentifier("dice" + rand1, "drawable", "com.example.diceroll");
        firstImage.setImageResource(img1);
        int img2 = getResources().getIdentifier("dice" + rand2, "drawable", "com.example.diceroll");
        secondImage.setImageResource(img2);
    }

}