package com.dgaps.android.fuelcalculator1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.text.DecimalFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioFule, radioDistance;
    RadioButton radioButton, radioButton1;
    Spinner spinner, spinner1;
    List<String> list;
    List<String> list2;
    TextView textView, textView1, textView2, textView3, fuel_used, fuel_required, fuel_cost;
    EditText editText1, editTex2, editText3;
    String fuel, distance, fuelPrice;

    double result;

    String Rupees = " -Total price";
    String liter = " -Total liters";
    String gallon = "-Total gallons";

    String color = "#7B1FA2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(color));
        }

        fuel_used = (TextView)findViewById(R.id.fuel_used);
        fuel_required = (TextView)findViewById(R.id.fuel_used_gallon);
        fuel_cost = (TextView)findViewById(R.id.cast);
        editText1 = (EditText) findViewById(R.id.edit2);
        editTex2 = (EditText) findViewById(R.id.price_value);
        editText3 = (EditText) findViewById(R.id.distance_value);
        textView1 = (TextView) findViewById(R.id.used_value);
        textView2 = (TextView) findViewById(R.id.cost_value);
        textView3 = (TextView)findViewById(R.id.fule_gallon_value);


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(editText1.getText().toString().length()>2){

                    radioFule.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });







         textView1.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);








//        spinner = (Spinner) findViewById(R.id.spinner1);
//        spinner1 = (Spinner) findViewById(R.id.spinner2);

        radioFule = (RadioGroup) findViewById(R.id.radio_fule);
        radioDistance = (RadioGroup)findViewById(R.id.radio_distance);

        radioFule.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


            @Override

            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // find which radio button is selected

                if (checkedId == R.id.fule_km) {

                    editText1.setHint("km/liter");
                    editText1.setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

                } else

                {

                    editText1.setHint("miles/gallon");
                    editText1.setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                }


            }
        });

        radioDistance.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


            @Override

            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // find which radio button is selected

                if (checkedId == R.id.distance_km) {

                    editText3.setHint("Distance in km");
                    editTex2.setHint("Enter price");
                    editText3.setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

                } else

                {

                    editText3.setHint("Distance in Miles");
                    editTex2.setHint("Enter price");
                    editText1.setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                }


            }
        });







