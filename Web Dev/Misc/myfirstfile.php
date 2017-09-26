<?php
	
	include('DBConnect.php');
	$sql = "INSERT INTO people (firstname, lastname)
		VALUES ('John', 'Doe', 'john@example.com')";

	if (mysqli_query($conn, $sql)) 
	{
		echo "New record created successfully";
	}
	else 
	{
		echo "Error: " . $sql . "<br>" . mysqli_error($conn);
	}

	mysqli_close($conn);
		

?>

<html>
<head>
	<title>Insert data into DB</title>
</head>

<body>
	<h1>Insert into DB</h1>
	<form method="post" action="myfirstfile.php">
		<input type="hidden" name="submitted" value="true"/>
		<fieldset>
			<legend></legend>
			<label>First Name: <input type="text" name="fname /"></label>
			<label>Last Name: <input type="text" name="lname /"></label>
		</fieldset>
		<br />
		<input type="submit" value="add new person" />
	</form>
	
</body>
</html>