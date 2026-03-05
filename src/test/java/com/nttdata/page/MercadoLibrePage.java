package com.nttdata.page;

import org.openqa.selenium.By;

public class MercadoLibrePage {
    public static By searchInput = By.name("as_word");
    public static By searchButton = By.cssSelector("button.nav-search-btn");
    public static By resultsList = By.cssSelector("li.ui-search-layout__item");
    public static By resultTitle = By.cssSelector("a.poly-component__title");
}
