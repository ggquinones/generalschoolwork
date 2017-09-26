<?php
	session_start();
	require "CSSC_DBConnect.php";
	
	//echo password_hash("adminromanscholars", PASSWORD_DEFAULT);
	//echo("\n");
	
	$user_name = mysqli_real_escape_string($con, $_REQUEST['username']);
	$psw = mysqli_real_escape_string($con, $_REQUEST['psw']);
	$combo = $user_name . $psw;
	//echo($combo . "\n");								
	$psw_query ="SELECT * FROM csscPasswords";					
	$saved_psw = $con->query($psw_query);
	$row = $saved_psw->fetch_assoc();
	$test = password_verify($combo, $row['hashedPassword']);															
	if ($test) 
	{
		$_SESSION['loggedin'] = true;
		header('Location: http://www.scholarchats.x10host.com/CSSC_AdminPortal.php');
	} 
	else 
	{
		echo '
		
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
				
				body,h1,h2,h3,h4,h5,h6 {font-family: "Orbitron", cursive;
				height:100%;
			}
				
				
			  </style>
			  
			</head> 
			  
			<body style="background: transparent;">
					<div class ="container-fluid">
						<div class="row">
							<div class="col-sm-2"></div>
							<div class="col-sm-8">
								<div class="well w3-center">
									<p>Invalid Username/Password Combination</p>
									<button type="button" onClick="parent.location=\'CSSC_AdminPortalLogIn.html\' " class="btn btn-primary w3-large w3-center">Back to Admin Portal</button>
								</div>
							</div>
							<div class="col-sm-2"></div>
						</div>
					</div>
			
			
			
		';
	}

?>