package com.example.ungdungdoanxem;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button btnBam;
    ImageView hinhAvtar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBam = (Button) findViewById(R.id.btnBam);
        hinhAvtar = (ImageView) findViewById(R.id.anhdoanxem);

        btnBam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Loadanh().execute("http://sohanews.sohacdn.com/thumb_w/660/2018/7/25/photo1532488958422-1532488958423377137026.jpg");

            }
        });

    }

    private class Loadanh extends AsyncTask<String, Void, Bitmap>{
        Bitmap bitmaphinh = null;
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openConnection().getInputStream();
                bitmaphinh = BitmapFactory.decodeStream(inputStream);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmaphinh;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            hinhAvtar.setImageBitmap(bitmap);
        }
    }

}
