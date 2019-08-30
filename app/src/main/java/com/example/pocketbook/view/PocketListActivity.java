package com.example.pocketbook.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pocketbook.R;
import com.example.pocketbook.fragment.TopExpendFragment;
import com.example.pocketbook.fragment.TopIncomeFragment;

public class PocketListActivity extends AppCompatActivity {

    private TopExpendFragment mTopExpendFragment;
    private TopIncomeFragment mTopIncomeFragment;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocket_list);
        initFragment();
    }

    private void initFragment() {
        mTopExpendFragment = new TopExpendFragment();
        mTopIncomeFragment = new TopIncomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.pocket_columns_fragments,mTopExpendFragment)
                .show(mTopExpendFragment).commit();
        mTabLayout = (TabLayout) findViewById(R.id.pocket_columns);
        mTabLayout.addOnTabSelectedListener(mSlideFragment);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private TabLayout.OnTabSelectedListener mSlideFragment = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    }


}
