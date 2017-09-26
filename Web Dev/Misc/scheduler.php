
<?php
	$dom = new DOMDocument();
    //libxml_use_internal_errors(true); hides nav bar error
	if (!$dom->loadHTMLFile("HomeIQ.html")) 
	{
		die ('Could not parse...');
	}
	$sun = array();
	$mon = array();
	$tue = array();
	$wed = array();
	$thu = array();
	$fri = array();
	$sat = array();
	$days = array("sun","mon","tue","wed","thu","fri","sat");
	$nums = array(10,11,12,1,2,3,4,5,6,7,8);
	$AV = array(array());
	
	for($i =0;$i < 1;$i++)
	{
		for($k = 0;$k < 11;$k++)
		{
			//AV[i][k] = availability(substr($dom->getElementById($days[i] . $nums[i])->getAttribute("style"),11,strlen($color)-12)));
			$style = $dom->getElementById($days[$i] . $nums[$k])->getAttribute("style"); // gets whatevers is the style attribute
			echo(substr($dom->getElementById($days[$i] . $nums[$k])->getAttribute("style"),11,strlen($style)-12)); // assuming background is first and only thing in style gets the color
			//echo($days[$i] . $nums[$k] . "<br>"); works!
		}
	}
?>