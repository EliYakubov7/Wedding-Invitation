package hit.gever.myweddinginvitation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences_names;

    Button next;
    EditText editText_names;
    EditText editText_names_he;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

       // if (Locale.getDefault().getLanguage().equals("en")) {
       //     Toast.makeText(getApplicationContext(), "You must fill the name field to continue", Toast.LENGTH_LONG).show();
       // }
       // else
       // {
       //     Toast.makeText(getApplicationContext(), "עליך למלא את שדה השם על מנת להמשיך", Toast.LENGTH_LONG).show();
       // }

        editText_names = findViewById(R.id.enter_names);

        editText_names_he = findViewById(R.id.enter_names);

        next = findViewById(R.id.button_next_screen);
        next.setClickable(true);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (Locale.getDefault().getLanguage().equals("en")) {


                    if (editText_names_he.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Enter the names and try again", Toast.LENGTH_LONG).show();
                    }
                    else {

                        String names = editText_names.getText().toString();
                        String welcome = "Welcome to the wedding of";
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra("user_welcome", welcome);
                        intent.putExtra("user_names", names);
                        startActivity(intent);

                        sharedPreferences_names = getSharedPreferences("SaveNames", MODE_PRIVATE);
                        SharedPreferences.Editor editor_names = sharedPreferences_names.edit();
                        editor_names.putString("Names", editText_names.getText().toString());
                        editor_names.apply();
                    }
                }

                else

                {
                    if (editText_names_he.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "הכנס את השמות , ונסה שנית", Toast.LENGTH_LONG).show();
                    }
                    else {
                        String names_he = editText_names_he.getText().toString();
                        String welcome_he = "ברוכים הבאים לחתונה של";
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra("ברוך הבא", welcome_he);
                        intent.putExtra("שמות", names_he);
                       // intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);

                        sharedPreferences_names = getSharedPreferences("שמור שמות", MODE_PRIVATE);
                        SharedPreferences.Editor editor_names = sharedPreferences_names.edit();
                        editor_names.putString("שמות", editText_names_he.getText().toString());
                        editor_names.apply();
                    }
                }
            }
        });


/*        editText_names.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!editText_names.getText().toString().equals("")) {
                    next.setClickable(true);
                }
                else if(editText_names.getText().toString().equals("")) {
                    next.setClickable(true);
                }
            }

            public void afterTextChanged(Editable s) {
            }
        });
        editText_names_he.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!editText_names_he.getText().toString().equals("")) {
                    next.setClickable(true);
                }
                else if(editText_names_he.getText().toString().equals("")) {
                    next.setClickable(true);
                }
            }

            public void afterTextChanged(Editable s) {
            }
        });*/

    }

}
