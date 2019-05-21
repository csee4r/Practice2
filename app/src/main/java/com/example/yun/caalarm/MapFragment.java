package com.example.yun.caalarm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;


public class MapFragment extends Fragment implements View.OnClickListener {
    boolean isView;
    ImageButton rightBt;
    FragmentManager manager;
    ImageView img;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        isView = false;
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        manager=getFragmentManager();

        img = (ImageView)view.findViewById(R.id.img);
        rightBt = (ImageButton)view.findViewById(R.id.rightBt);
        rightBt.setOnClickListener(this);

        return view;
    }

    public void onClick(View v) {
        if (v.getId() == R.id.rightBt) {
            isView = !isView;
            if(isView) {
                img.setImageResource(R.drawable.map_img);
                rightBt.setImageResource(R.drawable.rightbt_img);
            }else {
                img.setImageResource(R.drawable.info_img);
                rightBt.setImageResource(R.drawable.backbt_img);
            }

        }
    }
}

