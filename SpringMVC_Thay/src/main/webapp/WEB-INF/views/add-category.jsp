<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<h1>Add Category</h1>
<form:form modelAttribute="c">
	<p>
		<form:label path="categoryName">Name:</form:label>
		<form:input path="categoryName"/>
	</p>
	<p>
		<form:label path="parentId">Parent:</form:label>
		<form:select path="parentId">
		<%--cái categoryId đưa vào parentId --%>
			<form:options items="${parents }" itemLabel="categoryName" itemValue="categoryId" />
		</form:select>
	</p>
	<form:button>Save</form:button>
</form:form>