package com.docdevelopers.doctorlove.backup;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class frag1 extends Fragment {
	//Variables 
	Button calculate;
	EditText first,second;
	String man,girl,name_one,name_two;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{

        // setting The view for the activity as a variable
        View view = inflater.inflate(R.layout.frag1,container,false);
      
        super.onCreate(savedInstanceState);
  
        //Heart Button
        calculate = (Button) view.findViewById(R.id.heart_button);
        first= (EditText) view.findViewById(R.id.First_name);
        second = (EditText) view.findViewById(R.id.second_name);
        
        //Listen for click
        calculate.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                    	if(first.getText().toString().equals("") || second.getText().toString().equals(""))
                    	{
                    		Toast.makeText(getActivity(),"Please Fill in both boxes",Toast.LENGTH_SHORT).show();
                    	}
                    	else
                    	{
                        name_one=first.getText().toString();
                        name_two=second.getText().toString();
                                        
                        FragmentManager fragmentManager = getFragmentManager();
            			fragmentManager.beginTransaction()
            					.replace(R.id.frame_container, new result()).commit();
                    	}
                    }
                });
       
        return view;
	}
	
	 public void onClick(View v) {
         
		    //Nothing in here dirty code.
		        //Test Github Here
		            }
		    
		    
		    

		
	
}
