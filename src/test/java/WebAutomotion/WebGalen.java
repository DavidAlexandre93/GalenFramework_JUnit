package WebAutomotion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;

public class WebGalen {

	private WebDriver driver;

	@Test
	public void TesteInternetExplorer() throws Exception {
		System.setProperty("webdriver.internetexplorer.driver", "C:\\Users\\745093\\Documents\\driver\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(1024, 768));
		IEhomePageLayoutTest();
		IEMyNotesLayoutTest();
		IEEventTest();

	}

	@Test
	public void TesteFirefox() throws Exception {
		System.setProperty("webdriver.firefox.driver", "C:\\Users\\745093\\Documents\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(1024, 768));
		FFhomePageLayoutTest();
		FFMyNotesLayoutTest();
		FFEventTest();

	}

	@Test
	public void TesteChrome() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\745093\\Documents\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(1024, 768));
		driver.get("http://testapp.galenframework.com/");
		CRhomePageLayoutTest();
		CRMyNotesLayoutTest();
		CREventTest();

	}

//**********************************************************************************************    
//*********************************TESTE 1° Internet********************************************
//**********************************************************************************************    
	public void IEhomePageLayoutTest() throws Exception {

		driver.get("http://testapp.galenframework.com/");
		// Create a layoutReport object
		// checkLayout function checks the layout and returns a LayoutReport object
		LayoutReport layoutReport = Galen.checkLayout(driver, "specs/homepage.gspec", Arrays.asList("desktop"));

		// Criando a lista com GalenTestInfo
		List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

		// Estanciando o objeto do GalenTestInfo
		GalenTestInfo test = GalenTestInfo.fromString("IEhomepage layout");

		// Selecionando com get para check layout
		test.getReport().layout(layoutReport, "check IEhomepage layout");

		// Add test object to the tests list
		tests.add(test);

		// Estanciando o objeto do htmlReportBuilder
		HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

		// Criando reportbuild em target
		htmlReportBuilder.build(tests, "target");

		// If para validar se o layout retornar erros
		if (layoutReport.errors() > 0) {
			Assert.fail("Layout test failed");
		}
	}

//**********************************************************************************************    
//************************************TESTE 2° Internet******************************************
//**********************************************************************************************      
	public void IEMyNotesLayoutTest() throws Exception, InterruptedException {

		driver.get("http://testapp.galenframework.com/");
		// Clicar o botao login na welcomepage
		WebElement Botao = driver.findElement(By.cssSelector("button"));
		Botao.click();

		// Realizar o login na pagina
		WebElement usuario = driver.findElement(By.name("login.username"));
		WebElement senha = driver.findElement(By.name("login.password"));
		WebElement Button = driver.findElement(By.cssSelector("button"));

		usuario.sendKeys("testuser@example.com");
		senha.sendKeys("test123");
		Button.click();

		Thread.sleep(1000);
		// Create a layoutReport object
		// checkLayout function checks the layout and returns a LayoutReport object
		LayoutReport layoutReport = Galen.checkLayout(driver, "specs/mynotes.gspec", Arrays.asList("desktop"));

		// Criando a lista com GalenTestInfo
		List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

		// Estanciando o objeto do GalenTestInfo
		GalenTestInfo test = GalenTestInfo.fromString("IEmynotes layout");

		// Selecionando com get para check layout
		test.getReport().layout(layoutReport, "check IEmynotes layout");

		// Add test object to the tests list
		tests.add(test);

		// Estanciando o objeto do htmlReportBuilder
		HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

		// Criando reportbuild em target
		htmlReportBuilder.build(tests, "target");

	}

//**********************************************************************************************    
//*************************************TESTE 3° Internet****************************************
//**********************************************************************************************	
	public void IEEventTest() throws Exception, InterruptedException {

		driver.get("http://testapp.galenframework.com/");
		// Clicar o botao login na welcomepage
		WebElement Botao = driver.findElement(By.cssSelector("button"));
		Botao.click();

		// Realizar o login na pagina
		WebElement usuario = driver.findElement(By.name("login.username"));
		WebElement senha = driver.findElement(By.name("login.password"));
		WebElement Button = driver.findElement(By.cssSelector("button"));

		usuario.sendKeys("testuser@example.com");
		senha.sendKeys("test123");
		Button.click();

		Thread.sleep(1000);

		// Ainda na mynotes realizar o teste abaixo
		// Mover o cursor em cima do botao
		WebElement searchBtn = driver.findElement(By.cssSelector("button"));
		Actions action = new Actions(driver);
		action.moveToElement(searchBtn).perform();
		Thread.sleep(3000);

		// Create a layoutReport object
		// checkLayout function checks the layout and returns a LayoutReport object
		LayoutReport layoutReport = Galen.checkLayout(driver, "specs/eventTeste.gspec", Arrays.asList("desktop"));

		// Criando a lista com GalenTestInfo
		List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

		// Estanciando o objeto do GalenTestInfo
		GalenTestInfo test = GalenTestInfo.fromString("IEeventTeste layout");

		// Selecionando com get para check layout
		test.getReport().layout(layoutReport, "check IEeventTest layout");

		// Add test object to the tests list
		tests.add(test);

		// Estanciando o objeto do htmlReportBuilder
		HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

		// Criando reportbuild em target
		htmlReportBuilder.build(tests, "target");

		// If para validar se o layout retornar erros
		if (layoutReport.errors() > 0) {
			Assert.fail("Layout test failed");
		}

		Thread.sleep(3000);

	}

