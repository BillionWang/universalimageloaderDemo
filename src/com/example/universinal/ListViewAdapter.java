package com.example.universinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter{

	private ArrayList<ListViewItem> mArrayList;
	private Context mContext;
	private ImageLoader mImageLoader;
	private DisplayImageOptions options;
	
	public ListViewAdapter(ArrayList<ListViewItem> arraylist, Context context,ImageLoader imageLoader)
	{
		super();
		this.mArrayList = arraylist;
		Log.d("mArrayList", mArrayList.size()+"");
		this.mContext = context;
		this.mImageLoader = imageLoader;
		options = new DisplayImageOptions.Builder()
		.showImageOnFail(R.drawable.ic_launcher)
		.cacheInMemory(true)
		.cacheOnDisk(true)
		.build();
		Log.d("ListViewAdapter", "ListViewAdapter");
		
	}
	
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(mArrayList == null)
		{
			return 0 ; 
		}
		else {
			Log.d("mArrayList.size()", mArrayList.size()+"");
			return mArrayList.size();
		}
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		if(mArrayList==null)
		{
			return null;
		}
		else {
			return mArrayList.get(arg0);
		}
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder = null;
		if(arg1 ==null)
		{
			Log.d("arg1 ==null", "arg1 ==null");
			viewHolder = new ViewHolder();
			arg1 = LayoutInflater.from(this.mContext).inflate(R.layout.listviewitem, null,false);
			viewHolder.imageView = (ImageView) arg1.findViewById(R.id.imageview);
			viewHolder.textView = (TextView) arg1.findViewById(R.id.textview);
			arg1.setTag(viewHolder);
		}
		else {
			viewHolder = (ViewHolder) arg1.getTag();
		}
		
		if(this.mArrayList !=null)
		{
			
			ListViewItem listViewItem = this.mArrayList.get(arg0);
			if(viewHolder.textView !=null)
			{
				//Log.d("textView", "textView");
				viewHolder.textView.setText(listViewItem.getContent());
				Log.d("imageView", viewHolder.imageView+"");
			}
			
			if(viewHolder.imageView != null)
			{
				Log.d("loadImage", "loadImage");
				Log.d("getImageUrl", listViewItem.getImageUrl()+"");
				mImageLoader.displayImage(listViewItem.getImageUrl(), viewHolder.imageView, options);
				
			}
		}
		return arg1;
		
		
	}
	
	
	private class ViewHolder
	{
		ImageView imageView;
		TextView textView;
	}
	
	/*public static class ImageLoadingListenerImpl extends SimpleImageLoadingListener
	{
		public static final List<String> displayedImages = 
				Collections.synchronizedList(new LinkedList<String>());
		public void onLoadingComplete(String imageUri,View view,Bitmap bitmap)
		
	}*/
	
	
}
