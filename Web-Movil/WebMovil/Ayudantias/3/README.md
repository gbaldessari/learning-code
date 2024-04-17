
[QuickStart-CLI](https://reactnative.dev/docs/environment-setup?guide=native)
[Ejemplo instalacion](https://www.youtube.com/watch?v=8ejuHsaXiwU&t=37s)
[Documentacion](https://reactnative.dev/docs/getting-started)
[TypeScript](https://reactnative.dev/docs/typescript)


## ¿Qué es React Native?

React Native es un marco de desarrollo de aplicaciones móviles creado por Facebook que permite construir aplicaciones móviles multiplataforma utilizando JavaScript y React. Con React Native, puedes desarrollar aplicaciones para iOS y Android utilizando un código base compartido.
<!--  -->
## Conceptos Básicos

### Componentes

En React Native, los componentes son la unidad básica de la interfaz de usuario. Pueden ser elementos visuales como botones, etiquetas, o diseños más complejos como barras de navegación o listas.

Ejemplo de un componente básico en React Native:

```tsx
import React from 'react';
import { Text, View } from 'react-native';

const MiComponente = () => {
  return (
    <View>
      <Text>Hola, mundo!</Text>
    </View>
  );
};

export default MiComponente;
```

### Hooks en React Native

Los Hooks en React Native son funciones especiales que te permiten usar el estado y otras características de React sin tener que escribir una clase. Antes de los Hooks, la lógica de estado solo podía usarse en componentes de clase, pero con los Hooks, puedes usar características de React en componentes funcionales.

### useState Hook

El useState Hook es una función que te permite añadir estado a componentes funcionales en React Native. Puedes usar este Hook para manejar variables de estado dentro de tus componentes.

Ejemplo de uso del useState Hook:

```tsx
import React, { useState } from 'react';
import { View, Text, Button } from 'react-native';

const Contador = () => {
  const [contador, setContador] = useState(0);

  const incrementarContador = () => {
    setContador(contador + 1);
  };

  return (
    <View>
      <Text>Contador: {contador}</Text>
      <Button title="Incrementar" onPress={incrementarContador} />
    </View>
  );
};

export default Contador;
```

En este ejemplo, useState(0) inicializa el estado contador en 0, y setContador se utiliza para actualizar este estado.

[Ejemplo interactivo](https://www.w3schools.com/react/showreact.asp?filename=demo2_react_usestate)


### useEffect Hook

El useEffect Hook es una función que te permite realizar efectos secundarios en componentes funcionales en React Native. Puedes usar este Hook para ejecutar código después de que el componente se haya renderizado o cuando ciertos valores cambien.

Ejemplo de uso del useEffect Hook:

```tsx
import React, { useState, useEffect } from 'react';
import { View, Text } from 'react-native';

const Reloj = () => {
  const [hora, setHora] = useState(new Date().toLocaleTimeString());

  useEffect(() => {
    const intervalo = setInterval(() => {
      setHora(new Date().toLocaleTimeString());
    }, 1000);

    return () => clearInterval(intervalo);
  }, []);

  return <Text>Hora actual: {hora}</Text>;
};

export default Reloj;
```

En este ejemplo, el useEffect Hook se utiliza para actualizar la hora cada segundo utilizando setInterval. El return () => clearInterval(intervalo); asegura que el intervalo se limpie cuando el componente se desmonte.

[Ejemplo interactivo](https://www.w3schools.com/react/showreact.asp?filename=demo2_react_useeffect_settimeout3)