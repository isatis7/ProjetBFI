<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale.language}">
<head>
<title><spring:message code="home.client.histofi" /></title>
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
				<spring:message code="home.client.histofi" />
			</h1>
			<div class="table-responsive">
				<sec:authorize access="hasRole('ROLE_USER_CLIENT')">
					<table class="table table-hover">
						<thead class="thead-light">
							<tr>
								<th><spring:message code="entities.demandeFinancement.duree" /></th>
								<th><spring:message code="entities.demandeFinancement.montant" /></th>
								<th><spring:message code="entities.demandeFinancement.dateEffective" /></th>
								<th><spring:message code="entities.demandeFinancement.devise" /></th>
								<th><spring:message code="entities.demandeFinancement.typeFinancement" /></th>
								<th><spring:message code="commons.symbols.nbsp" /></th>
							</tr>
						</thead>
						<tbody>
							<tr>
							<c:forEach items="${financements}" var="financement">
								<tr>
									<td>${financement.duree}</td>
									<td>${financement.montant}</td>
									<td>${financement.dateEffective}</td>
									<td>${financement.devise}</td>
									<td>${financement.typeFinancement}</td>
									<td><a href="<c:url value="/demandefi/toUpdate?id=${financement.id}" />"><spring:message code="home.client.histofi.update" /></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</sec:authorize>
				<sec:authorize access="hasAnyRole('ROLE_USER_PRO', 'ROLE_ADMIN', 'ROLE_PO')">
					<table class="table table-hover">
						<thead class="thead-light">
							<tr>
								<th><spring:message code="entities.demandeFinancement.clientNom" /></th>
								<th><spring:message code="entities.demandeFinancement.dateDemande" /></th>
								<th><spring:message code="entities.demandeFinancement.reference" /></th>
								<th><spring:message code="entities.demandeFinancement.duree" /></th>
								<th><spring:message code="entities.demandeFinancement.montant" /></th>
								<th><spring:message code="entities.demandeFinancement.dateEffective" /></th>
								<th><spring:message code="entities.demandeFinancement.devise" /></th>
								<th><spring:message code="entities.demandeFinancement.typeFinancement" /></th>
								<th><spring:message code="entities.demandeFinancement.perfPlus" /></th>
								<th><spring:message code="entities.demandeFinancement.validation" /></th>
								<th><spring:message code="commons.symbols.nbsp" /></th>
							</tr>
						</thead>
					<tbody>
					<tr>
						<c:forEach items="${financements}" var="financement">
							<tr>
								<td>${financement.client}</td>
								<td>${financement.dateDemande}</td>
								<td>${financement.reference}</td>
								<td>${financement.duree}</td>
								<td>${financement.montant}</td>
								<td>${financement.dateEffective}</td>
								<td>${financement.devise}</td>
								<td>${financement.typeFinancement}</td>
								<td>${financement.perfPlus}</td>
								<td>${financement.validation}</td>
								<td><a href="<c:url value="/demandefi/toUpdate?id=${financement.id}" />"><spring:message code="home.client.histofi.update" /></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</sec:authorize>	
		</div>
	</section>
	</div>
		<div class="col-sm-2"></div>
	</div>
	</div>
	<c:import url="footerNav.jsp" />
</body>
</html>