package com.itheima.xmpp_20150807;

import android.content.ContentValues;
import android.database.Cursor;
import android.test.AndroidTestCase;

import com.itheima.xmpp_20150807.dbhelper.ContactOpenHelper;
import com.itheima.xmpp_20150807.provider.ContactsProvider;

import opensource.jpinyin.PinyinFormat;
import opensource.jpinyin.PinyinHelper;

/*
 * @创建者     Administrator
 * @创建时间   2015/8/7 15:23
 * @描述	      ${TODO}
 *
 * @更新者     $Author$
 * @更新时间   $Date$
 * @更新描述   ${TODO}
 */
public class TestContactsProvider extends AndroidTestCase {

	public void testInsert() {
		/**
		 public static final String ACCOUNT = "account";//账号
		 public static final String NICKNAME = "nickname";//昵称
		 public static final String AVATAR = "avatar";//头像
		 public static final String PINYIN = "pinyin";//账号拼音
		 */
		ContentValues values = new ContentValues();
		values.put(ContactOpenHelper.ContactTable.ACCOUNT, "billy@itheima.com");
		values.put(ContactOpenHelper.ContactTable.NICKNAME, "老伍");
		values.put(ContactOpenHelper.ContactTable.AVATAR, "0");
		values.put(ContactOpenHelper.ContactTable.PINYIN, "laowu");
		getContext().getContentResolver().insert(ContactsProvider.URI_CONTACT, values);
	}

	public void testDelete() {
		getContext().getContentResolver().delete(ContactsProvider.URI_CONTACT,
				ContactOpenHelper.ContactTable.ACCOUNT + "=?", new String[] { "billy@itheima.com" });
	}

	public void testUpdate() {
		ContentValues values = new ContentValues();
		values.put(ContactOpenHelper.ContactTable.ACCOUNT, "billy@itheima.com");
		values.put(ContactOpenHelper.ContactTable.NICKNAME, "我是老伍");
		values.put(ContactOpenHelper.ContactTable.AVATAR, "0");
		values.put(ContactOpenHelper.ContactTable.PINYIN, "woshilaowu");
		getContext().getContentResolver().update(ContactsProvider.URI_CONTACT, values,
				ContactOpenHelper.ContactTable.ACCOUNT + "=?", new String[] { "billy@itheima.com" });
	}

	public void testQuery() {
		Cursor c = getContext().getContentResolver().query(ContactsProvider.URI_CONTACT, null, null, null, null);
		int columnCount = c.getColumnCount();// 一共多少列
		while (c.moveToNext()) {
			// 循环打印列
			for (int i = 0; i < columnCount; i++) {
				System.out.print(c.getString(i) + "    ");
			}
			System.out.println("");
		}
	}

	public void testPinyin() {
		// String pinyinString = PinyinHelper.convertToPinyinString("内容", "分隔符", 拼音的格式);
		String pinyinString = PinyinHelper.convertToPinyinString("黑马程序员", "", PinyinFormat.WITHOUT_TONE);
		System.out.println(pinyinString);
	}
}
