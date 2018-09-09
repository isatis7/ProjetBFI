<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale.language}">
<head>
<title><spring:message code="entities.demandefi.traiter.title" /></title>
<c:import url="commonsHead.jsp" />
</head>
<body>
	<c:import url="headerNav.jsp" />

	<div class="container-fluid">
		<section>
			<h1 class="text-primary">
				<spring:message code="entities.demandefi.traiter.title" />
			</h1>

			<c:if test="${success}">
				<div class="alert alert-success">
					<spring:message code="commons.forms.traiter.demandefi.success" />
				</div>
			</c:if>
			
			<c:if test="${erreur}">
				<div class="alert alert-danger">
					<p>pb!!</p>
				</div>
			</c:if>

			<div class="alert alert-info">
				<strong><spring:message code="entities.accepterRejeter.messageInfo" /></strong>
				<br>
				&nbsp;- <spring:message code="entities.demandeFinancement.reference" />
				: ${demandeFinancement.reference}<br>
				&nbsp;- <spring:message code="entities.demandeFinancement.clientNom" />
				: ${demandeFinancement.user.lastname} ${demandeFinancement.user.firstname} - ${demandeFinancement.user.client.nom}
			</div>

			<form:form action="traiterDemande" method="POST"
				modelAttribute="demandeFinancement">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div class="form-row">
					<div class="form-group col">
						<form:hidden path="id" />
						<form:hidden path="user.id" />
						<form:hidden path="dateDemande" />
						<form:hidden path="reference" />
						<form:hidden path="duree" />
						<form:hidden path="dateEffective" />
						<form:hidden path="montant" />
						<form:hidden path="devise.id" />
						<form:hidden path="typeFinancement.id" />
						<form:hidden path="perfPlus" />

						<form:label path="validation">
							<spring:message code="entities.accepterRejeter.demandefi" />
						</form:label>

						<form:radiobutton path="validation" value="true" />
						<spring:message code="label.roundYes" />
						<form:radiobutton path="validation" value="false" />
						<spring:message code="label.roundNo" />
					</div>
				</div>

				<form:button class="btn btn-primary mb-3">
					<spring:message code="commons.forms.save" />
				</form:button>
			</form:form>
		</section>
	</div>

	<c:import url="footerNav.jsp" />
</body>
</html>