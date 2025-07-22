## Documentación del Challenge

Para la realización de este challenge utilicé **Java 17 con Spring Boot** para el backend y **Astro** para el frontend. Partí de la siguiente premisa:

> *"Esto podría ser un MVP, pero si la aplicación debe escalar, ¿cómo lo haríamos?"*

Con eso en mente, paso a explicar brevemente las decisiones de diseño y estructura del repositorio.

---

### Diseño del repositorio

El proyecto está contenido en un **monorepo** que agrupa dos proyectos independientes: uno para el **backend** y otro para el **frontend**.

#### Backend

Opté por Java y Spring Boot por dos motivos principales:

1. **Fiabilidad, estabilidad y rendimiento** del ecosistema Java + Spring Boot.
2. **Facilidad de desarrollo** gracias a mi experiencia previa.

Desde una visión más amplia, este stack permite escalar fácilmente a mediano y largo plazo. Además, ofrece la posibilidad de evolucionar la API actual (REST) hacia un modelo más maduro como el **nivel 3 del modelo de Richardson**, incluyendo **HATEOAS** si fuera necesario.

Spring Boot proporciona una excelente documentación, flujos de trabajo claros y herramientas como **AOP (aspectos)**, que reducen la carga de configuración manual.

Adopté una **estructura de carpetas basada en características o dominios funcionales** (por ejemplo, `product`, `user`, etc.), lo que mejora la cohesión entre clases relacionadas y facilita el mantenimiento del código.

Además, implementé **aspectos** para interceptar las peticiones HTTP y registrar la cantidad de parámetros enviados a cada endpoint. Esto sería útil en un escenario escalado, por ejemplo, para diagnosticar posibles problemas de comunicación entre microservicios.

A pesar de que esta implementación es sencilla y omite algunas columnas importantes en las entidades, decidí usar **proyecciones** para las consultas a la base de datos. Esto estandariza el acceso a entidades grandes, permitiendo consultar solo los campos necesarios. La manipulación de datos se realiza en la capa de servicio, y para simplificar el mapeo, utilicé **MapStruct**.

#### Frontend

Elegí **Astro** por su simplicidad. Como desarrollador backend, tener una herramienta ligera y enfocada en la presentación fue ideal. Astro permite apoyarse en herramientas generativas como **V0 de Vercel** para generar el maquetado inicial, facilitando así el enfoque en los *fetchs* y el renderizado dinámico de datos.

Astro utiliza **SSR por defecto**, lo que mejora los tiempos de carga y simplifica el desarrollo de aplicaciones web rápidas.

---

### Contenedorización

Contenericé la aplicación usando **Docker** y orquesté los servicios con **Docker Compose**. Esto incluyó:

* Archivos `Dockerfile` para frontend y backend.
* Archivo `docker-compose.yml` que define cómo levantar todo el entorno.

Principales configuraciones:

* La base de datos es accesible desde el exterior para facilitar su inspección con herramientas como **DBeaver**.
* Aunque `docker-compose` crea el contenedor de base de datos, es el backend (vía Jakarta Persistence) el encargado de crear las tablas y poblarla con **data dummy**.
* El backend expone puertos para poder ser consumido por herramientas como **Postman**.

Esta parte fue el mayor reto técnico del proyecto, ya que no acostumbro a configurar contenedores en mi día a día. Sin embargo, no representó un bloqueo.

---

### Oportunidades de mejora

Considerando la premisa inicial sobre escalabilidad, propongo las siguientes mejoras:

* **Java 21**: cambiar a esta versión permitiría el uso de *virtual threads*, lo cual sería muy útil en escenarios de alta concurrencia.
* **Caché**: implementar caché para consultas frecuentes como productos o rankings por categoría, reduciendo la carga sobre la base de datos.
* **Arquitectura basada en eventos**: si el sistema escala hacia múltiples microservicios, una arquitectura orientada a eventos puede mejorar la eficiencia, siempre que el equipo tenga el conocimiento necesario para aprovecharla bien.
* **Desarrollo multiplataforma o nativo**: si se planea tener una app móvil:

  * Para ir rápido al MVP, consideraría usar **React** en el frontend y **React Native** para la app.
  * Para un desarrollo nativo (mi preferencia), Astro podría quedarse corto. En ese caso, migraría el frontend a **Angular** (por su robustez y familiaridad para desarrolladores backend) y usaría **Kotlin** para Android y **Swift** para iOS.

---

### Ejecución del proyecto

Para levantar el proyecto, dirígete al archivo [`run.md`](https://github.com/JQuintero2430/meli-challenge/blob/main/run.md) en este repositorio y sigue las instrucciones.

