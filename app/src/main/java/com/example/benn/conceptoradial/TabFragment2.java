package com.example.benn.conceptoradial;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Benn on 9/12/16.
 */
public class TabFragment2 extends android.support.v4.app.Fragment implements View.OnClickListener {

    ImageButton fbButton;
    ImageButton twButton;
    ImageButton ytButton;
    ImageButton igButton;
    TextView redesSociales;
    View v;
    String YourPageURL = "https://www.facebook.com/n/?conceptoradial";
    Intent browserIntent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     v = inflater.inflate(R.layout.tab_fragment_2,container,false);
        redesSociales = (TextView)v.findViewById(R.id.redesSociales);
        fbButton= (ImageButton)v.findViewById(R.id.fbButton);
        fbButton.setOnClickListener(this);
        twButton = (ImageButton)v.findViewById(R.id.twButton);
        twButton.setOnClickListener(this);
        ytButton = (ImageButton)v.findViewById(R.id.ytButton);
        ytButton.setOnClickListener(this);
        igButton = (ImageButton)v.findViewById(R.id.igButton);
        igButton.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fbButton:
                YourPageURL = "https://www.facebook.com/n/?conceptoradial";
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(YourPageURL));
                startActivity(browserIntent);
                break;
            case R.id.ytButton:
                YourPageURL ="https://www.youtube.com/channel/UCbzuNhtevRSiyE6vYt7x3ng";
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(YourPageURL));
                startActivity(browserIntent);
                break;
            case R.id.twButton:
                YourPageURL ="https://twitter.com/conceptoradial";
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(YourPageURL));
                startActivity(browserIntent);
                break;
            case R.id.igButton:
                YourPageURL ="https://www.instagram.com/conceptoradial/";
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(YourPageURL));
                startActivity(browserIntent);
                break;
            default:
                break;
        }
       // startActivity(browserIntent);
    }

}