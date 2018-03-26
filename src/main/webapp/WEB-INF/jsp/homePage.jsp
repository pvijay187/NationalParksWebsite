<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:url value="/css/npgeek.css" var="cssHref2" />
<link rel="stylesheet" href="${cssHref2}">
<c:url value="/css/homepage.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">
<header>
		<c:url value="/" var="homePageHref" />
</header>

<body>




<div id="container">


<main id="center" class="column">
<article>

	<c:forEach var="park" items="${allParks}">
		<tr>

		
		<div class="test2"> <td><c:url var="parkDetails" value="/parkDetails">
					<c:param name="parkCode" value="${(park.parkCode)}" />
				</c:url> <c:url value="/img/parks/${fn:toLowerCase(park.parkCode)}.jpg" var="picture" /><a
				href="${parkDetails}"><img  src="${picture}" class="pic1"></a></td></div>
					
			<td>
				<ul>
				<div class="test1">	<h1><c:out value="${park.parkName}" /></h1>
				<p><c:out value="${park.state}" /></p>
				<p><c:out value="${park.inspQuote}" /></p>
				<p><c:out value="${park.parkDescription}" /></p></div>
					
				</ul>
				
			</td>
			</div>
		</tr>
	</c:forEach>

</article>	
</main>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />