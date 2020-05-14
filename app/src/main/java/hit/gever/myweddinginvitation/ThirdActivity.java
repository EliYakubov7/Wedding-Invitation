package hit.gever.myweddinginvitation;


import android.content.Intent;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Objects;


public class ThirdActivity extends AppCompatActivity {

    int day;
    int month;
    int year;
    int currentHour;
    int currentMinute;

    Button play;
    Button next3;



    private static final int CAMERA_REQUEST = 0;
    ImageView imageView_camera;
    Bitmap photo = null;
    Button photoButton;

    private static final int VIDEO_REQUEST = 1;
    VideoView videoView_video;
    boolean recordVideo = false;
    Button videoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        videoView_video = findViewById(R.id.videoView_video);
        imageView_camera = findViewById(R.id.imageView_camera);

        if (Locale.getDefault().getLanguage().equals("en")) {
            String waitForYou = getIntent().getStringExtra("wait for you");
            TextView textView2 = findViewById(R.id.waiting_for_you);
            textView2.setText(waitForYou);

            String eventHall = getIntent().getStringExtra("event hall");
            TextView textView = findViewById(R.id.event_hall);
            textView.setText(eventHall);
        }
        else
        {
            String waitForYou_he = getIntent().getStringExtra("מחכים לכם");
            TextView textView2 = findViewById(R.id.waiting_for_you);
            textView2.setText(waitForYou_he);

            String eventHall_he = getIntent().getStringExtra("אולם אירועים");
            TextView textView = findViewById(R.id.event_hall);
            textView.setText(eventHall_he);
        }



        day = getIntent().getIntExtra("Day",0);
        month = getIntent().getIntExtra("Month",0);
        year = getIntent().getIntExtra("Year",0);
        currentHour = getIntent().getIntExtra("Hour",0);
        currentMinute = getIntent().getIntExtra("Minute",0);


        play = findViewById(R.id.button_play);


        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                videoView_video.start();
            }
        });

        next3 = findViewById(R.id.button_next_screen3);
        next3.setClickable(true);

        next3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (Locale.getDefault().getLanguage().equals("en")) {
                    if (photo == null) {
                        Toast.makeText(getApplicationContext(), "Take a photo and try again", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (!recordVideo) {
                        Toast.makeText(getApplicationContext(), "Take a video and try again", Toast.LENGTH_LONG).show();
                        return;
                    }

                    Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
                    intent.putExtra("Day", day);
                    intent.putExtra("Month", month);
                    intent.putExtra("Year", year);
                    intent.putExtra("Hour", currentHour);
                    intent.putExtra("Minute", currentMinute);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
                else
                {
                    if (photo == null) {
                        Toast.makeText(getApplicationContext(), "צלם תמונה ונסה שנית", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (!recordVideo) {
                        Toast.makeText(getApplicationContext(), "צלם וידאו ונסה שנית", Toast.LENGTH_LONG).show();
                        return;
                    }

                    Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
                    intent.putExtra("Day", day);
                    intent.putExtra("Month", month);
                    intent.putExtra("Year", year);
                    intent.putExtra("Hour", currentHour);
                    intent.putExtra("Minute", currentMinute);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
            }

        });

        imageView_camera = findViewById(R.id.imageView_camera);
        photoButton = findViewById(R.id.button_take_photo);

        videoView_video = findViewById(R.id.videoView_video);
        videoButton = findViewById(R.id.button_take_video);

        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        });


        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent videoIntent = new Intent(android.provider.MediaStore.ACTION_VIDEO_CAPTURE);
                if (videoIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(videoIntent, VIDEO_REQUEST);
                }
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            photo = (Bitmap) Objects.requireNonNull(data.getExtras()).get("data");
            imageView_camera.setImageBitmap(photo);
        }

        if (requestCode == VIDEO_REQUEST && resultCode == RESULT_OK) {
            Uri videoUri = data.getData();
            videoView_video.setVideoURI(videoUri);
            //videoView_video.setMediaController(new MediaController(ThirdActivity.this));
            recordVideo = true;
            videoView_video.start();
        }

    }
/*    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
        startActivity(intent);
        finish();
    }*/
}