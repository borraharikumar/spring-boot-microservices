

function validate(form){
	
	//Reading form data
	let name = form.name.value;
	let email = form.email.value;
	let hireDate = new Date(form.hireDate.value);
	let job = form.job.value;
	let salary = form.salary.value;
	
	let flag=true;
	
	alert("Client side validations are going...!");
	
	//name validation
	if(name==""){
		document.getElementById("nameErr").innerHTML="Name must be filled out";
		flag=false;
	} else if(name.length>20){
		document.getElementById("nameErr").innerHTML="Name can contain up to 20 characters only";
		flag=false;
	}
	//email validation
	if(email==""){
		document.getElementById("emailErr").innerHTML="Email must be filled out";
		flag=false;
	} else if(email.length>20){
		document.getElementById("emailErr").innerHTML="Email can contain up to 20 characters only";
		flag=false;
	}
	//hireDate validation
	if(hireDate==""){
		document.getElementById("hireDateErr").innerHTML="Hire-date must be filled out";
		flag=false;
	} else if(hireDate>new Date()){
		document.getElementById("hireDateErr").innerHTML="Hire-date can be up to today's date only";
		flag=false;
	}
	//job validation
	if(job.length>10){
		document.getElementById("jobErr").innerHTML="Job can contain up to 10 characters only";
		flag=false;
	}
	//salary validation
	if(salary==""){
		document.getElementById("salaryErr").innerHTML="Salary must be filled out";
		flag=false;
	} else if(isNaN(salary)){
		document.getElementById("salaryErr").innerHTML="Salary must be numeric value";
		flag=false;
	} else if(salary<10000 || salary>1000000){
		document.getElementById("salaryErr").innerHTML="Salary range can be from 10000 to 1000000 only";
		flag=false;
	}
	
	form.vflag.value="yes";
	
	return flag;
	
}






