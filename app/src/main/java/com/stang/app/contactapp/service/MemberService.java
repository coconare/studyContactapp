package com.stang.app.contactapp.service;

import com.stang.app.contactapp.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2012 on 2017-02-04.
 */
public interface MemberService {
    // Create:
    public void add(MemberBean bean);

    // Update
    public void update(MemberBean bean);

    // Delete
    public void delete(MemberBean bean);

    // Read ONE
    public MemberBean readOen(MemberBean bean);

    // Read SOME
    public ArrayList<MemberBean> readSome(String keyword);

    // Read ALL
    public ArrayList<MemberBean> list();
}
