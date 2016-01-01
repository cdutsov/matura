package com.dutsov.chavdar.matura;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chavdar on 12/8/15.
 */
public class GridAuthors extends Activity{
    private final String appPackageName = "com.company.millenium.iwannask";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_activity);
        PreferenceManager.setDefaultValues(this, R.xml.preference_screen, false);

        final GridView gridView = (GridView)findViewById(R.id.gridview);
        gridView.setAdapter(new MyAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // this 'mActivity' parameter is Activity object, you can send the current activity.
                if (String.valueOf(position).contentEquals("15")) {
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                    }
                } else {
                    Intent i = new Intent(GridAuthors.this, ListActivity.class);
                    i.putExtra("item_clicked", String.valueOf(position));
                    GridAuthors.this.startActivity(i);
                }
            }
        });
    }

    private class MyAdapter extends BaseAdapter
    {
        private List<Item> items = new ArrayList<Item>();
        private LayoutInflater inflater;

        public MyAdapter(Context context)
        {
            inflater = LayoutInflater.from(context);

            items.add(new Item("Христо Ботев", R.drawable.botev));
            items.add(new Item("Иван Вазов", R.drawable.vasov));
            items.add(new Item("Алеко Константинов", R.drawable.aleko));
            items.add(new Item("Пенчо Славейков", R.drawable.pencho));
            items.add(new Item("Пейо Яворов", R.drawable.peio));
            items.add(new Item("Димчо Дебелянов", R.drawable.debelianov));
            items.add(new Item("Елин Пелин", R.drawable.elin));
            items.add(new Item("Христо Смирненски", R.drawable.smirnenski));
            items.add(new Item("Гео Милев", R.drawable.milev));
            items.add(new Item("Атанас Далчев", R.drawable.dalchev));
            items.add(new Item("Елисавета Багряна", R.drawable.bagriana));
            items.add(new Item("Йордан Йовков", R.drawable.iovkov));
            items.add(new Item("Никола Вапцаров", R.drawable.vapcarov));
            items.add(new Item("Димитър Талев", R.drawable.talev));
            items.add(new Item("Димитър Димов", R.drawable.dimov));
            items.add(new Item("IWannAsk", R.drawable.iwannask512_sepia));
        }


        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i)
        {
            return items.get(i);
        }

        @Override
        public long getItemId(int i)
        {
            return items.get(i).drawableId;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            View v = view;
            ImageView picture;
            TextView name;

            if(v == null)
            {
                v = inflater.inflate(R.layout.grid_view, viewGroup, false);
                v.setTag(R.id.picture, v.findViewById(R.id.picture));
                v.setTag(R.id.text, v.findViewById(R.id.text));
            }

            picture = (ImageView)v.getTag(R.id.picture);
            name = (TextView)v.getTag(R.id.text);

            Item item = (Item)getItem(i);

            picture.setImageResource(item.drawableId);
            name.setText(item.name);

            return v;
        }

        public class Item
        {
            final String name;
            final int drawableId;

            Item(String name, int drawableId)
            {
                this.name = name;
                this.drawableId = drawableId;
            }

        }
    }

}
