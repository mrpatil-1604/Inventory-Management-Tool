<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta lang="en">
<head>
     <style>
        :root {
	--color-gradient: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(159,159,245,1) 51%, rgba(0,212,255,1) 100%);
	--color-background: rgb(2,0,36);

}


body {

	color: black;
	background: var(--color-background);
	background: var(--color-gradient);
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
	font-weight: 500;

}

#survey-form {
	width: 60vw;
	max-width: 500px;
	min-width: 300px;
	margin: 0 auto;
	padding: 30px;
	border: none;
	border-radius: 10px;
	-webkit-backdrop-filter: blur(10px);
	backdrop-filter: blur(10px);
	background-color: rgba(243, 243, 243, 0.2);
	
}



#name, #email, #lastname, #age {
	display: block;
	margin-right: 0px;
	padding: 3px;
	width: 99%;
	height: 28px;
	background-color: rgba(53, 53, 100, 0.877);
	color: white;
}

#number {
	display: block;
	margin-right: 0px;
	padding: 3px;
	width: 20%;
	height: 28px;
	background-color: rgba(53, 53, 100, 0.877);
	color: white;
}

fieldset {
	border: none;
	padding: 1rem 0;

  }

label {
	display: block;
	margin: 0.5rem 0;
	width: 100%;

}

#name-label, #lastname-label, #email-label, #number-label {
	color: white;

}

select {
  margin: 10px 0 0 0;
	width: 100%;
  min-height: 2em;
}

h1 {
	font-family: 'Caveat', cursive;
	color: rgb(7,12,50);
	text-align: center;
	font-size: 55px;
}

h2 {
	margin-top: 0px;
	color: black;
}

p {
	font-size: 20px;
	font-weight: 400;
	color: white;
	text-align: center;
}

#title {
	padding-top: 25px;
}

#options {
	padding: 20px 0px;
	margin:0%;
	color: black;
}

.radio {
	width: unset;
	margin: 0 0.5em 0 0;
	vertical-align: middle;
}

textarea {
	background-color: rgba(53, 53, 100, 0.877);
	margin: none;
	display: block;
	color: white;
	font-size:15px;
	margin-top: 15px;
	margin: 10px 0 0 0;
	width: 100%;
  min-height: 2em;
	padding: 5px;
	border: 1px solid;
	border-radius: 5px;
}

input {
	background-color: rgba(53, 53, 100, 0.877);
	color: white;
	border: 1px solid;
	border-radius: 5px;

}

#dropdown {
	background-color: rgba(53, 53, 100, 0.877);
	color: white;
	border: 1px solid;
	border-radius: 5px white;


}

#submit {
	font-size: 15px;
	padding: 0%;
	width: 150px;
	height: 35px;
	border: 1px solid;
	border-radius: 5px;

}

#Coments {
	color: rgb(7,12,50);
	font-weight: 600;
	font-size: 18px;
}

#checkbox {
		margin: 0 0.5em 0 0;

}

@media (max-width: 500px) {
	h1 {
		font-size: 3em;
		transition: all 700ms;
	}

	#description {
		font-size: 1.1em;
		margin-bottom: 0;
		transition: all 700ms;
	}

	fieldset {
		font-size: 0.95em;
		transition: all 700ms;
	}

	#survey-form {
		padding: 1em 1.2em;
	}

	textarea {
		width: 95%;
	}

}
   body {
  margin: 0;
  padding: 0;
  color: #fff;
  font-family: 'Open Sans', Helvetica, sans-serif;
  box-sizing: border-box;
}

/* Assign grid instructions to our parent grid container, mobile-first (hide the sidenav) */
.grid-container {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 50px 1fr 50px;
  grid-template-areas:
    'header'
    'main'
    'footer';
  height: 100vh;
}

.menu-icon {
  position: fixed; /* Needs to stay visible for all mobile scrolling */
  display: flex;
  top: 5px;
  left: 10px;
  align-items: center;
  justify-content: center;
  background-color: #DADAE3;
  border-radius: 50%;
  z-index: 1;
  cursor: pointer;
  padding: 12px;
}

/* Give every child element its grid name */
.header {
  grid-area: header;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 16px;
  background-color: #648ca6;
}

/* Make room for the menu icon on mobile */
.header__search {
  margin-left: 42px;
}

.sidenav {
  grid-area: sidenav;
  display: flex;
  flex-direction: column;
  height: 100%;
  width: 240px;
  position: fixed;
  overflow-y: auto;
  transform: translateX(-245px);
  transition: all .6s ease-in-out;
  box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.16), 0 0 0 1px rgba(0, 0, 0, 0.08);
  z-index: 2; /* Needs to sit above the hamburger menu icon */
  background-color: #394263;
}

