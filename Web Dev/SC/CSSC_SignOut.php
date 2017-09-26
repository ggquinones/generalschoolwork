<?php
		
	require "CSSC_DBConnect.php";
	require "CSSC_phpScripts.php";
	
	// Escape user inputs for security
	$user_name = mysqli_real_escape_string($con, $_REQUEST['username']);
	$groupID = $_REQUEST['group'];
	$perDone = intval($_REQUEST['percentDone']);
	
	if((recognizedUserInGroup($user_name,$groupID)) && (!hasSignedOutToday($user_name)))
	{
		$sql =
		"
			INSERT INTO csscSignOut(ipfwUsername,groupId,percentDone) 
			 VALUES ('$user_name','$groupID','$perDone')
		";

		if(mysqli_query($con, $sql))
		{
			$flag = "You signed out successfully! Bye!";
		}
		else{$flag ="Error occured. Attempt to input again or email us at scholarchats@gmail.com";}
	}
	else if(!recognizedUserInGroup($user_name,$groupID))
	{
		$flag ="Error occured. No group member with that username!";
	}
	else if(hasSignedOutToday($user_name))
	{
		$flag ="Error occured. You have already signed out today!";
	}
	else
	{
		$flag ="Error occured. Attempt to input again or email us at scholarchats@gmail.com";
	}
	
	mysqli_close($con);
	
	
	
	
	
	

?>
<!DOCTYPE html>

<html>
<head>
	<title>Scholar Chats</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Orbitron" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>		  
	
	<style>    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
	
	body,h1,h2,h3,h4,h5,h6 {font-family: 'Orbitron', cursive;
	height:100%;
}
	
	
  </style>
  
</head> 
  
<body style="background: transparent;">
<!-- NavBar -->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="index.html"><img src="don2.png" alt="CSSC Logo" width="30" height="30"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="index.html">Home</a></li>
        <li><a href="CSSC_GroupSchedules.html">Mentor Groups</a></li>
		<li><a href="CSSC_SignUp.html">Sign Up</a></li>
		<li class="active"><a href="CSSC_ScholarPortal.html">Scholar Portal</a></li>
		<li><a href="CSSC_AdminPortalLogIn.html">Admin Portal</a></li>
      </ul>      
    </div>
  </div>
</nav>
<!-- NavBar End -->

<!-- Main Container -->
	<div class ="container-fluid">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div class="well w3-center">
					<h1><?php echo($flag);?></h1>
					<button type="button" onClick="parent.location='CSSC_ScholarPortal.html'" class=" w3-hide-small btn btn-primary w3-large w3-center">Go Back to Scholar Portal</button>
					<button type="button" onClick="parent.location='CSSC_ScholarPortal.html'" class="btn btn-primary w3-hide-medium w3-hide-large w3-medium w3-center">Go Back to Scholar Portal</button>	
				</div>	
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>

</body>


</html>






















