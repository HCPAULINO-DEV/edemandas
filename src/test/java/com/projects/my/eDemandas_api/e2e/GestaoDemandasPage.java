package com.projects.my.eDemandas_api.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GestaoDemandasPage extends PageObjects{

    public static final String URL_GESTAO_DEMANDAS = "http://localhost:8086/index.html";

    public GestaoDemandasPage() {
        super(null);
        browser.navigate().to(URL_GESTAO_DEMANDAS);
    }

    public void preencherFormularioDeCadastro(String nomeDemanda, String urlDocumento) {
        browser.findElement(By.name("nome")).sendKeys(nomeDemanda);
        browser.findElement(By.name("documento")).sendKeys(urlDocumento);
        browser.findElement(By.cssSelector(".btn.btn-success.w-100")).click();
    }
}
