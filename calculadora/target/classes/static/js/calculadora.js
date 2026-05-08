function suma(){
    let n1=document.getElementById("n1").value;
    let n2=document.getElementById("n2").value;
    let resultado=parseInt(n1) + parseInt(n2);
    document.getElementById("Resultado").innerHTML="Resultado"+resultado;
}

function resta(){
    let n1=document.getElementById("n1").value;
    let n2=document.getElementById("n2").value;
    let resultado=parseInt(n1) - parseInt(n2);
    document.getElementById("Resultado").innerHTML="Resultado"+resultado;
}

function multiplicacion(){
    let n1=document.getElementById("n1").value;
    let n2=document.getElementById("n2").value;
    let resultado=parseInt(n1) * parseInt(n2);
    document.getElementById("Resultado").innerHTML="Resultado"+resultado;
}

function division(){
    let n1=document.getElementById("n1").value;
    let n2=document.getElementById("n2").value;
    if (parseInt(n2) === 0){
        document.getElementById("resultado").innerHTML = "No es posible dividir entre 0";
    }
    else{
        let resultado = parseInt(n1) / parseInt(n2);
        document.getElementById("resultado").innerHTML = "Resultado" +resultado;}
}