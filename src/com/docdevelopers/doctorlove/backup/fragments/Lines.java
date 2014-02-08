package com.docdevelopers.doctorlove.backup.fragments;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.docdevelopers.doctorlove.backup.R;
import com.docdevelopers.doctorlove.backup.R.id;
import com.docdevelopers.doctorlove.backup.R.layout;
import com.docdevelopers.doctorlove.backup.data.Puller;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Lines extends Fragment 
{
	private ProgressDialog pDialog;
	private static String url = "http://pickup.docdevelopers.com/linepull.php";
	ListView lv;
	private static final String TAG_AUTHOR = "author";
	private static final String TAG_LINE = "line";
	private static final String TAG_DATE = "Date";
	
	JSONArray lines = null;
	
	ArrayList<HashMap<String,String>> cList;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{

        // setting The view for the activity as a variable
        View view = inflater.inflate(R.layout.frag2,container,false);

           // ArrayList for JSON data
         cList = new ArrayList<HashMap<String, String>>();

         lv = (ListView) view.findViewById(R.id.linesList);
         new GetLines().execute();
         
         
         
         return view;
         
	}
	
	

	private class GetLines extends AsyncTask<Void,Void,Void>
	{
		public GetLines()
		{
			
		}
		
		  protected void onPreExecute() {
	          super.onPreExecute();
	          // Showing progress dialog
	          pDialog = new ProgressDialog(getActivity());
	          pDialog.setMessage("Please wait...");
	          pDialog.setCancelable(false);
	          pDialog.show();
	
	      }
		
	
		@Override
		protected Void doInBackground(Void... arg0) 
		{
			Puller sh = new Puller();
			
			String jsonStr = sh.serviceCall(url,Puller.POST);
	
			
			
			if (jsonStr != null)
			{
				
				try 
				{
					JSONObject jsonObj = new JSONObject(jsonStr);
					lines = jsonObj.getJSONArray("lines");
					
					for(int i = 0; i< jsonStr.length(); i++)
					{
						JSONObject c = lines.getJSONObject(i);
						String author = c.getString(TAG_AUTHOR);
						
						String line = c.getString(TAG_LINE);
						String date = c.getString(TAG_DATE);
						
						HashMap<String, String> post = new HashMap<String, String>();
						post.put(TAG_AUTHOR, author);
						post.put(TAG_LINE, line);
						post.put(TAG_DATE, date);
						cList.add(post);
					}
				}
				catch (JSONException e) {
                    e.printStackTrace();
                }
			}
			
			else
			{
				// Something went wrong
			}
			// TODO Auto-generated method stub
			return null;
		}
		
		protected void onPostExecute(Void result)
		{
			super.onPostExecute(result);
            
			// Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */


            ListAdapter adapter = new SimpleAdapter(
                    getActivity(), cList,
                    R.layout.list_item, new String[] { TAG_AUTHOR, TAG_LINE,
                    TAG_DATE }, new int[] { R.id.author,
                    R.id.line, R.id.date });


                    lv.setAdapter(adapter);

		}
		
	}
}



