package com.example.yogurt.choosepictest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button takePhoto;
    private ImageView picture;
    public static final int TAKE_PHOTO=0;
    public static final int CROP_PHOTO=1;
    private Uri imageUri;
    private Button chooseFromAlbum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        takePhoto= (Button) findViewById(R.id.take_photo);
        picture= (ImageView) findViewById(R.id.picture);
        chooseFromAlbum= (Button) findViewById(R.id.choose_from_album);
        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File outputFile=new File(Environment.getExternalStorageDirectory(),"output_img.jpg");
                try {
                    if (outputFile.exists()){
                        outputFile.delete();
                    }
                    outputFile.createNewFile();
                }catch (Exception e){
                    e.printStackTrace();
                }

                imageUri=Uri.fromFile(outputFile);
                Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(intent,TAKE_PHOTO);

            }
        });

        chooseFromAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File outputImage=new File(Environment.getExternalStorageDirectory(),"outputImage.jpg");
                try {
                    if (outputImage.exists()){
                        outputImage.delete();
                    }else {
                        outputImage.createNewFile();
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }

                imageUri=Uri.fromFile(outputImage);
                Intent intent=new Intent("android.intent.action.GET_CONTENT");
                intent.setType("image/*");
                intent.putExtra("crop",true);
                intent.putExtra("scale",true);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(intent,CROP_PHOTO);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case TAKE_PHOTO:
                if (resultCode==RESULT_OK){
                    Intent intent=new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri,"image/*");
                    intent.putExtra("scale",true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                    startActivityForResult(intent,CROP_PHOTO);
                }
                break;
            case CROP_PHOTO:
                Log.d("Main",String.valueOf(requestCode));
                if (requestCode==RESULT_OK){
                    try {
                        Bitmap bitmap= BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        //Bitmap bitmap=BitmapFactory.decodeFile(String.valueOf(imageUri));
                        picture.setImageBitmap(bitmap);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }


    }
}
