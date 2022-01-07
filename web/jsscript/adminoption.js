function redirectadministratorpage()
{
    swal("Admin!","Redirecting to Admin page!","success");
    setTimeout(function(){window.location="adminactions.jsp";},3000);
}
function managecandidate()
{
    swal("Admin!","Redirecting to candidate management","success");
    setTimeout(function(){window.location="managecandidate.jsp";},3000);
}
function manageuser()
{
    swal("Admin!","Redirecting to user management","success");
    setTimeout(function(){window.location="manageuser.jsp";},3000);
}
function showuserform()
{
      removecandidateForm();
         var newdiv= document.createElement("div");
         newdiv.setAttribute("id","candidateform");
         newdiv.setAttribute("float","left");
         newdiv.setAttribute("padding-left","12px");
         newdiv.setAttribute("border","solid 12px red");
         newdiv.innerHTML="<h>User Details</h>";
         newdiv.innerHTML=newdiv.innerHTML+"<div id='cid' style='color:white; font-weight: bold'></div>";
      newdiv.innerHTML= newdiv.innerHTML+"<br><span id='addresp'></span>";
        // newdiv1.innerHtml= newdiv1.innerHtml+"<h3>hello</h3>";
        var addprd=$("#result");
        //alert(addprd);
        //alert(newdiv.innerHTML);
         addprd.append(newdiv);
     var data={"cid":"cid"};
     $.post("UserDetailsControllerServlet",data, function(responseText){
              //alert(responseText);
             // addprd.append(responseText);
             $('#cid').append(responseText);
             //$('#cid1').append(responseText);
             
         });
}

function removeuserform()
{
    removecandidateForm();
    var newdiv= document.createElement("div");
         newdiv.setAttribute("id","candidateform");
         newdiv.setAttribute("float","left");
         newdiv.setAttribute("padding-left","12px");
         newdiv.setAttribute("border","solid 12px red");
         newdiv.innerHTML="<h>Remove User</h>";
         newdiv.innerHTML=newdiv.innerHTML+"<div style='color:white; font-weight: bold'>CandidateId:</div><div><select id='cid'></select></div>";
      newdiv.innerHTML= newdiv.innerHTML+"<br><span id='addresp'></span>";
        // newdiv1.innerHtml= newdiv1.innerHtml+"<h3>hello</h3>";
        var addprd=$("#result");
        //alert(addprd);
        //alert(newdiv.innerHTML);
         addprd.append(newdiv);
         data={
             data:"cid"
         };
         $.post("ShowUserControllerServlet",data, function(responseText){
              //alert(responseText);
             // addprd.append(responseText);
             $('#cid').append(responseText);
             //$('#cid1').append(responseText);
             
         });
    
          $("#cid").on('change', function(){
             var cid=$(this).children("option:selected").val();
             //alert(cid);
             data={data: cid};
             $.post("ShowUserControllerServlet",data,function(responseText){
                 //alert(responseText);
                 clearText();
                  $('#addresp').append(responseText);
                   //newdiv.innerHTML===responseText;
                   $("#deletecnd").on('click', function deletecandidate() {
                    //alert(cid);
          //var cid1= $("#cndid").val();
         
           //alert(cid1);
          // alert(city);
           var data={cid: cid};
           //data.append("party", party);
          // data.append("city",city);
         
           $.post("DeleteUserControllerServlet",data,processResponse );
           function processResponse(responseText)
           {
               //alert(responseText);
               if(responseText.trim("delete"))
               {
                   swal("success","deleted successfully","success");
                   //setTimeout(function(){ window.location="removeuserform()",1000});
                   setTimeout(function(){ removecandidateForm();},1000);
                   //clearText();
                   //removecandidateForm();
               }
               else
               {  swal("error","some record found!!! cannot be deleted","error");
                  setTimeout(function(){ window.location="deleteuser.jsp",4000});
               }
           }
           
           
     });
             });
         });
}






