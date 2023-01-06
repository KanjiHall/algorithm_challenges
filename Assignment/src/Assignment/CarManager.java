/*
 *  To change this license header, choose License Headers in Project Properties.
 *  To change this template file, choose Tools | Templates
 *  and open the template in the editor.
 */
package Assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *
 * @author Asus
 */
public class CarManager extends ArrayList<Car> {

    private BrandManager brandList;

    public CarManager() {
        super();
    }

    public CarManager(BrandManager bList) {
        brandList = bList;
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
                StringTokenizer stk = new StringTokenizer(details, ",");
                String carId = stk.nextToken().toUpperCase().trim();
                String brandId = stk.nextToken().toUpperCase().trim();
                String color = stk.nextToken().toLowerCase().trim();
                String frameId = stk.nextToken().toUpperCase().trim();
                String engineId = stk.nextToken().toUpperCase().trim();
                int position = brandList.searchId(brandId);
                Brand brand = brandList.get(position);
                this.add(new Car(carId, brand, color, frameId, engineId));               
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
                return false;
            }
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Car car : this) {
                pw.println(car.getCarId() + ", " + car.getBrand().getBrandId() + ", " + car.getColor() + ", " + car.getFrameId() + ", " + car.getEngineId());
            }
            pw.close();
            fw.close();
            System.out.println("Saved successfully to file Cars.txt.");
            return true;
        } catch (Exception e) {
            System.out.println("Error!");
        }
        return false;
    }

    public int searchId(String carId) {
        if (this.size() == 0) {
            System.out.println("Empty List.");
            return -1;
        }
        for (Car car : this) {
            if (car.getCarId().equalsIgnoreCase(carId)) {
                return indexOf(car);
            }
        }
        return -1;
    }

    public int searchFrame(String frameId) {
        if (this.size() == 0) {
            System.out.println("Empty List.");
            return -1;
        }
        for (Car car : this) {
            if (car.getFrameId().equalsIgnoreCase(frameId)) {
                return indexOf(car);
            }
        }
        return -1;
    }

    public int searchEngine(String engineId) {
        if (this.size() == 0) {
            System.out.println("Empty List.");
            return -1;
        }
        for (Car car : this) {
            if (car.getEngineId().equalsIgnoreCase(engineId)) {
                return indexOf(car);
            }
        }
        return -1;
    }

    public void addCar() {
        String carId;
        Brand brand;
        String color;
        String frameId;
        String engineId;
        int duplicated;
        System.out.println("Enter new car's details: ");
        do {
            System.out.print("  Car's ID: ");
            carId = Menu.sc.nextLine().toUpperCase().replace(" ", "");
            duplicated = searchId(carId);
            if (duplicated != -1) {
                System.out.println("Input Car's ID existed in the list. Enter again.");
            }
        } while (duplicated != -1);
        Menu menu = new Menu();
        brand = (Brand) menu.ref_getChoice(brandList);
        do {
            System.out.print("  Car's Color: ");
            color = Menu.sc.nextLine().toLowerCase().replace(" ", "");
            if (color.length() == 0) {
                System.out.println("The Car's Color can't blank.");
            }
        } while (color.length() == 0);
        do {
            System.out.print("  Car's Frame ID: ");
            frameId = Menu.sc.nextLine().toUpperCase().replace(" ", "");
            duplicated = searchFrame(frameId);
            if (duplicated != -1) {
                System.out.println("Input Car's Frame ID existed in the list. Enter again.");
            }
            if (!frameId.matches("^F[\\d]{5}")) {
                System.out.println("Input Car's Frame ID doesn't match F00000.");
            }
        } while (duplicated != -1 || !frameId.matches("^F[\\d]{5}"));
        do {
            System.out.print("  Car's Engine ID: ");
            engineId = Menu.sc.nextLine().toUpperCase().replace(" ", "");
            duplicated = searchEngine(engineId);
            if (duplicated != -1) {
                System.out.println("Input Car's Engine ID existed in the list. Enter again.");
            }
            if (!engineId.matches("^E[\\d]{5}")) {
                System.out.println("Input Car's Engine ID doesn't match E00000.");
            }
        } while (duplicated != -1 || !engineId.matches("^E[\\d]{5}"));
        this.add(new Car(carId, brand, color, frameId, engineId));
        System.out.println("The car " + carId + " has been added.");
    }

    public void printBasedBrandName() {
        System.out.print("Enter Brand's Name: ");
        String aPartOfBrandName = Menu.sc.nextLine().toLowerCase().trim();
        int count = 0;
        for (Car car : this) {
            if (car.getBrand().getBrandName().toLowerCase().contains(aPartOfBrandName)) {
                System.out.println(car.screenString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Can't search car!");
        }
    }

    public boolean removeCar() {
        System.out.print("Enter Car's ID: ");
        String carId = Menu.sc.nextLine().toUpperCase().replace(" ", "");
        int position = searchId(carId);
        if (position == -1) {
            System.out.println("Not found car " + carId + ".");
            return false;
        } else {
            remove(position);
            System.out.println("The car " + carId + " has been removed.");
        }
        return true;
    }

    public boolean updateCar() {
        System.out.print("Enter Car's ID: ");
        String carId = Menu.sc.nextLine().toUpperCase().replace(" ", "");
        int position = searchId(carId);
        if (position == -1) {
            System.out.println("Not found car " + carId + ".");
            return false;
        } else {
            Brand brand;
            String color;
            String frameId;
            String engineId;
            int duplicated;
            Menu menu = new Menu();
            brand = (Brand) menu.ref_getChoice(brandList);
            do {
                System.out.print("  Car's Color: ");
                color = Menu.sc.nextLine().toLowerCase().replace(" ", "");
                if (color.length() == 0) {
                    System.out.println("The Car's Color can't blank.");
                }
            } while (color.length() == 0);
            do {
                System.out.print("  Car's Frame ID: ");
                frameId = Menu.sc.nextLine().toUpperCase().replace(" ", "");
                duplicated = searchFrame(frameId);
                if (duplicated != -1) {
                    System.out.println("Input Car's Frame ID existed in the list. Enter again.");
                }
                if (!frameId.matches("^F[\\d]{5}")) {
                    System.out.println("Input Car's Frame ID doesn't match F00000.");
                }
            } while (duplicated != -1 || !frameId.matches("^F[\\d]{5}"));
            do {
                System.out.print("  Car's Engine ID: ");
                engineId = Menu.sc.nextLine().toUpperCase().replace(" ", "");
                duplicated = searchEngine(engineId);
                if (duplicated != -1) {
                    System.out.println("Input Car's Engine ID existed in the list. Enter again.");
                }
                if (!engineId.matches("^E[\\d]{5}")) {
                    System.out.println("Input Car's Engine ID doesn't match E00000.");
                }
            } while (duplicated != -1 || !engineId.matches("^E[\\d]{5}"));
            this.get(position).setBrand(brand);
            this.get(position).setColor(color);
            this.get(position).setFrameId(frameId);
            this.get(position).setEngineId(engineId);
            System.out.println("The car " + carId + " has been updated.");
        }
        return true;
    }

    public void listCars() {
        ArrayList<Car> list = new ArrayList<>();
        for (Car car : this) {
            list.add(car);
        }
        Collections.sort(list);
        for (Car car : list) {
            System.out.println(car.screenString());
        }
    }

}
