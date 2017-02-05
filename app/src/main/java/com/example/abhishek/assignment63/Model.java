package com.example.abhishek.assignment63;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.ListFragment;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Model extends ListFragment {

    String[] title={"Youtube","Blogger"};
    String[] description={"Youtube Description","Blogger Description"};

    int[] desimg={R.drawable.youtube,R.drawable.blogger};

    ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
    SimpleAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //MAP
        HashMap<String, String> map=new HashMap<String, String>();
        //FILL
        for(int i=0;i<title.length;i++)
        {
            map=new HashMap<String, String>();
            map.put("Title", title[i]);
            map.put("Des", description[i]);
            map.put("Image", Integer.toString(desimg[i]));
            data.add(map);
        }
        //KEYS IN MAP
        String[] from={"Title","Des","Image"};
        //IDS OF VIEWS
        int[] to={R.id.nameTxt,R.id.textDes,R.id.imageView1};
        //ADAPTER
        adapter=new SimpleAdapter(getActivity(), data, R.layout.model, from, to);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos,
                                    long id) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(), data.get(pos).get("Player"), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