function addcandidate()
{
    //removecandidateForm();
    var form=$('#fileUploadForm')[0];
    var data=new FormData(form);  
    var cid=$("#cid").val();
    //alert(cid);
    
    var cname=$("#cname").val();
    var city=$("#city").val();
    var party=$("#party").val();
    var uid=$("#uid").val();
    data.append("cid",cid);
    data.append("uid",uid);
    data.append("cname",cname);
    data.append("party",party);
    data.append("city",city);
    //alert(cname);
    //alert(city);
    //alert(party);
    //alert(uid);
        $.ajax({
            type:"POST",
            enctype:'multipart/form-data',
            url: "AddNewCandidateControllerServlet",
            data: data,
            processData:false,
            contentType:false,
            cache:false,
            timeout: 600000,
            success:function (data) {
                str=data+"....";
                swal("Admin",str,"success");
                setTimeout(function(){showaddcandidateform();},3000);
                                             
            },
            error:function(e){
                swal("Admin!",e,"error");
            }
                
            
        });
}
function showaddcandidateform()
{
    removecandidateForm();
    var newdiv=document.createElement("div");
    newdiv.setAttribute("id","candidateform");
    newdiv.setAttribute("float","left");
    newdiv.setAttribute("padding-left","12px");
    newdiv.setAttribute("border","solid 2px red");
    newdiv.innerHTML="<h3>Add New Candidate</h3>";
    newdiv.innerHTML=newdiv.innerHTML+"<form method='POST' enctype='multipart/form-data' id='fileUploadForm'>\n\
    <table><tr><th>Candidate ID:</th><td><input type='text' id='cid'</td></th>\n\
    <tr><th>User Id:</th><td><input type='text' id='uid' onkeypress='return getdetails(event)'</td></tr>\n\
    <tr><th>Candidate Name:</th><td><input type='text' id='cname'</td></tr>\n\
    <tr><th>City:</th><td><select id='city'></select></td></tr>\n\
    <tr><th>Party:</th><td><input type='text' id='party'</td></tr>\n\
    <tr><td colspan='2'><input type='file' name='files' value='Select Image'></td></tr>\n\
    <tr><th><input type='button' value='Add Candidate' onclick='addcandidate()' id='addcdn'</th>\n\
    <th><input type='reset' value='Clear' onclick='clearText()'></th></tr></table></form>";
    newdiv.innerHTML=newdiv.innerHTML+"<br><span id='addresp'></span>";
    var addcand=$("#result");
    addcand.append(newdiv);
    data={id:"getid"};
    $.post("AddCandidateControllerServlet",data,function(responseText){$("#cid").val(responseText);
    $('#cid').prop("disabled",true);});
}


function getdetails(e)
{
    
    if(e.keyCode===13){
        //alert($("#uid").val());
        data={uid:$("#uid").val()};
        $.post("AddCandidateControllerServlet",data,function(responseText){
            //alert(responseText);
            responseText=responseText.trim();
            var i=responseText.lastIndexOf(",");
            $('#city').empty();
            $('#city').append(responseText.substring(0,i));
            var uname=responseText.substring(i+1,responseText.length);
            if(uname==="wrong")
                swal("Wrong! Adhar","Adhar number not found in DB","error");
            else
            {
                $('#cname').val(uname);
                $("#cname").prop("disabled",true);
                //alert($("#cname").val());
            }
        });
    }
}
function removecandidateForm()
{
    var contdiv=document.getElementById("result");
    var formdiv=document.getElementById("candidateform");
    if(formdiv!==null)
    {
        $("#candidateform").fadeOut("3500");
        contdiv.removeChild(formdiv);
    }
}
function showcandidate()
{
    
    removecandidateForm();
    var newdiv=document.createElement("div");
    newdiv.setAttribute("id","candidateform");
    newdiv.setAttribute("float","left");
    newdiv.setAttribute("padding-left","12px");
    newdiv.setAttribute("border","solid 2px red");
    newdiv.innerHTML="<h>Show Candidate</h3>";
    newdiv.innerHTML=newdiv.innerHTML+"<div style='color:white; font-weight:bold'>Candidate Id:</div></div><select id='cid'></select></div>";
    newdiv.innerHTML=newdiv.innerHTML+"<br><span id='addresp'></span>";
    var addprd=$("#result");
    addprd.append(newdiv);
    
    data={data:"cid"};
    $.post("ShowCandidateControllerServlet",data,function(responseText){
        $('#cid').append(responseText);
    });
   
    
    $("#cid").on('change',function(){
        var cid=$(this).children("option:selected").val();
        data={data:cid};
        $.post("ShowCandidateControllerServlet",data,function(responseText){
            clearText();
            $("#addresp").append(responseText);
        });
    });





}



function clearText()
{
    $("#addresp").html("");
}

function electionresult()
{
    var data={data:"result"};
    $.post("ElectionResultControllerServlet",data,function(responseText)
    {
        //swal("success",responseText.trim(),"success");
        swal("success","Showing results successfully !","success");

        $("#result").html("");
        $("#result").html(responseText);
        
    });
}


