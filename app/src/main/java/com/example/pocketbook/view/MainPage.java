package com.example.pocketbook.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.example.pocketbook.R;
import com.example.pocketbook.fragment.AccountListFragment;
import com.example.pocketbook.fragment.AddRecordFragment;
import com.example.pocketbook.fragment.PocketListFragment;
import com.example.pocketbook.fragment.UsersSettingsFragment;

public class MainPage extends AppCompatActivity {

    private BottomNavigationView mBnv;
    private AccountListFragment mAccountListFragment;
    private AddRecordFragment mAddRecordFragment;
    private UsersSettingsFragment mUsersSettingsFragment;
    private Fragment[] fragments;
    private int lastfragment;//记录最后一个fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        initFragment();
    }

    /*
    初始化fragment和fragment数组
     */
    private void initFragment() {
        mAccountListFragment = new AccountListFragment();
        mAddRecordFragment = new AddRecordFragment();
        mUsersSettingsFragment = new UsersSettingsFragment();
        fragments = new Fragment[]{mAccountListFragment,mAddRecordFragment,mUsersSettingsFragment};
        lastfragment = 0;
        getSupportFragmentManager().beginTransaction().replace(R.id.mainpage,mAccountListFragment).
                show(mAccountListFragment).commit();
        mBnv = (BottomNavigationView)findViewById(R.id.bnv);
        mBnv.setOnNavigationItemSelectedListener(changeFragmnet);
    }

    //判断选择的菜单栏
    private BottomNavigationView.OnNavigationItemSelectedListener changeFragmnet
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.account_list: {
                    if (lastfragment != 0) {
                        switchFragment(lastfragment, 0);
                        lastfragment = 0;
                    }
                    return true;
                }
                case R.id.add_records: {
                    if (lastfragment != 1) {
                        Intent intent = new Intent(MainPage.this,PocketListActivity.class);
                        startActivity(intent);
                    }
                    return true;
                }
                case R.id.users_settings:
                {
                    if (lastfragment != 2) {
                        switchFragment(lastfragment, 2);
                        lastfragment = 2;
                    }
                    return true;
            }
        }
            return false;
        }
    };

    //切换Fragment
    private void switchFragment(int lastfragment,int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
        if (fragments[index].isAdded() == false) {
            transaction.add(R.id.mainpage, fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }

}
