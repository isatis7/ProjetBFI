<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale.language}">
<head>
<title><spring:message code="entities.user.create.collaborateur.title" /></title>
<c:import url="commonsHead.jsp" />
</head>
<body>
	<c:import url="headerNav.jsp" />

	<div class="container-fluid">
		<section>
			<h1 class="text-primary">
				<spring:message code="entities.user.create.collaborateur.title" />
			</h1>
			
			<p class="bg-success">
			<c:if test="${success}">
				<span class="success"> <spring:message
						code="commons.forms.create.user.collaborateur.success" />
				</span>
			</c:if>
			</p>
			
			<form:form action="createCollaborateur" method="POST" modelAttribute="user">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			
				<div class="form-row">
					<div class="form-group col">
					<input type="hidden" name="firstname" value="${user.collaborateur.prenom}" />
					<input type="hidden" name="lastname" value="${user.collaborateur.nom}" />
					<input type="hidden" name="email" value="${user.collaborateur.email}" />
						<form:label path="collaborateur.id"><spring:message code="entities.user.collaborateur" /></form:label>
						<form:select path="collaborateur.id" cssClass="form-control" cssErrorClass="form-control is-invalid" onchange="getCollaborateurInfos(this.value)">
							<form:option value="0"><spring:message code="commons.forms.select" /></form:option>
							<form:options items="${collaborateurs}" itemValue="id" itemLabel="infoComplet" />
						</form:select>
						<form:errors element="div" path="collaborateur.id" cssClass="invalid-feedback" />
					</div>
				</div>
				<div class="form-row">		
					<div class="form-group col">
						<form:label path="password"><spring:message code="entities.user.password" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:password path="password" maxlength="100" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" />
						<form:errors element="div" path="password" cssClass="invalid-feedback" />
					</div>
					<div class="form-group col">
						<form:label path="role"><spring:message code="entities.user.role" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:select path="role" cssClass="form-control" cssErrorClass="form-control is-invalid">
							<form:options items="${rolesCollaborateur}" />
						</form:select>
						<form:errors element="div" path="role" cssClass="invalid-feedback" />
					</div>
				</div>
				<form:button class="btn btn-primary mb-3"><spring:message code="commons.forms.save" /></form:button>
			</form:form>
		</section>
	</div>

	<c:import url="footerNav.jsp" />
</body>
</html>