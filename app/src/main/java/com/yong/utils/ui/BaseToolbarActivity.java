package com.yong.utils.ui;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.yong.utils.R;

import org.jetbrains.annotations.Nullable;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Description: 带toolbar的baseActivity
 * @Author: yong
 * @time 2020/6/22 8:50
 * @Version: 1.0
 */
public abstract class BaseToolbarActivity extends AppCompatActivity {

    public abstract int getLayoutId();

    //导航栏
    private Toolbar toolbar;
    private Unbinder unbinder;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //避免fragment getActivity为null
        if (savedInstanceState != null) {
            String FRAGMENTS_TAG = "android:support:fragments";
            savedInstanceState.remove(FRAGMENTS_TAG);
        }

        //设置状态栏透明 且渐变
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        super.onCreate(savedInstanceState);
        //不为-1走ButterKnife否则为binding
        if (getLayoutId() != -1) {
            setContentView(getLayoutId());
            unbinder = ButterKnife.bind(this);
        } else {
            InitBinding();
        }

        //初始化导航栏
        initToolBar();
        //初始化数据
        initDate();
        //初始化页面
        initView();
    }

    protected void InitBinding() {
    }

    protected void initToolBar() {
        toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            //设置toolbar高度为本身nav高度+状态栏高度
            final ViewTreeObserver vto = toolbar.getViewTreeObserver();
            vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    toolbar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
                    layoutParams.height = toolbar.getMeasuredHeight() + ScreenUtils.getStatusHeight(BaseToolbarActivity.this);
                    toolbar.setLayoutParams(layoutParams);
                }
            });
            toolbar.setPadding(0, ScreenUtils.getStatusHeight(this), 0, 0);
            setSupportActionBar(toolbar);
            //去除默认的title
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            setBack(getIsBack());
            //设置是否显示保存二字
            setSaveShow(getIsShowSave());
            setToolBarTitle(getToolBarTitle());
        }
    }

    protected void setSaveShow(boolean isShowSave) {
        TextView textView = findViewById(R.id.save);
        if (textView != null && isShowSave) {
            textView.setVisibility(View.VISIBLE);
        } else if (textView != null) {
            textView.setVisibility(View.GONE);
        }
    }

    protected void setToolBarTitle(String toolBarTitle) {
        TextView textView = findViewById(R.id.title);
        if (textView != null && toolBarTitle != null) {
            textView.setText(toolBarTitle);
        }
    }

    protected void setBack(boolean isBack) {
        if (isBack) {
            toolbar.setNavigationOnClickListener(v -> finish());
        }
    }

    /**
     * 是否显示保存二字
     *
     * @return
     */
    protected boolean getIsShowSave() {
        return false;
    }

    /**
     * 是否设置返回
     *
     * @return
     */
    protected boolean getIsBack() {
        return true;
    }

    /**
     * 获取title
     *
     * @return
     */
    protected String getToolBarTitle() {
        return getIntent().getStringExtra("title");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    public void initDate() {
    }

    public void initView() {
    }
}
