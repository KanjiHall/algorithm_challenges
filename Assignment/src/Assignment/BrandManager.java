/*
 *  To change this license header, choose License Headers in Project Properties.
 *  To change this template file, choose Tools | Templates
 *  and open the template in the editor.
 */
package Assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Asus
 */
public class BrandManager extends ArrayList<Brand> {
    
    public BrandManager() {
        super();
    }
    
    public boolean loadFromFile(String fName) {
        if (this.size() > 0) {
            this.clear();
        }
        try {
            File f = new File(fName);
            if (!f.exists()) {
                System.out.println(fName + " doesn't exist.");
                return false;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",:");
                String brandId = stk.nextToken().toUpperCase().trim();
                String brandName = stk.nextToken().trim();
                String soundBrand = stk.nextToken().trim();
                double price = Double.parseDouble(stk.nextToken());
                this.add(new Brand(brandId, brandName, soundBrand, price));
            }
            bf.close();
            fr.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error!");
        }
        return false;
    }
    
    public boolean saveToFile(String fName) {
        if (this.size() == 0) {
            System.out.println("Empty List.");
            return false;
        }
        try {
            File f = new File(fName);
            if (!f.exists()) {
                System.out.println(fName + " doesn't exist.");
            }
            FileWriter fr = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fr);
            for (Brand brand : this) {
                pw.println(brand.getBrandId() + ", " + brand.getBrandName() + ", " + brand.getSoundBrand() + ": " + brand.getPrice());
            }
            pw.close();
            fr.close();
            System.out.println("Saved successfully to file Brands.txt.");
            return true;
        } catch (Exception e) {
            System.out.println("Error!");
        }
        return false;
    }
    
    public int searchId(String brandId) {
        if (this.size() == 0) {
            System.out.println("Empty List!");
            return -1;
        }
        for (Brand brand : this) {
            if (brand.getBrandId().equalsIgnoreCase(brandId)) {
                return indexOf(brand);
            }
        }
        return -1;
    }
    
    public Brand getUserChoice() {
        Menu menu = new Menu();
        return (Brand) menu.ref_getChoice(this);
    }
    
    public void addBrand() {
        String brandId;
        String brandName;
        String soundBrand;
        double price = 0;
        int duplicated;
        System.out.println("Enter new brand' details: ");
        do {
            duplicated = 0;
            System.out.print("  Brand's ID: ");
            brandId = Menu.sc.nextLine().toUpperCase().replace(" ", "");
            duplicated = searchId(brandId);
            if (duplicated != -1) {
                System.out.println("Input Brand's ID existed in the list. Enter again.");
            }
        } while (duplicated != -1);
        do {
            System.out.print("  Brand's Name: ");
            brandName = Menu.sc.nextLine().trim();
            if (brandName.length() == 0) {
                System.out.println("The Brand's Name can't blank.");
            }
        } while (brandName.length() == 0);
        do {
            System.out.print("  Sound Brand: ");
            soundBrand = Menu.sc.nextLine().trim();
            if (soundBrand.length() == 0) {
                System.out.println("The Sound Brand can't blank.");
            }
        } while (soundBrand.length() == 0);
        do {
            try {
                System.out.print("  Price(non-negative real number): ");
                price = Double.parseDouble(Menu.sc.nextLine());
                if (price <= 0) {
                    System.out.println("Invalid Price!");
                }
            } catch (Exception e) {
                System.out.println("Invalid Price!");
            }
        } while (price <= 0);
        this.add(new Brand(brandId, brandName, soundBrand, price));
        System.out.println("The brand " + brandId + " has been added.");
    }
    
    public void updateBrand() {
        String brandId;
        String brandName;
        String soundBrand;
        double price = 0;
        int position = -1;
        do {
            System.out.print("Enter Brand's ID: ");
            brandId = Menu.sc.nextLine().toUpperCase().replace(" ", "");
            position = searchId(brandId);
            if (position == -1) {
                System.out.println("Not found brand " + brandId + ".");
            }
        } while (position == -1);
        System.out.println("Enter details of updated brand " + brandId + ": ");
        do {
            System.out.print("  Brand's Name: ");
            brandName = Menu.sc.nextLine().trim();
            if (brandName.length() == 0) {
                System.out.println("The Brand's Name can't blank.");
            }
        } while (brandName.length() == 0);
        do {
            System.out.print("  Sound Brand: ");
            soundBrand = Menu.sc.nextLine().trim();
            if (soundBrand.length() == 0) {
                System.out.println("The Sound Brand can't blank.");
            }
        } while (soundBrand.length() == 0);
        do {
            try {
                System.out.print("  Price(non-negative real number): ");
                price = Double.parseDouble(Menu.sc.nextLine());
                if (price <= 0) {
                    System.out.println("Invalid Price!");
                }
            } catch (Exception e) {
                System.out.println("Invalid Price!");
            }
        } while (price <= 0);
        this.get(position).setBrandName(brandName);
        this.get(position).setSoundBrand(soundBrand);
        this.get(position).setPrice(price);
        System.out.println("The brand " + brandId + " has been updated.");
    }
    
    public void listBrands() {
        for (Brand brand : this) {
            System.out.println(brand);
        }
    }
    
}
