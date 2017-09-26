<?php
	$DB_USER = "scholarc_admin";
	$DB_PASSWORD = "scholarchats";
	$DB_HOST = "localhost";
	$DB_NAME = "scholarc_cssc";
	$con = mysqli_connect($DB_HOST, $DB_USER, $DB_PASSWORD, $DB_NAME) 
	OR die('Could not connect to mySQL'. mysqli_connect_error());
?>