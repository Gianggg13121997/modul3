<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Hotel" %>
<%@ page import="java.util.List" %>
<%@ page import="service.HotelService" %>
<%@ page import="java.sql.*" %>
<%@ page import="database.DatabaseConnection" %>
<%
    List<Hotel> hotels = (List<Hotel>) request.getAttribute("hotels");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hotel Manager</title>
</head>
<body>
<h1>Hotel Manager</h1>

<h2>Add Hotel</h2>
<form action="${pageContext.request.contextPath}/hotel" method="post">
    <label for="nameGuest">Name:</label>
    <input type="text" id="nameGuest" name="nameGuest" required><br>
    <label for="phone">Phone:</label>
    <input type="text" id="phone" name="phone" required><br>
    <label for="date">Date:</label>
    <input type="text" id="date" name="date" required><br>
    <label for="typePayment">Type Payment:</label>
    <select id="typePayment" name="typePayment" required>
        <%
            try (Connection conn = DatabaseConnection.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM typePayment")) {
                while (rs.next()) {
        %>
        <option value="<%= rs.getInt("id") %>"><%= rs.getString("type") %></option>
        <%
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        %>
    </select><br>
    <label for="note">Note:</label>
    <textarea id="note" name="note"></textarea><br>
    <input type="submit" value="Add Hotel">
</form>

<h2>Hotel List</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Date</th>
        <th>Type Payment</th>
        <th>Note</th>
    </tr>
    <%
        for (Hotel hotel : hotels) {
    %>
    <tr>
        <td><%= hotel.getId() %></td>
        <td><%= hotel.getNameGuest() %></td>
        <td><%= hotel.getPhone() %></td>
        <td><%= hotel.getDate() %></td>
        <td><%= hotel.getTypePayment() %></td>
        <td><%= hotel.getNote() %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
