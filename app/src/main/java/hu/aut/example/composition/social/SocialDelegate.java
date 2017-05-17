package hu.aut.example.composition.social;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import hu.aut.example.composition.composite.activity.ActivityDelegate;

public class SocialDelegate extends ActivityDelegate {


    public SocialDelegate(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("SocialDelegate", "Social magic is done here.");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("SocialDelegate", "Social magic is done here.");
    }
}
