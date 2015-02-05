package com.example.universinal;

import java.util.ArrayList;

import com.nostra13.universalimageloader.core.ImageLoader;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class MainActivity extends Activity {

	private ListView mlListView;
	private ImageLoader mImageLoader;
	private Context mContext;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    
    public void initView()
    {
    	mContext  = this;
    	mImageLoader = ImageLoader.getInstance();
    	mlListView = (ListView) findViewById(R.id.listview);
    	ArrayList<ListViewItem> arrayList = new ArrayList<ListViewItem>();
    	String[] imageUrl = ImageUrl.Urls;
    	ListViewItem listViewItem = null;
    	for(int i = 0;i< imageUrl.length;i++)
    	{
    		listViewItem = new ListViewItem("This is "+i, imageUrl[i]);
    		arrayList.add(listViewItem);
    	}
    	
    	ListViewAdapter adapter = new ListViewAdapter(arrayList,mContext,mImageLoader);
    	Log.d("mainArraylist", arrayList.size()+"");
    	mlListView.setAdapter(adapter);
    }
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	super.onDestroy();
    	
    }
    
    


}
