package com.example.wim.androidrecyclerview;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wim.androidrecyclerview.fragments.MemberFragment;
import com.example.wim.androidrecyclerview.model.Member;

public class DetailActivity extends AppCompatActivity {

    private Member member;
    private TextView nameAnggota;
    private TextView nameTeam;
    private ImageView photo;
    private TextView number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        member = (Member) getIntent().getSerializableExtra(MemberFragment.KEY_MEMBER);


        nameAnggota = (TextView) findViewById(R.id.namaAnggota);
        nameTeam = (TextView) findViewById(R.id.namaTeam);
        photo = (ImageView) findViewById(R.id.thumb2);
        number = (TextView) findViewById(R.id.number);

        nameAnggota.setText(member.getName());
        nameTeam.setText(member.getTeam());
        photo.setImageResource(member.getThumb());
        number.setText(member.getNumber()+"");

        Button call = (Button) findViewById(R.id.btnCall2);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent pindah2 = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:" + number.getText().toString()));
                if (ActivityCompat.checkSelfPermission(DetailActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(pindah2);
            }
        });

    }
}