.sidenav.active {
  transform: translateX(0);
}

.sidenav__close-icon {
  position: absolute;
  visibility: visible;
  top: 8px;
  right: 12px;
  cursor: pointer;
  font-size: 20px;
  color: #ddd;
}

.sidenav__list {
  padding: 0;
  margin-top: 85px;
  list-style-type: none;
}

.sidenav__list-item {
  padding: 20px 20px 20px 40px;
  color: #ddd;
}

.sidenav__list-item:hover {
  background-color: rgba(255, 255, 255, 0.2);
  cursor: pointer;
}

.main {
  grid-area: main;
  background-color: #8fd4d9;
}

.main-header {
  display: flex;
  justify-content: space-between;
  margin: 20px;
  padding: 20px;
  height: 150px;
  background-color: #e3e4e6;
  color: slategray;
}

.main-overview {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(265px, 1fr));
  grid-auto-rows: 94px;
  grid-gap: 20px;
  margin: 20px;
}

.overviewcard {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 20px;
  background-color: #d3d3;
}

.main-cards {
  column-count: 1;
  column-gap: 20px;
  margin: 20px;
}

.card {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  background-color: #82bef6;
  margin-bottom: 20px;
  -webkit-column-break-inside: avoid;
  padding: 24px;
  box-sizing: border-box;
}

/* Force varying heights to simulate dynamic content */
.card:first-child {
  height: 485px;
}

.card:nth-child(2) {
  height: 200px;
}

.card:nth-child(3) {
  height: 265px;
}

.footer {
  grid-area: footer;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 16px;
  background-color: #648ca6;
}

/* Non-mobile styles, 750px breakpoint */
@media only screen and (min-width: 46.875em) {
  /* Show the sidenav */
  .grid-container {
    grid-template-columns: 240px 1fr;
    grid-template-areas:
      "sidenav header"
      "sidenav main"
      "sidenav footer";
  }

  .header__search {
    margin-left: 0;
  }

  .sidenav {
    position: relative;
    transform: translateX(0);
  }

  .sidenav__close-icon {
    visibility: hidden;
  }
}

/* Medium screens breakpoint (1050px) */
@media only screen and (min-width: 65.625em) {
  /* Break out main cards into two columns */
  .main-cards {
    column-count: 2;
  }
}
    </style>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="style.css">
<title>Orientation to web development</title> 
</head>
<body>
<div class="grid-container">
    <div class="menu-icon">
     <i class="fas fa-bars header__menu"></i>
   </div>
    
   <header class="header">
     <div class="header__search"></div>
     <div class="header__avatar"></div>
   </header>
 
   <aside class="sidenav">
     <div class="sidenav__close-icon">
       <i class="fas fa-times sidenav__brand-close"></i>
     </div>
     <ul class="sidenav__list">
       <li class="sidenav__list-item"><a href ="addRaw"><font color="white">Add Raw Material</font></a></li>
       <li class="sidenav__list-item"><a href ="viewRaw"><font color="white">View Raw Material</font></a></li>
       <li class="sidenav__list-item"><a href ="addProcessed"><font color="white">Add Processed Material</font></a></li>
       <li class="sidenav__list-item"><a href ="viewProcessed"><font color="white">View Processed Material</font></a></li>
       <li class="sidenav__list-item"><a href ="viewLogsRaw"><font color="white">Views Logs-raw</font></a></li>
       <li class="sidenav__list-item"><a href ="viewLogsPro"><font color="white">Views Logs-processed</font></a></li>
       <li class="sidenav__list-item"><a href ="viewUnavailRaw"><font color="white">Views Process Unavailble</font></a></li>
       <li class="sidenav__list-item"><a href ="viewUnavailPro"><font color="white">Views Raw Unavailble</font></a></li>
     </ul>
   </aside>
  <fieldset>
  <form action="issuedRawMat" method="post"id="survey-form">
      <label id="name-label"> <b>Enter Id</b> </label><input id="name" type="number"name="Id" placeholder="Id" required/>
        <label id="lastname-label"></label><input id="name" name="name"type="hidden" value="<%=request.getParameter("name")%>"/> 
          <label id="email-label"> <b>Enter Quantity</b> </label><input id="" type="number"name="quantity"  required/> 
            <label id="number-label"> <b>Enter Issuer name</b> </label><input id="number" type="text" name="issuerName"  required/>
			<label id="number-label"> <b>Issued date</b> </label><input  type="date" name="date"   required/>
          	<label id="number-label"> </label><input  type="hidden" name="itemId" value="<%=request.getParameter("Id")%>" /><br>
        <input id="submit" type="submit" name="submit">
          </fieldset>         
  </form>

</body>

</html>