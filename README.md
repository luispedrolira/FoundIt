# Foundlt
 
# Autores
 - Luis Pedro Lira 23669
 - Mía Fuentes  23775
 - Anggelie Velásquez 221181

## Descripción del Proyecto

**FoundIt** es una aplicación móvil diseñada para la Universidad del Valle de Guatemala que facilita la localización de objetos perdidos. A través de esta aplicación, los estudiantes pueden verificar rápidamente si sus pertenencias extraviadas han sido encontradas, así como gestionar el proceso de recuperación. La aplicación cuenta con dos tipos de usuarios: estudiantes normales, quienes pueden visualizar los objetos encontrados, y administradores, encargados de gestionar el registro y entrega de dichos objetos.

  
1. Facilitar la Búsqueda: El objetivo principal debe ser ayudar a los estudiantes y personal de la universidad a encontrar sus objetos perdidos de manera más eficiente. Esto implica crear una interfaz intuitiva que permita buscar y filtrar los objetos extraviados.
2. Reporte Colaborativo: Fomentar la colaboración entre la comunidad universitaria. Los usuarios deberían poder reportar objetos encontrados y perdidos a través de la aplicación.
3. Notificaciones y Alertas: Configurar notificaciones para informar a los usuarios cuando alguien reporta un objeto perdido similar al que ellos han extraviado. Así, si alguien encuentra unas gafas, por ejemplo, los usuarios que hayan perdido gafas recibirán una alerta.
4. Seguridad y Privacidad: Garantizar la seguridad y privacidad de los usuarios. La aplicación debe proteger la información personal y evitar el uso indebido de los datos.

## Librerías

### 1. Retrofit
**Uso:** Utilizaremos Retrofit para realizar solicitudes HTTP hacia nuestra API fake o hacia APIs externas. Esta librería facilita el manejo de solicitudes y respuestas de una manera sencilla y escalable dentro del código de la aplicación.

### 2. Kotlinx Serialization
**Uso:** Kotlinx Serialization se utiliza para serializar y deserializar los datos enviados entre pantallas y entre la aplicación y los servicios externos. Esto nos asegura que los datos sean transmitidos de manera eficiente y sin errores de formato.

### 3. Jetpack Compose
**Uso:** Jetpack Compose se utiliza para construir la interfaz de usuario de la aplicación. Con esta librería, podemos crear interfaces de usuario declarativas y responsivas que mejoren la experiencia de los usuarios al interactuar con la app.

### 4. Navigation Component
**Uso:** El componente de navegación de Jetpack se utiliza para gestionar la navegación entre las diferentes pantallas de la aplicación. Esto nos asegura que los usuarios puedan moverse fácilmente entre las secciones de la app (e.j., el Dashboard y la pantalla de agregar objetos).

## Base de Datos Local
Para cumplir con el requerimiento de tener una base de datos local, se utilizará Room para almacenar una copia de los datos localmente. Esta base de datos se sincroniza con Firestore para asegurar que los usuarios puedan acceder a los objetos incluso cuando no tienen conexión a internet.

