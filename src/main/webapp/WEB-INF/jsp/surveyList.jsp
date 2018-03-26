<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url value="/surveyList" var="formAction" />
<c:url value="/css/npgeek.css" var="cssHref" />

<link rel="stylesheet" href="${cssHref}">

<form method="GET" action="${formAction}">
<b><div class = "popularParks">Most Popular Parks!!!</div></b>

	<c:forEach var="surveyResults" items="${surveyResults}">
		<div class="surveylist">
			</div>
			
			<c:choose>
				<c:when test="${surveyResults.parkName == 'CVNP'}">
					<c:out value="Cuyahoga Valley National Park" />
					<c:out value="${surveyResults.counter}" />
				</c:when>
				<c:when test="${surveyResults.parkName == 'ENP'}">
					<c:out value="Everglades National Park" />
					<c:out value="${surveyResults.counter}" />
				</c:when>
				<c:when test="${surveyResults.parkName == 'GCNP'}">
					<c:out value="Grand Canyon National Park" />
					<c:out value="${surveyResults.counter}" />
				</c:when>
				<c:when test="${surveyResults.parkName == 'GNP'}">
					<c:out value="Glacier National Park" />
					<c:out value="${surveyResults.counter}" />
				</c:when>
				<c:when test="${surveyResults.parkName == 'GSMNP'}">
					<c:out value="Great Smoky Mountains National Park" />
					<c:out value="${surveyResults.counter}" />
				</c:when>
				<c:when test="${surveyResults.parkName == 'GTNP'}">
					<c:out value="Grand Teton National Park" />
					<c:out value="${surveyResults.counter}" />
				</c:when>
				<c:when test="${surveyResults.parkName == 'MRNP'}">
					<c:out value="Mount Rainier National Park" />
					<c:out value="${surveyResults.counter}" />
				</c:when>
				<c:when test="${surveyResults.parkName == 'RMNP'}">
					<c:out value="Rocky Mountain National Park" />
					<c:out value="${surveyResults.counter}" />
				</c:when>
				<c:when test="${surveyResults.parkName == 'YNP'}">
					<c:out value="Yellowstone National Park" />
					<c:out value="${surveyResults.counter}" />
				</c:when>
				<c:when test="${surveyResults.parkName == 'YNP2'}">
					<c:out value="Yosemite National Park" />
					<c:out value="${surveyResults.counter}" />
				</c:when>


				<c:otherwise>
					<c:out value="Cuyasdfsdf" />
				</c:otherwise>
			</c:choose>
		
	</c:forEach>


</form>