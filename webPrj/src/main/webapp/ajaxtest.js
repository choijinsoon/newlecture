window.onload = function(){
    var btnRequest = document.getElementById("btn-request");
    btnRequest.onclick = (e)=>{
        e.preventDefault();
        
        let request = new XMLHttpRequest();
        request.onload = ()=>{
            console.log(request.responseText);
        };


        request.open("GET", "http://localhost:8080/hello?c=3");
        request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        request.send(); //URL 요청 형식

        // request.open("POST", "http://localhost:8080/save");
        // request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        // request.send("x=3&y=4"); //URL 요청 형식
    }
}