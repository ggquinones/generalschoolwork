<!DOCTYPE html>
<html>
<title>Beach Ellum Luau</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
<link href="https://fonts.googleapis.com/css?family=Shadows+Into+Light" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body, html {height: 100%}
body,h1,h2,h3,h4,h5,h6 {font-family: 'Shadows Into Light', cursive;}
.menu {display: none}



#sectHeader{
	text-shadow: -2px 0 black, 0 2px black, 2px 0 black, 0 -2px black;
}
#homeWords{
	text-shadow: -2px 0 white, 0 2px white, 2px 0 white, 0 -2px white;
	
}

</style>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top ">
  
    <div class="container-fluid w3-xxlarge" >
		<div class="navbar-header">
				<a   class="navbar-brand w3-bold w3-xxlarge" href="index.html">Beach Ellum Luau</a>
		</div>
    </div>
</nav><!-- End of Navigation Bar Code -->
<?php
		 
	
	$DB_USER = "beachell_admin";
	$DB_PASSWORD = "ginnyrose";
	$DB_HOST = "localhost";
	$DB_NAME = "beachell_luaudb";
	$message ="";	
	$con = mysqli_connect($DB_HOST, $DB_USER, $DB_PASSWORD, $DB_NAME) 
	OR die('Could not connect to mySQL'. mysqli_connect_error());
	//echo("connected!");
	
	// Escape user inputs for security
	$first_name = mysqli_real_escape_string($con, $_POST['first_name']);
	$last_name = mysqli_real_escape_string($con, $_POST['last_name']);
	$email = mysqli_real_escape_string($con, $_POST['email']);
	$subject = mysqli_real_escape_string($con, $_POST['subject']);	
	$message = mysqli_real_escape_string($con, $_POST['message']);	
	$division = $_POST['divisions'];
	$looking_for = $_POST['lookingfor'];

	$sql = 
			"INSERT INTO msgbrd(`first_name`, `last_name`, `email`, `subject`, `message`, `division`, `looking_for`, `dop`) 
			VALUES ('$first_name','$last_name','$email','$subject','$message','$division','$looking_for',CURRENT_TIMESTAMP)";

	if(mysqli_query($con, $sql)){
		$flag = "Message posted successfully!";
	} else{
		$flag ="Error occured. Attempt to input again!";
	}

	





	 
	 
	// close connection
	mysqli_close($con);
?>

<div class="container w3-padding-64">
			  <div class="jumbotron w3-center">
				<h1><?php echo("$flag");?></h1>
				<button type="button" onClick="parent.location='index.html" class="w3-section w3-hide-small btn btn-primary w3-jumbo w3-center">Go Back to Home Page</button>
				<button type="button" onClick="parent.location='index.html" class="w3-section btn btn-primary w3-hide-medium w3-hide-large w3-large w3-center">Go Back to Home Page</button>	
				<br>
				<button type="button" onClick="parent.location='forum.php'" class="w3-section w3-hide-small btn btn-primary w3-jumbo w3-center">Go to Forum</button>
				<button type="button" onClick="parent.location='forum.php'" class="w3-section btn btn-primary w3-hide-medium w3-hide-large w3-large w3-center">Go to Forum</button>	
				
			  </div>  
		</div>
</body>
</html>


