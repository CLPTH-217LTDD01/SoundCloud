package clpth.soundcloud;

import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;


import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private String fragment = "HOME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bnv = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        disableShiftMode(bnv);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        if (!fragment.equals("HOME")) {
                            MainActivity.this.getSupportActionBar().setTitle("Home");
                            selectedFragment = HomeFragment.newInstance();
                            fragment = "HOME";
                        }
                        break;
                    case R.id.action_stream:
                        if (!fragment.equals("STREAM")) {
                            MainActivity.this.getSupportActionBar().setTitle("Stream");
                            selectedFragment = StreamFragment.newInstance();
                            fragment = "STREAM";
                        }
                        break;
                    case R.id.action_search:
                        if (!fragment.equals("SEARCH")) {
                            MainActivity.this.getSupportActionBar().setTitle("");
                            selectedFragment = SearchFragment.newInstance();
                            fragment = "SEARCH";
                        }
                        break;
                    case R.id.action_favorite:
                        if (!fragment.equals("FAVORITE")) {
                            MainActivity.this.getSupportActionBar().setTitle("Collection");
                            selectedFragment = FavoriteFragment.newInstance();
                            fragment = "FAVORITE";
                        }
                        break;
                    case R.id.action_setting:
                        if (!fragment.equals("SETTING")) {
                            MainActivity.this.getSupportActionBar().setTitle("More");
                            selectedFragment = SettingFragment.newInstance();
                            fragment = "SETTING";
                        }
                        break;
                }
                if (selectedFragment != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, selectedFragment);
                    transaction.commit();
                    return true;
                }
                return false;
            }
        });
        getSupportActionBar().setTitle("Home");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, HomeFragment.newInstance());
        transaction.commit();
    }


    public void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field");
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode");
        }
    }
}
