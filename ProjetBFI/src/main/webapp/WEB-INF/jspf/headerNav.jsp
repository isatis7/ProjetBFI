<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<span id="TOP"></span>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="nav navbar-nav">
		<li class="navbar-brand" ><img src="webapp/static/image/Sodibank.png" alt="<spring:message
					code="commons.nav.brand" />"></li>
		
		<sec:authorize access="hasAnyRole('ROLE_USER_CLIENT', 'ROLE_PO')">
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/demandeFi" />"><spring:message
						code="commons.nav.demandeFi" /></a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/histoFi" />"><spring:message
						code="commons.nav.histoFi" /></a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/enCoursFi" />"><spring:message
						code="commons.nav.enCoursFi" /></a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/contactCon" />"><spring:message
						code="commons.nav.contactCon" /></a></li>
						
		</sec:authorize>
		
		<sec:authorize access="hasAnyRole('ROLE_PO', 'ROLE_ADMIN')">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <spring:message
						code="commons.nav.creation" />
			</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="<c:url value="/users/toUpdate" />"><spring:message
							code="commons.nav.creation.po" /></a>
							<a class="dropdown-item" href="<c:url value="/logout" />"><spring:message
							code="commons.nav.creation.banquier" /></a>
							<a class="dropdown-item" href="<c:url value="/users/toUpdate" />"><spring:message
							code="commons.nav.creation.client" /></a>
				</div></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/listeutil" />"><spring:message
						code="commons.nav.listeutil" /></a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/perfplus" />"><spring:message
						code="commons.nav.lperfplus" /></a></li>
			
						
		</sec:authorize>
		
		<sec:authorize access="hasAnyRole('ROLE_PO', 'ROLE_USER_PRO')">
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/gestionportefeuille" />"><spring:message
						code="commons.nav.gestionportefeuille" /></a></li>
			
		</sec:authorize>
		
	
		<sec:authorize access="isAuthenticated()">
		<ul class="nav navbar-nav navbar-right">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <sec:authentication
						property="principal.user.firstname"></sec:authentication>
			</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="<c:url value="/users/toUpdate" />"><spring:message
							code="commons.nav.settings.account" /></a>
							<a class="dropdown-item" href="<c:url value="/logout" />"><spring:message
							code="commons.nav.settings.logout" /></a>
				</div></li></ul>
		</sec:authorize>
	</ul>
</nav>