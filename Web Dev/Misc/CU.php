<?php
		 
	
	$DB_USER = "champi14_admin";
	$DB_PASSWORD = "champions";
	$DB_HOST = "localhost";
	$DB_NAME = "champi14_database";
	$message ="";	
	$con = mysqli_connect($DB_HOST, $DB_USER, $DB_PASSWORD, $DB_NAME) 
	OR die('Could not connect to mySQL'. mysqli_connect_error());
	//echo("connected!");
	
	// Escape user inputs for security
	$first_name = mysqli_real_escape_string($con, $_POST['firstName']);
	$last_name = mysqli_real_escape_string($con, $_POST['lastName']);
	$email = mysqli_real_escape_string($con, $_POST['email']);	
	$message = mysqli_real_escape_string($con, $_POST['message']);	


	$sql = 
			"INSERT INTO Messages(`firstName`, `lastName`, `email`, `message`) 
			VALUES ('$first_name','$last_name','$email','$message')";
			

	if(mysqli_query($con, $sql))
	{$flag = "Message posted successfully!";}
	else
	{$flag ="Error occured. Attempt to input again!"; }
	// close connection
	mysqli_close($con);
?>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Champion Beach Volleyball Club</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Shadows+Into+Light" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
	
	body,h1,h2,h3,h4,h5,h6 {font-family: 'Shadows Into Light', cursive;

	height:100%;
}
	body{font-size:25px;
	
	}
	
  </style>
</head>
<body >

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="cbvc.html"><img src="CBVCLogo.png" alt="CBVC Logo" width="50" height="30"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="cbvc.html">Home</a></li>
        <li><a href="cbvcstaff.html">Staff</a></li>
		<li><a href="cbvcinfo.html">Club Information</a></li>
		<li><a href="cbvcevents.html">Camps & Clinics</a></li>
		<li><a href="cbvcplayers.html">Player Gallery</a></li>
		<li ><a href="cbvcwof.html">Wall of Fame</a></li>
      </ul>
    </div>
  </div>
</nav>
 
 <!--  Header Div -->
<div class="container w3-padding-64">
	  <div class="jumbotron w3-center">
		<h1><?php echo($flag);?></h1>
		<button type="button" onClick="parent.location='cbvc.html'" class=" w3-hide-small btn btn-primary w3-jumbo w3-center">Go Back to Home Page</button>
		<button type="button" onClick="parent.location='cbvc.html'" class="btn btn-primary w3-hide-medium w3-hide-large w3-large w3-center">Go Back to Home Page</button>		
	  </div>
	  
	  
</div>
 <!-- End Header Div -->

	
	
<footer class="container-fluid text-center ">
  <p>Footer Text</p>
</footer>

</body>
</html>
