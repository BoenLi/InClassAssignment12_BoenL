package com.example.android.inclassassignment12_boenl;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private ImageView itemPhoto;
    private TextView itemTitle;
    private TextView itemDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        itemPhoto= (ImageView) findViewById(R.id.image);
        itemTitle= (TextView) findViewById(R.id.title);
        itemDesc= (TextView) findViewById(R.id.detail);

        Intent intent=getIntent();

        Info info= (Info) intent.getSerializableExtra("Info");
        itemPhoto.setImageResource(info.getPhotoId());
        itemTitle.setText(info.getTitle());
        itemDesc.setText(info.getDesc());

    }
}
