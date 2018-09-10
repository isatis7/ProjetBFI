<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale.language}">
<head>
<title><spring:message code="perfplus.title" /></title>
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
						<spring:message code="perfplus.title" />
					</h1>

					<c:if test="${success}">
						<div class="alert alert-success">
							<spring:message code="commons.forms.update.perfplus.success" />
						</div>
					</c:if>

					<c:if test="${erreur}">
						<div class="alert alert-danger">
							<b>Erreur: </b>
							<spring:message code="commons.forms.update.perfplus.failed" />
						</div>
					</c:if>

					<%
					    if (request.getParameter("success") != null) {
					%>
					<div class="alert alert-success">
						<spring:message code="commons.forms.update.perfplus.success" />
					</div>
					<%
					    }
					%>

					<%
					    if (request.getParameter("erreur") != null) {
					%>
					<div class="alert alert-danger">
						<b>Erreur: </b>
						<spring:message code="commons.forms.update.perfplus.failed" />
					</div>
					<%
					    }
					%>

					<c:url value="/perfplus/update" var="formUrl" />
					<form:form method="POST" action="${formUrl}"
						modelAttribute="parametres">
						<form:hidden path="id" />
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />

						<div class="form-group">
							<form:label path="paramA">
								<spring:message code="perfplus.paramA" />
							</form:label>
							<form:input path="paramA" maxlength="5" class="form-control"
								cssErrorClass="form-control is-invalid" autocomplete="off" />
							<form:errors element="div" path="paramA"
								cssClass="invalid-feedback" />
						</div>
						<div class="form-group">
							<form:label path="paramB">
								<spring:message code="perfplus.paramB" />
							</form:label>
							<form:input path="paramB" maxlength="5" class="form-control"
								cssErrorClass="form-control is-invalid" autocomplete="off" />
							<form:errors element="div" path="paramB"
								cssClass="invalid-feedback" />
						</div>
						<form:button class="btn btn-primary mb-3">
							<spring:message code="perfPlus.submit" />
						</form:button>
					</form:form>
				</section>
			</div>
		</div>
	</div>
	<c:import url="footerNav.jsp" />
</body>
</html>