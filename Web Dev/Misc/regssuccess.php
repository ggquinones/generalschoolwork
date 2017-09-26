

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
				<a   class="navbar-brand w3-bold w3-xxlarge" href="resp.html">MSJ 2017</a>
		</div>
    </div>
</nav><!-- End of Navigation Bar Code -->

<!--  Header Div -->
<div class="container w3-blue w3-padding-64">
	  <div class=" w3-white w3-text-black   jumbotron w3-center">
		<hr>
		<div class="w3-panel w3-green">
				<h1 class="w3-xxlarge">Your team <?php echo($message);?> has been registered!</h1>
		</div>
		<hr>
		<h3 class="w3-xxlarge"> Team Captain: <?php echo($capt_FN . " " . $capt_LN);?></h3>
		<h3 class="w3-xxlarge"> Phone: <?php echo($phone);?></h3>
		<h3 class="w3-xxlarge"> Email: <?php echo($email);?></h3>
		<hr>
		<h3 class="w3-xxlarge"> Player 1: <?php echo($player1FN . " " . $player1LN);?></h3>
		<hr>
		<h3 class="w3-xxlarge"> Player 2: <?php echo($player2FN . " " . $player2LN);?></h3>
		<hr>
		<h3 class="w3-xxlarge"> Player 3: <?php echo($player3FN . " " . $player3LN);?></h3>
		<hr>
		<h3 class="w3-xxlarge"> Player 4: <?php echo($player4FN . " " . $player4LN);?></h3>
		<hr>
		
		<button type="button" onClick="parent.location='resp.html'" class="btn w3-jumbo btn-primary w3-jumbo w3-center">Go Back to Home Page</button>		
	  </div>
	  
<?php
/* Attempt MySQL server connection. Assuming you are running MySQL
server with default setting (user 'root' with no password) */
$link = mysqli_connect("localhost", "root", "ginnyq0811", "metrosummerjoust_2k17");
 $message= "";
// Check connection
if($link === false){
    die("ERROR: Could not connect. " . mysqli_connect_error());
}
 
// Escape user inputs for security
$teamName = mysqli_real_escape_string($link, $_REQUEST['teamName']);
$capt_FN = mysqli_real_escape_string($link, $_REQUEST['captFN']);
$capt_LN = mysqli_real_escape_string($link, $_REQUEST['captLN']);
$phone = mysqli_real_escape_string($link, $_REQUEST['phone']);
$email = mysqli_real_escape_string($link, $_REQUEST['email']);
$player1FN = mysqli_real_escape_string($link, $_REQUEST['player1FN']);
$player1LN = mysqli_real_escape_string($link, $_REQUEST['player1LN']);

$player2FN = mysqli_real_escape_string($link, $_REQUEST['player2FN']);
$player2LN = mysqli_real_escape_string($link, $_REQUEST['player2LN']);

$player3FN = mysqli_real_escape_string($link, $_REQUEST['player3FN']);
$player3LN = mysqli_real_escape_string($link, $_REQUEST['player3LN']);

$player4FN = mysqli_real_escape_string($link, $_REQUEST['player4FN']);
$player4LN = mysqli_real_escape_string($link, $_REQUEST['player4LN']);

// attempt insert query execution
$sql = "INSERT INTO teams (teamname,captFN,captLN, phone, email, player1FN, player1LN, player2FN, player2LN, player3FN, player3LN ,player4FN, player4LN) 
		VALUES ('$teamName', '$capt_FN', '$capt_LN' , '$phone', '$email', '$player1FN', '$player1LN','$player2FN', '$player2LN','$player3FN', '$player3LN','$player4FN', '$player4LN')";
if(mysqli_query($link, $sql)){
    //echo "Team Registered Successfully!";
} else{
    echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);
}
 
// close connection
mysqli_close($link);
?>	  
</div>
 <!-- End Header Div -->

</body>
</html>