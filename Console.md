# Documentación de la clase de utilidad `Console`

## Descripción general

La clase `Console` proporciona una abstracción para operaciones de entrada y salida en la terminal de Java, con capacidades avanzadas de formateo de texto mediante colores ANSI. Esta clase simplifica tareas comunes como leer diferentes tipos de datos con validación, escribir en consola con colores personalizados y manipular la apariencia de la terminal.

## Características principales

- **Lectura de datos con validación**: Métodos para leer strings, enteros, decimales y caracteres con manejo automático de errores.
- **Escritura con formato**: Soporte para escribir texto con colores tanto en primer plano como en fondo.
- **Compatibilidad**: Detección automática de soporte ANSI en la terminal actual.
- **API intuitiva**: Métodos sobrecargados para diferentes tipos de datos y opciones de formateo.

## Estructura

La clase utiliza enumeraciones para definir los colores disponibles:

- `ForegroundColor`: Define los colores para el texto (primer plano).
- `BackgroundColor`: Define los colores para el fondo.

## Constructor

```java
public Console()
```

Inicializa un nuevo objeto Console y detecta automáticamente si la terminal actual soporta códigos ANSI para colores.

## Métodos de lectura

### Strings

```java
public String readString(String title)
```

Lee una línea de texto de la entrada estándar, mostrando opcionalmente un título o prompt.

```java
public String readString()
```

Lee una línea de texto sin mostrar ningún título.

### Números

```java
public int readInt(String title)
```

Lee un valor entero con validación, repitiendo la solicitud hasta obtener un entero válido.

```java
public double readDouble(String title)
```

Lee un valor decimal con validación, repitiendo la solicitud hasta obtener un decimal válido.

### Caracteres

```java
public char readChar(String title)
```

Lee un único carácter, con validación para asegurar que solo se ingresa un carácter.

```java
public char readChar(String title, boolean transformToUpperCase)
```

Lee un carácter y opcionalmente lo convierte a mayúscula.

## Métodos de escritura

### Sin salto de línea

```java
public void write(String string)
public void write(int value)
public void write(double value)
public void write(char character)
public void write(boolean value)
```

Escribe el valor dado en la consola sin añadir un salto de línea al final.

### Con salto de línea

```java
public void writeln()
public void writeln(String string)
public void writeln(int value)
public void writeln(double value)
public void writeln(char value)
public void writeln(boolean value)
```

Escribe el valor dado en la consola y añade un salto de línea al final. El método `writeln()` sin argumentos simplemente escribe un salto de línea.

## Escritura con colores

### Con color de texto

```java
public void write(String string, ForegroundColor color)
public void write(int value, ForegroundColor color)
public void write(double value, ForegroundColor color)
public void write(char value, ForegroundColor color)
public void write(boolean value, ForegroundColor color)
```

Escribe el valor dado con el color de texto especificado.

```java
public void writeln(String string, ForegroundColor color)
public void writeln(int value, ForegroundColor color)
public void writeln(double value, ForegroundColor color)
public void writeln(char value, ForegroundColor color)
public void writeln(boolean value, ForegroundColor color)
```

Escribe el valor dado con el color de texto especificado y añade un salto de línea.

### Con color de fondo

```java
public void write(String string, BackgroundColor bgColor)
public void write(int value, BackgroundColor bgColor)
public void write(double value, BackgroundColor bgColor)
public void write(char value, BackgroundColor bgColor)
public void write(boolean value, BackgroundColor bgColor)
```

Escribe el valor dado con el color de fondo especificado.

```java
public void writeln(String string, BackgroundColor bgColor)
public void writeln(int value, BackgroundColor bgColor)
public void writeln(double value, BackgroundColor bgColor)
public void writeln(char value, BackgroundColor bgColor)
public void writeln(boolean value, BackgroundColor bgColor)
```

Escribe el valor dado con el color de fondo especificado y añade un salto de línea.

### Con ambos colores

