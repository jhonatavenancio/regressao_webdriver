package Utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.Actions;
import Base.Log;

public class CarrinhoCompras {
    
    public static void adicionarItensTelaHome(WebDriver driver, int numeroItens, int indicadorItem, int limiteItem) {
    	int numeroItensAdicionados = numeroItens;
    	
        for (int i = indicadorItem; i <= limiteItem; i++) {
            
                WebElement produto = driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child("+i+") > div.pricebar > button"));
                produto.click();
                Actions.esperarSegundos(200);
                Log.registrar("Adiciona item");
                
                numeroItensAdicionados++;
        }
        
        validarAdicionados(driver, numeroItensAdicionados);
    }
    
    public static void removendoItensTelaHome(WebDriver driver, int indicadorItem, int limiteItem) {
    	adicionarItensTelaHome(driver, 0, 1, 6);
    	Actions.esperarSegundos(1000);
    	
        for (int i = indicadorItem; i <= limiteItem; i++) {
            
                WebElement produto = driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child("+i+") > div.pricebar > button"));
                produto.click();
                Actions.esperarSegundos(200);
                Log.registrar("Removido item"); 
        }
        validarRemovido(driver);
    }
    
    public static void adicionarItensNosDetalhes(WebDriver driver,int numeroItens, int indicadorItem, int limiteItem) {
    	int numeroItensAdicionados = numeroItens;
    	
        for (int i = indicadorItem; i <= limiteItem; i++) {
            
                WebElement produto = driver.findElement(By.cssSelector("#item_" + i + "_title_link > .inventory_item_name"));
                produto.click();
                Actions.esperarSegundos(200);
                Actions.clicarBotaoPegandoPeloCss(driver, ".btn_primary");
                Actions.clicarBotaoPegandoPeloCss(driver, ".inventory_details_back_button");
                Log.registrar("Adiciona item");
                
                numeroItensAdicionados++;
        }
        validarAdicionados(driver, numeroItensAdicionados);
    }

    public static void removendoItensNosDetalhes(WebDriver driver, int indicadorItem, int limiteItem) {
        adicionarItensNosDetalhes(driver, 0 , 0, 5);
        Actions.esperarSegundos(1000);
        for (int i = indicadorItem; i <= limiteItem; i++) {

                WebElement produto = driver.findElement(By.cssSelector("#item_" + i + "_title_link > .inventory_item_name"));
                produto.click();
                Actions.esperarSegundos(200);
                Actions.clicarBotaoPegandoPeloCss(driver, ".btn_secondary");
                Actions.clicarBotaoPegandoPeloCss(driver, ".inventory_details_back_button");
                Log.registrar("Remove item");
        }
        validarRemovido(driver);
    }
    
    public static void continuarComprandoDetalhes(WebDriver driver) {
    	adicionarItensNosDetalhes(driver, 0, 0, 2);
    	
    	 Actions.esperarSegundos(200);
         Actions.clicarBotaoPegandoPeloCss(driver, "path");
         Actions.esperarSegundos(200);
         Log.registrar("Entrar no carrinho"); 
         Actions.clicarBotaoPegandoPeloCss(driver, ".btn_secondary:nth-child(1)");
         Log.registrar("Clicar em 'continuar comprando'"); 
         Actions.esperarSegundos(200);
                
        adicionarItensNosDetalhes(driver, 3, 3, 5);
}
    
    public static void continuarComprandoTelaHome(WebDriver driver) {
    	adicionarItensTelaHome(driver, 0, 1, 2);
    	
        Actions.esperarSegundos(200);
        Actions.clicarBotaoPegandoPeloCss(driver, "path");
        Actions.esperarSegundos(200);
        Log.registrar("Entrar no carrinho"); 
        Actions.clicarBotaoPegandoPeloCss(driver, ".btn_secondary:nth-child(1)");
        Log.registrar("Clicar em 'continuar comprando'"); 
        Actions.esperarSegundos(200);
                
        adicionarItensTelaHome(driver, 2, 4, 6);
}

    public static void validarAdicionados(WebDriver driver, int numeroItensAdicionados) {
        WebElement carrinho = driver.findElement(By.cssSelector("#shopping_cart_container > a > span"));
        String textoCarrinho = carrinho.getText();
  
        int quantidadeNoCarrinho = Integer.parseInt(textoCarrinho);
        
        if (numeroItensAdicionados == quantidadeNoCarrinho) {
            Log.registrar("A quantidade de itens no carrinho está correta.");
            
        } else {
        	
        	String falha = "A quantidade de itens no carrinho não corresponde à quantidade adicionada.";
            Log.registrar(falha);
            Assert.fail(falha);
            
        }
    }
 
    public static void validarRemovido(WebDriver driver) {
     Actions.esperarSegundos(500);
     boolean carrinhoVazio = false;
     try {

         carrinhoVazio = !driver.findElement(By.cssSelector("#shopping_cart_container > a > span")).isDisplayed();
     } catch (NoSuchElementException e) {

         Log.registrar("O carrinho está vazio.");
         return;
     }

     if (!carrinhoVazio) {
         Log.registrar("Erro: Ainda há itens no carrinho.");
     } else {
         Log.registrar("Todos os itens foram removidos com sucesso.");
     }
 }
    
    public static void removendoPeloCarrinho(WebDriver driver, int indicadorItem, int limiteItem) {
    	adicionarItensTelaHome(driver, 0, 1, 6);
    	Actions.esperarSegundos(1000);
        Actions.clicarBotaoPegandoPeloCss(driver, "path");
        Log.registrar("Acessando o carrinho"); 
        Actions.esperarSegundos(200);
    	
        for (int i = indicadorItem; i <= limiteItem; i++) {
            
                WebElement produto = driver.findElement(By.cssSelector(".cart_item:nth-child("+i+") .btn_secondary"));
                produto.click();
                Actions.esperarSegundos(200);
                Log.registrar("Removido item"); 
        }
        validarRemovido(driver);
    }
}
