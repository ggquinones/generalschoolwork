<?php
	session_start();
	if (!(isset($_SESSION['loggedin']) && $_SESSION['loggedin'] == true)) 
	{
		header('Location: http://www.scholarchats.x10host.com/CSSC_AdminPortalLogIn.html');
	} 
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
      <a class="navbar-brand" href="index.html"><img src="don2.png" alt="CBVC Logo" width="30" height="30"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="CSSC_AdminPortal.php">Home</a></li>
        <li><a href="CSSC_AdminRegistrants.php">Registrants</a></li>
      </ul>      
    </div>
  </div>
</nav>
<!-- NavBar End -->

<!-- Main Container -->
	<div class ="container-fluid">
		<div class="w3-row">			
			<div class="w3-col s12">
				<?php
					require "CSSC_phpScripts.php";
					displayGroups();			
				?>
			</div>			
		</div>
	</div>

</body>


</html>