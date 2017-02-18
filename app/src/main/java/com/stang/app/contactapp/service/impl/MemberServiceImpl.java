package com.stang.app.contactapp.service.impl;

import android.content.Context;

import com.stang.app.contactapp.dao.MemberDao;
import com.stang.app.contactapp.domain.MemberBean;
import com.stang.app.contactapp.service.MemberService;

import java.util.ArrayList;

/**
 * Created by hb2012 on 2017-02-04.
 */
public class MemberServiceImpl implements MemberService {
    MemberDao memberDao;

    public MemberServiceImpl(Context context) {
        this.memberDao = new MemberDao(context);
    }

    @Override
    public void add(MemberBean bean) {

    }

    @Override
    public void update(MemberBean bean) {

    }

    @Override
    public void delete(MemberBean bean) {

    }

    @Override
    public MemberBean readOen(MemberBean bean) {
        return null;
    }

    @Override
    public ArrayList<MemberBean> readSome(String keyword) {
        return null;
    }

    @Override
    public ArrayList<MemberBean> list() {
        return null;
    }
}
