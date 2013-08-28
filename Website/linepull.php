<?php

//Connect To DB
mysql_connect("host", "username", "password") or die(mysql_error());
//Select DB
mysql_select_db("pickup_lines") or die(mysql_error());

//Query
$sql=mysql_query("SELECT author,line,DATE_FORMAT(created,'%m/%d/%Y') Date,likes FROM pick_lines"); 


while($row=mysql_fetch_assoc($sql)){
//Make array of pickup lines
$output[]=$row;
}

//Echo pickup lines in json format
echo json_encode($output); 
   
   
mysql_close(); 

?>


 