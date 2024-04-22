package zh.qa.amazon.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalndarHandle {
static WebDriver driver;

	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
//		select a date from the current month
		driver.findElement(By.id("datepicker")).click();
//		selectFutureDate("January 2025","21");
		selectPastDate("January 2023", 0);
		
	}
	public String currentMonthYear() {
	LocalDate currentDate=LocalDate.now();
	System.out.println(currentDate);
	String month=currentDate.format(DateTimeFormatter.ofPattern("MMMM"));
	String year=currentDate.format(DateTimeFormatter.ofPattern("YYYY"));
	String monthYear= month+" "+year;
	System.out.println(monthYear);
	return monthYear;
	}
	
	public static void selectFutureDate(String monthYear, int day) {
		if (day>31 || day<1) {
			System.out.println("The date passed is wrong... please pass the right date..passed date::"+day);
			return;
		}
		String actMonth = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
		while (!actMonth.equalsIgnoreCase(monthYear)) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actMonth = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
		}
		selectDate(day);
	}
	public static void selectPastDate(String monthYear, int day) {
		if (day>31 || day<1) {
			System.out.println("The date passed is wrong... please pass the right date..passed date::"+day);
			return;
		}
		String actMonth = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
		while (!actMonth.equalsIgnoreCase(monthYear)) {
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
			actMonth = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
		}
		selectDate(day);
	}
 public static void selectDate(int date) {
	 driver.findElement(By.xpath("//a[text()='"+date+"']")).click();
 }
}
