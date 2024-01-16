<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<body>
	<h3>Information for all employees</h3>
	<br>
	<br>
	<security:authorize access="hasRole('HR')">
		<input type="button" value="salary"
			onClick="window.location.href = 'hr_info'"> Only for HR stuff
	</security:authorize>
	<br>
	<br>
	<security:authorize access="hasRole('MANAGER')">
		<input type="button" value="performance"
			onClick="window.location.href = 'manager_info'"> Only for
	managers
	</security:authorize>
</body>
</html>