	// Para fechar o navegador
	@After
	public void IEtearDown() {
		driver.quit();
	}

	
	
	//**********************************************************************************************    
	//**********************************TESTE 1° FireFox********************************************
	//**********************************************************************************************    
		public void FFhomePageLayoutTest() throws Exception {

			driver.get("http://testapp.galenframework.com/");
			// Create a layoutReport object
			// checkLayout function checks the layout and returns a LayoutReport object
			LayoutReport layoutReport = Galen.checkLayout(driver, "specs/homepage.gspec", Arrays.asList("desktop"));

			// Criando a lista com GalenTestInfo
			List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

			// Estanciando o objeto do GalenTestInfo
			GalenTestInfo test = GalenTestInfo.fromString("FFhomepage layout");

			// Selecionando com get para check layout
			test.getReport().layout(layoutReport, "check FFhomepage layout");

			// Add test object to the tests list
			tests.add(test);

			// Estanciando o objeto do htmlReportBuilder
			HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

			// Criando reportbuild em target
			htmlReportBuilder.build(tests, "target");

			// If para validar se o layout retornar erros
			if (layoutReport.errors() > 0) {
				Assert.fail("Layout test failed");
			}
		}

	//**********************************************************************************************    
	//***********************************TESTE 2° FireFox********************************************
	//**********************************************************************************************      
		public void FFMyNotesLayoutTest() throws Exception, InterruptedException {

			driver.get("http://testapp.galenframework.com/");
			// Clicar o botao login na welcomepage
			WebElement Botao = driver.findElement(By.cssSelector("button"));
			Botao.click();

			// Realizar o login na pagina
			WebElement usuario = driver.findElement(By.name("login.username"));
			WebElement senha = driver.findElement(By.name("login.password"));
			WebElement Button = driver.findElement(By.cssSelector("button"));

			usuario.sendKeys("testuser@example.com");
			senha.sendKeys("test123");
			Button.click();

			Thread.sleep(1000);
			// Create a layoutReport object
			// checkLayout function checks the layout and returns a LayoutReport object
			LayoutReport layoutReport = Galen.checkLayout(driver, "specs/mynotes.gspec", Arrays.asList("desktop"));

			// Criando a lista com GalenTestInfo
			List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

			// Estanciando o objeto do GalenTestInfo
			GalenTestInfo test = GalenTestInfo.fromString("FFmynotes layout");

			// Selecionando com get para check layout
			test.getReport().layout(layoutReport, "check FFmynotes layout");

			// Add test object to the tests list
			tests.add(test);

			// Estanciando o objeto do htmlReportBuilder
			HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

			// Criando reportbuild em target
			htmlReportBuilder.build(tests, "target");

		}

	//**********************************************************************************************    
	//************************************TESTE 3° FireFox******************************************
	//**********************************************************************************************	
		public void FFEventTest() throws Exception, InterruptedException {

			driver.get("http://testapp.galenframework.com/");
			// Clicar o botao login na welcomepage
			WebElement Botao = driver.findElement(By.cssSelector("button"));
			Botao.click();

			// Realizar o login na pagina
			WebElement usuario = driver.findElement(By.name("login.username"));
			WebElement senha = driver.findElement(By.name("login.password"));
			WebElement Button = driver.findElement(By.cssSelector("button"));

			usuario.sendKeys("testuser@example.com");
			senha.sendKeys("test123");
			Button.click();

			Thread.sleep(1000);

			// Ainda na mynotes realizar o teste abaixo
			// Mover o cursor em cima do botao
			WebElement searchBtn = driver.findElement(By.cssSelector("button"));
			Actions action = new Actions(driver);
			action.moveToElement(searchBtn).perform();
			Thread.sleep(3000);

			// Create a layoutReport object
			// checkLayout function checks the layout and returns a LayoutReport object
			LayoutReport layoutReport = Galen.checkLayout(driver, "specs/eventTeste.gspec", Arrays.asList("desktop"));

			// Criando a lista com GalenTestInfo
			List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

			// Estanciando o objeto do GalenTestInfo
			GalenTestInfo test = GalenTestInfo.fromString("FFeventTeste layout");

			// Selecionando com get para check layout
			test.getReport().layout(layoutReport, "check FFeventTest layout");

			// Add test object to the tests list
			tests.add(test);

			// Estanciando o objeto do htmlReportBuilder
			HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

			// Criando reportbuild em target
			htmlReportBuilder.build(tests, "target");

			// If para validar se o layout retornar erros
			if (layoutReport.errors() > 0) {
				Assert.fail("Layout test failed");
			}

			Thread.sleep(3000);

		}

