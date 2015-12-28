package com.dutsov.chavdar.matura;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.io.InputStream;

/**
 * Created by chavdar on 12/6/15.
 */
public class FillData {
    public String result;
    public void FillHeroes(String value, View rootView, Context context) {
         //   if (value.contentEquals("Под Игото"))
         //           mTextView.setText("Уя му е най голем");
        try {
            Resources res = context.getResources();
            InputStream in_s = res.openRawResource(context.getResources().getIdentifier(value+"her", "raw", context.getPackageName()));

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            result = new String(b);
            in_s.close();
        } catch (Exception e) {
            e.printStackTrace();
            result = "Очаквайте следваща версия на приложението в което ще има доплънигелна информация\n" +
                    "за сега едно голямо нищо!";
        }
        TextView mTextView = (TextView) rootView.findViewById(R.id.heroes);
        mTextView.setMovementMethod(new ScrollingMovementMethod());
        mTextView.setText(result);

    }

   public void FillExamps(String value, View rootView, Context context) {
       try {
           Resources res = context.getResources();
           InputStream in_s = res.openRawResource(context.getResources().getIdentifier(value +"ex", "raw", context.getPackageName()));

           byte[] b = new byte[in_s.available()];
           in_s.read(b);
           in_s.close();
           result = new String(b);
       } catch (Exception e) {
           e.printStackTrace();
           result = "Error: can't show file.";
       }
       SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
       Boolean syncConnPref = sharedPref.getBoolean("big_font", false);

       TextView mTextView = (TextView) rootView.findViewById(R.id.examps);
       mTextView.setMovementMethod(new ScrollingMovementMethod());
       mTextView.setMovementMethod(LinkMovementMethod.getInstance());
       mTextView.setLinksClickable(true);
       result = result.replace("\n","<br/>");
       mTextView.setText(Html.fromHtml(result));
       if(syncConnPref)
           mTextView.setTextSize(18);
       else
           mTextView.setTextSize(14);

    }

    public void FillWork(String value, View rootView, Context context) {
        try {
            Resources res = context.getResources();
            InputStream in_s = res.openRawResource(context.getResources().getIdentifier(value, "raw", context.getPackageName()));

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            result = new String(b);
        } catch (Exception e) {
             e.printStackTrace();
            result = "Error: can't show file.";
        }

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        Boolean syncConnPref = sharedPref.getBoolean("big_font", false);


        TextView mTextView = (TextView) rootView.findViewById(R.id.work);
        mTextView.setMovementMethod(new ScrollingMovementMethod());
        mTextView.setMovementMethod(LinkMovementMethod.getInstance());
        mTextView.setLinksClickable(true);
        result = result.replace("\n","<br/>");
        mTextView.setText(Html.fromHtml(result));
        if(syncConnPref)
            mTextView.setTextSize(18);
        else
            mTextView.setTextSize(14);

//        if(value.contentEquals("Елегия"))
        //    mTextView.setText(result);
            //mTextView.setText(mContext.getResources().openRawResource(R.raw.elegiq));
    }


}
