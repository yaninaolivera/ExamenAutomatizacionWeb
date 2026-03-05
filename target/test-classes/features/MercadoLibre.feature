Feature: MercadoLibre
@busquedaProducto

  @testMercadoLibre
  Scenario: Busqueda de Productos
    Given estoy en la página de MercadoLibre
    When busco un producto "Televisores Led 40 pulgadas"
    Then una lista de resultados
    And valido el primer titulo del resultado sea 'Smart Tv Samsung 40" Fhd F6000F 2025 Black UN40F6000FGXPE'



