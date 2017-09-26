<?php
	$DB_USER = "beachell_admin";
	$DB_PASSWORD = "ginnyrose";
	$DB_HOST = "localhost";
	$DB_NAME = "beachell_luaudb";
		
	$con = mysqli_connect($DB_HOST, $DB_USER, $DB_PASSWORD, $DB_NAME) 
	OR die('Could not connect to mySQL'. mysqli_connect_error());
?>