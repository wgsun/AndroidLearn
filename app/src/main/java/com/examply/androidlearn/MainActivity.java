package com.examply.androidlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.examply.javacore.reflex.Test;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //反射测试
        Test test = new Test();
        try {
            test.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}