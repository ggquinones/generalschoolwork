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
      <a class="navbar-brand" href="index.html"><img src="don2.png" alt="CSSC Logo" width="30" height="30"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li ><a href="CSSC_AdminPortal.php">Home</a></li>
        <li class="active"><a href="CSSC_AdminRegistrants.php">Registrants</a></li>
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
					require "CSSC_DBConnect.php";					
					// Registrants Query
					$registrants_query = 
					"
						SELECT 
							csscRegistrants.firstName, csscRegistrants.lastName, csscRegistrants.ipfwUsername,csscRegistrants.email,
							csscGroups.groupName,csscGroups.days,csscGroups.time
						FROM
							csscRegistrants
						INNER JOIN
							csscGroups
						ON
							csscRegistrants.groupId=csscGroups.groupId
						ORDER BY
							csscGroups.groupName
					";					
					$registrants_result = $con->query($registrants_query);				
					$count =1;
					if ($registrants_result->num_rows > 0) {
						echo("<h1 class='w3-indigo w3-center w3-xxlarge'>Registrants</h1>");
						// output data of each row
						echo("<table class='w3-table w3-border w3-striped'>
								<tr class='w3-black'>
								  <th>No.</th>
								  <th>Name</th>
								  <th>Username</th>
								  <th>Email</th>
								  <th>Group</th>
								  <th>Day(s)</th>
								  <th>Time</th>
								</tr>");
						while($row = $registrants_result->fetch_assoc()) {
							
								addTableRow($count,$row['ipfwUsername'],$row['groupName'],$row['days'],$row['time'],$row['firstName'],$row['lastName'],$row['email']);
								$count++;
						}
						echo("</table>");
					} else {
						echo "0 results";
					}
					//  END
					
					
					$con->close();
					
					function addTableRow($count,$userName,$groupName,$days,$time,$fn,$ln,$email) {
					
					
					echo ("							
							<tr>
							  <td>$count</td>
							  <td>$fn $ln</td>
							  <td>$userName</td>
							  <td>$email</td>
							  <td>$groupName</td>
							  <td>$days</td>
							  <td>$time</td>
							</tr>								
						");
				}
				
				?>
			</div>			
		</div>
	</div>

</body>


</html>