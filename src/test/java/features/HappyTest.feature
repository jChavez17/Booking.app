#language: es
Característica: Reserva de alojamiento en Booking.com

  Escenario: Realizar una reserva de alojamiento en Cusco
    Cuando ingreso el destino "CUSCO"
    Y selecciono las fechas de estadía desde "14/02/2023" hasta "28/02/2023"
    Y selecciono 1 habitación, 2 adultos y 1 niño de 5 años
    Y realizo la búsqueda de alojamiento
    Y selecciono el segundo resultado de la búsqueda
    Y reservo la primera opción de habitación disponible
    Y lleno los datos de reserva con información válida
    Y verifico el costo de la reserva
    Y elijo la forma de pago tarjeta de crédito
    Entonces debería recibir una confirmación de reserva exitosa

  Escenario: Realizar una reserva de alojamiento con datos incorrectos
    Cuando ingreso el destino "CUSCO"
    Y selecciono fechas de estadía inválidas
    Y realizo la búsqueda de alojamiento
    Entonces debería recibir un mensaje de error indicando fechas inválidas

  Escenario: Realizar una reserva de alojamiento con datos faltantes
    Cuando no ingreso ningún dato de búsqueda
    Y realizo la búsqueda de alojamiento
    Entonces debería recibir un mensaje de error indicando datos faltantes
