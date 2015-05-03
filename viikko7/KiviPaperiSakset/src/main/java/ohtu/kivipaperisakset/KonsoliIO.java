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
public class KonsoliIO implements IO {

    private static final Scanner scanner = new Scanner(System.in);
    
    @Override
    public void print(String teksti) {
        System.out.println(teksti);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }
    
}
