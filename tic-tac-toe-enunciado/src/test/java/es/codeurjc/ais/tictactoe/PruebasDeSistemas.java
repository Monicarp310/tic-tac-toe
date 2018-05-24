package es.codeurjc.ais.tictactoe;

import static org.junit.Assert.*;
import io.github.bonigarcia.wdm.ChromeDriverManager;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class PruebasDeSistemas {
	protected WebDriver driver;
	protected WebDriver driver1;
	
	@BeforeClass
      public static void setupClass() {
      ChromeDriverManager.getInstance().setup();
	}
	
    @Before
    public void setupTest(){
    	driver = new ChromeDriver();
    	driver1 = new ChromeDriver();
    }
    
    @After
    public void teardown(){
    	if (driver != null){
    		driver.close();
    	}
    	if (driver1 != null){
    		driver1.close();
    	}
    }

	@Test
	public void PrimerJugadorGana() {
		
		driver.get("localhost:8080");
		driver1.get("localhost:8080");
		
		WebElement web1= driver.findElement(By.id("nickname"));
		web1.sendKeys("jose");
		WebElement web2= driver1.findElement(By.id("nickname"));
		web2.sendKeys("fran");
		WebElement boton1= driver.findElement(By.id("startBtn"));
		WebElement boton2= driver1.findElement(By.id("startBtn"));

		boton1.click();
		boton2.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		cell0.click();
		WebElement cell1 = driver1.findElement(By.id("cell-1"));
		cell1.click();
		WebElement cell2 = driver.findElement(By.id("cell-2"));
		cell2.click();
		WebElement cell3 = driver1.findElement(By.id("cell-3"));
		cell3.click();
		WebElement cell4 = driver.findElement(By.id("cell-4"));
		cell4.click();
		WebElement cell5 = driver1.findElement(By.id("cell-5"));
		cell5.click();
		WebElement cell6 = driver.findElement(By.id("cell-6"));
		cell6.click();
		
		String ganador=driver.switchTo().alert().getText();
		assertEquals(ganador,"jose wins! fran looses.");
		
		
		
		
		
		
	}


  @Test
  public void SegundoJugadorGana() {
	
	driver.get("localhost:8080");
	driver1.get("localhost:8080");
	
	WebElement web1= driver.findElement(By.id("nickname"));
	web1.sendKeys("jose");
	WebElement web2= driver1.findElement(By.id("nickname"));
	web2.sendKeys("fran");
	WebElement boton1= driver.findElement(By.id("startBtn"));
	WebElement boton2= driver1.findElement(By.id("startBtn"));

	boton1.click();
	boton2.click();
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	WebElement cell1 = driver.findElement(By.id("cell-1"));
	cell1.click();
	WebElement cell0 = driver1.findElement(By.id("cell-0"));
	cell0.click();
	WebElement cell3 = driver.findElement(By.id("cell-3"));
	cell3.click();
	WebElement cell2 = driver1.findElement(By.id("cell-2"));
	cell2.click();
	WebElement cell5 = driver.findElement(By.id("cell-5"));
	cell5.click();
	WebElement cell4 = driver1.findElement(By.id("cell-4"));
	cell4.click();
	WebElement cell7 = driver.findElement(By.id("cell-7"));
	cell7.click();
	WebElement cell6 = driver1.findElement(By.id("cell-6"));
	cell6.click();
	String ganador=driver.switchTo().alert().getText();
	assertEquals(ganador,"fran wins! jose looses.");
	
	
	
	
	
	
}
    @Test
    public void Empate() {
	
	driver.get("localhost:8080");
	driver1.get("localhost:8080");
	
	WebElement web1= driver.findElement(By.id("nickname"));
	web1.sendKeys("jose");
	WebElement web2= driver1.findElement(By.id("nickname"));
	web2.sendKeys("fran");
	WebElement boton1= driver.findElement(By.id("startBtn"));
	WebElement boton2= driver1.findElement(By.id("startBtn"));

	boton1.click();
	boton2.click();
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	WebElement cell0 = driver.findElement(By.id("cell-0"));
	cell0.click();
	WebElement cell1 = driver1.findElement(By.id("cell-1"));
	cell1.click();
	WebElement cell2 = driver.findElement(By.id("cell-2"));
	cell2.click();
	WebElement cell3 = driver1.findElement(By.id("cell-3"));
	cell3.click();
	WebElement cell5 = driver.findElement(By.id("cell-5"));
	cell5.click();
	WebElement cell4 = driver1.findElement(By.id("cell-4"));
	cell4.click();
	WebElement cell7 = driver.findElement(By.id("cell-7"));
	cell7.click();
	WebElement cell8 = driver1.findElement(By.id("cell-8"));
	cell8.click();
	WebElement cell6 = driver.findElement(By.id("cell-6"));
	cell6.click();
	String resultado=driver.switchTo().alert().getText();
	assertEquals(resultado,"Draw!");
	
	
	
	
	
	
}

}