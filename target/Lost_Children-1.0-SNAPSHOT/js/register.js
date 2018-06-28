/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

document.bgColor="lightblue";
var bflag=0;
var nflag=0;
var eflag=0;
var tflag=0;
var aflag=0;
var pflag=0;

function validate(event)
{
	event.preventDefault();
        var fname=document.getElementById("billing_first_name").value;
	var email=document.getElementById("billing_email").value;
	var telephone=document.getElementById("billing_phone").value;
	var address=document.getElementById("billing_address_1").value;
        var balance=document.getElementById("balance").value;
        var pass=document.getElementById("password").value;
	
	if (fname ==="")
	{
		document.getElementById("s2").innerHTML="*Required Field";
                nflag=1;
	}
	else{document.getElementById("s2").innerHTML="";
            nflag=0;
	}	
       if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))
       {
	 document.getElementById("s3").innerHTML="";
         eflag=0;
	}
	else if (email==="")
        {
            document.getElementById("s3").innerHTML="*Required Field";
            eflag=1;
        }
        else
        {document.getElementById("s3").innerHTML="Wrong email";
         eflag=1;
        }
          if (telephone===""){
          document.getElementById("s4").innerHTML="*Required Field";
           tflag=1;
          }
          else
          {
           document.getElementById("s4").innerHTML=""; 
            tflag=0;
          }
          if (address==="")
          {
            document.getElementById("s5").innerHTML="*Required Field";  
            aflag=1;
          }
          else
          {
            document.getElementById("s5").innerHTML=""; 
            aflag=0;
          }
          
          if (balance==="")
          {
            document.getElementById("s7").innerHTML="*Required Field";  
            bflag=1;  
          }else if((typeof parseInt(balance) === 'number')){
               document.getElementById("s7").innerHTML=""; 
               bflag=0;
          }
          else
          {
             document.getElementById("s7").innerHTML="wrong balance"; 
                 bflag=1;
          }
          if (pass==="")
          {
            document.getElementById("s8").innerHTML="*Required Field";  
            pflag=1;    
          }
          else
          {
             document.getElementById("s8").innerHTML="";  
             pflag=0;
          }
          if (aflag===1 || bflag===1 || pflag===1 || nflag===1 || tflag===1 || eflag===1)
          {
              return false;
          }
          else
          {
              document.registerform.submit();
          }
              
     }