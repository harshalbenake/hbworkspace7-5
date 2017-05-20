package com.harshalbenake.counterview.views;

import android.content.Context;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.harshalbenake.counterview.R;

/**
 * This class is used for custom counter.
 */
public class CustomCounter extends LinearLayout implements View.OnClickListener,TextView.OnEditorActionListener {
    private Context mContext;
    private EditText met_countervalue;

    public interface OnConterSubmitListner {
        void onConterSubmit();
    }

    OnConterSubmitListner mOnConterSubmitListner;


    public CustomCounter(Context context) {
        super(context);
        this.mContext = context;
        initlayout();
    }

    public CustomCounter(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initlayout();
    }

    public CustomCounter(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        initlayout();
    }

    /**
     * initialize Layout
     */
    private void initlayout() {
        View rootView = inflate(mContext, R.layout.custom_counter, this);
        met_countervalue = (EditText) rootView.findViewById(R.id.et_countervalue);
        ImageView ib_counterminus = (ImageView) rootView.findViewById(R.id.ib_counterminus);
        ImageView ib_counterplus = (ImageView) rootView.findViewById(R.id.ib_counterplus);

        ib_counterminus.setOnClickListener(this);
        ib_counterplus.setOnClickListener(this);
        met_countervalue.setOnEditorActionListener(this);

        met_countervalue.setKeyListener(DigitsKeyListener.getInstance(true,true));

    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.ib_counterminus) {
            decrementValue();
        } else if (viewId == R.id.ib_counterplus) {
            incrementValue();
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            if (mOnConterSubmitListner != null) {
                mOnConterSubmitListner.onConterSubmit();
            }
        }
        return false;
    }

    /**
     * increments Value
     */
    private void incrementValue() {
        int counterValue = getValue();
        met_countervalue.setText(String.valueOf(counterValue + 1));
    }

    /**
     * decrements Value
     */
    private void decrementValue() {
        int counterValue = getValue();
        if (counterValue > 0) {
            met_countervalue.setText(String.valueOf(counterValue - 1));
        }
    }

    /**
     * gets Value
     */
    public int getValue() {
        String counterValue = met_countervalue.getText().toString().trim();
        if (counterValue!=null && !counterValue.equalsIgnoreCase("")) {
            return Integer.valueOf(counterValue);
        } else {
            return 0;
        }
    }

    /**
     * sets Value
     */
    public void setValue(String strValue) {
        if (strValue!=null && !strValue.equalsIgnoreCase("")) {
            met_countervalue.setText(Integer.valueOf(strValue)+"");
        }
    }

    /**
     * set On ConterSubmit Listner
     * @param onConterSubmitListner
     */
    public void setOnConterSubmitListner(OnConterSubmitListner onConterSubmitListner) {
        mOnConterSubmitListner = onConterSubmitListner;
    }
}