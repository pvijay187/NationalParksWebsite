<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>

	<c:url value="/parkDetails" var="formAction" />
	<div class="npImage">
		<c:url value="/img/parks/${fn:toLowerCase(park.parkCode)}.jpg"
			var="picture" />
		<img class="npImage" src="${picture}">
	</div>




	<ul class="details">
		<li class="name"><strong> <c:out
					value="${park.parkName}" />
		</strong></li>
		<li class="quote"></li>
		<i><font size="3px"> <c:out value=' "${park.inspQuote}" ' />
		</font></i>
		<li class="quoteSource"></li>
		<font size="3px"> <c:out value="-${park.inspQuoteSource}" />
		</font>

		<li class="description"></li>
		<font size="3px"> <c:out value="${park.parkDescription}" /> <c:out
				value="This national park is in the state of ${park.state}" />
		</font>

		<li class="parkInfo"><strong><c:out
					value="Park Information" /></strong></li>
		<div class="bigGrid">
			<div class="firstItem">

				<li class="bar"></li> <strong>Year Founded: </strong> <font
					size="3px"> <c:out value="${park.yearFounded}" />
				</font>
				<li class="bar"></li> <strong>Acreage: </strong> <font size="3px">
					<c:out value="${park.acreage} Square Miles" />
				</font> </strong>

				<li class="bar"></li> <strong>Elevation in Feet: </strong> <font
					size="3px"> <c:out value="${park.elevationInFeet} feet" />
			</div>
			<div class="secondItem">
				</font>

				<li class="bar"></li> <strong>Miles of Trail: </strong> <font
					size="3px"> <c:out value="${park.milesOfTrail} miles" />
				</font>

				<li class="bar"></li> <strong>Number of Campsites: </strong> <font
					size="3px"> <c:out value="${park.numberOfCampsites}" />
				</font>

				<li class="bar"></li> <strong>Climate: </strong> <font size="3px">
					<c:out value="${park.climate}" />
				</font>

			</div>

			<div class="thirdItem">


				<li class="bar"></li> <strong>Annual Visitor Count: </strong> <font
					size="3px"> <c:out value="${park.annualVisitorCount}" />
				</font>

				<li class="bar"></li> <strong>Entry Fee : </strong> <font size="3px">
					<c:out value="$${park.entryFee}" />
				</font>

				<li class="bar"></li> <strong>Number of animal species: </strong> <font
					size="3px"> <c:out value="${park.numberOfAnimalSpecies}" />
				</font>
			</div>
		</div>


		<li></li>
	</ul>
	</div>


	<c:url value="parkDetails" var="formAction" />
	<form method="POST" action="${formAction}">

		<label for="temperature"> Select Fahrenheit or Celsius</label> <select
			name="tempConv" id="tempConv">
			<option value="true">Fahrenheit</option>
			<option value="false">Celsius</option>

		</select> <input type="hidden" name="parkCode" value="${park.parkCode}">

		<input type="submit" value="submit" />

	</form>

	<c:set var="tempDif" value="${dayOne.high - dayOne.low}" />

	<c:set value="${weatherWeek.get(0)}" var="dayOne" />

	<div class="dF">
		<strong><c:out value="DAILY FORECAST" /></strong>
	</div>
	<div class="dayOne">
		<div class="one">


			<c:url value="/img/weather/${dayOne.forecast}.png" var="picture" />
			<div class=do_detail>
				<img class="do_detail" src="${picture}" : width=200px;>
			</div>

			<div class="dayOneForecast">
				<strong></Strong>
				<c:out value="${dayOne.forecast.toUpperCase()}" />
				</strong>
			</div>

			<div class="highLow">
				<div class="high">
					<span class=high><c:out value="High" /> <c:choose>
							<c:when test="${isFahr == false}">
								<fmt:formatNumber var="celHigh"
									value="${(dayOne.high - 32)/1.8}" maxFractionDigits="1" />
								<c:out value="${celHigh} C" />
							</c:when>
							<c:otherwise>
								<c:out value="${dayOne.high} F" />
							</c:otherwise>

						</c:choose> </span>
				</div>
				<div class="low">
					<span class="low""><c:out value="Low" /> <c:choose>
							<c:when test="${isFahr == false}">
								<fmt:formatNumber var="celLow" value="${(dayOne.low - 32)/1.8}"
									maxFractionDigits="1" />
								<c:out value="${celLow} C" />
							</c:when>
							<c:otherwise>
								<c:out value="${dayOne.low} F" />
							</c:otherwise>
						</c:choose>
				</div>
			</div>

			<c:set var="rain" value="rain" />
			<c:set var="sunny" value="sunny" />
			<c:set var="thunderstorms" value="thunderstorms" />
			<c:set var="snow" value="snow" />
			<c:set var="partlycloudy" value="partly cloudy" />

			<c:if test="${dayOne.forecast == partlycloudy}">
				<span class="warning"><strong>WARNING!!!!</strong></span>
				<p>It's partly cloudy, please pack rain gear and bring
					waterproof, and maybe sunblock!</p>
			</c:if>
			<c:if test="${dayOne.forecast == sunny}">
				<span class="warning"><strong>WARNING!!!!</strong></span>
				<p>It will be sunny, please pack sunblock</p>
			</c:if>
			<c:if test="${dayOne.forecast == rain}">
				<span class="warning"><strong>WARNING!!!!</strong></span>
				<p>It's raining, please pack rain gear and bring waterproof
					shoes.</p>
			</c:if>

			<c:if test="${dayOne.forecast == thunderstorms}">
				<span class="warning"><strong>WARNING!!!!</strong></span>
				<p>There will be thunderstorms, please seek shelter and avoid
					hiking on exposed ridges</p>
			</c:if>
			<c:if test="${dayOne.forecast == snow}">
				<span class="warning"><strong>WARNING!!!!</strong></span>
				<p>There will be snow, please pack snow shoes</p>
			</c:if>
			<c:if test="${dayOne.high >= 70}">
				<span class="warning"><strong>WARNING!!!!</strong></span>
				<p>It will be HOT! Please bring an extra gallon of water!</p>
			</c:if>

			<c:if test="${dayOne.low <= 20}">
				<span class="warning"><strong>WARNING!!!!</strong></span>
				<p>It will be COLD! Please be wary of frostbite and hypothermia!</p>
			</c:if>
			<c:if test="${(dayOne.high-dayOne.low) >= 20}">
				<span class="warning"><strong>WARNING!!!!</strong></span>
				<p>The temperature will fluctuate! Please wear breathable
					layers!</p>
			</c:if>
		</div>
	</div>
	<div class="wF">
		<strong>WEEKLY FORECAST</strong>
	</div>
	<div class="otherDay">
		<c:forEach begin="1" end="4" var="weatherDay">
			<div class="other">
				<c:set value="${weatherWeek.get(weatherDay)}" var="otherDay" />
				<c:url value="/img/weather/${otherDay.forecast}.png" var="picture" />

				<img class="otherDayPicture" src="${picture}" width=200px>

				<div class="dayOneForecast">
					<strong> <c:out value="${otherDay.forecast.toUpperCase()}" />
					</strong>
				</div>



				<span class="Ohigh"><c:out value="High" /> <c:choose>
						<c:when test="${isFahr == false}">
							<fmt:formatNumber var="otherCelHigh"
								value="${(otherDay.high - 32)/1.8}" maxFractionDigits="1" />
							<c:out value="${otherCelHigh}" />
						</c:when>
						<c:otherwise>
							<c:out value="${otherDay.high}" />
						</c:otherwise>
					</c:choose></span> <span class="Olow"><c:out value="Low" /> <c:choose>
						<c:when test="${isFahr == false}">
							<fmt:formatNumber var="otherCelLow"
								value="${(otherDay.low - 32)/1.8}" maxFractionDigits="1" />
							<c:out value="${otherCelLow} C" />
						</c:when>
						<c:otherwise>
							<c:out value="${otherDay.low} F" />
						</c:otherwise>
					</c:choose></span>

				<div>
					<c:if test="${otherDay.forecast == partlycloudy}">
                It's partly cloudy, please pack rain gear and bring
                    waterproof, and maybe sunblock!
            </c:if>
				</div>
				<div>
					<c:if test="${otherDay.forecast == sunny}">
                It will be sunny, please pack sunblock
            </c:if>

				</div>
				<div>
					<c:if test="${otherDay.forecast == rain}">
It's raining, please pack rain gear and bring waterproof
shoes.
</c:if>
				</div>
				<div>
					<c:if test="${otherDay.forecast == thunderstorms}">
There will be thunderstorms, please seek shelter and avoid
hiking on exposed ridges
</c:if>
				</div>
				<div>
					<c:if test="${otherDay.forecast == snow}">
There will be snow, please pack snow shoes
</c:if>
				</div>
				<div>
					<c:if test="${otherDay.high >= 70}">
It will be HOT! Please bring an extra gallon of water!
</c:if>
				</div>
				<div>
					<c:if test="${otherDay.low <= 20}">
It will be COLD! Please be wary of frostbite and
hypothermia!
</c:if>
				</div>
				<div>
					<c:if test="${(otherDay.high-otherDay.low) >= 20}">
The temperature will fluctuate! Please wear breathable
layers!
</c:if>
				</div>
			</div>
		</c:forEach>
	</div>

</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />