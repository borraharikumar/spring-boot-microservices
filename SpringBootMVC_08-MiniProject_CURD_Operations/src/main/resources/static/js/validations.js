
function validate() {
	//Emptying the error messages
//	document.getElementById("nameErr").innerHTML="";
//	document.getElementById("mobileErr").innerHTML="";
//	document.getElementById("emailErr").innerHTML="";
//	document.getElementById("addresslErr").innerHTML="";
//	document.getElementById("hireDateErr").innerHTML="";
//	document.getElementById("designationErr").innerHTML="";
	
	
	//Reading form data
	let name = document.forms["employee"]["name"].value;
	let mobile = document.forms["employee"]["mobile"].value;
	let email = document.forms["employee"]["email"].value;
	let address = document.forms["employee"]["address"].value;
	let hireDate = document.forms["employee"]["hireDate"].value;
	let designation = document.forms["employee"]["designation"].value;
	let salary = document.forms["employee"]["salary"].value;
	
	let flag = false;
	
	//Form validations
	if(name=="") {
		document.write("Enter employee name");
		flag=false;
	} else if(name.length>20) {
		document.write("Employee name can contain upto 20 characters only");
		flag=false;
	}
	
	if(mobile=="") {
		document.write("Enter mobile number");
		flag=false;
	} else if(isNaN(mobile)) {
		document.write("Mobile number should be numeric");
		flag=false;
	} else if(mobile.length!=10) {
		document.write("Mobile number should contain 10 digits");
		flag=false;
	}
	
	if(email=="") {
		document.write("Enter email");
		flag=false;
	} else if(email.length>20) {
		document.write("Email can contain upto 20 characters only");
		flag=false;
	}
	
	if(address=="") {
		document.write("Enter address");
		flag=false;
	} else if(address.length>20) {
		document.write("Address can contain upto 20 characters only");
		flag=false;
	}
	
	if(hireDate=="") {
		document.write("Enter hire-date");
		flag=false;
	} else if(hireDate.getTime() > new Date().getTime()) {
		document.write("Hire-date can be up to todays date only");
		flag=false;
	}
	
	if(designation.toUpperCase()=="HACKER") {
		document.write("Hackers are not allowed to hire");
		flag=false;
	} else if(designation.length>20) {
		document.write("Designation can contain upto 20 characters only");
		flag=false;
	}
	
	if(salary=="") {
		document.write("Enter salary");
		flag=false;
	} else if(isNaN(salary)) {
		document.write("Salary number should be numeric");
		flag=false;
	} else if(salary<10000 || salary>1000000) {
		document.write("Salary range can be from 10000 to 1000000");
		flag=false;
	}
	
	alert("Validations completed...!");
	return false;
	
}