```java
public void write(String string, ForegroundColor fgColor, BackgroundColor bgColor)
public void write(int value, ForegroundColor fgColor, BackgroundColor bgColor)
public void write(double value, ForegroundColor fgColor, BackgroundColor bgColor)
public void write(char value, ForegroundColor fgColor, BackgroundColor bgColor)
public void write(boolean value, ForegroundColor fgColor, BackgroundColor bgColor)
```

Escribe el valor dado con los colores de texto y fondo especificados.

```java
public void writeln(String string, ForegroundColor fgColor, BackgroundColor bgColor)
public void writeln(int value, ForegroundColor fgColor, BackgroundColor bgColor)
public void writeln(double value, ForegroundColor fgColor, BackgroundColor bgColor)
public void writeln(char value, ForegroundColor fgColor, BackgroundColor bgColor)
public void writeln(boolean value, ForegroundColor fgColor, BackgroundColor bgColor)
```

Escribe el valor dado con los colores de texto y fondo especificados y añade un salto de línea.

## Métodos de utilidad

```java
public void writeError(String format)
```

Escribe un mensaje de error con formato y color rojo.

```java
public void clearScreen()
```

Limpia la pantalla de la consola utilizando códigos ANSI.

## Colores disponibles

<div align=center>

|ForegroundColor|BackgroundColor|
|-|-|
|`BLACK`: Negro|`BLACK`: Negro|
|`RED`: Rojo|`RED`: Rojo|
|`GREEN`: Verde|`GREEN`: Verde|
|`YELLOW`: Amarillo|`YELLOW`: Amarillo|
|`BLUE`: Azul|`BLUE`: Azul|
|`PURPLE`: Púrpura|`PURPLE`: Púrpura|
|`CYAN`: Cian|`CYAN`: Cian|
|`WHITE`: Blanco|`WHITE`: Blanco|
|`RESET`: Restablece al color por defecto|`RESET`: Restablece al color por defecto|

</div>

### Ejemplos

> Incluido en el `main()` de la clase.

```java
Console console = new Console();

console.writeln("Texto normal");
console.writeln("Texto en rojo", Console.ForegroundColor.RED);
console.writeln("Texto con fondo amarillo", Console.BackgroundColor.YELLOW);
console.writeln("Error crítico", Console.ForegroundColor.WHITE, Console.BackgroundColor.RED);

String nombre = console.readString("Introduce tu nombre: ");
int edad = console.readInt("Introduce tu edad: ");
double altura = console.readDouble("Introduce tu altura (m): ");
char inicial = console.readChar("Introduce tu inicial: ", true);

console.write("Nombre: ", Console.ForegroundColor.CYAN);
console.writeln(nombre);
console.write("Edad: ", Console.ForegroundColor.CYAN);
console.writeln(edad);
console.write("Altura: ", Console.ForegroundColor.CYAN);
console.writeln(altura);
console.write("Inicial: ", Console.ForegroundColor.CYAN);
console.writeln(inicial);

console.writeln("Información: proceso iniciado", Console.ForegroundColor.BLUE);

console.writeln("Advertencia: operación peligrosa", Console.ForegroundColor.YELLOW);

console.writeln("Éxito: operación completada", Console.ForegroundColor.GREEN);

console.writeln("Error: la operación ha fallado", Console.ForegroundColor.RED);

console.writeln("CRÍTICO: sistema comprometido", Console.ForegroundColor.WHITE, Console.BackgroundColor.RED);
```

## Limitaciones

- El soporte de colores ANSI puede variar según la terminal y el sistema operativo.
- En Windows, los códigos ANSI pueden no funcionar en todas las versiones del sistema operativo o configuraciones de terminal.
- La clase no incluye soporte para efectos adicionales como negrita, subrayado o parpadeo.

### Consideraciones técnicas

La clase utiliza códigos ANSI para formatear el texto. Estos códigos son secuencias de escape que modifican la apariencia del texto en terminales que los soportan. La clase incluye una detección automática de soporte ANSI, pero en algunos entornos específicos podría ser necesario ajustar esta detección.

### *2Do...*

La clase podría extenderse para incluir:

1. Soporte para efectos adicionales (negrita, subrayado, etc.).
1. Posicionamiento del cursor.
1. Menús interactivos.
1. Barras de progreso.
