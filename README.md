JobSalary

Contexto del Proyecto
-Un pipeline de procesamiento de datos construido en Java para analizar las tendencias salariales globales en el sector tecnológico. La aplicación lee, limpia y agrega datos para descubrir el impacto de la experiencia, ubicación y modalidad de trabajo en los salarios.

Stack Tecnológico
1. Lenguaje: Java
2. Herramientas: Java Collections Framework, Streams API para filtrado y agregación.
3. Formatos procesados: Archivos CSV.

Resultados del Procesamiento
1. Trabajo Remoto: El algoritmo agrupó y determinó que los roles 100% remotos (sede EE. UU.) superan en un 20% a los roles híbridos en otras regiones.
2. Impacto de la Experiencia: Se calculó un incremento salarial del 45% en la transición de 'Mid-Level' a 'Senior'.
3. Top Roles: La extracción de datos muestra a Data Engineers y ML Engineers en el top de compensación media.

Cómo ejecutar este proyecto
1. Clona este repositorio.
2. Asegúrate de tener los datos fuente en la carpeta `/data` (o ajusta la ruta en `application.properties`).
3. Compila y ejecuta la aplicación para generar el reporte en consola o exportar el archivo de resultados.
