package app;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("------------WELCOME TO TRIVIA----------\n");
        Player player = new Player();
        player.Register(player);
    }
}