package com.example.diceroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    public static final Random randint = new Random();
    ImageView firstImage, secondImage;
    int[] memory= new int[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= findViewById(R.id.roll_button);
        firstImage = (ImageView) findViewById(
                R.id.first_image_view);
        secondImage = (ImageView) findViewById(
                R.id.second_image_view);
        if (savedInstanceState != null){
            secondImage.setImageResource(savedInstanceState.getInt("img1"));
            firstImage.setImageResource(savedInstanceState.getInt("img2"));
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int rand1 = getResources().getIdentifier("dice" + (randint.nextInt(6)+1), "drawable", "com.example.diceroll");
                firstImage.setImageResource(rand1);
                memory[0] = rand1;

                int rand2= getResources().getIdentifier("dice" + (randint.nextInt(6)+1), "drawable", "com.example.diceroll");
                secondImage.setImageResource(rand2);
                memory[1] = rand2;
            }
        });
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("img1", memory[0]);
        savedInstanceState.putInt("img2", memory[1]);
    }
}