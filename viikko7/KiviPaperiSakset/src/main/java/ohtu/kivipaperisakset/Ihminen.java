/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author iivo
 */
public class Ihminen implements Vastustaja {

    private static final Scanner scanner = new Scanner(System.in);
    
    @Override
    public String annaSiirto() {
        return scanner.nextLine();
    }

    @Override
    public void asetaSiirto(String siirto) {
        // ei tehdä mitään 
    }
    
}
