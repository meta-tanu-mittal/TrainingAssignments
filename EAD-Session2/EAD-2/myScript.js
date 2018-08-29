/*validate whether all the inputs are valid or not
*/
function validateFormData()
{
	if(validateFirstName() && validateLastName()
		&& validateContact() &&  validateEmail() && validatePassword()
		&& validateConfirmPassword())
		{
			alert("form submitted successfully!!");
			return true;
		}
		else
		{
			alert("error:some error in form!!");
			return false;
		}
}

/*validate first name containing atleast 2 characters and no numeric digit
*/
function validateFirstName(){
	var name = document.getElementById("firstName");
	var letters=/^[a-zA-Z]+$/;
    if( letters.test(name.value) && name.value.length>=2)
	{
        name.style.border="2px solid green";
        return true;
		}
    else
    {
        name.style.border="2px solid red";
        return false;
    }
}

/*validate last name containing atleast 2 characters and no numeric digit
*/
function validateLastName(){
	var name = document.getElementById("lastName");
	var letters=/^[a-zA-Z]+$/;
    if( letters.test(name.value) && name.value.length>=2)
	{
        name.style.border="2px solid green";
        return true;
		}
    else
    {
        name.style.border="2px solid red";
        return false;
    }
}


/*validate contact number
*/    
function validateContact()
    {
        var letters=/^[0-9]+$/;
        var x=document.getElementById("contact");
        if(letters.test(x.value) && x.value.length>=8)
            {
				x.style.border="2px solid green";
			    return true;
            }
        else{
            x.style.border="2px solid red";
            return false;
        }
    }

/*validate password and return true if minumum length is 2 and contain atleast one number,uppercase and lowercase
*/	
	function validatePassword()
	{
		var message=document.getElementById("typePassword");
		var x=document.getElementById("pass");
		
		var re=/[0-9]/;
		if(!re.test(x.value))
		{
			message.innerHTML="password should contain atleast one number";
			x.style.border="2px solid red";
			return false;
		}
		var re=/[a-z]/;
		if(!re.test(x.value))
		{
			message.innerHTML="password should contain atleast one lower case";
			x.style.border="2px solid red";
			return false;
		}
	
		var re=/[A-Z]/;
		if(!re.test(x.value))
		{
			message.innerHTML="password should contain atleast one upper case";
			x.style.border="2px solid red";
			return false;
		}
        
		if(x.value.length<8)
		{
			message.innerHTML="password shold contain 8 letters";
			x.style.border="2px solid red";
			return false;
		}
		message.innerHTML="";
		x.style.border="2px solid green";
		return true;
	}
    
/*validate email
*/	
function validateEmail()
    {  
	   var message=document.getElementById("typeEmail");
	   var email = document.getElementById('email');
    if(/^([a-z0-9_\-\.]+)@([a-z0-9_\-\.]+)\.([a-z]+)$/.test(email.value)){
        email.style.border = "2px solid green";
		message.innerHTML="";
        return true;
    }else{
        email.style.border = "2px solid red";
		message.innerHTML="invalid email";
        return false;
    }
    }

/*check whether confirm password is equal to password or not
*/	
function validateConfirmPassword()
	{
		var pass=document.getElementById("pass");
		var confirmPass=document.getElementById("confirmPass");
		var message=document.getElementById("spanConfirmPass");
		if((pass.value)==(confirmPass.value))
		{
			confirmPass.style.border="2px solid green";
			message.innerHTML="Password matched";
			return true;
		}
		else{
			confirmPass.style.border="2px solid red";
			message.innerHTML="Password did not match";
			return false;
		}
	}