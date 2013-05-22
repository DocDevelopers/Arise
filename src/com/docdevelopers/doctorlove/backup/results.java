//Package Name
package com.docdevelopers.doctorlove.backup;

//Imports
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


import java.util.Random;


//Main Class
public class results extends Activity implements OnClickListener {

//Variables	
int count,percent;
Button Big_Heart,retry;
//Random Generator
Random getrandom =new Random();


      @Override
	  public void onCreate(Bundle savedInstanceState) {
    	  
    	  final String first_box = getIntent().getExtras().getString("first");
    	  final String second_box = getIntent().getExtras().getString("second");
    	  
    	  Log.v("Name uno", first_box);
    	  Log.v("Name dos", second_box);
    	  //Request window with no title
    	  requestWindowFeature(Window.FEATURE_NO_TITLE);
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.result);
	        Toast.makeText(getApplicationContext(), "Calculating...", Toast.LENGTH_SHORT).show();
	        Button retry= (Button) findViewById(R.id.retry);
	        retry.setOnClickListener(this);
	        final Button chance= (Button) findViewById(R.id.heartpercent);
	        
	       
	        //when you want to start the counting start the thread bellow.
	          new Thread(new Runnable() {
	        	  		
	                        public void run() {
	                        	
	                        	if(first_box.equals("Francisco Castellanos") && second_box.equals("Jaila Satchell") || 
	                        	   first_box.equals("Francisco") && second_box.equals("Jaila")||
	                        	   first_box.equals("francisco") && second_box.equals("jaila")||
	                        	   first_box.equals("francisco castellanos") && second_box.equals("jaila satchell")){
	                      		  
	                        		count=100;
	                      		  
	                      	  }
	                        	else if(first_box.equals("January") && second_box.equals("Maria")||
	                        			first_box.equals("january") && second_box.equals("maria")||
	                        			first_box.equals("January Llaverias") && second_box.equals("Maria Jose")||
	                        			first_box.equals("january llaverias") && second_box.equals("maria jose")||
	                        			first_box.equals("Maria") && second_box.equals("January")||
	                        			first_box.equals("maria") && second_box.equals("january")||
	                        			first_box.equals("maria jose") && second_box.equals("january llaverias")||
	                        			first_box.equals("Maria Jose") && second_box.equals("January Llaverias")){
	                        		
	                        		count=200;
	                            }
	                        	
	                        	else if(first_box.equals("January") != second_box.equals("Maria")||
	                        			first_box.equals("january") != second_box.equals("maria")||
	                        			first_box.equals("January Llaverias") != second_box.equals("Maria Jose")||
	                        			first_box.equals("january llaverias") != second_box.equals("maria jose")||
	                        			first_box.equals("Maria") != second_box.equals("January")||
	                        			first_box.equals("maria") != second_box.equals("january")||
	                        			first_box.equals("maria jose") != second_box.equals("january llaverias")||
	                        			first_box.equals("Maria Jose") != second_box.equals("January Llaverias")){
	                        		
	                        		count=0;
	                        				}
	                        	else if(first_box.equals("Chris") && second_box.equals("Diana")||
	                        			first_box.equals("chris") && second_box.equals("diana")||
	                        			first_box.equals("Chris Pirillo") && second_box.equals("Diana Pirillo")||
	                        			first_box.equals("chris pirillo") && second_box.equals("diana pirillo")||
	                        			first_box.equals("Diana") && second_box.equals("Chris")||
	                        			first_box.equals("diana") && second_box.equals("chris")||
	                        			first_box.equals("diana pirillo") && second_box.equals("chris pirillo")||
	                        			first_box.equals("Diana Pirillo") && second_box.equals("Chris Pirillo")){
	                        		
	                        		count=100;
	                        		
	                        	}
	                        	else if(first_box.equals("Chris") != second_box.equals("Diana")||
	                        			first_box.equals("chris") != second_box.equals("diana")||
	                        			first_box.equals("Chris Pirillo") != second_box.equals("Diana Pirillo")||
	                        			first_box.equals("chris pirillo") != second_box.equals("diana pirillo")||
	                        			first_box.equals("Diana") != second_box.equals("Chris")||
	                        			first_box.equals("diana") != second_box.equals("chris")||
	                        			first_box.equals("diana pirillo") != second_box.equals("chris pirillo")||
	                        			first_box.equals("Diana Pirillo") != second_box.equals("Chris Pirillo")){
	                        		
	                        		count=0;
	                        		
	                        	}
	                      	  else{
	                      		
	                      		  count= getrandom.nextInt(100);
	                      		
	                      	  }
	                        	
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
	                           
	                        }

	                    }).start();
	          
	        
      
      }
      
      
	        
	   //on button click     
	   public void onClick(View v) {
		//call method
		   activity();
		   }
	//Intent
	public void activity(){
		Intent myIntent = new Intent(results.this, Input.class);
		startActivity(myIntent);
		}

}

     
	  




