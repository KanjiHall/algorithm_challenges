/*
 *  To change this license header, choose License Headers in Project Properties.
 *  To change this template file, choose Tools | Templates
 *  and open the template in the editor.
 */
package Assignment;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class Menu {

    public static Scanner sc = new Scanner(System.in);

    public int int_getChoice(ArrayList options) {
        int response;
        for (int i = 0; i < options.size(); i++) {
            System.out.println("" + (i + 1) + "-" + options.get(i));
        }
        System.out.print("Please choose an option 1 -> " + options.size() + ": ");
        response = checkInputInt(options, 1, options.size());
        return response;
    }

    public Object ref_getChoice(ArrayList options) {
        int reponse;
        do {
            reponse = int_getChoice(options);
        } while (reponse < 0 || reponse > options.size());
        return options.get(reponse - 1);
    }

    public int checkInputInt(ArrayList options, int min, int max) {
        int result = -1;
        do {
            result = Integer.parseInt(sc.nextLine());
            if (result < min || result > max) {
                System.out.print("Invalid choice. Enter again: ");
            }
        } while (result < min || result > max);
        return result;
    }

}