		// Para fechar o navegador
		@After
		public void FFtearDown() {
			driver.quit();
		}
		//**********************************************************************************************    
		//**********************************TESTE 1° Chrome*********************************************
		//**********************************************************************************************    
			public void CRhomePageLayoutTest() throws Exception {

				driver.get("http://testapp.galenframework.com/");
				// Create a layoutReport object
				// checkLayout function checks the layout and returns a LayoutReport object
				LayoutReport layoutReport = Galen.checkLayout(driver, "specs/homepage.gspec", Arrays.asList("desktop"));

				// Criando a lista com GalenTestInfo
				List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

				// Estanciando o objeto do GalenTestInfo
				GalenTestInfo test = GalenTestInfo.fromString("CRhomepage layout");

				// Selecionando com get para check layout
				test.getReport().layout(layoutReport, "check CRhomepage layout");

				// Add test object to the tests list
				tests.add(test);

				// Estanciando o objeto do htmlReportBuilder
				HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

				// Criando reportbuild em target
				htmlReportBuilder.build(tests, "target");

				// If para validar se o layout retornar erros
				if (layoutReport.errors() > 0) {
					Assert.fail("Layout test failed");
				}
			}
		//**********************************************************************************************    
		//***********************************TESTE 2° Chrome********************************************
		//**********************************************************************************************      
			public void CRMyNotesLayoutTest() throws Exception, InterruptedException {

				driver.get("http://testapp.galenframework.com/");
				// Clicar o botao login na welcomepage
				WebElement Botao = driver.findElement(By.cssSelector("button"));
				Botao.click();

				// Realizar o login na pagina
				WebElement usuario = driver.findElement(By.name("login.username"));
				WebElement senha = driver.findElement(By.name("login.password"));
				WebElement Button = driver.findElement(By.cssSelector("button"));

				usuario.sendKeys("testuser@example.com");
				senha.sendKeys("test123");
				Button.click();

				Thread.sleep(1000);
				// Create a layoutReport object
				// checkLayout function checks the layout and returns a LayoutReport object
				LayoutReport layoutReport = Galen.checkLayout(driver, "specs/mynotes.gspec", Arrays.asList("desktop"));

				// Criando a lista com GalenTestInfo
				List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

				// Estanciando o objeto do GalenTestInfo
				GalenTestInfo test = GalenTestInfo.fromString("CRmynotes layout");

				// Selecionando com get para check layout
				test.getReport().layout(layoutReport, "check CRmynotes layout");

				// Add test object to the tests list
				tests.add(test);

				// Estanciando o objeto do htmlReportBuilder
				HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

				// Criando reportbuild em target
				htmlReportBuilder.build(tests, "target");

			}
		//**********************************************************************************************    
		//************************************TESTE 3° Chrome*******************************************
		//**********************************************************************************************	
			public void CREventTest() throws Exception, InterruptedException {

				driver.get("http://testapp.galenframework.com/");
				// Clicar o botao login na welcomepage
				WebElement Botao = driver.findElement(By.cssSelector("button"));
				Botao.click();

				// Realizar o login na pagina
				WebElement usuario = driver.findElement(By.name("login.username"));
				WebElement senha = driver.findElement(By.name("login.password"));
				WebElement Button = driver.findElement(By.cssSelector("button"));

				usuario.sendKeys("testuser@example.com");
				senha.sendKeys("test123");
				Button.click();

				Thread.sleep(1000);

				// Ainda na mynotes realizar o teste abaixo
				// Mover o cursor em cima do botao
				WebElement searchBtn = driver.findElement(By.cssSelector("button"));
				Actions action = new Actions(driver);
				action.moveToElement(searchBtn).perform();
				Thread.sleep(3000);

				// Create a layoutReport object
				// checkLayout function checks the layout and returns a LayoutReport object
				LayoutReport layoutReport = Galen.checkLayout(driver, "specs/eventTeste.gspec", Arrays.asList("desktop"));

				// Criando a lista com GalenTestInfo
				List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

				// Estanciando o objeto do GalenTestInfo
				GalenTestInfo test = GalenTestInfo.fromString("CReventTeste layout");

				// Selecionando com get para check layout
				test.getReport().layout(layoutReport, "check CReventTest layout");

				// Add test object to the tests list
				tests.add(test);

				// Estanciando o objeto do htmlReportBuilder
				HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

				// Criando reportbuild em target
				htmlReportBuilder.build(tests, "target");

				// If para validar se o layout retornar erros
				if (layoutReport.errors() > 0) {
					Assert.fail("Layout test failed");
				}

				Thread.sleep(3000);

			}

			// Para fechar o navegador
			@After
			public void CRtearDown() {
				driver.quit();
			}


}
