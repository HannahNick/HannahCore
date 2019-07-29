package com.app.androidutildemo.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.app.androidutildemo.R;
import com.app.androidutildemo.SimpleBaseActivity;
import com.app.androidutildemo.ui.fragment.HomeFragment;
import com.app.androidutildemo.ui.fragment.MeFragment;
import com.app.androidutildemo.ui.fragment.ShopCartFragment;
import com.app.androidutildemo.ui.fragment.SortFragment;
import com.blankj.utilcode.util.FragmentUtils;

public class HomeActivity extends SimpleBaseActivity {

    private HomeFragment mHomeFragment;
    private SortFragment mSortFragment;
    private ShopCartFragment mShopCartFragment;
    private MeFragment mMeFragment;
    private Fragment mLastFragment;

    @Override
    protected int contentView() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        mHomeFragment = new HomeFragment();
        mSortFragment= new SortFragment();
        mShopCartFragment= new ShopCartFragment();
        mMeFragment= new MeFragment();

        FragmentUtils.add(supportFragmentManager,mHomeFragment,R.id.rl_contain,false);
        FragmentUtils.add(supportFragmentManager,mSortFragment,R.id.rl_contain,true);
        FragmentUtils.add(supportFragmentManager,mShopCartFragment,R.id.rl_contain,true);
        FragmentUtils.add(supportFragmentManager,mMeFragment,R.id.rl_contain,true);
        mLastFragment = mHomeFragment;
    }

    public void onSelect(View view){
        int iMenuId = view.getId();
        switch (iMenuId){
            case R.id.menu_home://首页
                if (!(mLastFragment instanceof HomeFragment)){
                    mHomeFragment.setUserVisibleHint(true);
                    FragmentUtils.showHide(mHomeFragment,mSortFragment,mShopCartFragment,mMeFragment);
                    mLastFragment = mHomeFragment;
                }
                break;
            case R.id.menu_sort://分类
                if (!(mLastFragment instanceof SortFragment)){
                    mSortFragment.setUserVisibleHint(true);
                    FragmentUtils.showHide(mSortFragment,mHomeFragment,mShopCartFragment,mMeFragment);
                    mLastFragment = mSortFragment;
                }
                break;
            case R.id.menu_shopcart://购物车
                if (!(mLastFragment instanceof ShopCartFragment)){
                    FragmentUtils.showHide(mShopCartFragment,mHomeFragment,mSortFragment,mMeFragment);
                    mShopCartFragment.setUserVisibleHint(true);
                    mLastFragment = mShopCartFragment;
                }

                break;
            case R.id.menu_me://我的
                if (!(mLastFragment instanceof MeFragment)){
                    FragmentUtils.showHide(mMeFragment,mHomeFragment,mSortFragment,mShopCartFragment);
                    mMeFragment.setUserVisibleHint(true);
                    mLastFragment = mMeFragment;
                }
                break;
        }
    }
}