function showupdatecandidateform()
     {
         removecandidateForm();
         var newdiv= document.createElement("div");
         newdiv.setAttribute("id","candidateform");
         newdiv.setAttribute("float","left");
         newdiv.setAttribute("padding-left","12px");
         newdiv.setAttribute("border","solid 12px red");
         newdiv.innerHTML="<h>Update Candidate</h>";
         newdiv.innerHTML=newdiv.innerHTML+"<div style='color:white; font-weight: bold'>CandidateId:</div><div><select id='cid'></select></div>";
      newdiv.innerHTML= newdiv.innerHTML+"<br><span id='addresp'></span>";
        // newdiv1.innerHtml= newdiv1.innerHtml+"<h3>hello</h3>";
        var addprd=$("#result");
        //alert(addprd);
        //alert(newdiv.innerHTML);
         addprd.append(newdiv);
         data={
             data:"cid"
         };
         $.post("ShowCandidateControllerServlet1",data, function(responseText){
              //alert(responseText);
             // addprd.append(responseText);
             $('#cid').append(responseText);
             //$('#cid1').append(responseText);
             
         });
         
          $("#cid").on('change', function(){
             var cid=$(this).children("option:selected").val();
             //alert(cid);
             data={data: cid};
             $.post("ShowCandidateControllerServlet1",data,function(responseText){
                 //alert(responseText);
                 clearText();
                  $('#addresp').append(responseText);
                  
                   //newdiv.innerHTML===responseText;
                   $("#updatecnd").on('click', function updateCandidate(){
      var form= $('#fileUploadForm')[0];
         var data= new FormData(form);
          var cid= $("#cid").val();
          // var cname= $('#cname').val();
           var city= $('#city').val();
           var party= $('#party').val();
           //alert(party);
           //alert(cid);
           //alert(city);
            data.append("cid", cid);
           data.append("party", party);
           data.append("city",city);
         
           $.ajax(
                   {
                       type:"POST",
                       enctype:'multipart/form-data',
                       url:"UpdateControllerServlet",
                       data: data,
                       processData: false,
                       contentType: false,
                       cache: false,
                       timeout:600000,
                       success: function(data){  str=data+"Successfull....";
                                                 swal("admin!!",str,"success");                          
                             setTimeout(function(){ showupdatecandidateform();},3000);
                       },
                       error: function(e){swal("admin!!1",e,"error");}
                   });
           
           
     });
             });
           
         });
}

function deletecandidateform()
{
    removecandidateForm();
    var newdiv=document.createElement("div");
    newdiv.setAttribute("id","candidateform");
    newdiv.setAttribute("float","left");
    newdiv.setAttribute("padding-left","12px");
    newdiv.setAttribute("border","solid 2px red");
    newdiv.innerHTML="<h>Delete Candidate</h3>";
    newdiv.innerHTML=newdiv.innerHTML+"<div style='color:white; font-weight:bold'>Candidate Id:</div></div><select id='cid'></select></div>";
    newdiv.innerHTML=newdiv.innerHTML+"<br><span id='addresp'></span>";
    var addprd=$("#result");
    addprd.append(newdiv);
    
    data={data:"cid"};
    $.post("ShowCandidateControllerServlet2",data,function(responseText){
        $('#cid').append(responseText);
    });
    
    $("#cid").on('change', function(){
             var cid=$(this).children("option:selected").val();
             //alert(cid);
             data={data: cid};
             $.post("ShowCandidateControllerServlet2",data,function(responseText){
                 //alert(responseText);
                 clearText();
                  $('#addresp').append(responseText);
                   //newdiv.innerHTML===responseText;
                 $("#deletecnd").on('click', function deletecandidate() {
                    //alert(cid);
          //var cid1= $("#cndid").val();
         
           //alert(cid1);
          // alert(city);
           var data={cid: cid};
           //data.append("party", party);
          // data.append("city",city);
         
           $.post("DeleteControllerServlet",data,processResponse );
           function processResponse(responseText)
           {
               //alert(responseText);
               if(responseText.trim("delete"))
               {
                   swal("success","deleted successfully","success");
                   setTimeout(function(){ removecandidateForm();},1000);
                   clearText();
                   
                   //removecandidateForm();
               }
               else
               {  swal("error","some record found!!! cannot be deleted","error");
                  setTimeout(function(){ window.location="deletecandidate.jsp",4000});
               }
           }
           
           
     });
             });
         });   
}



