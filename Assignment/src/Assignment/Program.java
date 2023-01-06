/*
 *  To change this license header, choose License Headers in Project Properties.
 *  To change this template file, choose Tools | Templates
 *  and open the template in the editor.
 */
package Assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> options = new ArrayList<>();
        options.add("List all brands");
        options.add("Add a new brand");
        options.add("Search a brand based on its ID");
        options.add("Update a brand");
        options.add("Save brands to the file (Brands.txt)");
        options.add("List all cars in ascending order of brand names");
        options.add("List cars based on a part of an input brand name");
        options.add("Add a car");
        options.add("Remove a car based on its ID");
        options.add("Update a car based on its ID");
        options.add("Save cars to file (Cars.txt)");
        options.add("Quit");
        BrandManager brandList = new BrandManager();
        brandList.loadFromFile("Brands.txt");
        CarManager carList = new CarManager(brandList);
        carList.loadFromFile("Cars.txt");        
        int choice;
        Menu menu = new Menu();
        boolean isValid = true;
        do {
            System.out.println();
            choice = menu.int_getChoice(options);
            System.out.println("==================================================");
            switch (choice) {
                case 1:
                    brandList.listBrands();
                    break;
                case 2:
                    brandList.addBrand();
                    break;
                case 3:
                    System.out.print("Enter Brand's ID: ");
                    String brandId = Menu.sc.nextLine().toUpperCase().replace(" ", "");
                    int count = 0;
                    for (Brand brand : brandList) {
                        if (brand.getBrandId().equalsIgnoreCase(brandId)) {
                            System.out.println(brand);
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.println("Not found brand " + brandId);
                    }
                    break;
                case 4:
                    brandList.updateBrand();
                    break;
                case 5:
                    brandList.saveToFile("Brands.txt");
                    break;
                case 6:
                    carList.listCars();
                    break;
                case 7:
                    carList.printBasedBrandName();
                    break;
                case 8:
                    carList.addCar();
                    break;
                case 9:
                    carList.removeCar();
                    break;
                case 10:
                    carList.updateCar();
                    break;
                case 11:
                    carList.saveToFile("Cars.txt");
                    break;
                case 12:  
                    System.out.println("End Program!");
                    isValid = false;
                    break;
                default:
                    System.out.println("Invalid choice. Enter again!");
            }
        System.out.println("==================================================");   
        } while (isValid);
        System.out.println("\nBye now!");
    }

}
