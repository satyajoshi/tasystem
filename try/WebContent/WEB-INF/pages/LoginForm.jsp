<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Talent Acquisition System</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
<script>
$(document).ready(function(){
	$('#mainMenu li').hover(function(){
		$(this).closest('li').find('ul').css({'opacity':0,'margin-top':15}).show().animate({'margin-top':0,'opacity':1},300);
		},function(){
		$(this).closest('li').find('>ul').fadeOut(200,function(){
			 $(this).hide();   
		});
	});
	/*---------login-------*/	
	$("#login").click(function(){
		var list = document.loginForm.selectrole;
		var role = list.options[ list.selectedIndex ].value;
		
		if (role == "techlead"){
			location.href="techLead/tlHome.html";
		}
		else if (role == "recruiter"){
			location.href="recruiter/recHome.html";
		}
		else if (role == "sme"){
			location.href="sme/smeHome.html";
		}
		else{
			alert('Please Select Role');
		}

	});
});
</script>
<style type="text/css">
/*----col-------------*/
.col1 {
	width:5%;
}
.col2 {
	width:15%;
}
.col3 {
	width:15%;
}
.col4 {
	width:15%;
}
.col5 {
	width:15%;
}
.col6 {
	width:10%;
}
.col7 {
	width:15%;
}
.col8 {
	width:10%;
}
</style>
</head>
<body>
<div class="header">
  <div class="wrap">
    <div class="logo fl"> <img src="images/YASH.png" width="116" height="70" hspace="10" alt="JohnDeere"> </div>
    <div class="appName fr">
    	<h1><img src="images/appName.png" width="348" height="30"></h1>
    </div>
    <div class="clear"></div>
  </div>
</div>
<!-------main content div start---->
<div class="mainContent">
  <div class="wrap">
    <div id="centerContent" class="paddinLogin">
    <form id="loginForm" name="loginForm" method="post" action="">
      <div class="wrapLogin">
        <div class="pageTitle">
          <h4 class="pageTitleHead">Login</h4>
        </div>
        <div class="loginDetail">
          <label>Role :</label>
          <select name="selectrole" id="selectrole">
          	<option value="">Select</option>
	        <option value="tl">Team Lead</option>
          	<option value="recruiter">Recruiter</option>
            <option value="sme">SME</option>
          </select>
          <div class="clear"></div>
        </div>
        <div class="loginDetail">
          <label>User Name :</label>
          <input type="text" value="" name="" id="txtUserName" />
          <div class="clear"></div>
        </div>
        <div class="loginDetail">
          <label>Password :</label>
          <input type="password" value="" name="" id="txtPassword" />
          <div class="clear"></div>
        </div>
        <div class="loginDetail">
          <label>&nbsp;</label>
          <input name="login" type="button" value="Login" class="blueBtn" id="login" />
          &nbsp;
          <input name="cancel" type="button" value="Cancel" class="blueBtn" id="cancel" />
          <div class="clear"></div>
        </div>
        <div class="clear"></div>
      </div>
    </form>  
    </div>
    <!--footer--->
    <div class="footer"> Copyright © 2012. YASH Technologies. All Rights Reserved. </div>
    <!--footer end---> 
  </div>
</div>
<!-------main content div start---->
</body>
</html>
