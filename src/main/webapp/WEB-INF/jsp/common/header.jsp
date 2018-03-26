<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>


<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


<style>
.mySlides {display:none;}
</style>



 <!--  <div class="headDiv"> -->
	<head>
<meta charset="UTF-8">
<title>The National Parks of the USA!</title>
<c:url value="/css/npgeek.css" var="cssHref" />

<link rel="stylesheet" href="${cssHref}">
	</head>

	<div ="headerbody2">

	
	
	
	
	
	
	
	
		<header>
		
		
			<div class="w3-content w3-section" style="max-width:500px">
<c:url value="/" var="headerback" />	
			<c:url value="/img/header1.jpg" var="logoSrc1" />
			<a href="${headerback}">
			 <img src="${logoSrc1}" alt="National Park logo" class="mySlides" />
			 </a>

 
</div>
		
		
		
		
		
		
		
		
		
		
		
			<c:url value="/" var="homePageHref" />	
			<c:url value="/img/logo.png" var="logoSrc" />
			<a href="${homePageHref}"> <img src="${logoSrc}"
				alt="National Park logo" />
			</a>
			<h1>The National Parks of the USA!</h1>
			<p>he National park Service preserves unimpaired the natural and
				cultural resources and values of the national park system for the
				enjoyment, education, and inspiration of this and future
				generations.
			<p>To achieve this mission, the National Park Service adheres to
				the following guiding principles:Excellent Service: Providing the
				best possible service to park visitors and partners. Productive
				Partnerships: Collaborating with federal, state, tribal, and local
				governments, private organizations, and businesses to work toward
				common goals. Citizen Involvement: Providing opportunities for
				citizens to participate in the decisions and actions of the
				National.</p>
		</header>

		<nav>
			<h2>Explore our National Parks</h2>
			<ul class="head">

				<c:url value="/" var="homePage" />
				<li><a href="${homePage}">Home Page</a></li>

				<c:url value="/survey" var="survey" />
				<li><a href="${survey}">Survey</a></li>
			</ul>
		</nav>
<!-- </div> -->

<script>
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 2000); 
</script>
</div>
<body>