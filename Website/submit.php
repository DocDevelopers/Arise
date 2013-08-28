<?php



mysql_connect("host", "user_name", "password") or die(mysql_error());
mysql_select_db("pickup_lines") or die(mysql_error());


$author= $_POST["name"];
$line = $_POST["line"];















if($line != "" && $author != ""){

$query="INSERT INTO pick_lines (line_id,author,line,created) VALUES (null, '$author','$line',null)";



$result = mysql_query($query);

 echo "Thanks for submitting your pickup line.Please download  <a href=\"http://go.docdevelopers.com/love\">Doctor Love</a> on valentines day to
see if your pickup line was first.";

}

else{
    echo "<font color='#696969'>Looks like you did not fill out the whole form. Please go back and fill it</font>";
    exit;
}


?>
