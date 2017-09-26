<?php
/* Attempt MySQL server connection. Assuming you are running MySQL
server with default setting (user 'root' with no password) */
$con=mysqli_connect("Localhost","dallascu_admin","ginnyq11","dallascu_dallascup");

// Check connection
if($con === false){
    die("<br><br><br><br><br>ERROR: Could not connect. " . mysqli_connect_error());
}
 
// Escape user inputs for security
$first_name = mysqli_real_escape_string($con, $_REQUEST['firstname']);

$last_name = mysqli_real_escape_string($con, $_REQUEST['lastname']);
$message = mysqli_real_escape_string($con, $_REQUEST['message']);
 
// attempt insert query execution
$sql = "INSERT INTO messages (firstname, lastname, message) VALUES ('$first_name', '$last_name', '$message')";
if(mysqli_query($con, $sql)){
    $okay="Message sent successfully!";
} else{
    echo "<br><br><br><br><br>ERROR: Could not able to execute $sql. " . mysqli_error($con);
}
 
// close connection
mysqli_close($con);
?>

<!DOCTYPE html>
<html>
<title>Metroplex Summer Joust</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body, html {height: 100%}
body,h1,h2,h3,h4,h5,h6 {font-family: "Amatic SC", sans-serif}
.menu {display: none}



#sectHeader{
	text-shadow: -2px 0 black, 0 2px black, 2px 0 black, 0 -2px black;
}
#homeWords{
	text-shadow: -2px 0 white, 0 2px white, 2px 0 white, 0 -2px white;
	
}

</style>
<body>


<!-- Navigation Bar for the website. Clipped to top of webpage. -->
<nav class="navbar navbar-inverse navbar-fixed-top ">
  
    <div class="container-fluid w3-xxlarge" >
		<div class="navbar-header">
				<a   class="navbar-brand w3-bold w3-xxlarge" href="index.html">MSJ 2017</a>
		</div>
    </div>
</nav><!-- End of Navigation Bar Code -->

<!--  Header Div -->
<div class="container w3-padding-64">
	  <div class="jumbotron w3-center">
		<h1><?php echo($okay);?></h1>
		<button type="button" onClick="parent.location='index.html'" class=" w3-hide-small btn btn-primary w3-jumbo w3-center">Go Back to Home Page</button>
		<button type="button" onClick="parent.location='index.html'" class="btn btn-primary w3-hide-medium w3-hide-large w3-large w3-center">Go Back to Home Page</button>		
	  </div>
	  
	  
</div>
 <!-- End Header Div -->

</body>
</html>