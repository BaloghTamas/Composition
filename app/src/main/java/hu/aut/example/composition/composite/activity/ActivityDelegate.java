package hu.aut.example.composition.composite.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class ActivityDelegate {

    protected AppCompatActivity activity;


    public ActivityDelegate(AppCompatActivity activity) {
        this.activity = activity;
    }

    public void onBeforeCreate(@Nullable Bundle savedInstanceState) {
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
    }

    public void onPostCreate(@Nullable Bundle savedInstanceState) {
    }

    public void onStart() {
    }

    public void onRestart() {
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
    }

    public void onPause() {
    }


    public void onConfigurationChanged(Configuration newConfig) {
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    }

    public void onResume() {
    }

    public void onPostResume() {
    }

    public void onStop() {
    }

    public void onDestroy() {
    }

}