package hit.gever.myweddinginvitation;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences_name_of_event_hall;
    SharedPreferences sharedPreferences_location;
    SharedPreferences sharedPreferences_date;
    SharedPreferences sharedPreferences_grooms_parents;
    SharedPreferences sharedPreferences_brides_parents;

    SharedPreferences sharedPreferences_name_of_event_hall_he;
    SharedPreferences sharedPreferences_location_he;
    SharedPreferences sharedPreferences_date_he;
    SharedPreferences sharedPreferences_grooms_parents_he;
    SharedPreferences sharedPreferences_brides_parents_he;

    int minSelected;
    int hourSelected;
    int daySelected;
    int monthSelected;
    int yearSelected;

    int minSelected_he;
    int hourSelected_he;
    int daySelected_he;
    int monthSelected_he;
    int yearSelected_he;

    Button next2;

    DatePickerDialog picker;
    EditText editText_date;

    DatePickerDialog picker_he;
    EditText editText_date_he;

    Calendar calendar;
    int day;
    int month;
    int year;

    Calendar calendar_he;
    int day_he;
    int month_he;
    int year_he;

    TimePickerDialog picker2;
    EditText editText_time;

    TimePickerDialog picker2_he;
    EditText editText_time_he;

    int currentHour;
    int currentMinute;

    int currentHour_he;
    int currentMinute_he;

    String amPm;
    String amPm_he;


    EditText editTextGroomsParents;
    EditText editTextBridesParents;
    EditText editTextNameOfEventHall;
    EditText editTextAddress;

    EditText editTextGroomsParents_he;
    EditText editTextBridesParents_he;
    EditText editTextNameOfEventHall_he;
    EditText editTextAddress_he;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        if (Locale.getDefault().getLanguage().equals("en")) {
            editTextGroomsParents = findViewById(R.id.enter_names_of_grooms_parents);
            //editTextGroomsParents.addTextChangedListener(watcher);

            editTextBridesParents = findViewById(R.id.enter_names_of_brides_parents);
           // editTextBridesParents.addTextChangedListener(watcher);

            editTextNameOfEventHall = findViewById(R.id.enter_the_name_of_event_hall);
           // editTextNameOfEventHall.addTextChangedListener(watcher);

            editTextAddress = findViewById(R.id.enter_address);
           // editTextAddress.addTextChangedListener(watcher);
        } else {

            editTextGroomsParents_he = findViewById(R.id.enter_names_of_grooms_parents);
           // editTextGroomsParents_he.addTextChangedListener(watcher_he);

            editTextBridesParents_he = findViewById(R.id.enter_names_of_brides_parents);
           // editTextBridesParents_he.addTextChangedListener(watcher_he);

            editTextNameOfEventHall_he = findViewById(R.id.enter_the_name_of_event_hall);
            //editTextNameOfEventHall_he.addTextChangedListener(watcher_he);

            editTextAddress_he = findViewById(R.id.enter_address);
           // editTextAddress_he.addTextChangedListener(watcher_he);
        }


        if (Locale.getDefault().getLanguage().equals("en")) {
            calendar = Calendar.getInstance();
            day = calendar.get(Calendar.DAY_OF_MONTH);
            month = calendar.get(Calendar.MONTH);
            year = calendar.get(Calendar.YEAR);
        } else {
            calendar_he = Calendar.getInstance();
            day_he = calendar_he.get(Calendar.DAY_OF_MONTH);
            month_he = calendar_he.get(Calendar.MONTH);
            year_he = calendar_he.get(Calendar.YEAR);
        }

        next2 = findViewById(R.id.button_next_screen2);
        next2.setClickable(true);

        next2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (Locale.getDefault().getLanguage().equals("en")) {


                    if (editTextGroomsParents.getText().toString().equals("") || editTextBridesParents.getText().toString().equals("") ||
                            editTextNameOfEventHall.getText().toString().equals("") || editTextAddress.getText().toString().equals("") ||
                            editText_date.getText().toString().equals("") || editText_time.getText().toString().equals(""))
                    {
                        Toast.makeText(getApplicationContext(), "Incomplete details . Fill all the fields and try again ", Toast.LENGTH_LONG).show();
                        return;
                    }

                    else {

                        //  Toast.makeText(getApplicationContext(), "You must take at least a picture or a video to continue", Toast.LENGTH_LONG).show();

                        String eventHall = editTextNameOfEventHall.getText().toString();
                        String waitForYou = "We are waiting for you at event hall";

                        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);

                        intent.putExtra("event hall", eventHall);
                        intent.putExtra("wait for you", waitForYou);

                        intent.putExtra("Day", daySelected);
                        intent.putExtra("Month", monthSelected);
                        intent.putExtra("Year", yearSelected);
                        intent.putExtra("Hour", hourSelected);
                        intent.putExtra("Minute", minSelected);
                        // intent.putExtra("Day_Night",amPm);
                        startActivity(intent);
                    }
                } else {

                    if (editTextGroomsParents_he.getText().toString().equals("") || editTextBridesParents_he.getText().toString().equals("") ||
                            editTextNameOfEventHall_he.getText().toString().equals("") || editTextAddress_he.getText().toString().equals("") ||
                            editText_date_he.getText().toString().equals("") || editText_time_he.getText().toString().equals(""))
                    {
                        Toast.makeText(getApplicationContext(), "פרטים חסרים . מלא את כל השדות ונסה שנית", Toast.LENGTH_LONG).show();
                        return;
                    }

                    else {
                    //    Toast.makeText(getApplicationContext(), "עליך לצלם לפחות תמונה או סרטון על מנת להמשיך", Toast.LENGTH_LONG).show();

                        String eventHall_he = editTextNameOfEventHall_he.getText().toString();
                        String waitForYou_he = "אנחנו מחכים לכם באולם";

                        Intent intent_he = new Intent(SecondActivity.this, ThirdActivity.class);

                        intent_he.putExtra("אולם אירועים", eventHall_he);
                        intent_he.putExtra("מחכים לכם", waitForYou_he);

                        intent_he.putExtra("Day", daySelected_he);
                        intent_he.putExtra("Month", monthSelected_he);
                        intent_he.putExtra("Year", yearSelected_he);
                        intent_he.putExtra("Hour", hourSelected_he);
                        intent_he.putExtra("Minute", minSelected_he);
                        // intent.putExtra("Day_Night",amPm);
                        startActivity(intent_he);
                    }
                }

                if (Locale.getDefault().getLanguage().equals("en")) {
                    sharedPreferences_name_of_event_hall = getSharedPreferences("SaveNameOfEventHall", MODE_PRIVATE);
                    SharedPreferences.Editor editor_name_of_event_hall = sharedPreferences_name_of_event_hall.edit();
                    editor_name_of_event_hall.putString("EventHall", editTextNameOfEventHall.getText().toString());
                    editor_name_of_event_hall.apply();

                    sharedPreferences_location = getSharedPreferences("SaveLocation", MODE_PRIVATE);
                    SharedPreferences.Editor editor_location = sharedPreferences_location.edit();
                    editor_location.putString("Location", editTextAddress.getText().toString());
                    editor_location.apply();


                    sharedPreferences_date = getSharedPreferences("SaveDate", MODE_PRIVATE);
                    SharedPreferences.Editor editor_date = sharedPreferences_date.edit();
                    editor_date.putString("Date", editText_date.getText().toString());
                    editor_date.apply();

                    sharedPreferences_grooms_parents = getSharedPreferences("GroomsParents", MODE_PRIVATE);
                    SharedPreferences.Editor editor_grooms_parents = sharedPreferences_grooms_parents.edit();
                    editor_grooms_parents.putString("GParents", editTextGroomsParents.getText().toString());
                    editor_grooms_parents.apply();

                    sharedPreferences_brides_parents = getSharedPreferences("BridesParents", MODE_PRIVATE);
                    SharedPreferences.Editor editor_brides_parents = sharedPreferences_brides_parents.edit();
                    editor_brides_parents.putString("BParents", editTextBridesParents.getText().toString());
                    editor_brides_parents.apply();

                } else {
                    sharedPreferences_name_of_event_hall_he = getSharedPreferences("שמור שם אולם אירועים", MODE_PRIVATE);
                    SharedPreferences.Editor editor_name_of_event_hall_he = sharedPreferences_name_of_event_hall_he.edit();
                    editor_name_of_event_hall_he.putString("אולם אירועים", editTextNameOfEventHall_he.getText().toString());
                    editor_name_of_event_hall_he.apply();

                    sharedPreferences_location_he = getSharedPreferences("שמור מיקום", MODE_PRIVATE);
                    SharedPreferences.Editor editor_location_he = sharedPreferences_location_he.edit();
                    editor_location_he.putString("מיקום", editTextAddress_he.getText().toString());
                    editor_location_he.apply();

                    sharedPreferences_date_he = getSharedPreferences("שמור תאריך", MODE_PRIVATE);
                    SharedPreferences.Editor editor_date_he = sharedPreferences_date_he.edit();
                    editor_date_he.putString("תאריך", editText_date_he.getText().toString());
                    editor_date_he.apply();

                    sharedPreferences_grooms_parents_he = getSharedPreferences("הורי החתן", MODE_PRIVATE);
                    SharedPreferences.Editor editor_grooms_parents_he = sharedPreferences_grooms_parents_he.edit();
                    editor_grooms_parents_he.putString("הוריחתן", editTextGroomsParents_he.getText().toString());
                    editor_grooms_parents_he.apply();

                    sharedPreferences_brides_parents_he = getSharedPreferences("הורי הכלה", MODE_PRIVATE);
                    SharedPreferences.Editor editor_brides_parents_he = sharedPreferences_brides_parents_he.edit();
                    editor_brides_parents_he.putString("הוריכלה", editTextBridesParents_he.getText().toString());
                    editor_brides_parents_he.apply();
                }
                //sharedPreferences_time = getSharedPreferences("SaveBeginTime",MODE_PRIVATE);
                //SharedPreferences.Editor editor_begin_time = sharedPreferences_time.edit();
                //editor_begin_time.putString("BeginTime",editText_time.getText().toString());
                //editor_begin_time.apply();


            }
        });

        if (Locale.getDefault().getLanguage().equals("en")) {
            String welcome = getIntent().getStringExtra("user_welcome");
            TextView textView2 = findViewById(R.id.welcome);
            textView2.setText(welcome);

            String names = getIntent().getStringExtra("user_names");
            TextView textView = findViewById(R.id.names);
            textView.setText(names);
        } else {
            String welcome_he = getIntent().getStringExtra("ברוך הבא");
            TextView textView2 = findViewById(R.id.welcome);
            textView2.setText(welcome_he);

            String names_he = getIntent().getStringExtra("שמות");
            TextView textView = findViewById(R.id.names);
            textView.setText(names_he);
        }


        if (Locale.getDefault().getLanguage().equals("en")) {
            editText_date = findViewById(R.id.enter_date);
            editText_date.setFocusable(false);
           // editText_date.addTextChangedListener(watcher);
            editText_date.setInputType(InputType.TYPE_NULL);

            editText_date.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // date picker dialog
                    picker = new DatePickerDialog(SecondActivity.this, R.style.DatePickerTheme,
                            new DatePickerDialog.OnDateSetListener() {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                    editText_date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                    daySelected = dayOfMonth;
                                    monthSelected = monthOfYear;
                                    yearSelected = year;
                                }
                            }, year, month, day);

                    picker.getDatePicker().setMinDate(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
                    //picker.getDatePicker().setMinDate(System.currentTimeMillis());
                    picker.show();
                }

            });
        } else {
            editText_date_he = findViewById(R.id.enter_date);
            editText_date_he.setFocusable(false);
           // editText_date_he.addTextChangedListener(watcher_he);
            editText_date_he.setInputType(InputType.TYPE_NULL);

            editText_date_he.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // date picker dialog
                    picker_he = new DatePickerDialog(SecondActivity.this, R.style.DatePickerTheme,
                            new DatePickerDialog.OnDateSetListener() {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                    editText_date_he.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                    daySelected_he = dayOfMonth;
                                    monthSelected_he = monthOfYear;
                                    yearSelected_he = year;
                                }
                            }, year_he, month_he, day_he);

                    picker_he.getDatePicker().setMinDate(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
                  //  picker_he.getDatePicker().setMinDate(System.currentTimeMillis());
                    picker_he.show();
                }

            });
        }

        if (Locale.getDefault().getLanguage().equals("en")) {

            editText_time = findViewById(R.id.enter_time);
            editText_time.setFocusable(false);
          //  editText_time.addTextChangedListener(watcher);
            editText_time.setInputType(InputType.TYPE_NULL);

            editText_time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    calendar = Calendar.getInstance();
                    currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                    currentMinute = calendar.get(Calendar.MINUTE);


                    picker2 = new TimePickerDialog(SecondActivity.this, R.style.TimePickerTheme,
                            new TimePickerDialog.OnTimeSetListener() {
                                @SuppressLint({"DefaultLocale", "SetTextI18n"})
                                @Override
                                public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                                    minSelected = minute;
                                    hourSelected = hourOfDay;

                                    if (hourOfDay >= 12) {
                                        amPm = "PM";
                                    } else {
                                        amPm = "AM";
                                    }

                                    editText_time.setText(String.format("%02d:%02d" + " ", hourOfDay, minute) + amPm);
                                }
                            }, currentHour, currentMinute, false);

                    picker2.show();
                }
            });
        } else {
            editText_time_he = findViewById(R.id.enter_time);
            editText_time_he.setFocusable(false);
          //  editText_time_he.addTextChangedListener(watcher_he);
            editText_time_he.setInputType(InputType.TYPE_NULL);
           // editText_time_he.setKeyListener(DigitsKeyListener.getInstance("0123456789/"));

            editText_time_he.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    calendar_he = Calendar.getInstance();
                    currentHour_he = calendar_he.get(Calendar.HOUR_OF_DAY);
                    currentMinute_he = calendar_he.get(Calendar.MINUTE);


                    picker2_he = new TimePickerDialog(SecondActivity.this, R.style.TimePickerTheme,
                            new TimePickerDialog.OnTimeSetListener() {
                                @SuppressLint({"DefaultLocale", "SetTextI18n"})
                                @Override
                                public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                                    minSelected_he = minute;
                                    hourSelected_he = hourOfDay;

                                    if (hourOfDay >= 12) {
                                        amPm_he = "PM";
                                    } else {
                                        amPm_he = "AM";
                                    }

                                    editText_time_he.setText(String.format("%02d:%02d" + " ", hourOfDay, minute) + amPm_he);
                                }
                            }, currentHour_he, currentMinute_he, false);

                    picker2_he.show();
                }
            });
        }
    }



//    private final TextWatcher watcher = new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//        }
//
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before, int count) {
//            if (editTextGroomsParents.getText().toString().length() == 0 || editTextBridesParents.getText().toString().length() == 0 ||
//                    editTextNameOfEventHall.getText().toString().length() == 0 || editTextAddress.getText().toString().length() == 0 ||
//                    editText_date.getText().toString().length() == 0 || editText_time.getText().toString().length() == 0) {
//                next2.setEnabled(false);
//            } else {
//                next2.setEnabled(true);
//            }
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//        }
//    };

//    private final TextWatcher watcher_he = new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//        }
//
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before, int count) {
//            if (editTextGroomsParents_he.getText().toString().length() == 0 || editTextBridesParents_he.getText().toString().length() == 0 ||
//                    editTextNameOfEventHall_he.getText().toString().length() == 0 || editTextAddress_he.getText().toString().length() == 0 ||
//                    editText_date_he.getText().toString().length() == 0 || editText_time_he.getText().toString().length() == 0) {
//                next2.setEnabled(false);
//            } else {
//                next2.setEnabled(true);
//            }
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//        }
//    };

/*    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }*/

}



