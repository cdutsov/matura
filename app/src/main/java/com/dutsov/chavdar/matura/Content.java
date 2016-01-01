package com.dutsov.chavdar.matura;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.webkit.GeolocationPermissions;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Locale;

import static android.support.v4.app.ActivityCompat.startActivity;

public class Content extends AppCompatActivity implements ActionBar.TabListener{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;
    android.app.FragmentManager mFragmentManager = getFragmentManager();

    PrefsFragment mPrefsFragment = new PrefsFragment();
    android.app.FragmentTransaction mFragmentTransaction;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;
    public static String value;
    public static String fileString;
    public static HashMap<String, String> hm = new HashMap<String, String>();

    public void mapData(){
        hm.put("Майце си","maitsesi");
        hm.put("Към брата си","kumbratasi");
        hm.put("Елегия","elegiq");
        hm.put("Борба","borba");
        hm.put("До моето първо либе","domoetopurvolibe");
        hm.put("На прощаване","naproshtavane");
        hm.put("Хаджи Димитър", "hadzhidimitar");
        hm.put("Обесването на Васил Левски", "obesvaneto");

        hm.put("Българският език", "bulgarskiatezik");
        hm.put("Линее нашето поколение", "lineenashetopokolenie");
        hm.put("Елате ни вижте","elatenivijte");
        hm.put("При рилския манастир","pririlskiqmanastir");
        hm.put("Отечество любезно","otechestvolubezno");
        hm.put("Левски","levski");
        hm.put("Паисий","paisii");
        hm.put("Кочо","kocho");
        hm.put("Опълченците на Шипка","opalchencite");
        hm.put("Под Игото","podigoto");
        hm.put("Дядо Йоцо гледа","dqdoiotso");
        hm.put("Чичовци","chichovtsi");
        hm.put( "Под Игото Глава I Гост","gost");
        hm.put("Под Игото Глава XI Радини вълнения","radinivulnenia");

        hm.put("Къщата","kushtata");
        hm.put("Камък","kamak");
        hm.put("Болница","bolnitsa");
        hm.put("Стаята","staqta");
        hm.put("Прозорец","prosorets");
        hm.put("Повест","povest");
        hm.put("Книгите","knigite");
        hm.put("Дяволско","dqvolsko");

        hm.put("Септември", "septemvri");

        hm.put("Градушка","gradushka");
        hm.put("Заточеници","zatochenitsi");
        hm.put("Ще бъдеш в бяло","bqlo");
        hm.put("Две хубави очи","ochi");
        hm.put("Сенки","senki");
        hm.put("Две души","dvedushi");
        hm.put("Стон (на Лора)","ston");
        hm.put("Песента на човека","pesentanachoveka");
        hm.put("Маска","maska");

        hm.put("Cis Moll","cismoll");
        hm.put("Ни лъх не дъхва над полени","poleni");
        hm.put("Спи езерото","spiezeroto");
        hm.put("Самотен гроб в самотен кът","samotengrob");
        hm.put("Ралица","ralitsa");

        hm.put("Бай Ганьо тръгна по Европа","baiganiotrugna");
        hm.put("Бай Ганьо се върна от Европа","baiganiosevurna");
        hm.put("Разни хора, разни идеали","raznihora");

        hm.put("Тютюн","tiutiun");
        hm.put("Железният светилник", "svetilnik");

        //Дебелянов
        hm.put("Черна песен","chernapesen");
        hm.put("Пловдив","plovdiv");
        hm.put("Да се завърнеш в бащината къща","dasezavurnesh");
        hm.put("Помниш ли, помниш ли","pomnishlipomnishli");
        hm.put("Спи градът","spigradut");
        hm.put("Миг","mig");
        hm.put("Един убит","edinubit");
        hm.put("Сиротна песен","sirotnapesen");
        hm.put("Тиха победа","tihapobeda");

        //Смирненски
        hm.put("Цветарка","tsvetarka");
        hm.put("Да бъде ден","dabudeden");
        hm.put("Ний","nij");
        hm.put("Йохан","johan");
        hm.put("Стария музикант","stariyamuzikant");
        hm.put("Зимни вечери","zimnivecheri");
        hm.put("Юноша","junosha");

        //Гео Милев
        hm.put("Септември","septemvri");

        //Елисавета
        hm.put("Кукувица","kukuvitsa");
        hm.put("Потомка","potomka");
        hm.put("Вечната","vechnata");
        hm.put("Стихии","stihii");

        //Елин Пелин
        hm.put("Гераците","geratsite");
        hm.put("На оня свят","naonyasvyat");
        hm.put("Мечтатели","mechtateli");
        hm.put("Ветрената мелница","vetrenatamelnitsa");
        hm.put("Косачи","kosachi");
        hm.put("Задушница","zadushnitsa");
        hm.put("Андрешко","andreshko");
        hm.put("Занемелите камбани","zanemelitekambani");

        //Йовков
        hm.put("Песента на колелетата","pesentanakoleletata");
        hm.put("Последна радост","poslednaradost");
        hm.put("Шибил","shibil");
        hm.put("През чумавото","prezchumavoto");
        hm.put("Индже","indzhe");
        hm.put("Албена","albena");
        hm.put("Другоселец","drugoselets");
        hm.put("Серафим","serafim");

        hm.put("Вяра","vqra");
        hm.put("История","istoriq");
        hm.put("Кино","kino");
        hm.put("Песен за човека","pesenzachoveka");
        hm.put("Писмо","pismo");
        hm.put("Завод","zavod");
        hm.put("Сън","sun");
        hm.put("Прощално","proshtalno");
        hm.put("Борбата е безмилостно жестока","borbata");
    }

