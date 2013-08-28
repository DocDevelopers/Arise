package com.docdevelopers.doctorlove.backup; 
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView; 

//Organizes Data
public class DataAdapter extends BaseAdapter {
	Context mContext; 
	
	private LayoutInflater mInflater;
	
	
	String[] line,author,date;
	

	public DataAdapter(Context c, String[] line, String[] author, String[] date) {
		this.line = line;
		this.author = author; 
		this.date = date;
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
			holder.line = (TextView) convertView
					.findViewById(R.id.line); 
			holder.author = (TextView) convertView.findViewById(R.id.author); 
			holder.date = (TextView) convertView.findViewById(R.id.date);
			if (position == 0) {
				convertView.setTag(holder);
			}
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		try {
			//Put data into layout
			holder.line.setText(line[position]);
			holder.author.setText("By:"+author[position]);
			holder.date.setText("Posted On:"+date[position]);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//WTF
			e.printStackTrace();
		} 
		return convertView;
	} 
	static class ViewHolder {
		TextView line,author,date; 
	}

}
