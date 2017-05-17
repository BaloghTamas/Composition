package hu.aut.example.composition;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import hu.aut.example.composition.composite.activity.CompositeActivity;
import hu.aut.example.composition.social.SocialDelegate;
import hu.aut.example.composition.social.ThemeDelegate;
import hu.aut.example.composition.ui.all.AllFragment;
import hu.aut.example.composition.ui.receive.ReceiveFragment;
import hu.aut.example.composition.ui.send.SendFragment;

public class MainActivity extends CompositeActivity {

    @Override
    protected void initActivityDelegates() {
        addActivityDelegate(new SocialDelegate(this));
        addActivityDelegate(new ThemeDelegate(this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);


        final AllFragment allFragment = AllFragment.newInstance();
        final SendFragment sendFragment = SendFragment.newInstance();
        final ReceiveFragment receiveFragment = ReceiveFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, allFragment).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_all:
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, allFragment).commit();
                                break;
                            case R.id.action_send:
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, sendFragment).commit();
                                break;
                            case R.id.action_receive:
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, receiveFragment).commit();
                                break;
                        }
                        return true;
                    }
                });
    }
}
