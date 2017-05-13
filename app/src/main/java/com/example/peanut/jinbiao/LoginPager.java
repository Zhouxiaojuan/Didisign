package com.example.peanut.jinbiao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Peanut on 2017/5/12.
 */

public class LoginPager extends AppCompatActivity {

    private SharedPreferences preferences;

    private SharedPreferences.Editor editor;

    private EditText accountEdit,passwordEdit;

    private Button btn_login;

    private CheckBox rememberPass;

    private CheckBox autoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor=preferences.edit();

        //获取实例
        accountEdit= (EditText) findViewById(R.id.edit_account);
        passwordEdit= (EditText) findViewById(R.id.edit_password);
        btn_login= (Button) findViewById(R.id.btn_login);
        rememberPass= (CheckBox) findViewById(R.id.cbx_reb_psw);
        autoLogin= (CheckBox) findViewById(R.id.cbx_auto_login);

        //记住密码
        boolean isremreber=preferences.getBoolean("remember_password",false);

        //自动登录
        boolean isauto=preferences.getBoolean("auto_login",false);

        //注销
        boolean isback=getHelper().getIsauto();

        //默认自动记住并填充账号
        String account=preferences.getString("account",null);
        accountEdit.setText(account);

        //若来自注销，重置文件中的自动登录的boolean值
        if (!isback){
            editor.putBoolean("auto_login",false);
        }

        //判断是否记住密码，自动登录，或是注销
        if (isremreber){
            String password=preferences.getString("password",null);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
            if (isauto&&isback) {
                autoLogin.setChecked(true);
                Intent intent1 = new Intent(LoginPager.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        }
        //记住密码checkbox监听事件
        rememberPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (rememberPass.isChecked()){
                    editor.putBoolean("remember_password",true);
                }else {
                    editor.putBoolean("remember_password",false);
                }
                editor.apply();
            }
        });
        //自动登录checkbox监听事件
        autoLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (autoLogin.isChecked()){
                    rememberPass.setChecked(true);
                    editor.putBoolean("auto_login",true);
                }else {
                    editor.putBoolean("auto_login",false);
                }
                editor.apply();
            }
        });
        //登录按钮监听事件
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account=accountEdit.getText().toString();
                String password=passwordEdit.getText().toString();
                if (account.equals("admin")&&password.equals("123456")){
                    if (rememberPass.isChecked()){
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }
                    editor.apply();
                    Intent intent=new Intent(LoginPager.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginPager.this,"Account or password wrong!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //获得辅助类
    public Helper getHelper(){
        return ((Helper) getApplicationContext());
    }

}
