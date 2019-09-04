package com.example.pocketbook.view;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import com.example.pocketbook.R;
import com.example.pocketbook.fragment.AccountListFragment;
import com.example.pocketbook.fragment.TopExpendFragment;
import com.example.pocketbook.fragment.TopIncomeFragment;

import java.util.ArrayList;
import java.util.List;


public class PocketListActivity extends AppCompatActivity {

    private AccountListFragment mAccountListFragment;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mList;
    private PocketListAdapter mAdapter;
    private String[] mTitles = {"支出", "收入"};

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocket_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backup:
                Intent backup = new Intent(PocketListActivity.this, MainPage.class);
                startActivity(backup);
                break;
                default:
        }
        return true;
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
        Intent backPress = new Intent(PocketListActivity.this,MainPage.class);
        startActivity(backPress);
    }
}
