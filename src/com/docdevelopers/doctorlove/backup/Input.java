package com.docdevelopers.doctorlove.backup;




import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Input extends Activity implements OnClickListener {
//Variables 
Button calculate;
EditText first,second;
String man,girl,name_one,name_two;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
    	
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);
        //Heart Button
        calculate = (Button) findViewById(R.id.heart_button);
        first= (EditText) findViewById(R.id.First_name);
        second = (EditText) findViewById(R.id.second_name);
      
       

        //Listen for click
        calculate.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                    	name_one=first.getText().toString();
                        name_two=second.getText().toString();
                       
                        Log.v("EditText", first.getText().toString());
                        Log.v("EditText", second.getText().toString());
                        
                        activity();
                    }
                });
        
        
    }
        
   

    public void onClick(View v) {
    	
    //Nothing in here dirty code.
        
    	
       
    	
    	
    	}
    
    
    

public void activity(){
	if(first.getText().toString().equals("")|| name_two.equals("")){
		Toast.makeText(getApplicationContext(), "Please Fill in Both Boxes", Toast.LENGTH_SHORT).show();
    }
	else{
	Intent myIntent = new Intent(Input.this, results.class);
	myIntent.putExtra("first",name_one);
	myIntent.putExtra("second",name_two);

	startActivity(myIntent);
	}
	}
    
}