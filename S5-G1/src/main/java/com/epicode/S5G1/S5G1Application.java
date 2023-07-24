package com.epicode.S5G1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epicode.configBeans.Bevanda;
import com.epicode.configBeans.ConfigurationMenu;
import com.epicode.configBeans.Franchise;
import com.epicode.configBeans.Pizza;
import com.epicode.configBeans.Topping;

@SpringBootApplication
public class S5G1Application {

	public static void main(String[] args) {
		SpringApplication.run(S5G1Application.class, args);
		
		Menu();
	}
	
	public static void Menu() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationMenu.class);
		
		Pizza p1 = (Pizza) appContext.getBean("pizza", "Margherita", 500, 6.50);
		System.out.println(p1);
		
		Bevanda b1 = (Bevanda) appContext.getBean("bevanda", "CocaCola", 100, 1.50);
		System.out.println(b1);
		
		Topping t1 = (Topping) appContext.getBean("topping", "Ananas", 1.0);
		System.out.println(t1);
		
		Franchise f1 = (Franchise) appContext.getBean("franchise", "Maglietta", 25.0);
		System.out.println(f1);
		
		appContext.close();
	}

}
