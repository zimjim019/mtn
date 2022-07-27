package com.example411.termworkfour;

import androidx.appcompat.app.AppCompatActivity;
import android.app.WallpaperManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.*;
import android.graphics.drawable.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button changewallpaper;
    Timer timer;
    Drawable drawable;
    WallpaperManager wallpapermanager;
    int prev=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = new Timer();
        wallpapermanager = WallpaperManager.getInstance(this);
        changewallpaper = findViewById(R.id.changeWallapperBTN);
        changewallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWallpaperFunc();
            }
        });
    }

    private void setWallpaperFunc() {
        timer.schedule(new TimerTask() {
            @Override
            public void run(){
                if (prev==1){
                    drawable = getResources().getDrawable(R.drawable.image1);
                    prev=2;
                }else if (prev == 2){
                    drawable = getResources().getDrawable(R.drawable.image2);
                    prev=3;
                }else if (prev ==3) {
                    drawable = getResources().getDrawable(R.drawable.image3);
                    prev=4;
                }else if (prev == 4) {
                    drawable = getResources().getDrawable(R.drawable.image4);
                    prev=5;
                }else if (prev == 5){
                    drawable = getResources().getDrawable(R.drawable.image5);
                    prev = 1;
                }
                Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
                try {
                    wallpapermanager.setBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        },0,30000);
    }
}