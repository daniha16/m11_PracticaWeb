
function validarNombre(){
    var nombre = document.getElementById("nombre").value;
    console.log("Nombre "+nombre)
    if (nombre == null || nombre.length == 0) {
        mensajes.push("-Nombre");
        return false;
    }
    else if(!isNaN(nombre)){
        alert("El nombre solo puede contener letras");
        return false;
    }
    return true;
    
}

function validarApellido(){
    var apellido = document.getElementById("apellidos").value;
    if (apellido == null || apellido.length == 0){
        mensajes.push("-Apellidos");
        return false;
    }
    else if(!isNaN(apellido)){
        alert("El apellido solo puede contener letras");
        return false;
    }
    return true;
}

function validarCorreo(){
    var correo = document.getElementsByName("correo")[0].value;
    emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
    if (correo == null || correo.length == 0){
        mensajes.push("-Correo");
        return false;
    }
    else if(!emailRegex.test(correo)){
        alert("El correo no es válido");
        return false;
    }
    return true
}

function validarTelefono(){
    var telefono = document.getElementById("telefono").value;
    if (telefono == null || telefono.length == 0){
        mensajes.push("-Telefono");
        return false;
    }
    else if(isNaN(telefono)){
        alert("El telefono solo puede contener numeros");
        return false;
    }
    return true;
}

function validarPassword(){
    var password = document.getElementsByName("pwd")[0].value;
    console.log("Password "+password)
    if (password == null || password.length == 0){
        mensajes.push("-Contraseña");
        return false;
    }
    return true;
}

function validarCampoTexto(){
    var campoTexto = document.getElementById("mensaje").value;
    if (campoTexto == null || campoTexto.length == 0) {
        mensajes.push("-Campo de texto");
        return false;
    }
    return true;
}

function validarRadio(){
    missing = false;
    chosen = false;
    var radios = document.getElementsByName("hm");
    console.log(radios[0])
    for(var i=0; i<radios.length;i++){
        if(radios[i].checked == false){
            missing = true;    
        }
        else{
            chosen = true;
        }
    }
    if(missing && !chosen){
        mensajes.push("-Genero");
        return false;
    }
    else if(chosen){
        missing = false;
        return true;
    }

}

function validarFecha(){
    var fecha = document.getElementById("start").value;
    if(fecha == "" || fecha.length == 0){
        mensajes.push("-Fecha");
        return false;
    }
    else{
        return true;
    }
}

function validarRegister(){
    var formulario = document.getElementById("formulario");
    mensajes = [];
    var vN = validarNombre();
    var vA = validarApellido();
    var vR = validarRadio();
    var vF = validarFecha();
    var vT = validarTelefono();
    var vC = validarCorreo();
    var vP = validarPassword();
    error = mensajes.join("\n");
    if(!(vN && vA && vR && vF && vT && vC && vP)){
        alert("Los siguientes campos están vacíos: \n"+error)
        /*alert("vN: "+vN+","+"vA: "+vA+","+"vR: "+vR+","+"vF: "+vF+","+"vT: "+vT+","+"vC: "+vC+","+"vP: "+vP)*/
    }
    else{
        alert("Enviando datos con éxito!");
        formulario.submit();
    }
}

function validarLogin(){
    var formulario = document.getElementById("formulario")
    mensajes = [];
    var vN = validarCorreo();
    var vP = validarPassword();
    error = mensajes.join("\n");
    if(!(vN && vP)){
        alert("Los siguientes campos están vacíos: \n"+error)
    }
    else{
        formulario.submit();  
    }
}

function validarQuejas(){
    
    var formulario = document.getElementById("formulario")
    mensajes = [];
    var vN = validarNombre();
    var vR = validarRadio();
    var vCT = validarCampoTexto();
    error = mensajes.join("\n");
    if(!(vN && vR && vCT)){
        alert("Los siguientes campos están vacíos: \n"+error)
    }
    else{
        alert("Enviando datos con éxito!");
        formulario.submit();
    }
}

function borrar(){
    var formulario = document.getElementById("formulario");
    formulario.reset();
}

function enviarDatos(info){
    var formulario = document.getElementById("enviarForm");
    if(info==="proyectos"){
        formulario.action.value="listTrabajadorProyectos";
        formulario.setAttribute("action","ProyectoController");
    }
    else if(info==="registroDiario"){
        
    }
    else if(info==="calendario"){
        
    }
    else if(info==="Estadisticas"){
        
    }
    else if(info==="Solicitudes"){
        
    }
    formulario.submit();
}