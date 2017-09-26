<!DOCTYPE html>



<html>

<head>
	<title>abc</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>

	<div class="container">
		<form action="abc.php" method="post" >
			<button id="sun10" type="button" style="background:green;" onclick="changeColor(this) ">Open</button>
			<button type="submit">Save</button>
		</form>
	</div>



</body>
<script>
		
		
		function changeColor(elem)		
		{		
			var newBtn = elem;
			
			
			if(elem.style.background == "green")
			{
				
				newBtn.style.background = "red";
				newBtn.style.color = "white";				
				elem.parentNode.replaceChild(newBtn, elem);
				//elem.style.background = "red";
				//elem.style.color = "white";
			}
			else if(elem.style.background == "red")
			{
				newBtn.style.background = "yellow";
				newBtn.style.color = "black";				
				elem.parentNode.replaceChild(newBtn, elem);
				//elem.style.background = "yellow";
				//elem.style.color = "black";
			}
			else
			{
				newBtn.style.background = "green";
				newBtn.style.color = "white";				
				elem.parentNode.replaceChild(newBtn, elem);
				//elem.style.background = "green";
				//elem.style.color = "white";
			}
		}

		
	</script>



</html>