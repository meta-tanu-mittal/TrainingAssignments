function addProject() {
    var x = document.createElement("div");
    x.setAttribute("class", "input-container");
    var y = document.createElement("div");
    y.setAttribute("class", "text-name");

    var label = document.createElement("label");
    var project = document.createTextNode("Project Description");
    x.appendChild(y);
    label.appendChild(project);
    y.appendChild(label);

    var z = document.createElement("div");
    var icon = document.createElement("i");
    var input = document.createElement("textarea");

    x.appendChild(z);
    icon.setAttribute("class", "fa fa-pencil-alt icon");
    input.setAttribute("placeholder", "Project Description");
    input.setAttribute("rows", "2");
    input.setAttribute("cols", "22");
    input.setAttribute("class", "input-field");
    input.setAttribute("id","project");
    z.appendChild(icon);
    z.appendChild(input);
    document.getElementById('myForm').appendChild(x);
}

function addWebsite() {
    var x = document.createElement("div");
    x.setAttribute("class", "input-container");
    var y = document.createElement("div");
    y.setAttribute("class", "text-name");

    var label = document.createElement("label");
    var websiteLabel = document.createTextNode("Website or domain name");
    x.appendChild(y);
    label.appendChild(websiteLabel);
    y.appendChild(label);

    var z = document.createElement("div");
    var icon = document.createElement("i");
    var input = document.createElement("input");
    input.setAttribute("type", "text");
    input.setAttribute("id","website")
    input.setAttribute("onkeyup","validateWebsite()")

    x.appendChild(z);
    icon.setAttribute("class", "fa fa-globe-asia icon");
    input.setAttribute("placeholder", "Website or domain name");
    input.setAttribute("class", "input-field");
    z.appendChild(icon);
    z.appendChild(input);
    document.getElementById('myForm').appendChild(x);
}

function addZipCode() {
    var x = document.createElement("div");
    x.setAttribute("class", "input-container");
    var y = document.createElement("div");
    y.setAttribute("class", "text-name");

    var label = document.createElement("label");
    var zip = document.createTextNode("Zip Code");
    x.appendChild(y);
    label.appendChild(zip);
    y.appendChild(label);

    var z = document.createElement("div");
    var icon = document.createElement("i");
    var input = document.createElement("input");
    input.setAttribute("type", "text");

    x.appendChild(z);
    icon.setAttribute("class", "fa fa-home icon");
    input.setAttribute("placeholder", "Zip Code");
    input.setAttribute("class", "input-field");
    input.setAttribute("id","zipCode");
    input.setAttribute("onkeyup","validateZipCode()");
    z.appendChild(icon);
    z.appendChild(input);
    document.getElementById('myForm').appendChild(x);
}

function addHaveHosting() {
    debugger;
    var x = document.createElement("div");
    x.setAttribute("class", "input-container");
    var y = document.createElement("div");
    y.setAttribute("class", "text-name");

    var label = document.createElement("label");
    var hosting = document.createTextNode("Do you have hosting?");
    x.appendChild(y);
    label.appendChild(hosting);
    y.appendChild(label);

    var z = document.createElement("div");
    var input1 = document.createElement("input");
    var p1 = document.createElement("p");
    var text1=document.createTextNode("Yes");
    p1.appendChild(text1);
    input1.setAttribute("type", "radio");
    
    var breakTag=document.createElement("br");
  
    var input2 = document.createElement("input");
    var p2 = document.createElement("p");
    var text2=document.createTextNode("No");
    p2.appendChild(text2);
    input2.setAttribute("type", "radio");
    input2.setAttribute("checked","checked");
    
    x.appendChild(z);
    input1.setAttribute("class", "input-field");
    z.appendChild(input1);
    z.appendChild(p1);
    z.appendChild(breakTag);
    z.appendChild(input2);
    z.appendChild(p2);
    document.getElementById('myForm').appendChild(x);

}


function myFunction() {

    var elem=document.getElementById("state");
    if (elem.value === 'Rajasthan') {
        removeElements();
        addProject();
        addWebsite();
    }
    if (elem.value === 'Haryana') {
        removeElements();
        addZipCode();
        addHaveHosting();
    }
    if (elem.value === 'Maharashtra') {
        removeElements();
        addZipCode();
        addProject();
    }
}

function removeElements() {
    debugger;
    parentForm = document.getElementById("myForm");
    var countChildren = document.getElementById("myForm").children.length;

    if (countChildren == 9) {

        var item1 = parentForm.childNodes[15];
        var item2 = parentForm.childNodes[16];

        parentForm.removeChild(item1);
        parentForm.removeChild(item2);
    }
}
