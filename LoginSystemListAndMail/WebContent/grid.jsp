<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="Login.Registration.ListAndMail.*"%>
<%@ page import="Login.Registration.Model.*"%>
<%@ page import="LoginListAndMail.Registration.Hibernate.RetunrnResponse"%>
<%@ page import="java.lang.reflect.Method"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="CSS/detailList.css">
<body>
	<jsp:include page="adminPage.jsp"/>   
	<p>Users List</p>
	<table id="detailsList" cellpadding="0" cellspacing="0" border=2>
	<%
		RegistrationDAO registrationDAO = new RegistrationDAOImpl();
		System.out.println("grid jsp class 1:");
		RetunrnResponse returnResponse = registrationDAO.getUserList();
		System.out.println("grid jsp class 2:");
		HashMap<String, ArrayList> mapResponse = returnResponse.getMapResponse();
		
		ArrayList<Object> listValues = (ArrayList<Object>)mapResponse.get("listValues");
		ArrayList<TablesDet> tablesDets = (ArrayList<TablesDet>)mapResponse.get("tableValues");
		System.out.println("grid jsp class 3:"+listValues);
		System.out.println("grid jsp class 3.1:"+tablesDets);
	%>
	<tr>
	<%
	for(TablesDet tableDet : tablesDets)
	{
		if(tableDet.getDisplayName() != null)
		{
			System.out.println("RegistrationDAOImpl grid jsp header:"+tableDet.getDisplayName());
	%>
			
				<th><%= tableDet.getDisplayName() %></th>
	<%
			
		}
	}
	%>
	</tr><tbody>
	<%
	for (Object object : listValues) 
	{
		Class<?> classToCall = object.getClass();
		 Method declaredMethod = classToCall.getDeclaredMethod("getId");
		 Object returnObject = declaredMethod.invoke(object);
		//BaseModel model = (BaseModel)object;
		//System.out.println("RegistrationDAOImpl grid jsp class 5:"+model);
		%><tr>
		<td class="ids"><%= ((Long) returnObject).longValue() %></td>
		<%
		System.out.println("RegistrationDAOImpl grid jsp class 6:");
		for(TablesDet tableDet : tablesDets)
		{
		    String field = tableDet.getName();
		    String methodToCall = "get".concat(field.replaceAll("_", ""));
		    //Class<? extends Number> call = (Class<? extends Number>) object.getClass();
		    
		    declaredMethod = classToCall.getDeclaredMethod(methodToCall);
		    returnObject = declaredMethod.invoke(object);

		    System.out.println("returnObject:" + returnObject);
			if (returnObject != null)
		    {
				if (returnObject instanceof Long)
				{
					System.out.println("returnObject Long:" + returnObject);
					%><td><%= ((Long) returnObject).longValue() %></td><%
				}
				else if (returnObject instanceof Integer) 
				{
					System.out.println("returnObject Integer:" + returnObject);
					%><td><%= ((Integer) returnObject).intValue() %></td><%
				} 
				else if (returnObject instanceof String) 
				{
					System.out.println("returnObject String:" + returnObject);
					%><td><%= String.valueOf(returnObject) %></td><%
				}
		    }
		}
		%></tr><%
	}
	%>
	</tbody>
	</table>
</body>
<script>
highlight_row();
function highlight_row() 
{
    var table = document.getElementById('detailsList');
    var cells = table.getElementsByTagName('td');
    for (var i = 0; i < cells.length; i++) 
    {
        // Take each cell
        var cell = cells[i];
        // do something on onclick event for cell
        cell.onclick = function () {
        /**alert("Cell[0]:"+cells[0]);**/
            // Get the row id where the cell exists
            var rowId = this.parentNode.rowIndex;

            var rowsNotSelected = table.getElementsByTagName('tr');
           /** for (var row = 0; row < rowsNotSelected.length; row++) {
                rowsNotSelected[row].style.backgroundColor = "";
                rowsNotSelected[row].classList.remove('selected');
            }**/
            var rowSelected = table.getElementsByTagName('tr')[rowId];
           /** rowSelected.style.backgroundColor = "yellow";**/
            /**rowSelected.className += " selected";**/

            msg = 'The ID of the company is: ' + rowSelected.cells[0].innerHTML;
           /** msg += '\nThe cell value is: ' + this.innerHTML;**/
            alert("ms:"+rowSelected.cells[0].innerHTML);
          /** request.setAttribute("userId", rowSelected.cells[0].innerHTML)**/
            window.location.href ='userDetails.jsp?userId=' + rowSelected.cells[0].innerHTML;
        }
    }

}
</script>
</html>