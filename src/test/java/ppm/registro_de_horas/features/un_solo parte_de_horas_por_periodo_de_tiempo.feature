Feature: Un sólo parte de Horas por período de tiempo.

El Usuario no debe poder crear más de 1 parte de horas en un mismo período de tiempo (mes-año).

Scenario: no existe un parte de horas en el período
Given que el usuario no tiene partes de horas del período en que desea registrar sus horas
When el usuario intenta crear un parte de horas
Then el sistema le permite crear la parte de horas deseada


Scenario: existe un parte de horas en el período
Given que el usuario ya tiene una parte de horas en el período de tiempo deseado
When el usuario intenta crear una parte de horas en el mismo período de tiempo
Then el sistema no le deja crear la parte de horas y le indica que ya existe dicha parte de horas