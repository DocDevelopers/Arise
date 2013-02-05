package com.docdevelopers.doctorlove.backup; 
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader; 
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList; 
import java.util.Random;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject; 
import android.app.Activity; 
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;  
import android.widget.ListView;
import android.widget.Toast;

/*
 * author firzan
 * 
 */
public class DemoMySqlPhpActivity extends Activity {
	JSONArray jArray;
	String result = null;
	InputStream is = null;
	StringBuilder sb = null; 
	ArrayList<String> al = new ArrayList<String>();
	ArrayList<String> al1 = new ArrayList<String>();
	Random generator = new Random();
	
	String line;
	String author;
	int responseCode;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo);
		setTitle("Pick up line of the day");  
		try {
			URL url = new URL("http://pickup.docdevelopers.com/linepull.php");
			URLConnection connection = url.openConnection();
			connection.setConnectTimeout(5000);
			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			responseCode = httpConnection.getResponseCode();
		} 
	catch (Exception e) {} 
		try{
			if(isNetworkAvailable()==true ){
				new LoadData().execute();
			}
			else{
				AlertDialog.Builder ad=new AlertDialog.Builder(this);
				ad.setMessage("Nigga get some internet!!!");
				ad.show();
			}
		}
		catch(Exception e){
			
		}
	}
	
	private class LoadData extends AsyncTask<Void, Void, Void> { 
		private ProgressDialog progressDialog;  
		@Override
		// can use UI thread here
		protected void onPreExecute() {
		this.progressDialog = ProgressDialog.show(DemoMySqlPhpActivity.this, ""," Loading...");  
		}
		@Override
		protected void onPostExecute(final Void unused) {  
			 this.progressDialog.dismiss();	
			try{
	 				 ListView listview = (ListView) findViewById(R.id.listView1);  
	 				this.progressDialog.dismiss();	
				     listview.setAdapter(new DataAdapter(DemoMySqlPhpActivity.this,al.toArray(new String[al.size()]),al1.toArray(new String[al1.size()])));
				     
				}
	 			catch(Exception e){
	 				
	 				Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
	 			} 
	 			
		}
		
		@Override
		protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub  
			// HTTP post
			 
					try {
						
						ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
						HttpClient httpclient = new DefaultHttpClient(); 
						try{
						HttpPost httppost = new HttpPost("http://pickup.docdevelopers.com/linepull.php");
						httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
						HttpResponse response = httpclient.execute(httppost);
						HttpEntity entity = response.getEntity();
						is = entity.getContent();
						
						}
						catch(Exception e){
							Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
						}
						//buffered reader
						try{
						BufferedReader reader = new BufferedReader(new InputStreamReader(
								is, "iso-8859-1"), 80);
						sb = new StringBuilder();
						sb.append(reader.readLine() + "\n");
						String line = "0";
						while ((line = reader.readLine()) != null) {
							sb.append(line + "\n");
						}
						is.close();
						result = sb.toString();
						}
						catch(Exception e){
							Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
						}
						try{
						jArray = new JSONArray(result);
						JSONObject json_data = null;
						int which = generator.nextInt(jArray.length());
						
							json_data = jArray.getJSONObject(which); 
							line=json_data.getString("line");
							author=json_data.getString("author");
							al.add(line); 
							al1.add(author);
							 
						
					}
					catch(JSONException e){
						Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
					}	
					} catch (ParseException e) {
					//	Log.e("log_tag", "Error in http connection" + e.toString());
						Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
					}  
					 catch (Exception e) {
							//	Log.e("log_tag", "Error in http connection" + e.toString());
								Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
							}  		
			 
			 
			return null;
	 
		}
	}
 
	public boolean isNetworkAvailable() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = cm.getActiveNetworkInfo();
		// if no network is available networkInfo will be null, otherwise check
		// if we are connected
		if (networkInfo != null && networkInfo.isConnected()) {

			// Log.i("net status:", "Online...!!!");
			return true;
		}
		// Log.i("net status:", "offline...!!!");
		return false;
	}
}