    public static WebView myWebView;
    private static ValueCallback<Uri> mUploadMessage;
    private final static int FILECHOOSER_RESULTCODE=1;
    private static BroadcastReceiver mRegistrationBroadcastReceiver;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static final String TAG = "Content";
    private static String URL;
    private static SwipeRefreshLayout mSwipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mapData();
        Intent mIntent = getIntent();
        Bundle extras = mIntent.getExtras();
        value = extras.getString("data");
        fileString = hm.get(value);
        setContentView(R.layout.activity_content);
        this.setTitle(value);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
        Boolean syncConnPref = sharedPref.getBoolean("fullscreen", false);
        if (syncConnPref)
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //        WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Set up settings fragment

        // Set up the action bar.
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_content, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //return true;
            // Display the fragment as the main content.
            mFragmentTransaction = mFragmentManager
                    .beginTransaction();
            mFragmentTransaction.replace(android.R.id.content, mPrefsFragment);
            mFragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);

            if (!mPrefsFragment.isVisible()) {
                mFragmentTransaction.show(mPrefsFragment).commit();
            } else {
                mFragmentTransaction.hide(mPrefsFragment).commit();
            }
            //mFragmentTransaction.commit();
            // TODO Auto-generated method stub
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }
    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if(intent.hasExtra("url")) {
            String url = intent.getStringExtra("url");
            myWebView.loadUrl(Constants.SERVER_URL + url);
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 2:
                    return HeroesFragment.newInstance(2);
                case 1:
                    return ExampsFragment.newInstance(1);
                case 0:
                    return WorkFragment.newInstance(0);
            }
            return null;

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 2:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 0:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class HeroesFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static HeroesFragment newInstance(int sectionNumber) {
            HeroesFragment fragment = new HeroesFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public HeroesFragment() {
        }

        @Override
        public void onPause() {
            LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(mRegistrationBroadcastReceiver);
            super.onPause();
        }

        @Override
        public void onResume() {
            super.onResume();;
            LocalBroadcastManager.getInstance(getActivity()).registerReceiver(mRegistrationBroadcastReceiver,
                    new IntentFilter(QuickstartPreferences.REGISTRATION_COMPLETE));
            if (DetectConnection.checkInternetConnection(getActivity())) {
                myWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
                myWebView.reload();
            }
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.heroes_content, container, false);

            Intent mIntent = getActivity().getIntent();
            URL = Constants.SERVER_URL;
            if(mIntent.hasExtra("url")) {
                myWebView = null;
                startActivity(getActivity().getIntent());
                String url = mIntent.getStringExtra("url");
                URL = Constants.SERVER_URL + url;
            }

            CookieSyncManager.createInstance(getActivity());
            CookieSyncManager.getInstance().startSync();
            myWebView = (WebView) rootView.findViewById(R.id.webview);
//            myWebView.setWebViewClient(new WebViewClient());
//            myWebView.setWebChromeClient(new WebChromeClient() {
//                public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
//                    callback.invoke(origin, true, false);
//                }
//            });
//            myWebView.getSettings().setGeolocationDatabasePath(getActivity().getFilesDir().getPath());
            WebSettings webSettings = myWebView.getSettings();
            webSettings.setUseWideViewPort(false);
            if (!DetectConnection.checkInternetConnection(getActivity())) {
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                showNoConnectionDialog(getActivity());
            }
            else {
                webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
            }
            //myWebView.setWebViewClient(new CustomWebViewClient());
            webSettings.setJavaScriptEnabled(true);
            webSettings.setLoadWithOverviewMode(true);
            webSettings.setUseWideViewPort(true);
            myWebView.setOverScrollMode(View.OVER_SCROLL_NEVER);

            //location test
            webSettings.setAppCacheEnabled(true);
            webSettings.setDatabaseEnabled(true);
            webSettings.setDomStorageEnabled(true);

            myWebView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView view, String url) {
                    CookieSyncManager.getInstance().sync();
                }

                @Override
                public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                    handler.proceed(); // Ignore SSL certificate errors
                }


                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    if (Uri.parse(url).getHost().equals(Constants.HOST) || Uri.parse(url).getHost().equals(Constants.WWWHOST)) {
                        // This is my web site, so do not override; let my WebView load
                        // the page
                        return false;
                    }
                    // Otherwise, the link is not for a page on my site, so launch
                    // another Activity that handles URLs
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return true;
                }
            });
            myWebView.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView view, int progress) {
                    getActivity().setProgress(progress * 100);
                }

                //The undocumented magic method override
                //Eclipse will swear at you if you try to put @Override here
                // For Android 3.0+
                public void openFileChooser(ValueCallback<Uri> uploadMsg) {

                    mUploadMessage = uploadMsg;
                    Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                    i.addCategory(Intent.CATEGORY_OPENABLE);
                    i.setType("image/*");
//                    Content.this.startActivityForResult(Intent.createChooser(i, "File Chooser"), FILECHOOSER_RESULTCODE);

                }

                // For Android 3.0+
                public void openFileChooser(ValueCallback uploadMsg, String acceptType) {
                    mUploadMessage = uploadMsg;
                    Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                    i.addCategory(Intent.CATEGORY_OPENABLE);
                    i.setType("*/*");
//                    MainActivity.this.startActivityForResult(
//                            Intent.createChooser(i, "File Browser"),
//                            FILECHOOSER_RESULTCODE);
                }

                //For Android 4.1
                public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
                    mUploadMessage = uploadMsg;
                    Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                    i.addCategory(Intent.CATEGORY_OPENABLE);
                    i.setType("image/*");
