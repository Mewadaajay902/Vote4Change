function addvote()
{
    var id=$('input[type=radio][name=flat]:checked').attr('id');
    data={candidateid:id};
    $.post("AddVoteControllerServlet",data,processresponse);
    //alert(id);
}
 function processresponse(responseText)
 {
     responseText=responseText.trim();
     if(responseText==="success")
         window.location="votingresponse.jsp";
     else
         window.location="accessdenied.html";
 }
 
 function redirectvotingpage()
{
    swal("Admin!","Redirecting to voting page!","success");
    setTimeout(function(){window.location="VotingControllerServlet";},3000);
}

function redirectvoting()
{
    swal("Admin!","Redirecting to voting page!","success");
    setTimeout(function(){window.location="voteractions.jsp";},3000);
}

function updatevoterform()
{
  removecandidateForm();
         var newdiv= document.createElement("div");
         newdiv.setAttribute("id","candidateform");
         newdiv.setAttribute("float","left");
         newdiv.setAttribute("padding-left","12px");
         newdiv.setAttribute("border","solid 12px red");
         newdiv.innerHTML="<h>Update Voter</h>";
         newdiv.innerHTML=newdiv.innerHTML+"<div id='cid' style='color:white; font-weight: bold'></div>";
      newdiv.innerHTML= newdiv.innerHTML+"<br><span id='addresp'></span>";
        // newdiv1.innerHtml= newdiv1.innerHtml+"<h3>hello</h3>";
        var addprd=$("#result");
        //alert(addprd);
        //alert(newdiv.innerHTML);
         addprd.append(newdiv);
         data={
             data:"cid"
         };
         $.post("ShowVoterControllerServlet",data,function (responseText){
                //alert(responseText);
              //swal("success","You Can Update Your Profile","success")
              $('#cid').append(responseText);
              $("#updatecnd").on('click',function updatecandidate(){
                var address=  $("#address").val();
                var city=$("#city").val();
                var mobile=$("#mobile").val();
                var password=$("#password").val();
                var username=$("#username").val();
                var email=$("#email").val();
                //alert(address+city+mobile+password+username+email);
                 var data={
                     address:address,
                    city:city,
                    mobile:mobile,
                    password:password,
                    username:username,
                    email:email
                     
                 };
                 $.post("updateVoterControllerServlet",data,processResponse);
                 function processResponse(responseText)
                 {
                     if(responseText.trim("success"))
                     {
                         swal("sucess","recoded updated","success");
                         clearText();
                         removecandidateForm();
                     }
                     else
                          swal("error","recoded not updated","error");
                 }
              })
         });
               
    }  