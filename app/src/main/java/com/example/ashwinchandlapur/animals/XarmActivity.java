package com.example.ashwinchandlapur.animals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class XarmActivity extends ActionBarActivity {

    // For this example, only two pages
    static final int NUM_ITEMS = 3;

    ViewPager mPager;
    SlidePagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //  this.supportrequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.xarm_activity);

		/* Instantiate a ViewPager and a PagerAdapter. */
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new SlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(XarmActivity.this,ScrollingActivity.class);
        startActivity(intent);
    }
    /* PagerAdapter class */
    public class SlidePagerAdapter extends FragmentPagerAdapter {
        public SlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
			/*
			 * IMPORTANT: This is the point. We create a RootFragment acting as
			 * a container for other fragments
			 */
            if (position == 0)
                return new XarmrootFragment();
            else if(position==1)
                return new StaticFragment();
            else
                return new StaticFragments();
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }
    }
    public void home(View v)
    {
        Intent intent=new Intent(XarmActivity.this,ScrollingActivity.class);
        startActivity(intent);
    }
}
