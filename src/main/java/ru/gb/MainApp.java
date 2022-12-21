package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.Services.ServiceClientProduct;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.gb");
        ServiceClientProduct serviceClientProduct = context.getBean(ServiceClientProduct.class);
        SessionFactoryUtils sessionFactoryUtils = context.getBean(SessionFactoryUtils.class) ;
        sessionFactoryUtils.init();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter client's id for show list of products:");
            int id_client = scanner.nextInt();
            System.out.println(serviceClientProduct.purchasedProducts(id_client).toString());
            System.out.println();
            System.out.println("Enter product's id for show list of clients:");
            int id_product = scanner.nextInt();
            System.out.println(serviceClientProduct.clientsBoughtProduct(id_product).toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            sessionFactoryUtils.shutdown();
        }
    }
}