/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

document.bgColor="lightblue";
var eflag=0;
var pflag=0;
function validate(event)
{
	event.preventDefault();
	var email=document.getElementById("email").value;
        var pass=document.getElementById("password").value;
	
	
       if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))
       {
	 document.getElementById("s1").innerHTML="";
         eflag=0;
	}
	else if (email==="")
        {
            document.getElementById("s1").innerHTML="*Required Field";
            eflag=1;
        }
        else
        {document.getElementById("s1").innerHTML="Wrong email";
         eflag=1;
        }
          if (pass==="")
          {
            document.getElementById("s2").innerHTML="*Required Field";  
            pflag=1;    
          }
          else
          {
             document.getElementById("s2").innerHTML="";  
             pflag=0;
          }
          if (eflag===1 || pflag===1)
          {
              return false;
          }
          else
          {
              document.registerform.submit();
          }
              
     }