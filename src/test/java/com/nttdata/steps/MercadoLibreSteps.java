package com.nttdata.steps;

import com.nttdata.page.MercadoLibrePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MercadoLibreSteps {

    private WebDriver driver;

    // constructor
    public MercadoLibreSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el producto en el buscador
     */
    public void typeProduct(String product){
        WebElement searchInput = driver.findElement(MercadoLibrePage.searchInput);
        searchInput.sendKeys(product);
    }

    /**
     * Click en el botón buscar
     */
    public void clickSearch(){
        driver.findElement(MercadoLibrePage.searchButton).click();
    }

    /**
     * Buscar producto completo
     */
    public void searchProduct(String product){
        typeProduct(product);
        clickSearch();
    }

    /**
     * Obtener cantidad de resultados
     */
    public int getResultsSize(){
        List<WebElement> results = driver.findElements(MercadoLibrePage.resultsList);
        return results.size();
    }

    /**
     * Obtener el título del primer resultado
     */
    public String getFirstResultTitle(){

        List<WebElement> results = driver.findElements(MercadoLibrePage.resultsList);

        return results.get(0)
                .findElement(MercadoLibrePage.resultTitle)
                .getText();
    }
}