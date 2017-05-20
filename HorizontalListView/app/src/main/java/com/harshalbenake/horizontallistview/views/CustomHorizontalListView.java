package com.harshalbenake.horizontallistview.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.harshalbenake.horizontallistview.R;

import java.util.ArrayList;

/**
 * This class is used for custom HorizontalListView.
 */
public class CustomHorizontalListView extends LinearLayout {
    private Context mContext;
    private LinearLayout mll_contatinerlistview;
    private ArrayList<String> mItemSelectedArray;
    private String mItemArray[];
    public CustomHorizontalListView(Context context) {
        super(context);
        this.mContext = context;
        initlayout();
    }

    public CustomHorizontalListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initlayout();
    }

    public CustomHorizontalListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        initlayout();
    }

    /**
     * initialize Layout
     */
    private void initlayout() {
        View rootView = inflate(mContext, R.layout.custom_horizontallistview, this);
        mll_contatinerlistview = (LinearLayout) rootView.findViewById(R.id.ll_contatinerlistview);
        mItemSelectedArray = new ArrayList<>();
    }

    /**
     * sets Lables
     * @param itemArray
     **/
    public void setListItems(String[] itemArray) {
        mItemArray=itemArray;
        for (int listItemsIndex = 0; listItemsIndex < itemArray.length; listItemsIndex++) {
            TextView view = new TextView(mContext);
            view.setId(listItemsIndex);
            view.setTag(itemArray[listItemsIndex]);
            view.setText(itemArray[listItemsIndex]);
            view.setBackgroundColor(Color.GRAY);
            view.setOnClickListener(new CustomOnClickListener());
            LayoutParams layoutParamsTextView = new LayoutParams(75, 500);
            layoutParamsTextView.setMargins(10,10,10,10);
            view.setGravity(Gravity.CENTER);
            view.setLayoutParams(layoutParamsTextView);
            mll_contatinerlistview.addView(view);
        }
    }

    /**
     * Custom On Click Listener
     */
    class CustomOnClickListener implements OnClickListener {

        public CustomOnClickListener() {
        }

        @Override
        public void onClick(View view) {
            int viewID = view.getId();
            String viewTag = view.getTag().toString();
            resetAllColors((ViewGroup)view.getParent());
            view.setBackgroundColor(Color.GREEN);
            mItemSelectedArray.clear();
            mItemSelectedArray.add(viewTag);
        }
    }

    public void resetAllColors(ViewGroup group)
    {
        for(int i = 0; i< mItemArray.length; i++){
            View view = group.getChildAt(i);
            view.setBackgroundColor(Color.GRAY);
        }
    }

    /**
     * selectd Item By Tag
     */
    public void selectItemByTag(String strTag){
        for(int i = 0; i< mItemArray.length; i++) {
            View view = mll_contatinerlistview.getChildAt(i);
            if(view.getTag().toString().equalsIgnoreCase(strTag)){
                view.setBackgroundColor(Color.GREEN);
                view.setSelected(true);
            }
        }
    }

    /**
     * gets Item Selected Array
     * @return
     */
    public ArrayList<String> getListItemsArray(){
        return mItemSelectedArray;
    }
}