<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="#TOP"><spring:message code="commons.nav.top" /></a></li>
		<li class="nav-item"><a class="nav-link" href="<c:url value="/infos" />" ><spring:message
						code="commons.nav.info" /></a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/contrat" />"><spring:message
						code="commons.nav.contrat" /></a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/contact" />"><spring:message
						code="commons.nav.contact" /></a></li>
	</ul>
</nav>