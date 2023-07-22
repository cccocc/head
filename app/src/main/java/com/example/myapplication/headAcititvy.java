package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifDrawable;

public class headAcititvy extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head);
//      ”点击屏幕中间“的文字
        TextView textView=findViewById(R.id.tiptext);
        textView.setShadowLayer(100,10,10, Color.WHITE);


//      首页大按钮
        View dialogView = getLayoutInflater().inflate(R.layout.say, null);

        Button butsaysomething = findViewById(R.id.say_button);

        butsaysomething.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //缩小图片和文字
                        butsaysomething.animate().scaleX(0.95f).scaleY(0.95f).setDuration(100).start();
                        break;
                    case MotionEvent.ACTION_UP:
                        //还原图片和文字
                        butsaysomething.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
//                        Intent intent=new Intent(headAcititvy.this,ChatActivity.class);
//                        startActivity(intent);
                        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(headAcititvy.this);
                        LayoutInflater inflater = getLayoutInflater();
                        View dialogView = inflater.inflate(R.layout.say, null);
                        dialogBuilder.setView(dialogView);

                        pl.droidsonroids.gif.GifImageView gifImageView = dialogView.findViewById(R.id.gifImageView);
                        GifDrawable gifDrawable = (GifDrawable) gifImageView.getDrawable();

                        AlertDialog alertDialog = dialogBuilder.create();
                        alertDialog.show();
                        gifDrawable.start();

                        break;
                }
                return true;
            }
        });


//      首页新手引导按钮
        Button butxinshou=findViewById(R.id.xin_shou);
        butxinshou.setShadowLayer(100,10,10,Color.WHITE);

        butxinshou.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //缩小图片和文字
                        butxinshou.animate().scaleX(0.95f).scaleY(0.95f).setDuration(100).start();
                        break;
                    case MotionEvent.ACTION_UP:
                        //还原图片和文字
                        butxinshou.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
                        Intent intent=new Intent(headAcititvy.this, gruid_new_shit_acitvity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });


//      我的消息按钮
        final LinearLayout mynew = findViewById(R.id.mynews);
        final ImageView mynewimage = mynew.findViewById(R.id.mynews_son1);
        final TextView mynewtext = mynew.findViewById(R.id.mynews_son2);
        mynew.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //缩小图片和文字
                        mynewimage.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).start();
                        mynewtext.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).start();
                        break;
                    case MotionEvent.ACTION_UP:
                        //还原图片和文字
                        mynewimage.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
                        mynewtext.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
                        Intent intent=new Intent(headAcititvy.this, mynews_activity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });


//      搜索框
        SearchView mSearchView = findViewById(R.id.search);


//      下方功能栏
//      首页
        final LinearLayout myButton1 = findViewById(R.id.littleshit1);
        final ImageView image1 = myButton1.findViewById(R.id.littleshit1_son1);
        final TextView text1 = myButton1.findViewById(R.id.littleshit1_son2);
        myButton1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //缩小图片和文字
                        image1.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).start();
                        text1.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).start();
                        break;
                    case MotionEvent.ACTION_UP:
                        //还原图片和文字
                        image1.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
                        text1.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
                        Intent intent=new Intent(headAcititvy.this, headAcititvy.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

//      阅读
        final LinearLayout myButton2 = findViewById(R.id.littleshit2);
        final ImageView image2 = myButton2.findViewById(R.id.littleshit2_son1);
        final TextView text2 = myButton2.findViewById(R.id.littleshit2_son2);
        myButton2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //缩小图片和文字
                        image2.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).start();
                        text2.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).start();
                        break;
                    case MotionEvent.ACTION_UP:
                        //还原图片和文字
                        image2.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
                        text2.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
                        Intent intent=new Intent(headAcititvy.this, read_activity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

//      备忘录
        final LinearLayout myButton3 = findViewById(R.id.littleshit3);
        final ImageView image3 = myButton3.findViewById(R.id.littleshit3_son1);
        final TextView text3 = myButton3.findViewById(R.id.littleshit3_son2);
        myButton3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //缩小图片和文字
                        image3.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).start();
                        text3.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).start();
                        break;
                    case MotionEvent.ACTION_UP:
                        //还原图片和文字
                        image3.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
                        text3.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
                        Intent intent=new Intent(headAcititvy.this, bei_wang_lu.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
//      我的
        final LinearLayout myButton4 = findViewById(R.id.littleshit4);
        final ImageView image4 = myButton4.findViewById(R.id.littleshit4_son1);
        final TextView text4 = myButton4.findViewById(R.id.littleshit4_son2);
        myButton4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //缩小图片和文字
                        image4.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).start();
                        text4.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).start();
                        break;
                    case MotionEvent.ACTION_UP:
                        //还原图片和文字
                        image4.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
                        text4.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
                        Intent intent=new Intent(headAcititvy.this, me_acitvity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
    }
}
