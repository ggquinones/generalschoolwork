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
      <a class="navbar-brand" href="index.html"><img src="don3.png" alt="CBVC Logo" width="30" height="30"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="CSSC_AdminPortal.html">Home</a></li>
        <li><a href="CSSC_AdminGroupInfo.html">Mentor Groups Info</a></li>
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
					$DB_USER = "scholarc_admin";
					$DB_PASSWORD = "scholarchats";
					$DB_HOST = "localhost";
					$DB_NAME = "scholarc_cssc";
					$con = mysqli_connect($DB_HOST, $DB_USER, $DB_PASSWORD, $DB_NAME) 
					OR die('Could not connect to mySQL'. mysqli_connect_error());
					
					// GROUP 0: Query to get Sign In/Out information for group: CS160-Andrea (GroupID=0)
					$group0Portal_query = 
					"
						SELECT * FROM csscSignUp
					";					
					$group0_result = $con->query($group0Portal_query);				
					if ($group0_result->num_rows > 0) {
						echo("<h1 class='w3-yellow w3-center w3-xxlarge'>CS160-Andrea</h1>");
						// output data of each row
						echo("<table class='w3-table w3-border w3-striped'>
								<tr class='w3-black'>
								  <th>First Name</th>
								  <th>Last Name</th>
								  <th>ipfwUsername</th>
								  <th>email</th>
								  <th>groupId</th>
								</tr>");
						while($row = $group0_result->fetch_assoc()) {
							
								addTableRow($row['firstName'],$row['lastName'],$row['ipfwUsername'],$row['email'],$row['groupId']);
								
						}
						echo("</table>");
					} else {
						echo "0 results";
					}
					// GROUP 0 END

					$con->close();
					
					function addTableRow($fn,$ln,$un,$ema,$gi) {
					
					
					echo ("							
							<tr>
							  <td>$fn</td>
							  <td>$ln</td>
							  <td>$un</td>
							  <td>$ema</td>
							  <td>$gi</td>
							</tr>								
						");
				}
				
				?>
			</div>			
		</div>
	</div>

</body>


</html>