package com.harshalbenake.calenderdates.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.harshalbenake.calenderdates.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CalenderListAdapter extends BaseAdapter {
        private Context mContext;
        private String[] mDateArray,mDayArray,mYearArray;

        public CalenderListAdapter(Context context) {
            this.mContext = context;


            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat("dd");
            String[] dateArray = new String[365];

            for (int i = 0; i < 365; i++) {
                Date date = calendar.getTime ();
                // now format it using SimpleDateFormat
                String format = simpleDateFormatDate.format (date);
                dateArray[i] = format;
                calendar.add (Calendar.DAY_OF_WEEK, 1);
            }

            SimpleDateFormat simpleDateFormatDay = new SimpleDateFormat("MMM");
            String[] dayArray = new String[365];

            for (int i = 0; i < 365; i++) {
                Date date = calendar.getTime ();
                // now format it using SimpleDateFormat
                String format = simpleDateFormatDay.format (date);
                dayArray[i] = format;
                calendar.add (Calendar.DAY_OF_WEEK, 1);
            }

            SimpleDateFormat simpleDateFormatYear = new SimpleDateFormat("yyyy");
            String[] yearArray = new String[365];

            for (int i = 0; i < 365; i++) {
                Date date = calendar.getTime ();
                // now format it using SimpleDateFormat
                String format = simpleDateFormatYear.format (date);
                yearArray[i] = format;
                calendar.add (Calendar.DAY_OF_WEEK, 1);
            }


            this.mDateArray = dateArray;
            this.mDayArray = dayArray;
            this.mYearArray = yearArray;
        }

        @Override
        public int getCount() {
            return mDateArray.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final ViewHolderItem viewHolder;
            if (convertView == null) {
                // inflate the layout
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.rowitem_calender, parent, false);
                viewHolder = new ViewHolderItem();
                viewHolder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
                viewHolder.tv_day = (TextView) convertView.findViewById(R.id.tv_day);
                viewHolder.tv_year = (TextView) convertView.findViewById(R.id.tv_year);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolderItem) convertView.getTag();
            }

            viewHolder.tv_date.setText(mDateArray[position]);
            viewHolder.tv_day.setText(mDayArray[position]);
            viewHolder.tv_year.setText(mYearArray[position]);
            return convertView;
        }

        private static class ViewHolderItem {
            TextView tv_date,tv_day,tv_year;
        }

    }
