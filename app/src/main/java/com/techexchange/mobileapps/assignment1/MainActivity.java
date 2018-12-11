package com.techexchange.mobileapps.assignment1;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.nfc.Tag;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView grid[] = new ImageView[9];
    private int movenum;
    private int emptyspace;
    private Random ran = new Random();
    private int random;
    private boolean gameended;
    private int count;
    private int count2;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image0 = findViewById(R.id.ph00);
        image0.setOnClickListener(view -> Onclick(view, 0, grid));
        image0.setTag(0);

        ImageView image1 = findViewById(R.id.ph01);
        image1.setOnClickListener(view -> Onclick(view, 1, grid));
        image1.setTag(1);

        ImageView image2 = findViewById(R.id.ph02);
        image2.setOnClickListener(view -> Onclick(view, 2, grid));
        image2.setTag(2);

        ImageView image3 = findViewById(R.id.ph03);
        image3.setOnClickListener(view -> Onclick(view, 3, grid));
        image3.setTag(3);

        ImageView image4 = findViewById(R.id.ph04);
        image4.setOnClickListener(view -> Onclick(view, 4, grid));
        image4.setTag(4);

        ImageView image5 = findViewById(R.id.ph05);
        image5.setOnClickListener(view -> Onclick(view, 5, grid));
        image5.setTag(5);

        ImageView image6 = findViewById(R.id.ph06);
        image6.setOnClickListener(view -> Onclick(view, 6, grid));
        image6.setTag(6);

        ImageView image7 = findViewById(R.id.ph07);
        image7.setOnClickListener(view -> Onclick(view, 7, grid));
        image7.setTag(7);

        ImageView image8 = findViewById(R.id.ph08);
        image8.setOnClickListener(view -> Onclick(view, 8, grid));
        image8.setTag(8);

        grid[0] = image0;
        grid[1] = image1;
        grid[2] = image2;
        grid[3] = image3;
        grid[4] = image4;
        grid[5] = image5;
        grid[6] = image6;
        grid[7] = image7;
        grid[8] = image8;
        emptyspace = 0;

        randomNumbers(grid);
    }


    private void Onclick(View view, int title, ImageView grid[]) {
        ImageView image = (ImageView) view;

        for (int k = 0; k < grid.length; k++) {
            if (grid[k] == view) {
                movenum = k;
            }
        }//for

        if (isValidMove(movenum, emptyspace) && gameended == false) {
            grid[emptyspace].setImageDrawable(grid[movenum].getDrawable());
            grid[emptyspace].setTag(grid[movenum].getTag());
            emptyspace = movenum;
            grid[movenum].setImageDrawable(null);
            grid[movenum].setTag(0);
            wontheGame(grid);


        }
    }//end

    private boolean isValidMove(int movenum, int emptyspace) {
        return movenum - 1 == emptyspace || movenum - 3 == emptyspace || movenum + 1 == emptyspace || movenum + 3 == emptyspace;
    }

    private void randomNumbers(ImageView grid[]) {
        for (int k = 0; k < 20; k++) {
            random = ran.nextInt(9);
            if (random - 1 == emptyspace || random - 3 == emptyspace || random + 1 == emptyspace || random + 3 == emptyspace) {
                grid[emptyspace].setImageDrawable(grid[random].getDrawable());
                grid[emptyspace].setTag(grid[random].getTag());
                emptyspace = random;
                grid[random].setImageDrawable(null);
                grid[random].setTag(0);
            }

        }
    }

    private void wontheGame(ImageView grid[]) {
        count = 1;
        count2 = 0;

        for (int k = 0; k < grid.length; k++) {
            if ((int) grid[k].getTag() == k + 1)
                count2++;

        }

        if (count2 == 8) {
            grid[0].setImageResource(R.drawable.tile021);
            grid[1].setImageResource(R.drawable.tile022);
            grid[2].setImageResource(R.drawable.tile023);
            grid[3].setImageResource(R.drawable.tile024);
            grid[4].setImageResource(R.drawable.tile025);
            grid[5].setImageResource(R.drawable.tile026);
            grid[6].setImageResource(R.drawable.tile027);
            grid[7].setImageResource(R.drawable.tile028);

            Toast.makeText(getApplicationContext(), "YOU WON!", Toast.LENGTH_LONG).show();
            gameended = true;
        }
    }


}
