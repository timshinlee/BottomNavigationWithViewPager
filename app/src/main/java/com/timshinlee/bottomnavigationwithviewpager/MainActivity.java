package com.timshinlee.bottomnavigationwithviewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private static final int[] mMenuIds = new int[]{
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager pager = findViewById(R.id.pager);
        final BottomNavigationView navigation = findViewById(R.id.navigation);

        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                navigation.setSelectedItemId(mMenuIds[position]);
            }
        });

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        pager.setCurrentItem(0,true);
                        return true;
                    case R.id.navigation_dashboard:
                        pager.setCurrentItem(1,true);
                        return true;
                    case R.id.navigation_notifications:
                        pager.setCurrentItem(2,true);
                        return true;
                }
                return false;
            }
        });
    }

    private static class MyPagerAdapter extends FragmentPagerAdapter {

        MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return SampleFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
