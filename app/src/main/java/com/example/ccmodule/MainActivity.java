package com.example.ccmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.example.cclibrary.permission.CcPermissions;
import com.example.cclibrary.permission.Consumer;
import com.example.cclibrary.permission.IQuickDialogListener;
import com.example.cclibrary.permission.PermissionFragment;
import com.example.cclibrary.permission.PermissionName;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PermissionFragment.iQuickDialogListener = (PermissionName)->{
            new AlertDialog.Builder(MainActivity.this)
                    //.setTitle("提示")
                    .setCancelable(true)
                    .setMessage("C为了保证您正常的使用App，请允许我们获取您的" + "权限")
                    .setPositiveButton("确定1", (dialog, which) -> CcPermissions.gotoPermissionSettings(MainActivity.this, false))
                    .setNegativeButton("取消2", (dialog, which) -> dialog.dismiss())
                    .create().show();
        };




        CcPermissions.with(this)
                .permission(PermissionName.CAMERA)
                .request(new Consumer() {
                    @Override
                    public void accept(List<String> granted, boolean isAll) {
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public AlertDialog.Builder getBuilder(String permissionName) {

                        AlertDialog.Builder customerBuilder = new AlertDialog.Builder(MainActivity.this)
                                //.setTitle("提示")
                                .setCancelable(true)
                                .setMessage("A为了保证您正常的使用App，请允许我们获取您的" + permissionName + "权限")
                                .setPositiveButton("确定1", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        CcPermissions.gotoPermissionSettings(MainActivity.this, false);
                                    }
                                }).setNegativeButton("取消2", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        return customerBuilder;
                    }

                });

    }
}