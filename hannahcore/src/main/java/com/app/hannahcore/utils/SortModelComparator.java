package com.app.hannahcore.utils;


import com.app.hannahcore.bean.ContactBean;

import java.util.Comparator;

/**
 * 对象比较器根据首字母从A到Z由小到大排序
 * Created by Nick on 2017/8/8.
 */

public class SortModelComparator implements Comparator<ContactBean> {
    @Override
    public int compare(ContactBean o1, ContactBean o2) {
        String s1 = o1.getSortLetters().toUpperCase();
        char c1 = s1.charAt(0);

        String s2 = o2.getSortLetters().toUpperCase();
        char c2 = s2.charAt(0);
        if (c1>c2){
            return 1;
        }else if(c1==c2){
            return 0;
        }else {
            return -1;
        }
    }
}
