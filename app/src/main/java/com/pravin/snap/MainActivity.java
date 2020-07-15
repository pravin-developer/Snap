package com.pravin.snap;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private ImageView imageView;



        @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            TextView textView=(TextView) findViewById(R.id.textView);
            imageView = (ImageView) findViewById(R.id.imageView);
            Button photoButton = (Button) this.findViewById(R.id.photobutton);
            photoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent, 0);


                }


            });
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode,resultCode,data);

        Bitmap photo = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(photo);

    }
}
