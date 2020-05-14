package hit.gever.myweddinginvitation;

import android.Manifest;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;


public class FourthActivity extends AppCompatActivity {

    final int SET_TIMER_PERMISSION_REQUEST = 1;

    TextView saveDate;
    TextView saveDate_he;

    ImageButton timer;
    ImageButton addEvent;
    ImageButton youtube;
    ImageButton whatsapp;
    ImageButton map;

    String amPm;
  //  String amPm_he;

    int day;
    int month;
    int year;
    int hour;
    int minutes;

   // int day_he;
   //int month_he;
   //int year_he;
   // int hour_he;
   //int minutes_he;

   // EditText eventHall = findViewById(R.id.enter_name_of_event_hall);
    //EditText timeWedding = findViewById(R.id.enter_time);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_activity);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        if (Locale.getDefault().getLanguage().equals("en")) {
            day = getIntent().getIntExtra("Day", 0);
            month = getIntent().getIntExtra("Month", 0);
            year = getIntent().getIntExtra("Year", 0);
            hour = getIntent().getIntExtra("Hour", 0);
            minutes = getIntent().getIntExtra("Minute", 0);
        }
        else
        {
            day = getIntent().getIntExtra("Day", 0);
            month = getIntent().getIntExtra("Month", 0);
            year = getIntent().getIntExtra("Year", 0);
            hour = getIntent().getIntExtra("Hour", 0);
            minutes = getIntent().getIntExtra("Minute", 0);
        }

        if (Locale.getDefault().getLanguage().equals("en")) {
            saveDate = findViewById(R.id.txt_save_date);
            SharedPreferences result = getSharedPreferences("SaveDate", Context.MODE_PRIVATE);
            String date = result.getString("Date", "Date Not Found");
            saveDate.setText(date);
        }
        else {
            saveDate_he = findViewById(R.id.txt_save_date);
            SharedPreferences result_he = getSharedPreferences("שמור תאריך", Context.MODE_PRIVATE);
            String date_he = result_he.getString("תאריך", "התאריך לא נמצא");
            saveDate_he.setText(date_he);
        }

        addEvent = findViewById(R.id.image_button_Add_Event_to_Calendar);

        timer = findViewById(R.id.image_button_set_timer);

        youtube = findViewById(R.id.image_button_youtube);

        whatsapp = findViewById(R.id.image_button_WhatsApp);

        map = findViewById(R.id.image_button_map);


        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Locale.getDefault().getLanguage().equals("en")) {
                    SharedPreferences result2 = getSharedPreferences("SaveLocation", Context.MODE_PRIVATE);
                    String Location = result2.getString("Location", "Location Not Found");

                    String map = "http://maps.google.co.in/maps?q=" + Location;

                    Uri gmmIntentUri = Uri.parse(map);
                    Intent intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    intent.setPackage("com.google.android.apps.maps");
                    startActivity(intent);
                }
                else {
                    SharedPreferences result2_he = getSharedPreferences("שמור מיקום", Context.MODE_PRIVATE);
                    String Location = result2_he.getString("מיקום", "המיקום לא נמצא");

                    String map = "http://maps.google.co.in/maps?q=" + Location;

                    Uri gmmIntentUri = Uri.parse(map);
                    Intent intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    intent.setPackage("com.google.android.apps.maps");
                    startActivity(intent);
                }
            }
        });

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Locale.getDefault().getLanguage().equals("en")) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_TEXT, "Congratulations for wedding day" + "\n" + "Wishing you all the best" + " " + "♥");
                    intent.setType("text/plain");
                    intent.setPackage("com.whatsapp");
                    try {
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(getApplicationContext(), "Whatsapp have not been installed", Toast.LENGTH_LONG).show();

                    }

                } else {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_TEXT, "ברכות לרגל יום חתונתכם" + "\n" + "מאחל לכם את כל הטוב שבעולם" + " " + "♥");
                    intent.setType("text/plain");
                    intent.setPackage("com.whatsapp");
                    try {
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(getApplicationContext(), "וואצאפ לא מותקן", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });


        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Locale.getDefault().getLanguage().equals("en")) {
                    String playlist = "Top 100 Beautiful Wedding Songs 2019 PLAYLIST";

                    Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
                    intent.putExtra(MediaStore.EXTRA_MEDIA_FOCUS, MediaStore.Audio.Artists.ENTRY_CONTENT_TYPE);
                    intent.putExtra(SearchManager.QUERY, playlist);
                    intent.setPackage("com.google.android.youtube");
                    try {
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(getApplicationContext(), "Youtube have not been installed", Toast.LENGTH_LONG).show();
                    }
                } else {
                    String playlist = "טופ 100 שירים יפים לחתונה 2019 פלייליסט";

                    Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
                    intent.putExtra(MediaStore.EXTRA_MEDIA_FOCUS, MediaStore.Audio.Artists.ENTRY_CONTENT_TYPE);
                    intent.putExtra(SearchManager.QUERY, playlist);
                    intent.setPackage("com.google.android.youtube");
                    try {
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(getApplicationContext(), "יוטיוב לא מותקן", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Locale.getDefault().getLanguage().equals("en")) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        int hasSetTimer = checkSelfPermission(Manifest.permission.SET_ALARM);

                        if (hasSetTimer == PackageManager.PERMISSION_GRANTED) {
                            setTimer();
                        } else // Permission Denied
                        {
                            requestPermissions(new String[]{Manifest.permission.SET_ALARM}, SET_TIMER_PERMISSION_REQUEST);
                        }
                    } else {
                        setTimer();
                    }
                }
                else
                {
                    if (Build.VERSION.SDK_INT >= 23) {
                        int hasSetTimer_he = checkSelfPermission(Manifest.permission.SET_ALARM);

                        if (hasSetTimer_he == PackageManager.PERMISSION_GRANTED) {
                            setTimerHe();
                        } else // Permission Denied
                        {
                            requestPermissions(new String[]{Manifest.permission.SET_ALARM}, SET_TIMER_PERMISSION_REQUEST);
                        }
                    } else {
                        setTimerHe();
                    }
                }
            }
        });

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String endTime

                if (Locale.getDefault().getLanguage().equals("en")) {
                    SharedPreferences result2 = getSharedPreferences("SaveLocation", Context.MODE_PRIVATE);
                    String Location = result2.getString("Location", "Location Not Found");

                    SharedPreferences result4 = getSharedPreferences("SaveNameOfEventHall", Context.MODE_PRIVATE);
                    String eventHall = result4.getString("EventHall", "Event Hall Not Found");

                    SharedPreferences result5 = getSharedPreferences("SaveNames", Context.MODE_PRIVATE);
                    String Names = result5.getString("Names", "Names Not Found");

                    SharedPreferences result1 = getSharedPreferences("GroomsParents", Context.MODE_PRIVATE);
                    String groomsParents = result1.getString("GParents", "Names Of Groom's Parents Not Found");

                    SharedPreferences result3 = getSharedPreferences("BridesParents", Context.MODE_PRIVATE);
                    String bridesParents = result3.getString("BParents", "Names Of Bride's Parents Not Found");

                    Calendar beginTimeOfEvent = Calendar.getInstance();
                    beginTimeOfEvent.set(year, month, day, hour, minutes);

                    int dayOfWeek = beginTimeOfEvent.get(Calendar.DAY_OF_WEEK);

                    Calendar endTimeOfEvent = Calendar.getInstance();

                    if (hour >= 12 && Calendar.FRIDAY == dayOfWeek) {
                        amPm = "PM";
                        endTimeOfEvent.set(year, month, day, hour + 4, 0);
                    } else if (hour >= 12) {
                        endTimeOfEvent.set(year, month, day, hour + 8, 0);
                    }

                    if (hour <= 12 && Calendar.FRIDAY == dayOfWeek) {
                        amPm = "AM";
                        endTimeOfEvent.set(year, month, day, hour + 4, 0);
                    } else if (hour <= 12) {
                        endTimeOfEvent.set(year, month, day, hour + 8, 0);
                    }

                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setData(CalendarContract.Events.CONTENT_URI);
                    intent.putExtra(CalendarContract.Events.TITLE, "Wedding Of" + " " + Names);
                    intent.putExtra(CalendarContract.Events.EVENT_LOCATION, Location);
                    intent.putExtra(CalendarContract.Events.DESCRIPTION,
                            "The groom's parents"  + " " + ":" + " " + groomsParents + "\n" +
                            "The bride's parents"  + " " + ":" + " " + bridesParents + "\n" +
                            "Name Of Event Hall" + " " + ":" + " " + eventHall);
                    intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTimeOfEvent.getTime().getTime());
                    intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTimeOfEvent.getTime().getTime());

                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
                else {
                    SharedPreferences result2_he = getSharedPreferences("שמור מיקום", Context.MODE_PRIVATE);
                    String Location_he = result2_he.getString("מיקום", "המיקום לא נמצא");

                    SharedPreferences result4_he = getSharedPreferences("שמור שם אולם אירועים", Context.MODE_PRIVATE);
                    String eventHall_he = result4_he.getString("אולם אירועים", "אולם האירועים לא נמצא");

                    SharedPreferences result5_he = getSharedPreferences("שמור שמות", Context.MODE_PRIVATE);
                    String Names_he = result5_he.getString("שמות", "השמות לא נמצאו");

                    SharedPreferences result1_he = getSharedPreferences("הורי החתן", Context.MODE_PRIVATE);
                    String groomsParents_he = result1_he.getString("הוריחתן", "שמות הורי החתן לא נמצאו");

                    SharedPreferences result3_he = getSharedPreferences("הורי הכלה", Context.MODE_PRIVATE);
                    String bridesParents_he = result3_he.getString("הוריכלה", "שמות הורי הכלה לא נמצאו");


                    Calendar beginTimeOfEvent_he = Calendar.getInstance();
                    beginTimeOfEvent_he.set(year, month, day, hour, minutes);

                    int dayOfWeek_he = beginTimeOfEvent_he.get(Calendar.DAY_OF_WEEK);

                    Calendar endTimeOfEvent_he = Calendar.getInstance();

                    if (hour >= 12 && Calendar.FRIDAY == dayOfWeek_he) {
                        amPm = "PM";
                        endTimeOfEvent_he.set(year, month, day, hour + 4, 0);
                    } else if (hour >= 12) {
                        endTimeOfEvent_he.set(year, month, day, hour + 8, 0);
                    }

                    if (hour <= 12 && Calendar.FRIDAY == dayOfWeek_he) {
                        amPm = "AM";
                        endTimeOfEvent_he.set(year, month, day, hour + 4, 0);
                    } else if (hour <= 12) {
                        endTimeOfEvent_he.set(year, month, day, hour + 8, 0);
                    }

                    Intent intent_he = new Intent(Intent.ACTION_INSERT);
                    intent_he.setData(CalendarContract.Events.CONTENT_URI);
                    intent_he.putExtra(CalendarContract.Events.TITLE, "החתונה של" + " " + Names_he);
                    intent_he.putExtra(CalendarContract.Events.EVENT_LOCATION, Location_he);
                    intent_he.putExtra(CalendarContract.Events.DESCRIPTION,
                            "שמות הורי החתן"  + " " + ":" + " " + groomsParents_he + "\n" +
                            "שמות הורי הכלה"  + " " + ":" + " " + bridesParents_he + "\n" +
                            "שם אולם האירועים" + " " + ":" + " " + eventHall_he);
                    intent_he.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTimeOfEvent_he.getTime().getTime());
                    intent_he.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTimeOfEvent_he.getTime().getTime());

                    if (intent_he.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent_he);
                    }
                }
            }
        });
    }

    private void setTimer()
    {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Countdown Started");
        intent.putExtra(AlarmClock.EXTRA_LENGTH, 86400);
        intent.putExtra(AlarmClock.EXTRA_SKIP_UI, false);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void setTimerHe()
    {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "הספירה לאחור החלה");
        intent.putExtra(AlarmClock.EXTRA_LENGTH, 86400);
        intent.putExtra(AlarmClock.EXTRA_SKIP_UI, false);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == SET_TIMER_PERMISSION_REQUEST) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            setTimer();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Sorry , can't work without set alarm permission ", Toast.LENGTH_LONG).show();

            }
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
        Intent intent = new Intent(FourthActivity.this, ThirdActivity.class);
        startActivity(intent);
        finish();
    }*/
}



