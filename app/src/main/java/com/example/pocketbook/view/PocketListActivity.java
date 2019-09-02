package com.example.pocketbook.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.example.pocketbook.R;
import com.example.pocketbook.fragment.AccountListFragment;
import com.example.pocketbook.fragment.TopExpendFragment;
import com.example.pocketbook.fragment.TopIncomeFragment;

import java.util.ArrayList;
import java.util.List;


public class PocketListActivity extends FragmentActivity {

    private AccountListFragment mAccountListFragment;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mList;
    private PocketListAdapter mAdapter;
    private String[] mTitles = {"支出", "收入"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocket_list);
        //实例化
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.pocket_columns);
        //页面，数据源
        mList = new ArrayList<>();
        mList.add(new TopExpendFragment());
        mList.add(new TopIncomeFragment());
        //ViewPager的适配器
        mAdapter = new PocketListAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        //绑定
        mTabLayout.setupWithViewPager(mViewPager);
    }


    class PocketListAdapter extends FragmentPagerAdapter {

        public PocketListAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return mList.get(i);
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        /**
         * 重写方法，设置标题
         */
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
