# Laboratorio 2: Testing Unitario

---
Asignatura: Patrones de Software y Programación

Semestre: I-2024

Herramientas: IntelliJ + Java 17.

Fecha Entrega:  21-06-2025 23:59

---

## Política de Clima Severo

El objetivo de este laboratorio es obtener experiencia en testing unitarios y análisis de cobertura de código.

## Contexto

Suponga que la Universidad Católica del Norte tiene una política de cancelación de actividades en los campus de acuerdo
a las condiciones climáticas.

## Política

Si algunas de estas condiciones se cumplen, el campus será cerrado:

1. Mas de 6 pulgadas de lluvias son predecidas para las próximas 24 horas.
2. Ráfagas de vientos de mas de 70 mph son predecidas dentro las próximas 24 horas.
3. Si se predice que habrá mas de 4 pulgadas de lluvias y rágafas de viento por sobre los 45 mph.

Si no se cumplen ninguna de las condiciones, la universidad podrá seguir advirtiendo a los funcionarios y estudiantes
a no realizar actividades fuera de los edificios. Señales de advertencia son ejecutadas cuando:

1. Se predice que las ráfagas de viento están por sobre los 45 mph.
2. Se predice que las lluvias estarán por sobre las 4 pulgadas.

La clase *HerramientasClima* que se encuentra en el paquete cl.ucn.modelo es parte del sistema de alertas y soporte a la
desición.

El método *consejoClimatico* implementa la política descrita previamente. Su tarea consiste en desarrollar un conjunto de 
pruebas unitarias que verifiquen la correcta implementación de este método. Estas pruebas deben asegurar que el método 
funcione correctamente y, además, deben confirmar que se lanza la excepción adecuada cuando el método recibe una entrada 
inválida.

---

## Parte 1

### Crear una clase de test unitario

1. Cree una clase de testing para la clase *HerramientasClima* en el paquete correspondiente del proyecto. Escriba el 
siguiente código:

```java
/**
 * Tests de HerramientasClimaTest.
 *
 * @author
 * @version
*/
public class HerramientasClimaTest {

    /**
     * Tests para método consejoClimatico.
     */
    @Test
    public void testConsejoClimatico() {
        fail("Aun no implementado");
    }

}
```

2. Reemplace el método *fail* con un *assertion*, por ejemplo:

```java
    assertionEquals("CANCELAR", HerramientasClima.consejoClimatico(70.1,0.0));
```
3. Ejecute el caso de test y compruebe si pasó la prueba o no.
4. Ejecute el análisis de cobertura para su programa. Verifique los porcentajes de cobertura.
5. Verifique las métricas de cobertura: (conteo de lineas, conteo de ramas, etc.)

### Escribiendo tests adicionales

Completar *HerramientasClimaTest.java* escribiendo un conjunto de métodos apropiados de tests. Usted puede verificar la 
cobertura de su código en IntelliJ. Completar los tests hasta conseguir una cobertura de 100% para el método.

Una vez que se sienta confiado que sus tests unitarios son suficientes, demuéstrelo generando un reporte de cobertura 
que se genera con el botón en rectángulo rojo que se muestra en la figura a continuación.

![reporteCobertura](imagenes/reporteCobertura.png)

Este reporte debe subirlo a la plataforma CampusVirtual UCN.

Nota: Para cubrir la linea ```java public class HerramientasClima```, deberá construir un objeto *HerramientasClima*.
El siguiente ejemplo "cubre" el constructor por defecto. Notar que no existe ningún assert.

```java 
/**
 * Test para constructor (para 100% de cobertura).
 */
@Test
public void testConstructorPorDefecto() {
    new HerramientasClima();
}
```

### Test de Excepciones

Existen varias formas de testiar excepciones *throw* en JUnit. Por ahora, se propone utilizar el constructo que se 
muestra a continuación, que involucra que el test capture el error esperado y utilize un método *fail* de JUnit después
de la línea donde se espera el *throw*.

