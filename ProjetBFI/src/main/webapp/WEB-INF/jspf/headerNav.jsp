<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<span id="TOP"></span>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="nav navbar-nav">
		<span class="navbar-brand text-info"><spring:message
				code="commons.nav.brand" /></span>
		<li class="nav-item"><a class="nav-link"
			href="<c:url value="/home/welcome" />"><spring:message
					code="commons.nav.home" /></a></li>
		<sec:authorize access="isAuthenticated()">
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
						<li class="nav-item"><a class="nav-link"
				href="<c:url value="/logout" />"><spring:message
						code="commons.nav.logout" /></a></li>
		</sec:authorize>
		
	
		<sec:authorize access="isAuthenticated()">
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
				</div></li>
		</sec:authorize>
	</ul>
</nav>