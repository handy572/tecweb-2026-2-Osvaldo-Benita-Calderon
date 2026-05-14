function setDigito(digito){
    let display = document.getElementById('display');
    display.value=display.value+digito;
}

function setOperador(operador){
     let display = document.getElementById('display');
     display.value=display.value+operador;
}

function borrar(){
    let display = document.getElementById('display');
    display.value= '';
}

function obtenerResultado(){
    let display = document.getElementById('display');
    display.value = eval(display.value);
}

function raizCuadrada(){
    let display = document.getElementById('display');

    try{
        display.value = Math.sqrt(eval(display.value));
    }catch(error){
        display.value = 'Error';
    }
}

function logaritmo(){
    let display = document.getElementById('display');

    try{
        let numero = eval(display.value);

        // Math.log = logaritmo natural
        display.value = Math.log(numero);

    }catch(error){
        display.value = 'Error';
    }
}

function potencia(){
    let display = document.getElementById('display');

    try{
        let base = eval(display.value);

        let exponente = prompt("Ingrese el exponente:");
        display.value = Math.pow(base, exponente);

    }catch(error){
        display.value = 'Error';
    }
}