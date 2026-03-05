package com.nttdata.stepsdefinitions;

import com.nttdata.steps.MercadoLibreSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.*;

public class MercadoLibreStepsDef {

    private WebDriver driver;

    private MercadoLibreSteps mercadoLibreSteps(WebDriver driver){
        return new MercadoLibreSteps(driver);
    }

    @Given("estoy en la página de MercadoLibre")
    public void estoy_en_la_página_de_mercado_libre() {
        driver = getDriver();
        driver.get("https://www.mercadolibre.com.pe/");
        screenShot();
    }

    @When("busco un producto {string}")
    public void busco_un_producto(String producto) {
        MercadoLibreSteps steps = new MercadoLibreSteps(driver);
        steps.searchProduct(producto);
        esperaImplicita();
        screenShot();
    }

    @Then("una lista de resultados")
    public void una_lista_de_resultados() {
        int resultsSize = mercadoLibreSteps(driver).getResultsSize();

        Assertions.assertTrue(resultsSize > 0,
                "No se encontraron resultados");
    }

    @And("valido el primer titulo del resultado sea {string}")
    public void valido_el_primer_titulo_del_resultado_sea(String expectedTitle) {

        String firstTitle = mercadoLibreSteps(driver).getFirstResultTitle();

        Assertions.assertEquals(expectedTitle, firstTitle);
        screenShot();
    }
}