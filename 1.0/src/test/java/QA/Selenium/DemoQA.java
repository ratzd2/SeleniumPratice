package QA.Selenium;

import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoQA {

	String caminhoProjeto = System.getProperty("user.dir"); // RETORNA O CAMINHO DO PROJETO
	private static WebDriver driver;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	private static final String PHANTOM_DRIVER_PROPERTY = "phantomjs.binary.path";
	
	@Before
	public void beforeMethod() {	
		System.setProperty(FIREFOX_DRIVER_PROPERTY, caminhoProjeto + "\\Util\\geckodriver.exe"); // CONFIGURA NAVEGADOR
		driver = new FirefoxDriver();	// FIREFOX
//		System.setProperty(CHROME_DRIVER_PROPERTY, caminhoProjeto + "\\Util\\chromedriver.exe"); // CONFIGURA NAVEGADOR
//		driver = new ChromeDriver();	// CHROME
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // PARAMETRIZA O TEMPO PADRAO DE ESPERA
		driver.manage().window().maximize(); // MAXIMIZA O NAVEGADOR

		driver.get("http://www.store.demoqa.com"); // SITE A SER ACESSADO
	}

	@Test
	public void pesquisaIpad() throws InterruptedException {		
		By xpathAllProducts = By.xpath("/html/body/div[2]/div/div/header/nav/ul/li[4]/a");
		driver.findElement(xpathAllProducts).click();
		
		By classCampoPesquisa = By.name("s");
		driver.findElement(classCampoPesquisa).clear();
		driver.findElement(classCampoPesquisa).sendKeys("IPAD");
		driver.findElement(classCampoPesquisa).submit();
		Thread.sleep(5000);
		
		By linkTextIpad = By.linkText("Apple iPad 6 32GB (White, 3D)");
		driver.findElement(linkTextIpad).click();
		Thread.sleep(5000);
	}
	
	@Test
	public void cadastro() throws InterruptedException {
		By xpathMyAccount = By.xpath("/html/body/div[2]/div/div/header/div[2]/a");
		driver.findElement(xpathMyAccount).click();
		Thread.sleep(5000);
		
		By linkTextRegistrar = By.linkText("Register");
		driver.findElement(linkTextRegistrar).click();
		Thread.sleep(5000);
		
		By idUsername = By.id("user_login");
		driver.findElement(idUsername).sendKeys("Nome User");
		
		By idEmail = By.id("user_email");
		driver.findElement(idEmail).sendKeys("useremail@email.com");
		
		By idSubmit = By.id("wp-submit");
		driver.findElement(idSubmit).click();
		Thread.sleep(5000);
	}

	@After
	public void afterMethod() {
		driver.quit(); // ENCERRA O DRIVER
	}
}