```java 
/**
 * Test que el constructor se valida apropiadamente.
 * NOTE: la clase Atom es solo de ejemplo
 * el constructor de la clase debe lanzar un IllegalArgumentException si la
 * el número atómico o peso son inválidos (ej. negativos).
 */
@Test
public void constructor_ArgumentoIlegal() {
    try {
            new Atom("O", -8, -16);
    
            // No debería llegar hasta aquí
            fail("Constructor debe lanzar un IllegalArgumentException");
        } catch (IllegalArgumentException iae) {
        // La excepción fue capturada como se esperaba
        }
}
```
### Asegúrese que pueda responder las siguientes preguntas:

1. ¿Cómo se escribe una prueba que confirme que la implementación lanza una excepción cuando se especifica?

2. ¿Cómo se escribe una prueba que confirme que la implementación no lanza una excepción cuando se especifica que no debe hacerlo?

3. ¿Cómo se ve la cobertura de código cuando se lanzan excepciones? ¿Hay alguna manera de lograr una cobertura del 100% en una clase de pruebas que maneja excepciones?

### Envío Parte 1

Enviar el archivo *HerramientasClimaTest* por CampusVirtual UCN. Deben pasar todos los casos de test.

## Parte 2

Una cobertura del 100% no necesariamente significa que sus pruebas sean lo suficientemente buenas. Las pruebas de alta 
calidad deben ser capaces de descubrir errores en el código que se está probando. El siguiente paso es ejecutar sus 
tests contra una implementación que se sabe que contiene errores. Si sus pruebas son efectivas, deberían indicar que 
hay un problema con este código. Para esta parte del laboratorio, deberá ejecutar sus pruebas contra un archivo *.class* 
precompilado que se ha codificado intencionalmente para que contenga al menos un error.

1. Cree un nuevo proyecto Java.
2. Asegúrese que el proyecto tiene acceso a JUnit5
3. En el **nuevo proyecto** copie su clase desarrollada *HerramientasClimaTest.java*. Además, copie la clase precompilada que se encuentra
en la carpeta *precompilado* de este proyecto (HerramientasClima.class) y agréguelo al Java Build Path como se muestra en la figura a continuación

![javabuildpath](imagenes/javabuildpath.png)

Debe crear una carpeta en el nuevo proyecto y guardar la clase de test. Para acceder al menú de la figura debe navegar por
los siguientes menús: **File -> Project Structure -> Project Settings -> Modules**

4. Ejecute los casos de tests y confirme que al menos uno de los tests falla. Obtenga un pantallazo mostrando lo anterior
y adjúntelo en CampusVirtual.

## Parte 3

---

Existe una base de datos llamada **clima.db**. Esta tabla contiene los valores por año desde el 2014 a la fecha de 
la velocidad del viento y lluvia caída en promedio de 12 meses en una determinada ciudad. Los valores se muestran en la 
siguiente figura.

![tabla](imagenes/tabla.png)

Implemente las siguientes consultas usando JPA (https://jakarta.ee/learn/docs/jakartaee-tutorial/current/persist/persistence-querylanguage/persistence-querylanguage.html
) y construya los casos de test asociados.

1. Consulta para Encontrar Registros por Año: Escriba una consulta que devuelva todos los registros para un año específico y crea una prueba unitaria para verificar su funcionamiento.

Consulta:
```java  
@Query("SELECT v FROM ValoresClima v WHERE v.anho = :anho")
List<ValoresClima> findByAnho(@Param("anho") int anho);
```

2. Consulta para Encontrar Registros con Velocidad de Viento Mayor a un Valor: Escriba una consulta que devuelva todos 
los registros con una velocidad de viento mayor a un valor específico y crea una prueba unitaria para verificar su funcionamiento

Consulta:
```java  
@Query("SELECT v FROM ValoresClima v WHERE v.velocidadViento > :velocidad")
List<ValoresClima> findByVelocidadVientoGreaterThan(@Param("velocidad") double velocidad);
```
3. Consulta para Encontrar Registros por Rango de Lluvia: Escribe una consulta que devuelva todos los registros con 
valores de lluvia dentro de un rango específico y crea una prueba unitaria para verificar su funcionamiento.

Consulta:
```java  
@Query("SELECT v FROM ValoresClima v WHERE v.lluvia BETWEEN :minLluvia AND :maxLluvia")
List<ValoresClima> findByLluviaBetween(@Param("minLluvia") double minLluvia, @Param("maxLluvia") double maxLluvia);
```

Deberá enviar las clases creadas y/o modificadas a CampusVirtual para este requerimiento (.java).

