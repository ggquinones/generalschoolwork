<?php

?>

<!DOCTYPE html>
<html>
<title>Beach Ellum Luau</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="https://fonts.googleapis.com/css?family=Shadows+Into+Light" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body, html {height: 100%}
body,h1,h2,h3,h4,h5,h6 {font-family: 'Shadows Into Light', cursive;}
.menu {display: none}


.bgimg {
    background-repeat: no-repeat;
    background-size: 70% 50%;		
    background-image: url("jousting.jpg");
	background-position: center;
    min-height: 90%;
}
#sectHeader{
	text-shadow: -2px 0 black, 0 2px black, 2px 0 black, 0 -2px black;
}
#homeWords{
	text-shadow: -2px 0 white, 0 2px white, 2px 0 white, 0 -2px white;
}

</style>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top w3-xxlarge">
	  <div class="container-fluid">
		<div class="navbar-header">
		  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>                        
		  </button>
		  <a class="navbar-brand" href="index.html">Beach Ellum Luau</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
		  <ul class="nav navbar-nav">
			<li class="active"><a href="index.html">Home</a></li>
			<li><a href="SignUp.html">Sign Up</a></li>
			<li><a href="forum.php">Find a Player/Team</a></li>
			<li><a href="contactus.html">Contact Us</a></li>
		  </ul>
		  
		</div>
	  </div>
	</nav>
	
	<div class="header " style="margin-top:70px;">
		<div class="w3-round-medium jumbotron w3-center w3-blue w3-margin">
		<h1 class="w3-text-black"> Welcome to the our Forum: <h1>
		<div class="w3-container w3-text-white ">
			<p>Below you will find a tables containing posts made by other players in need of:<br> 
			(1) Players to complete their teams<br> 
			OR<br> 
			(2) Teams to play in<br>	
			If you are interested in a message, use the email provided at the bottom of every post.
			
			
			</p>
			
			<span class="w3-black w3-text-red w3-center w3-xxlarge">Don't see what you're looking for? <span><br>
			
		</div>
		<br>
		<button class="btn w3-green w3-round-medium w3-jumbo w3-hide-small" >Post on our Forum!</button>
		<button class="btn w3-green w3-round-medium w3-xxlarge w3-hide-large w3-hide-medium">Post on our Forum!</button>
		</div>
	</div>
	<?php
					
					$DB_USER = "beachell_admin";
					$DB_PASSWORD = "ginnyrose";
					$DB_HOST = "localhost";
					$DB_NAME = "beachell_luaudb";
						
					$con = mysqli_connect($DB_HOST, $DB_USER, $DB_PASSWORD, $DB_NAME) 
					OR die('Could not connect to mySQL'. mysqli_connect_error());
					//echo("connected!");
					
					//Teams seeking Player
					$sql_getPlayers = "SELECT * FROM msgbrd WHERE looking_for = 'player'";
					$result_getPlayers = $con->query($sql_getPlayers);
					if ($result_getPlayers->num_rows > 0) {
						echo("<h1 class='w3-red w3-center w3-xxlarge'>Teams seeking Player</h1>");
						// output data of each row
						while($row = $result_getPlayers->fetch_assoc()) {
							
								echoPost($row['first_name'],$row['last_name'],$row['email'],$row['subject'],$row['message'],$row['dop'],$row['looking_for'],$row['division']);
						}
						
					} else {
						echo "0 results";
					}
					//Players seeking Team
					$sql_getTeams = "SELECT * FROM msgbrd WHERE looking_for = 'team'";
					$result_getTeams = $con->query($sql_getTeams);

					if ($result_getTeams->num_rows > 0) {
						echo("<h1 class='w3-red w3-center w3-xxlarge'>Players seeking Team</h1>");
						// output data of each row
						while($row = $result_getTeams->fetch_assoc()) {
							
								echoPost($row['first_name'],$row['last_name'],$row['email'],$row['subject'],$row['message'],$row['dop'],$row['looking_for'],$row['division']);
						}
						
					} else {
						echo "0 results";
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					$con->close();
					
					function echoPost($fn,$ln,$email,$subject,$message,$dop,$looking_for,$division) {
					$message = rtrim($message);
					
					echo ("
								
									<div class='row w3-cyan w3-margin w3-xlarge' >
										<div class='w3-col m2 center-block ' ><p></p></div>
									
										<div class='w3-col m8 w3-container center-block'>
											<div class='panel panel-primary w3-margin'>					
												<div class='container-fluid panel-heading ' >
												<p class='w3-third' >$fn $ln </p>      <p class='w3-third'> $subject      $division </p>       <p class='w3-third'> $dop</p>  
												</div>						
												<div class='panel-body'>$message</div>					
												<div class='panel-footer'>Contact $fn $ln at $email</div>
											</div>
										</div>
										
										<div class='w3-col m2 center-block'><p></p></div>
									</div>
								
						");
				}
					
				?> 
	
</body>
</html>
