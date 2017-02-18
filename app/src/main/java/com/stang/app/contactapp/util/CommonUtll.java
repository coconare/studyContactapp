package com.stang.app.contactapp.util;

/**
 * Created by hb2012 on 2017-02-18.
 */
public class CommonUtll {
    public static boolean nvl(String str){
        if(str==null || "".equals(str)) return false;
        return true;
    }
}
