package com.example.pnu_front.profile;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.R;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int[] tmp = {0}; //0일때 평소 상태 1일때 확대 상태
        setContentView(R.layout.activity_profile);
        ImageView imageView = findViewById(R.id.Congress_member_listsizebtn);
        RecyclerView congresslist = findViewById(R.id.congress_member_list);
        RecyclerView memberprofile = findViewById(R.id.congress_member_profile);
        FrameLayout frameLayout = findViewById(R.id.frame_layout);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tmp[0] == 0) {
                    ViewGroup.LayoutParams params = congresslist.getLayoutParams();
                    params.width = 950;
                    params.height = 1400;
                    congresslist.setLayoutParams(params);
                    memberprofile.setVisibility(View.GONE);
                    imageView.setBackgroundResource(R.drawable.up_right);
                    tmp[0] = 1;
                }
                else
                {
                    ViewGroup.LayoutParams params = congresslist.getLayoutParams();
                    params.height = 600;
                    congresslist.setLayoutParams(params);
                    memberprofile.setVisibility(View.VISIBLE);
                    imageView.setBackgroundResource(R.drawable.down_right);
                    tmp[0] = 0 ;

                }
            }
        });
    }
}