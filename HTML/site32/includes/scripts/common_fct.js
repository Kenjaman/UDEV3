function getAjaxRequestObject(){
    var xmlHttpRequestObject = null;
    if(window.XMLHttpRequest) //FIrefox et autres
        xmlHttpRequestObject= new XMLHttpRequest();
    else if(window.ActiveXObject) {//Internet Explorer
        xmlHttpRequestObject=new ActiveXObject("Microsoft.XMLHTTP");
    }else{
        alert("Votre navigateur ne gère pas les requêtes JS");
        return null;
    }
    return xmlHttpRequestObject;
}