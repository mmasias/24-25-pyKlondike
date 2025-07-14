# [24][25] - pyKlondike

```console
OPCIONES>
  1. Mover de Baraja a Descarte
  2. Mover de Descarte a Palo
  3. Mover de Descarte a Columna
  4. Mover de Palo a Columna
  5. Mover de Columna a Palo
  6. Mover de Columna a Columna
  7. Voltear carta de Columna
  8. Voltear Descarte en Baraja
  9. Salir

BARAJA: [? ?]
Descarte: [Q ♦️][7 ♦️][9 ♣️]

1º Palo: [A ♥️]
2º Palo: [A ♦️]
3º Palo: No hay cartas en el palo
4º Palo: No hay cartas en el palo

Columna [1]: [3 ♠️]
Columna [2]: [K ♥️]
Columna [3]: [? ?][? ?][7 ♠️]
Columna [4]: [? ?][? ?][? ?]
Columna [5]: [? ?][? ?][? ?][? ?][X ♥️]
Columna [6]: [? ?][? ?][? ?][? ?][? ?][6 ♥️]
Columna [7]: [? ?][? ?][? ?][? ?][? ?][? ?][9 ♥️]

Elige una opción  [1-9]
```

## Artefactos del proyecto

### Código fuente
- [Código de la aplicación](/src) - Contiene todas las clases Java del juego Klondike

### Documentación
- [Documentación del proyecto](/docs) - Incluye documentación técnica y recursos
- [Documentación de la clase Console](/docs/Console.md) - Documentación detallada de la clase de utilidad Console

### Modelos UML
- [Modelos UML](/modelosUML) - Diagramas y modelos del sistema
- [Jerarquía de clases](/modelosUML/jerarquia.puml) - Diagrama de herencia de clases

## Cómo ejecutar el proyecto

Para compilar y ejecutar el juego:

```bash
# Navegar al directorio src
cd src

# Compilar todos los archivos Java
javac *.java

# Ejecutar el juego
java ClienteKlondike
```

## Proceso de creación

En los commits hasta donde sea posible. En caso de ser necesario al final de la construcción aclararemos temas extra en este archivo.

### Incluida jerarquía de herencia

<div align=center>

|![](/docs/images/jerarquia.svg)
|:-:
|Jerarquía de clases ([*source*](/modelosUML/jerarquia.puml))

</div>

