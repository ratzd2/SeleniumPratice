package QA.Selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FormPratice {

	String caminhoProjeto = System.getProperty("user.dir"); // RETORNA O CAMINHO DO PROJETO
	private static WebDriver driver;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	private static final String PHANTOM_DRIVER_PROPERTY = "phantomjs.binary.path";

	@Before
	public void beforeMethod() {
		System.setProperty(FIREFOX_DRIVER_PROPERTY, caminhoProjeto + "\\Util\\geckodriver.exe"); // CONFIGURA NAVEGADOR
		driver = new FirefoxDriver(); // FIREFOX
		// System.setProperty(CHROME_DRIVER_PROPERTY, caminhoProjeto +
		// "\\Util\\chromedriver.exe"); // CONFIGURA NAVEGADOR
		// driver = new ChromeDriver(); // CHROME

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // PARAMETRIZA O TEMPO PADRAO DE ESPERA
		driver.manage().window().maximize(); // MAXIMIZA O NAVEGADOR

		driver.get("http://toolsqa.wpengine.com/automation-practice-form"); // SITE A SER ACESSADO
	}

	@Test
	public void preencherFormulario() throws InterruptedException {
		Select oSelect = new Select(driver.findElement(By.id("continents")));
		oSelect.selectByVisibleText("Europe");

		Thread.sleep(5000);

		oSelect.selectByIndex(2); // SELECIONA OPCAO AFRICA
		Thread.sleep(5000);
	}

	@After
	public void afterMethod() {
		driver.quit(); // ENCERRA O DRIVER
	}
}
