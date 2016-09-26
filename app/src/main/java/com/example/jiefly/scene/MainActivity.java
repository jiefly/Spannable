package com.example.jiefly.scene;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Scene scene1;
    Scene scene2;
    int count = 0;
    ImageView mImageView1;
    ImageView mImageView2;
    ImageView mImageView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewGroup view = (ViewGroup) findViewById(R.id.id_root_view);
        scene2 = Scene.getSceneForLayout(view,R.layout.scene_start,this);

        scene1 = Scene.getSceneForLayout(view,R.layout.scene_end,this);
        mImageView1 = (ImageView) findViewById(R.id.id_img1);
        mImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"1 click",Toast.LENGTH_SHORT).show();
            }
        });
        mImageView2 = (ImageView) findViewById(R.id.id_img2);
        mImageView3 = (ImageView) findViewById(R.id.id_img3);
        mImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"2 click",Toast.LENGTH_SHORT).show();
            }
        });
        mImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"3 click",Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.id_start_anim_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                switch (count%2){
                    case 1:
                        TransitionManager.go(scene1,new Fade());
                        break;
                    case 0:
                        TransitionManager.go(scene2,new Slide());
                }

            }
        });
    }
}
