# [Nest](https://docs.nestjs.com)

### [Nest-CLI](https://docs.nestjs.com/cli/overview) Comandos\*

## ¿Qué es Nest?

Nest es un framework de Node.js para construir aplicaciones eficientes y escalables del lado del servidor.

## Conceptos Básicos de Nest

### 1. Controladores (Controllers)

Los controladores en Nest manejan las solicitudes HTTP entrantes y devuelven las respuestas adecuadas. Se definen utilizando decoradores y métodos específicos para cada tipo de solicitud (GET, POST, PUT, DELETE, PATCH).

#### Tipos de Solicitudes HTTP

En desarrollo web, existen varios tipos de solicitudes HTTP que se utilizan para interactuar con servidores y obtener o enviar datos. A continuación, se presentan los tipos más comunes:

-   GET
    Elétodo GET se utiliza para solicitar datos del servidor. Por lo general, se utiliza para recuperar información, como páginas web, imágenes o archivos.

-   POST
    El método POST se utiliza para enviar datos al servidor. Se utiliza comúnmente para enviar formularios o crear recursos en el servidor.

-   PUT
    El método PUT se utiliza para actualizar datos en el servidor. Se utiliza cuando se desea modificar un recurso existente con los datos proporcionados.

-   DELETE
    El método DELETE se utiliza para eliminar un recurso en el servidor. Al enviar una solicitud DELETE a un recurso específico, se elimina dicho recurso.

-   PATCH
    El método PATCH se utiliza para realizar modificaciones parciales en un recurso. Se envían los datos que se desean cambiar, sin necesidad de enviar todo el recurso.

Ejemplo de un controlador básico:

```typescript
import { Controller, Get } from '@nestjs/common'

@Controller('users')
export class UsersController {
	@Get()
	getUsers() {
		return 'Lista de usuarios'
	}
}
```

### 2. Servicios (Services)

Los servicios en Nest contienen la lógica de negocio de la aplicación. Se utilizan para realizar operaciones como acceder a bases de datos, interactuar con otros servicios web, etc. Los servicios se inyectan en los controladores y otros componentes según sea necesario.

Ejemplo de un servicio básico:

```typescript
import { Injectable } from '@nestjs/common'

@Injectable()
export class UserService {
	getUsers(): string[] {
		return ['Usuario 1', 'Usuario 2', 'Usuario 3']
	}
}
```

### 3. Proveedores (Providers)

Los proveedores en Nest son objetos que pueden ser inyectados en otros componentes. Pueden ser servicios, configuraciones, bases de datos, etc. Se definen utilizando la anotación @Injectable() y se proporcionan dentro de los módulos.

Ejemplo de un proveedor básico:

```typescript
import { Injectable } from '@nestjs/common'

@Injectable()
export class ConfigService {
	getDatabaseConfig(): any {
		return {
			host: 'localhost',
			port: 5432,
			username: 'usuario',
			password: 'contraseña',
		}
	}
}
```

### 4. Módulos (Modules)

Los módulos en Nest son contenedores que agrupan controladores, servicios y otros componentes relacionados. Ayudan a organizar la aplicación de manera modular y permiten la reutilización de código.

Ejemplo de un módulo básico:

```typescript
import { Module } from '@nestjs/common'
import { UsersController } from './users.controller'
import { UserService } from './user.service'

@Module({
	controllers: [UsersController],
	providers: [UserService],
})
export class UsersModule {}
```
