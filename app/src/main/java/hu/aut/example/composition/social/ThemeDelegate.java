package hu.aut.example.composition.social;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import hu.aut.example.composition.R;
import hu.aut.example.composition.composite.activity.ActivityDelegate;

public class ThemeDelegate extends ActivityDelegate {

    public ThemeDelegate(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void onBeforeCreate(@Nullable Bundle savedInstanceState) {
        Log.d("Theme", "Setting theme before onCreate");
        activity.setTheme(R.style.BlueTheme);
    }

}
