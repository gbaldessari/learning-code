## Node.js

Node.js es un entorno que permite ejecutar código JavaScript fuera del navegador, es decir, en tu computadora o servidor. Es como darle a JavaScript el poder de hacer cosas que normalmente se harían con otros lenguajes de programación en el lado del servidor, como leer archivos del sistema o manejar conexiones de red.

### Instalacion Node

[Link Node](https://nodejs.org/en)


## JavaScript

JavaScript es un lenguaje de programación que se utiliza principalmente para crear páginas web dinámicas. Permite añadir interactividad, animaciones, manejar eventos, y mucho más.

### Variables

Las variables en JavaScript se utilizan para almacenar datos que pueden variar. Se pueden declarar usando `var`, `let` o `const`.

```js
let mensaje = 'Hola, mundo!'
const PI = 3.14159
```

### Tipos de Datos

JavaScript es un lenguaje de tipado dinámico, lo que significa que no necesitas declarar el tipo de dato de una variable. Los tipos de datos básicos incluyen:

String: Cadena de texto.
Number: Números.
Boolean: Valor verdadero o falso.
Object: Colección de propiedades.

```js
let nombre = 'Ana' // String
let edad = 25 // Number
let esEstudiante = true // Boolean
let objeto = { nombre: 'Ana', edad: 25 } // Object
```

### Condicionales

Los condicionales se usan para realizar diferentes acciones basadas en diferentes condiciones.

```js
let numero = 10
if (numero > 5) {
	console.log('El número es mayor que 5.')
} else {
	console.log('El número es menor o igual a 5.')
}
```

=== comparacion

```js
let a = 5 // número
let b = '5' // cadena de texto

console.log(a == b) // true, porque se realiza la conversión de tipo (5 se convierte en "5")
console.log(a === b) // false, porque aunque ambos son 5, los tipos son diferentes (número vs cadena de texto)
```

En JavaScript, === se usa para la comparación estricta, lo que significa que compara tanto el valor como el tipo de las variables. Por otro lado, == realiza una comparación débil, solo compara los valores, y si los tipos no coinciden, intenta convertirlos a un tipo común antes de comparar. Por esto, === es generalmente preferido, ya que proporciona resultados más predecibles y evita conversiones de tipo implícitas.

### Bucles

Los bucles pueden ejecutar un bloque de código varias veces.

```js
for (let i = 0; i < 5; i++) {
	console.log('El número es ' + i)
}
```

### Funciones

Las funciones son bloques de código que se pueden llamar para ejecutar una tarea específica.

```js
function saludar(nombre) {
	return 'Hola, ' + nombre + '!'
}

console.log(saludar('Pedro'))
```

#### Funciones Flecha (Arrow Functions)

```js
// Función tradicional
function suma(a, b) {
	return a + b
}

// Arrow function equivalente
const suma = (a, b) => a + b

const crearPersona = (nombre, edad) => ({ nombre: nombre, edad: edad })
console.log(crearPersona('Ana', 25)) // Imprime: { nombre: 'Ana', edad: 25 }
```

### Arrays

```js
const numbers = [1, 2, 3, 4, 5, 6]

numbers.forEach((element) => {
    console.log(element);
});

const squares = numbers.map((element) => Math.pow(element, 2))
const evenNumbers = numbers.filter((element) => element % 2 === 0)
const total = numbers.reduce((acumulator, element) => acumulator + element)
```

- squares:
map() es un método que recorre cada elemento del arreglo numbers.
    Para cada elemento del arreglo, calcula su cuadrado usando Math.pow(element, 2) (eleva el elemento al cuadrado).
    El resultado es un nuevo arreglo squares que contiene los cuadrados de los números originales.

- evenNumbers:
filter() también recorre cada elemento del arreglo numbers.
    Para cada elemento, verifica si es un número par comprobando element % 2 === 0 (si el resto de dividir el elemento por 2 es 0).
    Los elementos que cumplan esta condición (números pares) se incluyen en el nuevo arreglo evenNumbers.
    
- total:
reduce() procesa cada elemento del arreglo numbers para reducirlo a un único valor.
    Usa dos parámetros en su función: acumulator y element.
    acumulator es el valor acumulado de la operación anterior, y element es el elemento actual del arreglo.
    La operación acumulator + element suma el elemento actual al acumulador.
    El resultado final de reduce() es total, que es la suma de todos los elementos del arreglo numbers.


## Asincronia 


#### Una promesa
 en JavaScript es un objeto que representa la eventual finalización (o fracaso) de una operación asíncrona y su resultado. Esencialmente, es una forma de manejar operaciones que tomarán algún tiempo en completarse, como solicitudes de red, lectura de archivos, etc.

Las promesas tienen tres estados posibles:

Pendiente (Pending): Estado inicial de la promesa. La operación aún no ha completado.
Cumplida (Fulfilled): Significa que la operación asíncrona se completó con éxito y la promesa tiene un valor resultante.
Rechazada (Rejected): La operación asíncrona falló y la promesa tiene un motivo de rechazo, que es un error o una explicación de por qué falló.
Cuando creas una promesa, proporcionas una función que toma dos argumentos: resolve y reject.

resolve se llama con el valor o resultado cuando la operación asíncrona se completa con éxito, moviendo la promesa al estado "cumplida".
reject se llama con un error o motivo cuando la operación falla, moviendo la promesa al estado "rechazada".
Aquí hay un ejemplo básico de una promesa:

```js
let miPromesa = new Promise((resolve, reject) => {
    // Simulando una operación asíncrona
    let condicion = true;

    if (condicion) {
        resolve('La operación fue exitosa');
    } else {
        reject('La operación falló');
    }
});

miPromesa.then((mensaje) => {
    console.log(mensaje); // Se ejecuta si la promesa se cumple
}).catch((mensaje) => {
    console.log(mensaje); // Se ejecuta si la promesa es rechazada
});

```
#### async y await

async y await en JavaScript se usan para trabajar con promesas de una manera más cómoda y legible, permitiendo escribir código asíncrono que se ve y se comporta como si fuera síncrono.

async: Se coloca antes de la definición de una función para indicar que dicha función devolverá una promesa. Dentro de una función async, se puede usar await.
await: Se utiliza para esperar a que una promesa se resuelva antes de continuar con la ejecución del código. Solo se puede usar dentro de una función async.
Aquí un ejemplo simple usando async y await:


```js
// Simulamos una función que retorna una promesa que se resuelve después de 2 segundos
function delay(time) {
    return new Promise(resolve => setTimeout(resolve, time));
}

// Función async que usa await para esperar la promesa de delay
async function runDelay() {
    console.log('Inicio de delay');

    // Espera a que la promesa de delay se resuelva
    await delay(2000);

    console.log('Fin del delay');
}

runDelay(); // Llama a la función async

```

# Typescript

TypeScript es un lenguaje de programación desarrollado por Microsoft que se basa en JavaScript. Añade tipos estáticos y objetos basados en clases a JavaScript, lo que facilita el desarrollo de aplicaciones grandes y complejas. TypeScript se compila a JavaScript puro, lo que significa que cualquier entorno que pueda ejecutar JavaScript también puede ejecutar TypeScript.




### Instalacion

Para comenzar con TypeScript, primero necesitas instalarlo. Si ya tienes Node.js, puedes instalar TypeScript globalmente usando npm:

```bash
npm install -g typescript
```
tsc index.ts


### Tipos de Datos

TypeScript mejora JavaScript al añadir tipos de datos estáticos. Esto significa que puedes especificar el tipo de dato para variables, parámetros de función y valores de retorno.

```ts
let nombre: string = 'Ana'
let edad: number = 25
let esEstudiante: boolean = true
```

### Interfaces

Las interfaces en TypeScript se utilizan para definir la forma de los objetos. Permiten especificar los nombres de las propiedades y los tipos de datos de un objeto.

```ts
interface Persona {
	nombre: string
	edad: number
}

const persona: Persona = {
	nombre: 'Juan',
	edad: 30,
}
```

### Clases

TypeScript también soporta programación orientada a objetos y permite definir clases con propiedades y métodos.

```ts
class Animal {
	nombre: string

	constructor(nombre: string) {
		this.nombre = nombre
	}

	mover(distanciaEnMetros: number): void {
		console.log(`${this.nombre} se movió ${distanciaEnMetros}m.`)
	}
}

let perro = new Animal('Perro')
perro.mover(10)
```

### Módulos

TypeScript soporta módulos, permitiendo la separación del código en diferentes archivos para facilitar la mantenibilidad y reutilización.

```ts
// animal.ts
export class Animal {
	constructor(public nombre: string) {}
	mover(distanciaEnMetros: number) {
		console.log(`${this.nombre} se movió ${distanciaEnMetros}m.`)
	}
}

// main.ts
import { Animal } from './animal'

const gato = new Animal('Gato')
gato.mover(5)
```


## funciones

```js
function suma(a: number, b: number): number {
    return a + b;
}
```

---

## Nest

Nest es un marco de trabajo (framework) para construir aplicaciones del lado del servidor en Node.js. Ayuda a organizar el código de manera eficiente y hace más fácil el desarrollo de aplicaciones complejas, proporcionando una estructura y herramientas para manejar tareas comunes como conectar con bases de datos, gestionar peticiones y respuestas, etc.

### Docs Nest

[Link Nest Docs](https://docs.nestjs.com)