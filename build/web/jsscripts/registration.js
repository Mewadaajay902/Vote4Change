var username,password,cpassword,city,address,adhar,email,mobile;

function addUser(){
    userName=$("#username").val();
    password=$("#password").val();
    cpassword=$("#cpassword").val();
    city=$("#city").val();
    address=$("#address").val();
    adhar=$("#adhar").val();   
    email=$("#email").val();
    mobile=$("#mobile").val();
    if(validateUser()){
        if(password!==cpassword){
            swal("Error!","password does not match!","error");
            return;
        }
        else
        {
            if(checkEmail(email)===false)
                return;
            var data={username:username,
                password:password,
                city:city,
                address:address,
                userid:adhar,
                email:email,               
                mobile:mobile};
            $.post("RegistrationControllerServlet",data,processresponse);
                
        }
    }
    function processresponse(responseText){
    responseText=responseText.trim();
    if(responseText==="success"){
        swal("success!","Registration Successful!You can now Login","success");
        setTimeout(redirectUser,3000);
    }
    else if(responseText==="uap"){
        swal("Error!","Sorry!the userid is already present","error");
    }
    else
    {
        swal("Error","Registration Failed! Try again","error");
    }
}


function validateUser(){
    if(username===""||password===""||cpassword===""||city===""||address===""||adhar===""||email===""||mobile===""){
        swal("Error!","All fields are mandatory!","error");
        return false;
    }
    else
    {
        return true;
    }
}
function checkEmail(email){
    var atposition=email.indexOf("@");
    var dotposition=email.lastIndexOf(".");
    if(atposition<1||dotposition<atposition+2||dotposition+2>=email.length){
        swal("Error!","please enter valid email!","error");
        return false;
    }
    return true;
}
function redirectUser()
{
    window.location="login.html";
}

}

