package com.app.hannahcore.ui.activity;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.widget.ListView;

import com.app.hannahcore.R;
import com.app.hannahcore.base.BaseActivity;
import com.app.hannahcore.base.BasePresenter;
import com.app.hannahcore.bean.ContactBean;
import com.app.hannahcore.ui.adapter.ContactAdapter;
import com.app.hannahcore.utils.CharacterParser;
import com.app.hannahcore.utils.SortModelComparator;
import com.app.hannahcore.widget.WaveSideBarView;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.PermissionUtils.SimpleCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactActivity extends BaseActivity implements WaveSideBarView.OnTouchLetterChangeListener{

    /**
     * ui
     */
    private ListView mLv_list;
    private WaveSideBarView mWsbv_slidebar;

    /**
     * data
     */
    private List<ContactBean> mData;
    private static final String[] PHONES_PROJECTION = new String[] {
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
    };

    /**
     * adapter
     */
    private ContactAdapter mAdapter;


    /**
     * constants
     */
    public static final int RESULTCODE = 10000;
    public static final String CONTACT_NAME = "CONTACT_NAME";
    public static final String CONTACT_PHONE = "CONTACT_PHONE";
    private static final int PHONES_DISPLAY_NAME_INDEX = 0;
    private static final int PHONES_NUMBER_INDEX = 1;


    @Override
    protected int setLayout() {
        return R.layout.activity_contact;
    }

    @Override
    protected void findViews() {
        mLv_list = findViewById(R.id.lv_list);
        mWsbv_slidebar = findViewById(R.id.wsbv_slide_bar);
    }

    @Override
    protected void init() {
        setUpToolbar("手机联系人");
        mData = new ArrayList<>();
        mAdapter = new ContactAdapter(this,mData);
        mLv_list.setAdapter(mAdapter);
        PermissionUtils.permission(PermissionConstants.CONTACTS).callback(new SimpleCallback() {
            @Override
            public void onGranted() {
                initData();
            }

            @Override
            public void onDenied() {
                finish();
            }
        }).request();
    }

    @Override
    protected void initListener() {
        mWsbv_slidebar.setOnTouchLetterChangeListener(this);
    }

    @Override
    protected void release() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void onLetterChange(String letter) {
        int position = mAdapter.getPositionForSection(letter.charAt(0));
        mLv_list.setSelection(position);
    }

    private void initData(){
        CharacterParser mCharacterParser = CharacterParser.getInstance();
        Cursor phoneCursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PHONES_PROJECTION, null, null, null);
        if (phoneCursor != null) {
            while (phoneCursor.moveToNext()) {
                ContactBean bean = new ContactBean();
                String phoneNumber = phoneCursor.getString(PHONES_NUMBER_INDEX).replace(" ", "").replace("-", "");
                if (TextUtils.isEmpty(phoneNumber))
                    continue;
                String contactName = phoneCursor.getString(PHONES_DISPLAY_NAME_INDEX);
                bean.setName(contactName);
                //汉字转换成拼音
                String pinyin = mCharacterParser.getSelling(contactName);
                String sortString = pinyin.substring(0, 1).toUpperCase();
                // 正则表达式，判断首字母是否是英文字母
                if(sortString.matches("[A-Z]")){
                    bean.setSortLetters(sortString.toUpperCase());
                }else{
                    bean.setSortLetters("#");
                }
                bean.setPhone(phoneNumber);
                mData.add(bean);
            }
            phoneCursor.close();
        }
        sortData(mData);
        mAdapter.notifyDataSetChanged();
    }


    /**
     * 对填充完毕的数据进行排序
     * @param data
     */
    private void sortData(List<ContactBean> data){
        Collections.sort(data,new SortModelComparator());
    }
}
