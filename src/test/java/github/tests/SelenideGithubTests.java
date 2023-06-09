package github.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SelenideGithubTests {
	@BeforeAll
	public static void beforeAll() {
		Configuration.baseUrl = "https://github.com/";
		Configuration.pageLoadStrategy = "eager";
	}

	@Test
	public void selenideTest() {
		Selenide.open("/selenide/selenide");
		$("#wiki-tab").shouldBe(visible).click();
		$("#wiki-body").shouldHave(text("Soft assertions"));
		$("#wiki-body").$(byText("Soft assertions")).click();
		$("#wiki-body").$(byText("3. Using JUnit5 extend test class:")).sibling(0).shouldHave(exactText("@ExtendWith({SoftAssertsExtension.class})\n" +
				"class Tests { " +
				"  @Test " +
				"  void test() { " +
				"    Configuration.assertionMode = SOFT; " +
				"    open(\"page.html\"); " +
				" " +
				"    $(\"#first\").should(visible).click(); " +
				"    $(\"#second\").should(visible).click(); " +
				"  } " +
				"}"));
	}

}
