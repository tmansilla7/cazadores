# Sistema de Cazadores de Recompensas

## 📌 Descripción general

Este proyecto consiste en el desarrollo de un **Sistema de Cazadores de Recompensas**, realizado como **trabajo práctico en pares**, cuyo objetivo es modelar un dominio complejo aplicando **Programación Orientada a Objetos**, **desarrollo colaborativo** y **control de versiones con GitHub**.

El sistema permite gestionar cazadores, prófugos y zonas, simulando procesos de captura, intimidación, evolución de prófugos y generación de reportes, siguiendo estrictamente el enunciado provisto por la cátedra.

---

## 🎯 Objetivos del trabajo

- Modelar el dominio de cazadores de recompensas y prófugos.
- Aplicar correctamente conceptos de **OOP**: herencia, polimorfismo, composición y delegación.
- Implementar un flujo de trabajo colaborativo usando **GitHub**.
- Validar la lógica del sistema mediante **TDD con JUnit 4**.
- Mantener un código claro, probado y bien organizado.

---

## 🛠️ Tecnologías utilizadas

- **Java**
- **JUnit 4** (Testing)
- **Git & GitHub**
- Proyecto Java tradicional con estructura de carpetas estándar

---

## 🧠 Diseño del sistema

### Cazadores de Recompensas

Se modelaron distintos tipos de cazadores, cada uno con comportamientos específicos:

- **Cazador Urbano**
- **Cazador Rural**
- **Cazador Sigiloso**

Todos comparten una clase base común, aprovechando herencia y polimorfismo para definir reglas de captura e intimidación específicas según el tipo.

### Prófugos

Cada prófugo posee:
- Nivel de inocencia
- Nivel de habilidad (1 a 100)
- Estado nervioso

Además, los prófugos pueden **evolucionar** mediante entrenamientos que agregan capacidades sin perder las anteriores, aplicando el concepto de **composición/decoración**.

Entrenamientos implementados:
- Artes marciales avanzadas
- Entrenamiento de élite
- Protección legal

---

## 🔁 Proceso de captura

Un cazador puede actuar sobre una **zona**, la cual contiene un conjunto de prófugos.

Para cada prófugo:
- Si cumple las condiciones → **es capturado**
- Caso contrario → **es intimidado**, modificando sus atributos según el tipo de cazador

Al finalizar el proceso:
- La zona queda sin los prófugos capturados
- El cazador incrementa su experiencia según la fórmula indicada en el enunciado

---

## 📊 Reportes implementados

El sistema permite obtener:

- 📋 Todos los prófugos capturados
- 🧠 El prófugo más hábil capturado
- 🏆 El cazador con mayor cantidad de capturas

---

## 🧪 Testing

- Desarrollo guiado por **TDD**
- Tests implementados con **JUnit 4**
- Cobertura enfocada en los casos centrales del sistema
- Validación de reglas de captura, intimidación, evolución y reportes

---

## 📁 Organización del proyecto

- Clases separadas por responsabilidad
- Paquetes bien definidos
- Métodos cortos y claros
- Nomenclatura consistente:
  - `UpperCamelCase` para clases
  - `lowerCamelCase` para métodos y variables