//        list = new ArrayList<String>();
//        list.add("km");
//        list.add("miles");
//
//        list2 = new ArrayList<>();
//        list2.add("km");
//        list2.add("miles");
//
//
//        editTex2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
//
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list);
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//
//        spinner.setAdapter(arrayAdapter);
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> arg0, View arg1,
//                                       int arg2, long arg3) {
//
//
//                switch (arg2) {
//
//
//                    case 0:
//                        editText1.setHint("Enter Liter");
//                        editText1.setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
//
//
//                        break;
//                    case 1:
//                        editText1.setHint("Enter Miles");
//
//                        editText1.setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
//
//
//                }
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list2);
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//
//        spinner1.setAdapter(adapter);
//
//        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> arg0, View arg1,
//                                       int arg2, long arg3) {
//
//
//                switch (arg2) {
//
//
//                    case 0:
//
//                        editTex2.setHint("Enter liter price");
//                        editText3.setHint("Enter distance in km");
//                        editText1.setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
//
//
//                        break;
//                    case 1:
//
//                        editTex2.setHint("Enter liter price");
//                        editText3.setHint("Enter distance in miles");
//                        editText1.setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
//
//
//                }
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        switch (item.getItemId()){

            case R.id.about:
               aboutUs();
                return true;


            case R.id.help:
                help();
                return true;

            case R.id.app:
              ourApp();
                return true;



        //noinspection SimplifiableIfStatement
        default:
        return super.onOptionsItemSelected(item);
    }

    }

    public void calculateResult(View view) {
        if (editText1.getText().length() == 0){
            editText1.requestFocus();
            Toast.makeText(MainActivity.this, "Please enter Fuel Consumption !", Toast.LENGTH_LONG).show();
        }
        else  if (editTex2.getText().length() == 0){
            editTex2.requestFocus();

            Toast.makeText(MainActivity.this, "Please enter Fuel Price !", Toast.LENGTH_LONG).show();

        } else if (editText3.getText().length() == 0) {

            editText3.requestFocus();

            Toast.makeText(MainActivity.this, "Please enter Travel Distance !", Toast.LENGTH_LONG).show();

        } else {
            radioButton = (RadioButton) findViewById(radioFule.getCheckedRadioButtonId());
            radioButton1 = (RadioButton) findViewById(radioDistance.getCheckedRadioButtonId());
              if (radioButton.getText().toString().equals("Km/liter") && (radioButton1.getText().toString().equals("Km"))) {

                fuel = editText1.getText().toString();
                distance = editText3.getText().toString();
                fuelPrice = editTex2.getText().toString();


                double fuel1 = Double.parseDouble(fuel);
                double distance2 = Double.parseDouble(distance);
                double fulePrice1 = Double.parseDouble(fuelPrice);



                result = distance2 / fuel1;

                  DecimalFormat df = new DecimalFormat("#.#####");
                  String formatted = df.format(result);

                textView1.setText(formatted + " " +liter);



                  double mgp1 = result*.2642;

                  String fromit = df.format(mgp1);

                  textView3.setText(fromit+" " +gallon);

                double finalResult = result * fulePrice1;

                  String new1 = df.format(finalResult);

                textView2.setText(new1 + ""+Rupees);



            } else if  (radioButton.getText().toString().equals("Miles/gallon") &&(radioButton1.getText().toString().equals("Miles")))
               {


                fuel = editText1.getText().toString();
                distance = editText3.getText().toString();
                fuelPrice = editTex2.getText().toString();


                double fuel1 = Double.parseDouble(fuel);
                double distance2 = Double.parseDouble(distance);
                double fulePrice1 = Double.parseDouble(fuelPrice);

                   double prince1 = distance2/0.621372;
                   double prince2 = fuel1*.425143;

                result = prince1 /prince2;


                   double val1 = result*.2642;

                   DecimalFormat df1 = new DecimalFormat("#.#####");

                   String jam = df1.format(result);


                textView1.setText(jam + " " +liter);




                   String pakistan = df1.format(val1);

                   textView3.setText(pakistan +" " +gallon);

                double finalResult = result * fulePrice1;

                   String pakistan1 = df1.format(finalResult);
                textView2.setText(pakistan1 + ""+Rupees);


            } else if  (radioButton.getText().toString().equals("Km/liter") && (radioButton1.getText().toString().equals("Miles"))) {

                fuel = editText1.getText().toString();
                distance = editText3.getText().toString();
                fuelPrice = editTex2.getText().toString();

                double fuel1 = Double.parseDouble(fuel);
                double distance2 = Double.parseDouble(distance);
                double fulePrice1 = Double.parseDouble(fuelPrice);

                  DecimalFormat df2 = new DecimalFormat("#.#####");


//                double value2 = distance2/2.352;


                  double name = distance2/0.6213727367;

                result = name / fuel1;

                  String helo = df2.format(result);


                textView1.setText(helo + " " +liter);

                  double mgp3 = result*.2642;

                  String helo1 = df2.format(mgp3);

                  textView3.setText(helo1 +" " +gallon);

                double finalResult = result * fulePrice1;

                  String helo3 = df2.format(finalResult);

                textView2.setText(helo3 + ""+Rupees);

//                  Toast.makeText(MainActivity.this,"Km--Miles",Toast.LENGTH_LONG).show();


            } else if  (radioButton.getText().toString().equals("Miles/gallon") &&(radioButton1.getText().toString().equals("Km"))) {

                fuel = editText1.getText().toString();
                distance = editText3.getText().toString();
                fuelPrice = editTex2.getText().toString();

                double fuel1 = Double.parseDouble(fuel);
                double distance2 = Double.parseDouble(distance);
                double fulePrice1 = Double.parseDouble(fuelPrice);


                  DecimalFormat df3 = new DecimalFormat("#.#####");

//                double value3 = fuel1/ 2.352;

                  double num = fuel1*.42514;
                result = distance2 / num;

                  String helo4 = df3.format(result);

                textView1.setText(helo4 + " " +liter);


                 double mgp4 = result*.2642;

                  String helo5 = df3.format(mgp4);
                  textView3.setText(helo5 +" " +gallon);

                double finalResult = result * fulePrice1;

                  String helo6 = df3.format(finalResult);

                textView2.setText(helo6 + ""+Rupees);

//                  Toast.makeText(MainActivity.this,"Miles--km",Toast.LENGTH_LONG).show();

              }


        }



        textView1.setVisibility(View.VISIBLE);
        textView3.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.VISIBLE);
        radioFule.setVisibility(View.VISIBLE);
        radioDistance.setVisibility(View.VISIBLE);


    }

    public void hideStatusBar() {
        // Hide status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    public void Reset(View view) {

        editText1.setText("");
        editTex2.setText("");
        editText3.setText("");
        textView1.setText("");
        textView2.setText("");
        textView3.setText("");


        textView1.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);




    }

    public void help(){


        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Help");
        alertDialog.setMessage("Actually this application is used to calculate the fuel in kilometer per liter and also calculate the fuel in gallon and also calculate the total cost of fuel  ");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();



    }


    public void aboutUs(){


        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("http://www.dgaps.com/");
        alertDialog.setIcon(R.drawable.logo);
        alertDialog.setMessage(" Digital Application’s Plans and Price has no hidden charges,\n" +
                "we have all-inclusive prices and unbeatable value. Other Companies promise to provide cheap solutions,\n" +
                "but they charge extra as setup fees or higher renewal rates, or some hidden charges.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();






    }


    public void ourApp(){


        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Our App");
        alertDialog.setMessage("Write About App");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();


    }


}
