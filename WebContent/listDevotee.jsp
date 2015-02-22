<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
			<table width="60%">
				<tr>
					<th width="20%">NOME FEDELE</th>
					<th width="20%">COGNOME FEDELE</th>
					<th width="20%">EMAIL</th>
				</tr>
				<c:forEach var="d" items="${listDevotee}">
					<tr>
						<td>${ d.name }</td>
						<td>${ d.surname }</td>
						<td>${ d.email }</td>
					</tr>
				</c:forEach>
			</table>