package com.docdevelopers.doctorlove.backup; 
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView; 
public class DataAdapter extends BaseAdapter {
	Context mContext; 
	
	private LayoutInflater mInflater;
	
	String[] line;
	String[] author;
	String[] date;
	String[] likes;
	public DataAdapter(Context c, String[] line, String[] author,String[] date,String[] likes) {
		this.line = line;
		this.author = author; 
		this.date = date;
		this.likes = likes;
		mContext = c;
		mInflater = LayoutInflater.from(c); 
	} 
	public int getCount() {
		return line.length;
	} 
	public Object getItem(int position) {
		return position;
	} 
	public long getItemId(int position) {
		return position;
	} 
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.customgrid, parent, false);
			holder = new ViewHolder();
			holder.line = (TextView) convertView.findViewById(R.id.line); 
			holder.author = (TextView) convertView.findViewById(R.id.author); 
			holder.date = (TextView) convertView.findViewById(R.id.date);
			holder.like = (TextView) convertView.findViewById(R.id.likes);
			if (position == 0) {
				convertView.setTag(holder);
			}
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		try {

			holder.line.setText(line[position]);
			holder.author.setText("By:"+author[position]);
			holder.date.setText("Submitted On:"+date[position]);
			holder.like.setText("Likes:"+likes[position]);
		

		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//WTF
			e.printStackTrace();
		} 
		return convertView;
	} 
	static class ViewHolder {
	
		TextView line,author, date,like; 
	}

}

