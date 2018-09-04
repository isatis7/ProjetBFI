<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="${pageContext.response.locale.language}">
<head>
<title><spring:message code="entities.demande.create.title" /></title>
<c:import url="commonsHead.jsp" />
</head>
<body>
	<c:import url="headerNav.jsp" />
	<div class="container-fluid">
		<section>
			<h1 class="text-primary"><spring:message code="entities.demande.create.title" /></h1>
			<h3 class="text-primary"><spring:message code="entities.demande.create.hello" />${client.nom}, nous sommes le<fmt:formatDate value="${today}" pattern="dd/MM/yyyy"/></h3>
			<form:form action="create" method="POST" modelAttribute="demandeFinancement">
				<div class="form-row">
					<div class="form-group col">
						<form:label path="reference"><spring:message code="entities.demandeFinancement.reference" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<div class="input-group">
							<div class="input-group-prepend"></div>
							<form:input path="reference" maxlength="10" placeHolder="REF0111222" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" lang="fr" />
							<form:errors element="div" path="reference" cssClass="invalid-feedback" />
						</div>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col">
						<form:label path="duree"><spring:message code="entities.demandeFinancement.duree" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<div class="input-group">
							<div class="input-group-prepend"></div>
							<form:input path="duree" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" lang="fr" />
							<form:errors element="div" path="duree" cssClass="invalid-feedback" />
						</div>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col">
						<form:label path="montant"><spring:message code="entities.demandeFinancement.montant" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<div class="input-group">
							<div class="input-group-prepend"></div>
							<form:input path="montant" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" lang="fr" />
							<form:errors element="div" path="reference" cssClass="invalid-feedback" />
						</div>
					</div>
				</div>
				
				<div class="form-row">
			 		<spring:message code="commons.formats.date" var="datePattern" />
					<div class="form-group col">
						<form:label path="dateEffective"><spring:message code="entities.demandeFinancement.dateEffective" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:input path="dateEffective" maxlength="10" placeHolder="${datePattern}" cssClass="form-control datepicker" cssErrorClass="form-control datepicker is-invalid" autocomplete="off" />
						<form:errors element="div" path="dateEffective" cssClass="invalid-feedback" />
					</div>
					
				</div>
				
			 	<div class="form-row">
					<div class="form-group col">
						<form:label path="code"><spring:message code="entities.course.code" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:input path="code" maxlength="4" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" />
						<form:errors element="div" path="code" cssClass="invalid-feedback" />
					</div>
					<div class="form-group col">
						<form:label path="type.id"><spring:message code="entities.course.type" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:select path="type.id" cssClass="form-control" cssErrorClass="form-control is-invalid">
							<form:option value="0"><spring:message code="commons.forms.select" /></form:option>
							<form:options items="${courseTypes}" itemValue="id" itemLabel="name" />
						</form:select>
						<form:errors element="div" path="type.id" cssClass="invalid-feedback" />
					</div>
					<div class="form-group col">
						<form:label path="price"><spring:message code="entities.course.price" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<div class="input-group">
							<div class="input-group-prepend">
					        	<div class="input-group-text"><spring:message code="commons.symbols.euro" /></div>
					        </div>
							<form:input path="price" maxlength="5" placeHolder="0.00" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" />
							<form:errors element="div" path="price" cssClass="invalid-feedback" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<form:label path="frenchDescription"><spring:message code="entities.course.frenchDescription" /></form:label>
					<div class="input-group">
						<div class="input-group-prepend">
						    <div class="input-group-text"><spring:message code="commons.symbols.isoFrench" /></div>
						</div>
						<form:textarea path="frenchDescription" rows="5" cssClass="form-control" lang="fr" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="englishDescription"><spring:message code="entities.course.englishDescription" /></form:label>
					<div class="input-group">
						<div class="input-group-prepend">
						    <div class="input-group-text"><spring:message code="commons.symbols.isoEnglish" /></div>
						</div>
						<form:textarea path="englishDescription" rows="5" cssClass="form-control" lang="en" />
					</div>
				</div>
				<button type="reset" class="btn btn-primary mb-3"><spring:message code="commons.forms.reset" /></button>
				<form:button class="btn btn-primary mb-3"><spring:message code="commons.forms.save" /></form:button>
			</form:form>
		</section>
	</div>
	<c:import url="footerNav.jsp" />
</body>
</html>