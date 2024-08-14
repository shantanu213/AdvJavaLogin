<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="regform" method="post">
          NAME  :   <input type="text" name="name1"/><br/><br/>
          Email :   <input type="text" name="email"/><br/><br/>
       PassWord :   <input type="password" name="pass1"><br/><br/>
         Gender :   <input type="radio" name="gender"/>MALE<input type="radio" name="gender">FEMALE <br/><br/>
           city :   <select name="city1">
                    <option>SELECT CITY</option>
                    <option>NAGPUR</option>
                    <option>PUNE</option>
                    <option>GUJRAT</option>
                    <option>HYDERBAD</option>
                </select>  <br/><br/>
                <input type="submit" value="Register">
     </form>
     
</body>
</html>