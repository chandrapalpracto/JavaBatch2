<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>

<h2>HTML Table</h2>

<table>
  <tr>
      <th>S. No</th>
    <th>Task</th>
    <th>Task Description</th>
        <th>Action</th>
  </tr>
  <c:forEach var = "x" items="${ list }">
  <tr>
        <td>    ${x.id }</td>
    <td>    ${x.task }</td>
        <td>    ${x.taskDesc }</td>
        <form action="edit">
        <input type="hidden" name ="id" value=" ${x.id }"/>
         <input type="hidden" name ="task" value= " ${x.task }"/>
                 <input type="hidden" name ="taskDesc" value= " ${x.taskDesc }"/>
        <td><input type="submit" value="Update"/></td>
        </form>

  </tr>
</c:forEach>
  
</table>


</body>
</html>

