package com.comexample.lieke.myapplication.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.comexample.lieke.myapplication.R;
import com.comexample.lieke.myapplication.utils.LoginUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

import java.util.List;

@ContentView(R.layout.activity_main)
public class LoginActivity extends AppCompatActivity {
    private EditText etPhone;
    private TextView tvRegedit;
    private RelativeLayout rlLogin;
    private RelativeLayout rlMain;
    private RelativeLayout rlRegedit;
    private RelativeLayout rlCode;
    private TextView tvLogin;
    private TextView tvCodeLogin;


    //是否是开始的动画
    private Button btnLogin;
    private Button btnRegedit;
    private Button btnCode;

    private LayoutTransition mTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initViews();
        mTransition = new LayoutTransition();

        //监听事件
        addListener();


    }

    private void addListener() {

        etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 11) {
                    //改变背景
                    btnRegedit.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_check_bg));
                    btnRegedit.setTextColor(getResources().getColor(R.color.white));
                } else {
                    //改变背景
                    btnRegedit.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_bg));
                    btnRegedit.setTextColor(getResources().getColor(R.color.blue));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        tvRegedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录界面隐藏
                hideAnim(rlLogin);
                //注册界面显示
                showAnim(rlRegedit);
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录界面显示
                showAnim(rlLogin);
                //注册界面隐藏
                hideAnim(rlRegedit);
            }
        });

        btnRegedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐藏注册界面
                hideAnim(rlRegedit);
                showAnim(rlCode);
            }
        });

        tvCodeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐藏验证码界面
                hideAnim(rlCode);
                //显示登录界面
                showAnim(rlLogin);
            }
        });

        btnCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐藏验证码界面
                hideAnim(rlCode);
                //显示登录界面
                showAnim(rlLogin);
            }
        });

        //登录界面
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(LoginActivity.this,MainOrderActivity.class));
                Intent intent = new Intent(LoginActivity.this, MainOrderActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.activity_enter, R.anim.activity_out);

            }
        });
    }

    private void initViews() {
        etPhone = (EditText) this.findViewById(R.id.et_regedit_phone);
        tvRegedit = (TextView) this.findViewById(R.id.tv_regedit);
        rlLogin = (RelativeLayout) this.findViewById(R.id.rl_login);
        rlMain = (RelativeLayout) this.findViewById(R.id.rl_main);
        rlRegedit = (RelativeLayout) this.findViewById(R.id.rl_regedit);
        rlCode = (RelativeLayout) this.findViewById(R.id.rl_get_code);
        tvLogin = (TextView) this.findViewById(R.id.tv_login);
        btnLogin = (Button) this.findViewById(R.id.btn_login);
        btnRegedit = (Button) this.findViewById(R.id.btn_regedit);
        tvCodeLogin = (TextView) this.findViewById(R.id.tv_code_login);
        btnCode = (Button) this.findViewById(R.id.btn_code);
    }

    /**
     * 隐藏动画
     */
    private void hideAnim(View view) {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f,
                0f, 0f);
        ObjectAnimator.ofPropertyValuesHolder(view, pvhX).setDuration(2000).start();
        view.setVisibility(View.GONE);
    }


    /**
     * 显示动画
     */
    private void showAnim(View view) {
        LoginUtils.listLogin.add(view);
        view.setVisibility(View.VISIBLE);
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 0f,
                1f, 1f);
        ObjectAnimator.ofPropertyValuesHolder(view, pvhX).setDuration(2000).start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            List<View> list = LoginUtils.listLogin;
            int num = list.size();


            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}