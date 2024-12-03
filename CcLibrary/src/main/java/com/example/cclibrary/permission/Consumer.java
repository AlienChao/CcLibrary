package com.example.cclibrary.permission;



import android.app.AlertDialog;

import java.util.List;

/**
 * @author AlienChao
 * @date 2018/11/27 16:18
 */
public abstract  class Consumer implements IPermission {



    @Override
    public void noPermission(List<String> denied, boolean quick) {

    }

    @Override
    public void noPermission(List<String> denied, boolean quick, List<String> quickStr) {

    }

    @Override
    public AlertDialog.Builder getBuilder(String permissionName) {
        return null;
    }
}
