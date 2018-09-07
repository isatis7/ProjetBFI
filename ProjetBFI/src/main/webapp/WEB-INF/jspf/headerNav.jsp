<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<span id="TOP"></span>

<li class="navbar-brand"><img
	src=<c:url value="/static/image/Sodibank.png" />
	alt="<spring:message
					code="commons.nav.brand" /> "
	style="width: 50%"></li>
<li class="navbar-brand"><img
	src=<c:url value="/static/image/slogan1.png" />
	alt="<spring:message
					code="commons.nav.brand" /> "
	style="width: 50%"></li>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<div class="container-fluid">
		<ul class="nav navbar-nav">


			<sec:authorize access="hasRole('ROLE_USER_CLIENT')">
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/demandefi/toCreate" />"><spring:message
							code="commons.nav.demandeFi" /></a></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/demandefi/histoFi" />"><spring:message
							code="commons.nav.histoFi" /></a></li>
				<li class="nav-item"><a class="nav-link" href="#"><spring:message
							code="commons.nav.enCoursFi" /></a></li>


			</sec:authorize>

			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <spring:message
							code="commons.nav.creation" />
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<c:url value="/users/toUpdate" />"><spring:message
								code="commons.nav.creation.po" /></a> <a class="dropdown-item"
							href="<c:url value="/logout" />"><spring:message
								code="commons.nav.creation.banquier" /></a> <a
							class="dropdown-item" href="<c:url value="/users/toUpdate" />"><spring:message
								code="commons.nav.creation.client" /></a>
					</div></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/home/toListUser" />"><spring:message
							code="commons.nav.listeutil" /></a></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/perfplus/toUpdate" />"><spring:message
							code="commons.nav.perfplus" /></a></li>



			</sec:authorize>

			<sec:authorize access="hasRole('ROLE_USER_PRO')">
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/gestionportefeuille" />"><spring:message
							code="commons.nav.gestionportefeuille" /></a></li>

			</sec:authorize>

			<sec:authorize access="hasRole('ROLE_PO')">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <spring:message
							code="commons.nav.gestion" />
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<!--           Option de gestion de portefeuille à implémenter dans une V2 -->
						<a class="dropdown-item disabled" href="#"><spring:message
								code="commons.nav.gestionportefeuille" /></a> <a
							class="dropdown-item" href="<c:url value="/demandefi/histoFi" />"><spring:message
								code="commons.nav.histoFi" /></a>

					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <spring:message
							code="commons.nav.creation" />
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<c:url value="/users/toUpdate" />"><spring:message
								code="commons.nav.creation.po" /></a> <a class="dropdown-item"
							href="<c:url value="/logout" />"><spring:message
								code="commons.nav.creation.banquier" /></a> <a
							class="dropdown-item" href="<c:url value="/users/toUpdate" />"><spring:message
								code="commons.nav.creation.client" /></a>
					</div></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/home/toListUser" />"><spring:message
							code="commons.nav.listeutil" /></a></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/perfplus/toUpdate" />"><spring:message
							code="commons.nav.perfplus" /></a></li>
			</sec:authorize>
		</ul>
		<sec:authorize access="isAuthenticated()">
			<ul class="nav navbar-nav navbar-left">

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <sec:authentication
							property="principal.user.firstname"></sec:authentication>
				</a>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="navbarDropdown">


						<!--           Option de gestion de portefeuille à implémenter dans une V2 -->
						<a class="dropdown-item disabled" href="#"><spring:message
								code="commons.nav.settings.account" /></a> <a class="dropdown-item"
							href="<c:url value="/logout" />"><spring:message
								code="commons.nav.settings.logout" /></a>
					</div></li>
			</ul>
		</sec:authorize>

	</div>
</nav>