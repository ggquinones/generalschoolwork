<?php
//################################################################################################################################
// Functions used in Sign In/Out
//		
	function recognizedUserInGroup($userName,$groupID)
	{
		// DB Connection Script
		require "CSSC_DBConnect.php";		
		$sql = "SELECT * FROM csscRegistrants WHERE ipfwUsername = '$userName' and groupId='$groupID';";
		$result = $con->query($sql);
		
		if($result->num_rows > 0 )
		{
			return true;// Return true if username is recognized
		}
		else
		{
			return false;// Return false if username is NOT recognized
		}		
		// close connection
		mysqli_close($con);
	}
	
	function hasSignedInToday($userName)
	{
		// DB Connection Script
		require "CSSC_DBConnect.php";		
		$sql = "SELECT * FROM csscSignIn WHERE ipfwUsername = '$userName' and CURRENT_DATE=DATE(timestamp);";
		$result = $con->query($sql);
		
		if($result->num_rows > 0 )
		{
			return true;// Return true if the user has signed in that day
		}
		else
		{
			return false;// Return false if the user has NOT signed in that day
		}		
		// close connection
		mysqli_close($con);	
	}
	
		function hasSignedOutToday($userName)
	{
		// DB Connection Script
		require "CSSC_DBConnect.php";		
		$sql = "SELECT * FROM csscSignOut WHERE ipfwUsername = '$userName' and CURRENT_DATE=DATE(timestamp);";
		$result = $con->query($sql);		
		if($result->num_rows > 0 )
		{
			return true;// Return true if the user has signed out that day
		}
		else
		{
			return false;// Return false if the user has NOT signed out that day
		}		
		// close connection
		mysqli_close($con);	
	}
//################################################################################################################################
//################################################################################################################################
	
//################################################################################################################################
// Functions used in Admin Portal
//	
	function displayGroups()
	{
		
		$groupNames = array("CS160-Andrea","CS160-Levi","CS160/161-Levi","CS161-Kurtis","CS161-Katie","CS260-Gabe","CS260-Kurtis","CS232-Tom","MA175-Micah","MA153/154-Ivan");
		for($i =0; $i < count($groupNames);$i++)
		{
			displayGroupTable($groupNames[$i],$i);
		}
		
	}
	
	function displayGroupTable($groupName,$groupID)
	{
		require "CSSC_DBConnect.php";						
		$sql =
		"
			SELECT csscSignIn.ipfwUsername, csscSignIn.task, csscSignOut.percentDone, csscSignIn.timestamp AS 'SignIn', csscSignOut.timestamp AS 'SignOut',TIMEDIFF(TIME(csscSignOut.timestamp),TIME(csscSignIn.timestamp)) AS 'timeSpent'
			FROM csscSignIn
			INNER JOIN csscSignOut ON csscSignIn.groupId=$groupID and  csscSignOut.groupId =$groupID and csscSignIn.ipfwUsername = csscSignOut.ipfwUsername and DATE(csscSignIn.timestamp)=DATE(csscSignOut.timestamp)
			order by DAY(DATE(csscSignIn.timestamp))
		";
		$result = $con->query($sql);
		if ($result->num_rows > 0) 
		{
			echo("<h1 class='w3-indigo w3-center w3-xxlarge'>$groupName</h1>");
			tableHeader();							
					
			while($row = $result->fetch_assoc()) 
			{								
				addTableRow($row['ipfwUsername'],$row['task'],$row['percentDone'],$row['SignIn'],$row['SignOut'],$row['timeSpent']);									
			}
			echo("</table>"); // Finish Table
		} 
		else 
		{
			echo("<h1 class='w3-red w3-center w3-xxlarge'>$groupName has no entries</h1>");
		}
		$con->close();
	}
	
	function tableHeader()
	{
		echo("<table class='w3-table w3-border w3-striped'>
					<tr class='w3-black'>
					  <th>UserName</th>
					  <th>Task</th>
					  <th>Percent Completed</th>
					  <th>Sign In</th>
					  <th>Sign Out</th>
					  <th>Time Spent</th>
					</tr>");
	}
					
	function addTableRow($userName,$task,$perDone,$timestampIn,$timestampOut, $timeSpent ="Default") 
	{				
		echo ("							
				<tr>							  		
				  <td>$userName</td>
				  <td>$task</td>
				  <td>$perDone</td>
				  <td>$timestampIn</td>
				  <td>$timestampOut</td>
				  <td>$timeSpent</td>
				</tr>								
			");
	}	
//################################################################################################################################
//################################################################################################################################
	
?>