//                    activity.this.startActivityForResult(Intent.createChooser(i, "File Chooser"), Content.FILECHOOSER_RESULTCODE);
                }

            });
//            rootView.setContentView(myWebView);
            myWebView.loadUrl(URL);
            mRegistrationBroadcastReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
//                mRegistrationProgressBar.setVisibility(ProgressBar.GONE);
                    SharedPreferences sharedPreferences =
                            PreferenceManager.getDefaultSharedPreferences(context);
                    boolean sentToken = sharedPreferences
                            .getBoolean(QuickstartPreferences.SENT_TOKEN_TO_SERVER, false);
                }
            };

            //Pull-to-refresh
            mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.container);
            mSwipeRefreshLayout.setOnRefreshListener(this);
            return rootView;
        }

        @Override
        public void onRefresh() {
            myWebView.reload();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }, 2000);
        }
    }

    public static class ExampsFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static ExampsFragment newInstance(int sectionNumber) {
            ExampsFragment fragment = new ExampsFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public ExampsFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.examps_content, container, false);
            FillData data = new FillData();
            data.FillExamps(fileString, rootView, this.getContext());
            return rootView;
        }
    }

    public static class WorkFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        public View rootView;

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static WorkFragment newInstance(int sectionNumber) {
            WorkFragment fragment = new WorkFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public WorkFragment() {
        }

        @Override
        public void onResume() {
            super.onResume();
        }

        @Override
        public void onPause() {
            super.onPause();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            //View rootView = inflater.inflate(R.layout.work_content, container, false);
            rootView = inflater.inflate(R.layout.work_content, container, false);
            //FillData data = new FillData(value, rootView);
            FillData data = new FillData();
           // data.FillWork(value, rootView);
            data.FillWork(fileString, rootView, this.getContext());
            return rootView;
        }
    }

    public static class PrefsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener{

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.preference_screen);
        }
        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            getView().setBackgroundColor(Color.WHITE);
            getView().setClickable(true);
        }

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if (key.equals("big_font")) {
                Preference pref = findPreference(key);
                pref.setSummary(sharedPreferences.getString(key, ""));
            }
            if (key.equals("fullscreen")) {
                Preference preference = findPreference(key);
                preference.setSummary(sharedPreferences.getString(key,""));
            }
        }
    }

    public static void showNoConnectionDialog(Context ctx1) {
        final Context ctx = ctx1;
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx, R.style.AlertDialog);
        builder.setCancelable(true);
        builder.setMessage(R.string.no_connection);
        builder.setTitle(R.string.no_connection_title);
        builder.setPositiveButton(R.string.settings_button_text, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                ctx.startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
            }
        });

        builder.setNegativeButton(R.string.cancel_button_text, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });

        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                return;
            }
        });

        builder.show();
    }


}
