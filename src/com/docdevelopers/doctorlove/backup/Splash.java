package com.docdevelopers.doctorlove.backup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;



public class Splash extends Activity {
	
	protected boolean _active = true;
	protected int _splashTime = 1000;
	
		
	  	 
		 public void onCreate(Bundle savedInstanceState) {
		        requestWindowFeature(Window.FEATURE_NO_TITLE);
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.splash);
		

		        
		        
		        Thread splashTread = new Thread() {
		            @Override
		            public void run() {
		                try {
		                    int waited = 0;
		                    while(_active && (waited < _splashTime)) {
		                        sleep(100);
		                        if(_active) {
		                            waited += 100;
		                        }
		                    }
		                } catch(InterruptedException e) {
		                    // do nothing
		                } finally {
		                	
		                	
		                    finish();
		                    startActivity(new Intent(Splash.this, Input.class));
		                    
		                }
		            }
		        };
		        splashTread.start();
			
		}}
		
		 



		
		
		
