package com.study.luoluo.wanandroid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.study.luoluo.wanandroid.R;
import com.study.luoluo.wanandroid.base.BaseActivity;
import com.study.luoluo.wanandroid.module.homepage.ui.HomeFragment;
import com.study.luoluo.wanandroid.module.knowledge.ui.KnowledgeFragment;
import com.study.luoluo.wanandroid.module.login.LoginActivity;
import com.study.luoluo.wanandroid.ui.constant.Constant;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private Fragment currentFragment = new HomeFragment();
    private TextView title;
    //    private FrameLayout content;
    private int currentFragmentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDrawerLayout();
        initBottomNavigationView();
        if (savedInstanceState != null) {
            // restore fragment
            currentFragmentIndex = savedInstanceState.getInt(Constant.CURRENT_FRAGMENT_KEY);
        } else {
            // create fragment
            fragments.add(new HomeFragment());
            fragments.add(new KnowledgeFragment());
            fragments.add(new WeChatFragment());
            fragments.add(new ProjectsFragment());
            fragments.add(new MyselfFragment());
        }
        // To remove bar title named wanAndroid
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }
        showFragment(currentFragmentIndex);
        NavigationView navigationView = findViewById(R.id.main_nv);
        View header = navigationView.getHeaderView(0);
        TextView login = header.findViewById(R.id.tv_login);
//        TextView login = findViewById(R.id.tv_login);
        if (login != null) {
            login.setOnClickListener(v -> {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            });
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(Constant.CURRENT_FRAGMENT_KEY, currentFragmentIndex);
    }

    // hide last fragment and show fragment which is clicked
    private void showFragment(int fragmentIndex) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment needShowFragment = fragments.get(fragmentIndex);
        if (!needShowFragment.isAdded()) {
            fragmentTransaction.hide(currentFragment);
            fragmentTransaction.add(R.id.fl_current_fragment_container, needShowFragment, String.valueOf(fragmentIndex));
        } else {
            fragmentTransaction.hide(currentFragment);
            fragmentTransaction.show(needShowFragment);
        }
        currentFragment = fragments.get(fragmentIndex);
        fragmentTransaction.commit();
    }

    private void initDrawerLayout() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.main_dl);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.draw_layout_open, R.string.draw_layout_close);
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

    }

    private void initBottomNavigationView() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bnv);
        title = findViewById(R.id.tv_title);
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.home:
                    currentFragmentIndex = 0;
                    title.setText(R.string.bottom_navigation_home);
                    showFragment(currentFragmentIndex);
                    break;
                case R.id.hierarchy:
                    currentFragmentIndex = 1;
                    title.setText(R.string.bottom_navigation_hierarchy);
                    showFragment(currentFragmentIndex);
                    break;
                case R.id.wechat:
                    currentFragmentIndex = 2;
                    title.setText(R.string.bottom_navigation_wechat);
                    showFragment(currentFragmentIndex);
                    break;
                case R.id.project:
                    currentFragmentIndex = 3;
                    title.setText(R.string.bottom_navigation_project);
                    showFragment(currentFragmentIndex);
                    break;
                case R.id.myself:
                    currentFragmentIndex = 4;
                    title.setText(R.string.bottom_navigation_myself);
                    showFragment(currentFragmentIndex);
                    break;
                default:
                    break;
            }
            return true;
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.tv_login:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return true;
    }
}
