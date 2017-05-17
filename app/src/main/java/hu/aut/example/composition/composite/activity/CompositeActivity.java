package hu.aut.example.composition.composite.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositeActivity extends AppCompatActivity {

    List<ActivityDelegate> delegates = new ArrayList<>();

    protected void addActivityDelegate(ActivityDelegate delegate) {
        delegates.add(delegate);
    }

    protected void removeActivityDelegate(ActivityDelegate delegate) {
        delegates.remove(delegate);
    }

    protected abstract void initActivityDelegates();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initActivityDelegates();
        for (ActivityDelegate delegate : delegates) {
            delegate.onBeforeCreate(savedInstanceState);
        }

        super.onCreate(savedInstanceState);
        for (ActivityDelegate delegate : delegates) {
            delegate.onCreate(savedInstanceState);
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        for (ActivityDelegate delegate : delegates) {
            delegate.onPostCreate(savedInstanceState);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        for (ActivityDelegate delegate : delegates) {
            delegate.onStart();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        for (ActivityDelegate delegate : delegates) {
            delegate.onRestart();
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        for (ActivityDelegate delegate : delegates) {
            delegate.onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (ActivityDelegate delegate : delegates) {
            delegate.onResume();
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        for (ActivityDelegate delegate : delegates) {
            delegate.onPostResume();
        }
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        for (ActivityDelegate behaviour : delegates) {
            behaviour.onConfigurationChanged(newConfig);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (ActivityDelegate delegate : delegates) {
            delegate.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (ActivityDelegate delegate : delegates) {
            delegate.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    protected void onPause() {
        for (ActivityDelegate delegate : delegates) {
            delegate.onPause();
        }
        super.onPause();
    }

    @Override
    protected void onStop() {
        for (ActivityDelegate delegate : delegates) {
            delegate.onStop();
        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        for (ActivityDelegate delegate : delegates) {
            delegate.onDestroy();
        }
        super.onDestroy();
    }
}