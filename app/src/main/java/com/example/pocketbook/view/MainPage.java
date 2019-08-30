package com.example.pocketbook.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.example.pocketbook.R;
import com.example.pocketbook.fragment.AccountListFragment;
import com.example.pocketbook.fragment.AddRecordFragment;
import com.example.pocketbook.fragment.UsersSettingsFragment;

public class MainPage extends AppCompatActivity {

    private BottomNavigationView mBnv;
    private AccountListFragment mAccountListFragment;
    private AddRecordFragment mAddRecordFragment;
    private UsersSettingsFragment mUsersSettingsFragment;
    private Fragment[] mFragments;
    private int mLastfragment;//记录最后一个fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        initFragment();
    }

    /**
     * 初始化fragment和fragment数组
     */
    private void initFragment() {
        mAccountListFragment = new AccountListFragment();
        mAddRecordFragment = new AddRecordFragment();
        mUsersSettingsFragment = new UsersSettingsFragment();
        mFragments = new Fragment[]{mAccountListFragment, mAddRecordFragment, mUsersSettingsFragment};
        mLastfragment = 0;
        getSupportFragmentManager().beginTransaction().replace(R.id.mainpage, mAccountListFragment).
                show(mAccountListFragment).commit();
        mBnv = (BottomNavigationView) findViewById(R.id.bnv);
        mBnv.setOnNavigationItemSelectedListener(mChangeFragment);
    }

    /**
     * 判断选择的菜单栏
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mChangeFragment
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.account_list:
                    if (mLastfragment != 0) {
                        switchFragment(mLastfragment, 0);
                        mLastfragment = 0;
                    }
                    return true;
                case R.id.add_records:
                    if (mLastfragment != 1) {
                        Intent intent = new Intent(MainPage.this, PocketListActivity.class);
                        startActivity(intent);
                        //此处注意：不设置上一个被选中的item的值，避免重复点击此项不跳转
                    }
                    return true;
                case R.id.users_settings:
                    if (mLastfragment != 2) {
                        switchFragment(mLastfragment, 2);
                        mLastfragment = 2;
                    }
                    return true;
            }
            return false;
        }
    };

    /**
     * 切换Fragment
     */
    private void switchFragment(int lastfragment, int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(mFragments[lastfragment]);//隐藏上个Fragment
        if (mFragments[index].isAdded() == false) {
            transaction.add(R.id.mainpage, mFragments[index]);
        }
        transaction.show(mFragments[index]).commitAllowingStateLoss();
    }

}
