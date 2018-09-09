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
<title><spring:message code="entities.demande.create.title" /></title>
<c:import url="commonsHead.jsp" />
</head>
<body>
	<c:import url="headerNav.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<section>
					<!-- Avoir la date actuelle -->
					<jsp:useBean id="now" class="java.util.Date" />
					<fmt:formatDate var="dateNow" value="${now}" pattern="dd/MM/yyyy" />
					<br>
					<div class="card">
						<div class="card-body">
							<strong>Informations de connexion</strong><br> Bonjour
							<sec:authentication property="principal.user.firstname" />
							<sec:authentication property="principal.user.lastname" />
							de l'entreprise
							<sec:authentication property="principal.user.client.nom" />&nbsp;(<sec:authentication property="principal.user.client.code" />),&nbsp;nous sommes le ${dateNow}.
						</div>
					</div>

					<h1 class="text-primary">
						<spring:message code="entities.demande.create.title" />
					</h1>
					<c:if test="${success}">
						<div class="alert alert-success">
							<spring:message
								code="commons.forms.create.demandefi.client.success" />
						</div>
					</c:if>
					<form:form action="create" method="POST"
						modelAttribute="demandeFinancement">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<form:hidden path="user.id" />
						<div class="form-row ">
							<div class="form-group col ">
								<form:label path="reference">
									<spring:message code="entities.demandeFinancement.reference" />
									<span class="text-danger"><spring:message
											code="commons.symbols.required" /></span>
								</form:label>
								<div class="input-group">
									<div class="input-group-prepend"></div>
									<form:input path="reference" maxlength="10"
										placeHolder="REF0111222" cssClass="form-control"
										cssErrorClass="form-control is-invalid" autocomplete="off"
										lang="fr" />
									<form:errors element="div" path="reference"
										cssClass="invalid-feedback" />
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col">
								<form:label path="duree">
									<spring:message code="entities.demandeFinancement.duree" />
									<span class="text-danger"><spring:message
											code="commons.symbols.required" /></span>
								</form:label>
								<div class="input-group">
									<div class="input-group-prepend"></div>
									<form:input path="duree" cssClass="form-control"
										cssErrorClass="form-control is-invalid" autocomplete="off"
										lang="fr" />
									<form:errors element="div" path="duree"
										cssClass="invalid-feedback" />
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col">
								<form:label path="montant">
									<spring:message code="entities.demandeFinancement.montant" />
									<span class="text-danger"><spring:message
											code="commons.symbols.required" /></span>
								</form:label>
								<div class="input-group">
									<div class="input-group-prepend"></div>
									<form:input path="montant" cssClass="form-control"
										cssErrorClass="form-control is-invalid" autocomplete="off"
										lang="fr" />
									<form:errors element="div" path="montant"
										cssClass="invalid-feedback" />
								</div>
							</div>
						</div>

						<div class="form-row">
							<spring:message code="commons.formats.date" var="datePattern" />
							<div class="form-group col">
								<form:label path="dateEffective">
									<spring:message
										code="entities.demandeFinancement.dateEffective" />
									<span class="text-danger"><spring:message
											code="commons.symbols.required" /></span>
								</form:label>
								<form:input path="dateEffective" maxlength="10"
									placeHolder="${datePattern}" cssClass="form-control datepicker"
									cssErrorClass="form-control datepicker is-invalid"
									autocomplete="off" />
								<form:errors element="div" path="dateEffective"
									cssClass="invalid-feedback" />
							</div>
						</div>
						<div class="row">
							<div class="col-sm-1"></div>
							<div class="col-sm-6">
								<div class="form-row">
									<div class="form-group col">
										<div class="input-group">
											<form:label path="devise.id">
												<spring:message code="entities.demandeFinancement.devise" />
												<span class="text-danger"><spring:message
														code="commons.symbols.required" /></span>
											</form:label>
											<form:select path="devise.id" cssClass="form-control"
												cssErrorClass="form-control is-invalid">
												<form:option value="0">
													<spring:message code="commons.forms.select" />
												</form:option>
												<form:options items="${devises}" itemValue="id"
													itemLabel="codeIso" />
											</form:select>
											<form:errors element="div" path="devise.id"
												cssClass="invalid-feedback" />
										</div>
									</div>
								</div>
								<div class="form-row">
									<div class="form-group col">
										<div class="input-group">
											<form:label path="typeFinancement.id">
												<spring:message
													code="entities.demandeFinancement.typeFinancement" />
												<span class="text-danger"><spring:message
														code="commons.symbols.required" /></span>
											</form:label>
											<form:select path="typeFinancement.id"
												cssClass="form-control"
												cssErrorClass="form-control is-invalid">
												<form:option value="0">
													<spring:message code="commons.forms.select" />
												</form:option>
												<form:options items="${types}" itemValue="id"
													itemLabel="nom" />
											</form:select>
											<form:errors element="div" path="typeFinancement.id"
												cssClass="invalid-feedback" />
										</div>
									</div>
								</div>
							</div>
						</div>
						<button type="reset" class="btn btn-primary mb-3">
							<spring:message code="commons.forms.reset" />
						</button>
						<form:button class="btn btn-primary mb-3">
							<spring:message code="commons.forms.save" />
						</form:button>
					</form:form>
				</section>
			</div>
			<div class="col-sm-2"></div>
		</div>
	</div>
	<c:import url="footerNav.jsp" />
</body>
</html>