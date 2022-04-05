

//function otherGenre(){
//    a=document.getElementById('other_genre');
//    a.checked=true;
//    }
//
//function Genre(){
//    a=document.getElementById('genre');
//    a.value="";
//    }

function biencopie(mailinglist){
    navigator.clipboard.writeText(mailinglist);
    alert("mailing liste copiée dans le press papier");
    }



window.onload = function() {
    var $recaptcha = document.querySelector('#g-recaptcha-response');
    
    if($recaptcha) {
        $recaptcha.setAttribute("required", "required");
            
    }
};
var recaptchachecked=false; 
function recaptchaCallback() {
    
    recaptchachecked = true;
}
function ok(){
    if(!recaptchachecked ){
        alert('Compléter le captcha SVP !')
    }
        
}