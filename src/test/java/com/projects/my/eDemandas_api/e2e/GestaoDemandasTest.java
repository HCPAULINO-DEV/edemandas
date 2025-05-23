package com.projects.my.eDemandas_api.e2e;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class GestaoDemandasTest {

    private GestaoDemandasPage gestaoDemandasPage;

    @BeforeEach
    public void beforeEach(){
        this.gestaoDemandasPage = new GestaoDemandasPage();
    }

    @AfterEach
    public void afterEach(){
        gestaoDemandasPage.quit();
    }

    @Test
    public void deveCadastrarDemanda(){
        String demanda = "Demanda 1";
        String documento = "documento_1.xls";
        gestaoDemandasPage.preencherFormularioDeCadastro(demanda, documento);
}
