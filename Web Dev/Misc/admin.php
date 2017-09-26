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
		<li><a href="CU.html">Club Information</a></li>
		<li><a href="cbvcevents.html">Camps & Clinics</a></li>
		<li><a href="cbvcplayers.html">Player Gallery</a></li>
		<li ><a href="cbvcwof.html">Wall of Fame</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid w3-padding-64">    
  <?php
	$DB_USER = "champi14_admin";
	$DB_PASSWORD = "champions";
	$DB_HOST = "localhost";
	$DB_NAME = "champi14_database";
	$message ="";	
	$con = mysqli_connect($DB_HOST, $DB_USER, $DB_PASSWORD, $DB_NAME) 
	OR die('Could not connect to mySQL'. mysqli_connect_error());
	//echo("connected!");
	
	// Messages Query
	$sql_getMessages = "SELECT * FROM Messages";
					$result_getMessages = $con->query($sql_getMessages);
					if ($result_getMessages->num_rows > 0) {
						echo("<h1 class='w3-red w3-center w3-xxlarge'>Messages</h1>");
						// output data of each row
						while($row = $result_getMessages->fetch_assoc()) {
							
								echoPost($row['firstName'],$row['lastName'],$row['email'],$row['message']);
						}
						
					} else {
						echo "No Messages!";
					}
		$con->close();
					
					function echoPost($fn,$ln,$email,$message) {
					$message = rtrim($message);
					
					echo ("
								
									<div class='row w3-cyan w3-margin w3-xlarge' >
										<div class='w3-col m2 center-block ' ><p></p></div>
									
										<div class='w3-col m8 w3-container center-block'>
											<div class='panel panel-primary w3-margin'>					
												<div class='container-fluid panel-heading ' >
												<p class='w3-third' >$fn $ln </p>      <p class='w3-rest'> $email</p>  
												</div>						
												<div class='panel-body'>$message</div>
											</div>
										</div>
										
										
									</div>
								
						");
				}			
  
  
  ?>
		
</html>
