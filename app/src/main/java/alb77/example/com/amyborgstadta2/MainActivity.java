package alb77.example.com.amyborgstadta2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.examples.alb77.amyborgstadta2.FragmentList;

import java.net.URL;


public class MainActivity extends FragmentActivity  {

    boolean webPage = false;
    static View.OnClickListener myOnClickListener;
    static FragmentList listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myOnClickListener = new MyOnClickListener(this);

        private class MyOnClickListener implements View.OnClickListener{
            private final Context context;
            private MyOnClickListener(Context context){ this.context = context;}
            @Override
            public void onClick(View view){
                String URL = listFragment.getItem(view);
            }
        }

        if (savedInstanceState == null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            FragmentList listFragment = new FragmentList();
            ft.add(R.id.fragment_list_container, listFragment);
            ft.commit();
        }

        if (findViewById(R.id.fragment_web_container) != null) {
            webPage = true;
            getFragmentManager().popBackStack();

            FragmentWebView webFragment = (FragmentWebView) getFragmentManager().findViewById(R.id.fragment_web_container);

            if (webFragment == null) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                webFragment = new FragmentWebView();
                ft.replace(R.id.fragment_web_container, webFragment);
                ft.commit();
            }
        }
    }
        @Override
        public  void onURLSelected(String URL){

            if (webPage){
                FragmentWebView webFragment = (FragmentWebView) getFragmentManager().findFragmentById(R.id.fragment_web_container);
                webFragment.updateURLContent(URL);
            }else{
                FragmentWebView webFragment = new FragmentWebView();
                webFragment.setmURLContent(URL);
                FragmentTransaction ft = new getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_list_container,webFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        }
    }







