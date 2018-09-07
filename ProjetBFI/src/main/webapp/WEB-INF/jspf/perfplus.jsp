<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale.language}">
<head>
<title><spring:message code="login.title" /></title>
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
			<c:url value="/perfplus/update" var="formUrl" />
			<form:form method="POST" action="${formUrl}" modelAttribute="parametres">
			<form:hidden path="id"/>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<div class="form-group">
					<form:label path="paramA"><spring:message code="perfplus.paramA" /></form:label>
					<form:input path="paramA" maxlength="5" class="form-control" />
					<form:errors element="div" path="paramA" cssClass="invalid-feedback" />
				</div>
				<div class="form-group">
					<form:label path="paramB"><spring:message code="perfplus.paramB" /></form:label>
					<form:input path="paramB" maxlength="5" class="form-control" />
					<form:errors element="div" path="paramB" cssClass="invalid-feedback" />
				</div>
				<form:button type="submit" class="btn btn-primary mb-3"><spring:message code="perfPlus.submit" /></form:button>
				
			</form:form>
		</section>
	</div>
	</div>
	</div>
	<c:import url="footerNav.jsp" />
</body>
</html>