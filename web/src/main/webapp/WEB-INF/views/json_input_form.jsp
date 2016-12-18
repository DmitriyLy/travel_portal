<%--
  Created by IntelliJ IDEA.
  User: dima_2
  Date: 18.12.2016
  Time: 19:51
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Handling JSON</title>
</head>
<body>

<h2>Student Information</h2>
<form method="POST" action="/json4">
    <table>
        <tr>
            <td><label>Input JSON text</label></td>
            <td><textarea name="json_text" rows="5" cols="50">
                Enter JSON here...
            </textarea></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
