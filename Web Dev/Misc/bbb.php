

<html>
	<head>
		<title>iQVoli</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<script src="jquery-3.2.1.min.js"></script>	
		
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
	</head>
	<style>
		.btn{color:white;}
		
		#grid{
			
			width: 50%;
			margin: auto;
			padding-top: 10%;
			
		}
	</style>
	<body>
		
		
		
		<!-- Grid for schedule outer container -->
		<div id="grid" class="container-fluid">
			<form action=bbb.php  >
				
					<div class="form-inline">
						<div class="form-group ">
							<div class="btn-group-vertical">
							  <button type="button" style="background:green;" class="btn" onclick="changeBtnColor(this) >10:00 am</button>
							  
							</div>
						</div>	
					</div>
				
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
			
			
			
		</div>

		
	</body>
		
		<script>
			var schedule = new Array(7);
			for (var i = 0; i < 7; i++) {
			  x[i] = new Array(12);
			}
			
			for(var i=0;i<7;i++)
			{
				for(var k=0;i<12;k++)
				{
					schedule[i][k] = 0;
				}
			}
			
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