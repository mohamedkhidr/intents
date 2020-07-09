package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import com.google.android.gms.actions.NoteIntents;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void alarmClock(View view){
        // need set alarm permission
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Hey ! wake up")
                .putExtra(AlarmClock.EXTRA_HOUR, 13)
                .putExtra(AlarmClock.EXTRA_MINUTES, 30);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void timer(View view){
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "timer")
                .putExtra(AlarmClock.EXTRA_LENGTH, 130)
                    .putExtra(AlarmClock.EXTRA_SKIP_UI, true); // show the timer ui or not
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void allAlarms(View view){
        Intent intent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void addCalenderEvent(View view){
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, "event")
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "egypt")
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, 343345344)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, 543434344);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    // TODO need content provider
    public void shareContent(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "fedfdfd");
        Intent chooser = Intent.createChooser(intent, "chooser title");
        if (chooser.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }
    public void composeEmail(View view){
        // From Android developer DOCS
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"example@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "something");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void email(View view){
        // will be handled by an email app
        String[] TO = {"example@gmail.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"dfdfdfd"});
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
        Intent chooser = Intent.createChooser(emailIntent, "title");
        if (chooser.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }

    public void locationOnMap(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:30.7326539,30.7234604?z=10"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void createANote(View view){
        Intent intent = new Intent(NoteIntents.ACTION_CREATE_NOTE)
                .putExtra(NoteIntents.EXTRA_NAME, "subject")
                .putExtra(NoteIntents.EXTRA_TEXT, "text");
        if (intent.resolveActivity(getPackageManager()) != null) {
            Log.v(TAG, "create not intent not handled");
            startActivity(intent);
        }
    }
    public void InitiateAPhoneCall(View view){
        // TODO need run time permission
    }

    public void perFormAWebSearch(View view) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, "nagrig");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void openASectionInSettings(View view){
        Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void textMessage(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:3454545"));  // This ensures only SMS apps respond
        intent.putExtra("sms_body", "message");
        //intent.putExtra(Intent.EXTRA_STREAM, attachment);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void loadAWebURL(View view){
        Uri webpage = Uri.parse("https://www.google.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void captureAnImage(View view){
    }
    public void cameraStillImageMode(View view){

    }
    public void cameraStillVideoMode(View view){

    }
    public void selectAContact(View view){

    }
    public void selectSpecificContact(View view){

    }
    public void viewAContact(View view){

    }
    public void EditExistingContact(View view){

    }
    public void InsertAContact(View view){

    }
    public void retrieveSpecificTypeOfFile(View view){

    }
    public void openSpecificTypeOfFile(View view){

    }
    public void callACar(View view){

    }
    public void playAMediaFile(View view){

    }
    public void playMusicBasedOnSearchQuery(View view){

    }
    public void searchUsingSpecificApp(View view){

    }
}
