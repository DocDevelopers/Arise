package com.docdevelopers.doctorlove.backup; 
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView; 
public class DataAdapter extends BaseAdapter {
	Context mContext; 
	private LayoutInflater mInflater;
	String targetmonth;
	String targetyear;
	String targetamount; 
	String[] line;
	String[] author;
	public DataAdapter(Context c, String[] line, String[] author) {
		this.line = line;
		this.author = author; 
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
			holder.month = (TextView) convertView
					.findViewById(R.id.line); 
			holder.year = (TextView) convertView.findViewById(R.id.author); 
			
			if (position == 0) {
				convertView.setTag(holder);
			}
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		try {

			holder.month.setText(line[position]);
			holder.year.setText("By:"+author[position]);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return convertView;
	} 
	static class ViewHolder {
		TextView month;
		TextView year, amount; 
	}

}
