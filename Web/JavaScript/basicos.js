var variable = "hola"; // variable global
let variable2 = "mundo"; // variable de bloque
const variable3 = "sos"; // variable de bloque constante

console.log(variable+" "+variable2+" "+variable3); // funcion que imprime en consola

let array = ["a","b","c"]; // array

console.table(array); // imprime una tabla en consola con los valores y sus posiciones

let obj = { // declaracion de objeto
    nombre: "Giacomo",
    apellido: "Baldessari"
};
console.log(obj);
console.log(obj.nombre) // obtener atributos

obj.numero = 123;

console.table(obj);
