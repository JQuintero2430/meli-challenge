# Instrucciones para ejecutar el proyecto

Para poder ejecutar el programa, es necesario que el usuario cuente con **Docker Engine** instalado en su entorno de ejecución, ya que la ejecución se realiza a través de **Docker Compose**.

## Pasos para ejecutar

1. **Clonar el repositorio**

   Desde la terminal de tu PC, ejecuta el siguiente comando para clonar el proyecto:

   ```bash
   git clone https://github.com/JQuintero2430/meli-challenge.git
   ```

2. **Ingresar al proyecto**

   Navega hasta la raíz del proyecto (es un monorepo) usando la terminal:

   ```bash
   cd meli-challenge
   ```

3. **Levantar los contenedores**

   Ejecuta el siguiente comando para construir y levantar los contenedores:

   ```bash
   docker compose up --build
   ```

   Deberás esperar un momento hasta que los contenedores estén corriendo. Podrás identificar que el sistema está listo cuando en la terminal aparezca la frase:

   ```
   -> Inicialización de datos completada exitosamente.
   ```

4. **Visualizar la aplicación**

   Una vez todo esté funcionando, podrás visualizar el desarrollo accediendo a:

   ```
   http://localhost:4321
   ```

   desde cualquier navegador.

---

## Endpoints disponibles

Una vez levantado el backend, puedes consultar los siguientes endpoints desde herramientas como Postman o desde el navegador (para métodos GET):

* Obtener detalles de producto por slug y productId:

  ```
  http://localhost:8080/api/products/{slug}?productId={productId}
  ```

* Obtener información de un vendedor por su ID:

  ```
  http://localhost:8080/api/seller/{sellerId}
  ```

* Obtener información de un usuario por su ID:

  ```
  http://localhost:8080/api/user/{userId}
  ```
