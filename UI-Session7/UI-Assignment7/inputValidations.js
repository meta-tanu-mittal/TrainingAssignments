function validateFormData() {
    debugger;
    error = '';

    validateFirstName();
    validateLastName();
    validateNumber();
    validateCity();

    var state = document.getElementById("state");
    if (state.value === 'Haryana') {
        validateZipCode();
    }
    if (state.value === 'Maharashtra') {
        validateZipCode();
    }

    if (state.value === 'Rajasthan') {
        validateWebsite();
    }

    var email = document.getElementById("email");
    var address = document.getElementById("address");
    if (error === '') {
        localStorage.setItem("firstName", firstName.value);
        localStorage.setItem("lastName", lastName.value);
        localStorage.setItem("email", email.value);
        localStorage.setItem("phone", phone.value);
        localStorage.setItem("address", address.value);
        localStorage.setItem("city", city.value);
        localStorage.setItem("state", state.value);

        if (state.value === 'Rajasthan') {
            localStorage.setItem("website", website.value);
            project = document.getElementById("project");
            localStorage.setItem("project", project.value);
        }

        if (state.value === 'Maharashtra') {
            localStorage.setItem("zipCode", zipCode.value);
            project = document.getElementById("project");
            localStorage.setItem("project", project.value);

        }
        
        if(state.value==='Haryana')
            {
               localStorage.setItem("zipCode", zipCode.value); 
            }

        alert("form submitted successfully");
        return true;
    } else {
        alert(error);
        return false;
    }
}


function validateFirstName() {
    debugger;
    firstName = document.getElementById("firstName");
    var letters = /[a-zA-Z]{2,}/;
    if (letters.test(firstName.value)) {
        firstName.style.border = "2px solid green";
        return true;
    } else {
        firstName.style.border = "2px solid red";
        error = error + "first name:invalid name\n";
        return false;
    }
}

function validateLastName() {
    debugger;
    lastName = document.getElementById("lastName");
    var letters = /[a-zA-Z]{2,}/;
    if (letters.test(lastName.value)) {
        lastName.style.border = "2px solid green";
        return true;
    } else {
        lastName.style.border = "2px solid red";
        error = error + "lastname:invalid name\n";
        return false;
    }
}

function validateNumber() {
    phone = document.getElementById("phone");
    var letters = /[0-9]{8,12}/;
    if (letters.test(phone.value)) {
        phone.style.border = "2px solid green";
        return true;
    } else {
        phone.style.border = "2px solid red";
        error = error + "phone:invalid number\n";
        return false;
    }
}


function validateZipCode() {
    zipCode = document.getElementById("zipCode");
    var letters = /^[0-9]+$/;
    if (letters.test(zipCode.value) && zipCode.value.length===6) {
        zipCode.style.border = "2px solid green";
        return true;
    } else {
        zipCode.style.border = "2px solid red";
        error = error + "zip code:invalid zip code\n";
        return false;
    }
}

function validateCity() {
    city = document.getElementById("city");
    var letters = /[a-zA-Z]+/;
    if (letters.test(city.value)) {
        city.style.border = "2px solid green";
        return true;
    } else {
        city.style.border = "2px solid red";
        error = error + "city:invalid city \n";
        return false;
    }
}

function validateWebsite() {
    website = document.getElementById("website");
    var letters = /(https?:\/\/).+/;
    if (letters.test(website.value)) {
        website.style.border = "2px solid green";
        return true;
    } else {
        website.style.border = "2px solid red";
        error = error + "website:invalid website\n";
        return false;
    }
}
