package com.dutsov.chavdar.matura;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends Activity implements AbsListView.OnScrollListener {

    public String item;
    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;
    private ImageView backgroundImage;

    private static final int MAX_ROWS = 50;
    private int lastTopValue = 0;

    public static HashMap<String, String> hm = new HashMap<String, String>();

    public void mapData(){
        hm.put("0","botev");
        hm.put("1","vasov");
        hm.put("2","aleko");
        hm.put("3","pencho");
        hm.put("4","peio");
        hm.put("5","debelianov");
        hm.put("6","elin");
        hm.put("7","smirnenski");
        hm.put("8","milev");
        hm.put("9","dalchev");
        hm.put("10","bagriana");
        hm.put("11","iovkov");
        hm.put("12","vapcarov");
        hm.put("13","talev");
        hm.put("14","dimov");

    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mapData();

        //Catch intent
        Intent intent = getIntent();
        item = intent.getStringExtra("item_clicked");
        Resources res = this.getResources();


        mainListView = (ListView) findViewById( R.id.mainListView );

        String[] works = populateWorks(hm.get(item));
        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll( Arrays.asList(works) );

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.list_row_works, planetList);


        // Set the ArrayAdapter as the ListView's adapter.
        //mainListView.setAdapter( listAdapter );
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Intent mIntent = new Intent(ListActivity.this,Content.class);
                Bundle extras = new Bundle();
                extras.putString("data", (String) mainListView.getItemAtPosition(position));
                mIntent.putExtras(extras);
                startActivity(mIntent);
            }
        });
        // inflate custom header and attach it to the list
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.custom_header, mainListView, false);
        mainListView.addHeaderView(header, null, false);

        // we take the background image and button reference from the header
//        backgroundImage = (ImageView) header.findViewById(res.getIdentifier(hm.get(item),"drawable", this.getPackageName()));
        backgroundImage = (ImageView) findViewById(R.id.listHeaderImage);
        backgroundImage.setImageResource(res.getIdentifier(hm.get(item),"drawable", this.getPackageName()));
        mainListView.setOnScrollListener(this);
        mainListView.setAdapter( listAdapter );

    }

    public String[] populateWorks(String author) {
        String works[] = null;

        if(author.contentEquals("vasov")) {
            works = new String[] {"Под Игото",
                    "Под Игото Глава I Гост",
                    "Под Игото Глава XI Радини вълнения",
                    "Чичовци",
                    "Дядо Йоцо гледа",
                    "Българският език",
                    "Линее нашето поколение",
                    "Елате ни вижте",
                    "При рилския манастир",
                    "Отечество любезно",
                    "Левски",
                    "Паисий",
                    "Кочо",
                    "Опълченците на Шипка"};
        }
        if(author.contentEquals("botev")) {
            works = new String[] {
                    "Майце си",
                    "Към брата си",
                    "Елегия","Борба",
                    "До моето първо либе",
                    "На прощаване",
                    "Хаджи Димитър",
                    "Обесването на Васил Левски"
            };
        }
        if(author.contentEquals("aleko")) {
            works = new String[] {
                    "Бай Ганьо тръгна по Европа",
                    "Бай Ганьо се върна от Европа",
                    "Разни хора, разни идеали"
            };
        }
        if(author.contentEquals("pencho")) {
            works = new String[] {
                    "Cis Moll",
                    "Ни лъх не дъхва над полени",
                    "Спи езерото",
                    "Самотен гроб в самотен кът",
                    "Ралица"
            };
        }
        if(author.contentEquals("peio")) {
            works = new String[] {
                    "Градушка",
                    "Заточеници",
                    "Ще бъдеш в бяло",
                    "Две хубави очи",
                    "Сенки",
                    "Две души",
                    "Стон (на Лора)",
                    "Песента на човека",
                    "Маска"
            };
        }
        if(author.contentEquals("debelianov")) {
            works = new String[]{
                    "Черна песен",
                    "Пловдив",
                    "Да се завърнеш в бащината къща",
                    "Помниш ли, помниш ли",
                    "Спи градът",
                    "Миг",
                    "Един убит",
                    "Сиротна песен",
                    "Тиха победа"
            };
        }
            if(author.contentEquals("elin")) {
                works = new String[] {
                        "Гераците",
                        "На оня свят",
                        "Мечтатели",
                        "Ветрената мелница",
                        "Косачи",
                        "Задушница",
                        "Андрешко",
                        "Занемелите камбани"
                };
            }
        if(author.contentEquals("smirnenski")) {
            works = new String[] {
                    "Цветарка",
                    "Да бъде ден",
                    "Ний",
                    "Йохан",
                    "Стария музикант",
                    "Зимни вечери",
                    "Юноша"
            };
        }
        if(author.contentEquals("milev")) {
            works = new String[] {
                    "Септември"
            };
        }
        if(author.contentEquals("dalchev")) {
            works = new String[] {
                    "Къщата",
                    "Камък",
                    "Болница",
                    "Стаята",
                    "Прозорец",
                    "Повест",
                    "Книгите",
                    "Дяволско"
            };
        }

        if(author.contentEquals("bagriana")) {
            works = new String[] {
                    "Кукувица",
                    "Потомка",
                    "Вечната",
                    "Стихии"
            };
            if(author.contentEquals("vapcarov"))
            works = new String[]{
                    "Вяра",
                    "История",
                    "Кино",
                    "Песен за човека",
                    "Писмо",
                    "Завод",
                    "Сън",
                    "Прощално",
                    "proshtalno",
                    "Борбата е безмилостно жестока"
            };

        }

        if(author.contentEquals("iovkov")) {
            works = new String[] {
                    "Песента на колелетата",
                    "Последна радост",
                    "Шибил",
                    "През чумавото",
                    "Индже",
                    "Албена",
                    "Другоселец",
                    "Серафим"
            };
        }
        if(author.contentEquals("vapcarov")) {
            works = new String[] {
                    "Вяра",
                    "История",
                    "Кино",
                    "Песен за човека",
                    "Писмо",
                    "Завод",
                    "Сън",
                    "Прощално",
                    "Борбата е безмилостно жестока"
            };
        }
        if(author.contentEquals("talev")) {
            works = new String[] {
                    "Железният светилник"
            };

        }

        if(author.contentEquals("dimov")) {
            works = new String[] {
                    "Тютюн"
            };
        }



        return works;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        Rect rect = new Rect();
        backgroundImage.getLocalVisibleRect(rect);
        if (lastTopValue != rect.top) {
        //if(lastTopValue - rect.top > 5) {
            lastTopValue = rect.top;
            backgroundImage.setY((float) (rect.top / 2.0));
        }
    }

}
