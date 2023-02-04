package com.example.scrollexampletest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

public class ScrollChangeHeadView extends ListView {

    private View viewHead;
    private View topBar;

    //添加构造函数
    public ScrollChangeHeadView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        viewHead = LayoutInflater.from(context).inflate(R.layout.scroll_change_head, null);
        addHeaderView(viewHead);

        //添加滚动监听事件
        setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                //滚动时调用这里
                if (topBar!=null){
                    int headTop = viewHead.getTop();
                    headTop = Math.abs(headTop);

                    //0-255 0：全透明 255：不透明
                    topBar.getBackground().setAlpha(headTop * (255 / 100));
                }
            }
        });
    }

    public void setTopBar(View v) {
        topBar = v;
    }
}
