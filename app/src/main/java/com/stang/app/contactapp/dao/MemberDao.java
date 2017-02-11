package com.stang.app.contactapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.stang.app.contactapp.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2012 on 2017-02-11.
 */
public class MemberDao extends SQLiteOpenHelper{

    public MemberDao(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String.format("%s", "CREATE TABLE member ( id text(10) PRIMARY KEY, pass text(10), name text(10), phone text(13), addr text(20), profile text(20));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // Create:
    public void add(MemberBean bean){
        String sql = String.format("INSERT INTO member (id, pass, name, phone, addr, profile) VALUES " +
                "('%s', '%s', '%s', '%s', '%s', '%s');",
                bean.getId(), bean.getPass(), bean.getName(), bean.getPhone(), bean.getAddr(), bean.getProfile());
    }

    // Update
    public void update(MemberBean bean){
        String sql = String.format("UPDATE member SET " +
                "pass='%s', phone='%s', addr='%s', profile='%s' " +
                "WHERE id='%s';",
                bean.getPass(), bean.getPhone(), bean.getAddr(), bean.getProfile(), bean.getId());
    }

    // Delete
    public void delete(MemberBean bean){
        String sql = String.format("DELETE FROM member WHERE id='%s'", bean.getId());
    }

    // Read ONE
    public MemberBean seleteOne(MemberBean bean){
        MemberBean member = new MemberBean();
        String sql = String.format("SELECT id, pass, name, phone, addr, profile " +
                "FROM member WHERE id='%s';", bean.getId());
        return  member;
    }

    // Read SOME
    public ArrayList<MemberBean> selectSome(String keyword){
        ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
        String sql = String.format("SELECT id, pass, name, phone, addr, profile " +
                "FROM member WHERE name='%s';", keyword);
        return  memberList;
    }

    // Read ALL
    public ArrayList<MemberBean> selectAll(){
        ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
        String sql = "SELECT id, pass, name, phone, addr, profile FROM member;";
        return  memberList;
    }
}