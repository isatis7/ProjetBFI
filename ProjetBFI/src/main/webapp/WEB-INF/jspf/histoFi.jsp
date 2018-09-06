<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale.language}">
<head>
<title><spring:message code="entities.demande.create.title" /></title>
<c:import url="commonsHead.jsp" />
</head>
<body>
	<c:import url="headerNav.jsp" />
	<div class="container-fluid">
	<div class="row">
	<div class="col-sm-2"></div>
	<div class="col-sm-8">
		<section>
		<h1 class="text-primary">
				<spring:message code="home.welcome.courses" />
			</h1>
			<div class="table-responsive">
				<table class="table table-hover">
					<thead class="thead-light">
						<tr>
							<th><spring:message code="home.client.histofi.duree" /></th>
							<th><spring:message code="home.client.histofi.montant" /></th>
							<th><spring:message code="home.client.histofi.dateeff" /></th>
							<th><spring:message code="home.client.histofi.devise" /></th>
							<th><spring:message code="home.client.histofi.typefi" /></th>
							<th><spring:message code="commons.symbols.nbsp" /></th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<c:forEach items="${courses}" var="course">
							<tr>
								<td>${course.typeName}</td>
								<td>${course.code}</td>
								<td><spring:message code="commons.symbols.euro" />${course.price}</td>
								<td>${course.name}</td>
								<td><a href="<c:url value="/courses/toUpdate?id=${course.id}" />"><spring:message code="home.welcome.courses.update" /></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
</section>
	</div>
	<div class="col-sm-2"></div>
	</div>
	</div>
	<c:import url="footerNav.jsp" />
</body>
</html>