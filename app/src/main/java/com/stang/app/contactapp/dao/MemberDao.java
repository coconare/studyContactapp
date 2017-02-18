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

    /**
     *
     * @param context
     * @param name DA 위치
     * @param factory
     * @param version
     */
    public MemberDao(Context context) {
        super(context, "contactapp.db", null, 1);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String.format("%s", "CREATE TABLE IF NOT EXISTS member ( id text(10) PRIMARY KEY, pass text(10), name text(10), email text(30), phone text(13), addr text(20), profile text(20));");
        db.execSQL(sql);
        db.execSQL("CREATE TABLE IF NOT EXISTS Message(\n" +
                "    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    sender TEXT,\n" +
                "    receiver TEXT,\n" +
                "    content TEXT,\n" +
                "    writeTime TEXT,\n" +
                "    id TEXT,\n" +
                "    FOREIGN KEY(id) REFERENCES Member(id)\n" +
                ");\n");
        db.execSQL("INSERT INTO Member(id,pass,name,email,phone,addr,profile)\n" +
                "VALUES('hong','1','홍길동','hong@test.com','010-1234-5678','서울','default');");
        db.execSQL("INSERT INTO Member(id,pass,name,email,phone,addr,profile)\n" +
                "VALUES('kim','1','김유신','kim@test.com','010-1234-5678','인천','default');");
        db.execSQL("INSERT INTO Member(id,pass,name,email,phone,addr,profile)\n" +
                "VALUES('lee','1','이순신','lee@test.com','010-1234-5678','부산','default');");
        db.execSQL("INSERT INTO Member(id,pass,name,email,phone,addr,profile)\n" +
                "VALUES('park','1','박지성','park@test.com','010-1234-5678','전주','default');");
        db.execSQL("INSERT INTO Member(id,pass,name,email,phone,addr,profile)\n" +
                "VALUES('yoo','1','유비','yoo@test.com','010-1234-5678','서울','default');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // Create:
    public void add(MemberBean bean){
        String sql = String.format("INSERT INTO member (id, pass, name, email, phone, addr, profile) VALUES " +
                "('%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                bean.getId(), bean.getPass(), bean.getName(), bean.getEmail(), bean.getPhone(), bean.getAddr(), bean.getProfile());
    }

    // Update
    public void update(MemberBean bean){
        String sql = String.format("UPDATE member SET " +
                "pass='%s', email='%s', phone='%s', addr='%s', profile='%s' " +
                "WHERE id='%s';",
                bean.getPass(), bean.getEmail(), bean.getPhone(), bean.getAddr(), bean.getProfile(), bean.getId());
    }

    // Delete
    public void delete(MemberBean bean){
        String sql = String.format("DELETE FROM member WHERE id='%s'", bean.getId());
    }

    // Read ONE
    public MemberBean seleteOne(MemberBean bean){
        MemberBean member = new MemberBean();
        String sql = String.format("SELECT id, pass, name, email, phone, addr, profile " +
                "FROM member WHERE id='%s';", bean.getId());
        return  member;
    }

    // Read SOME
    public ArrayList<MemberBean> selectSome(String keyword){
        ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
        String sql = String.format("SELECT id, pass, name, email, phone, addr, profile " +
                "FROM member WHERE name='%s';", keyword);
        return  memberList;
    }

    // Read ALL
    public ArrayList<MemberBean> selectAll(){
        ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
        String sql = "SELECT id, pass, name, email, phone, addr, profile FROM member;";
        return  memberList;
    }
}