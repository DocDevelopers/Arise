package com.docdevelopers.doctorlove.backup;

import java.util.Random;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class result extends Fragment {
	int count,percent;
	Button Big_Heart,retry;
	Random getrandom =new Random();
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{

        // setting The view for the activity as a variable
        View view = inflater.inflate(R.layout.result,container,false);
        final Button chance = (Button) view.findViewById(R.id.heartpercent);
        final Button retry= (Button) view.findViewById(R.id.retry);
        
        
        

        //when you want to start the counting start the thread bellow.
          new Thread(new Runnable() {
                                  
                        public void run() {
                         count= getrandom.nextInt(100);
                                      
                                
                                
                            while (percent < count) {
                                    
                                try {
                                    Thread.sleep(30);
                                } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                chance.post(new Runnable() {

                                    public void run() {
                                            
                                        chance.setText(percent+"%");
                                        
                                   
                                              
                                    }

                                });
                                
                                percent++;
                            }
                            
                            retry.setOnClickListener(
                                    new View.OnClickListener()
                                    {
                                        public void onClick(View view)
                                        {
                                        	 FragmentManager fragmentManager = getFragmentManager();
                                 			fragmentManager.beginTransaction()
                                 					.replace(R.id.frame_container, new frag1()).commit();
                                        }	
                                    });
                           
                        }

                    }).start();
          
        
       
        return view;
	}
}
