
## Objetivo de la App

El objetivo de la app es permitir la consulta tanto de medicamientos como de ocurrencias de reacciones adversas entre medicamentos y padecimientos comunes haciendo uso de la API de la FDA (U.S. Food and Drug Administration). Además, permite tener un registro de medicamentos que el usuario desee guardar de forma local.
Cabe destacar que la aplicación no pretende reemplazar el diagnostico ni el juicio de un especialista de la salud, sino apoyar a la consulta y administración de la información de los medicamentos.

## Descripción del logo y lo que representa

El logo trata de mostrar de forma simple la idea básica de la app: consultar información sobre medicamentos.

## Justificación de la elección del tipo de dispositivo, versión del sistema operativo y las orientaciones soportadas.

Ya que la app tiene un fin relacionado a la salud, se consideró que la versión de Android 7.0 era ideal pues permite que la gran mayoria de los dispositivos puedan utilizar esta aplicación. Se definió una orientación vertical para la aplicación para facilitar el desarrollo de la aplicación.

## Credenciales para poder acceder al app (si se requieren)
No se necesitan credenciales para acceder y usar la app, pero la API cuenta con una restricción de 1000 peticiones por día, por lo que para fines del proyecto se redujo el límite de resultados obtenidos.
Como la api esta en ingles, se recomienda usar productos vendidos en EEUU o en su defecto el nombre genérico en inglés

## Dependencias del proyecto (paquetes y/o frameworks utilizados)
Se utilizaron las librerías de Retrofit, Gson, además de Lifecycle.runtime y logging.interceptor.
