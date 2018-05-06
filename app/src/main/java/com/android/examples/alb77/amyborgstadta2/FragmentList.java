package com.android.examples.alb77.amyborgstadta2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alb77 on 3/19/2018.
 */

public class FragmentList extends Fragment {

    OnURLSelectedListener mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_view,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        displayListView();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        if(context instanceof Activity){
            try{
                mListener = (OnURLSelectedListener)(Activity) context;
            }catch(ClassCastException e){
                throw new ClassCastException(context.toString()+"must be implement OnURLSelectedListener");
            }
        }
    }

    public interface OnURLSelectedListener{
        public void onURLSelected(String URL);
    }
}

private void displayListView(){
    final List<String> webList = new ArrayList<String>();
    webList.add("University of Central Missouri");
    webList.add("Computer Science - UCM");
    webList.add("CS Faculty - UCM");

    final List<String> urlList = new ArrayList<String>();
    urlList.add("htt;://www.ucmo.edu");
    urlList.add("http://www.ucmo.edu/cs");
    urlList.add("http://www.ucmo.edu/cs/faculty.cfm");

    ArrayAdapter<String>dataAdapter = new ArrayAdapter<String>(getActivity(),R.layout.web_list,webList);
    ListView listView = (ListView)getView().findViewById(R.id.webpagelist);

    listView.setAdapter(dataAdapter);
    listView.setTextFilterEnabled(true);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
        public void onItemClick(AdapterView<?>parent,View view,int position,long id){
            mListener.onURLSelected(urlList.get(position));
    }
});
}
