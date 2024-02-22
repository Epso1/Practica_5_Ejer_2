package com.example.practica_5_ejer_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        URLCollector collector = new URLCollector();
        Downloader downloader = new Downloader();

        collector.addObserver(downloader);

        Scanner scanner = new Scanner(System.in);
        System.out.println("***** Recolector de URLs *****");
        System.out.println("Introduce '0' para salir del programa.");

        boolean exit = false;

        while (!exit) {
            System.out.println("Introduce la web (por ejemplo https://www.myweb.com): ");
            String url = scanner.nextLine();
            if (url.equals("0")) {
                System.out.println("Saliendo del programa...");
                exit = true;
            } else {
                collector.addURL(url);
            }
        }
    }
}