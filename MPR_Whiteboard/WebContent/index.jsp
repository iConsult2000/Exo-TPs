<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Whiteboard</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="./JS/jquery-1.7.1.js"></script>
<script type="text/javascript" src="./JS/jquery-ui-1.8.17.custom-min.js"></script>

</head>
<body>

<div class="drag" style="background-color: #000; width:100px; height: 100px; "></div>
<div id="monDiv">Bla</div>
<img src="./WEB-IMG/un_effet_Fractalus_sur_une_image15.jpg" />
<form name="toServer" action="./server"></form>
<script type="text/javascript">

			
	//var url = $form.attr( 'action' );
			
	//$.post(url, {arg_top:ui.position.top, arg_left:ui.position.left});
	
	//setInterval(submitToServer(),50000);

</script>


<script type="text/javascript">
	(function(jQuery){
		//Cache tous les élements de la class CSS "drag"
		$('.drag').draggable();
		//Cache l'élément ayant pour identifiant "monDiv"
		$('#monDiv').hide();
		//Cache tous les élements de type img
		$('img').draggable();
	}());
</script>

</body>
</html>