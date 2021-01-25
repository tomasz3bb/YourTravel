function savePass(){
    var pass = document.getElementById("pass").value;
    var pass2 = document.getElementById("pass2").value;

    var regex = new RegExp("[A-Za-z0-9]{5}.*");
    var flag = true;

    if(!regex.test(pass)) {
        document.getElementById("pass").style.backgroundColor = 'RED';
        flag = false;
    } else {
        document.getElementById("pass").style.backgroundColor = 'WHITE';
    }

    if(!regex.test(pass2)) {
        document.getElementById("pass2").style.backgroundColor = 'RED';
        flag = false;
    } else {
        document.getElementById("pass2").style.backgroundColor = 'WHITE';
    }

    if(pass != pass2) {
        document.getElementById("pass").style.backgroundColor = 'RED';
        document.getElementById("pass2").style.backgroundColor = 'RED';
        flag = false;
    } else {
        if(flag) {
            document.getElementById("pass").style.backgroundColor = 'WHITE';
            document.getElementById("pass2").style.backgroundColor = 'WHITE';
        }
    }

    return flag;
}