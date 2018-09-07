<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale.language}">
<head>
<title><spring:message code="entities.users.list.title" /></title>
<c:import url="commonsHead.jsp" />
</head>
<body>
	<c:import url="headerNav.jsp" />
	<div class="container-fluid">
		<section>
			<h1 class="text-primary"><spring:message code="entities.user.manage" /></h1>
						<div class="table-responsive">
				<table class="table table-hover">
					<thead class="thead-light">
						<tr>
							<th><spring:message code="entities.user.email" /></th>
							<th><spring:message code="entities.user.firstname" /></th>
							<th><spring:message code="entities.user.lastname" /></th>
							<th><spring:message code="entities.user.role" /></th>
							<th><spring:message code="commons.symbols.nbsp" /></th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<c:forEach items="${users}" var="user">
							<tr>
								<td>${user.email}</td>
								<td>${user.firstname}</td>
								<td>${user.lastname}</td>
								<td>${user.role}</td>
								
								<td><c:if test="${user.role != 'ROLE_ADMIN' }">
								<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_PO')">
								<a href="<c:url value="/users/disable/${user.id}"/>"><spring:message code="entities.users.list.delete" /></a>
								</sec:authorize>
								
								
							</c:if></td>
								
							
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			</section>
			</div>

	<div class="row">
	<div class="col-sm-2"></div>
	<div class="col-sm-8">

	</div>
	</div>

	<c:import url="footerNav.jsp" />
</body>
</html>