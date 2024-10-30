package oop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get Customer Name
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();

        // Get Customer Location
        System.out.print("Enter your location: ");
        String customerLocation = scanner.nextLine();

        // Get Customer Phone Number with Validation
        String customerPhone;
        while (true) {
            System.out.print("Enter your phone number (11 digits): ");
            customerPhone = scanner.next();

            // Validate if the phone number is numeric and exactly 11 digits
            if (customerPhone.matches("\\d{11}")) {
                break;  // Valid input, exit the loop
            } else {
                System.out.println("⚠️ Warning: Invalid phone number. Please enter exactly 11 digits.");
            }
        }

        // Create a new Order
        Order order = new Order();

        // Main Menu Loop
        while (true) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Burger");
            System.out.println("2. Fries");
            System.out.println("3. Drinks");
            System.out.println("0. Complete Order and Print Receipt");

            System.out.print("Select a category: ");
            int mainChoice = scanner.nextInt();

            if (mainChoice == 0) {
                break;  // Exit the loop to complete the order
            }

            switch (mainChoice) {
                case 1:
                    // Burger Menu
                    while (true) {
                        System.out.println("\n--- Burger Menu ---");
                        System.out.println("1. Regular Burger  - ₱25.00");
                        System.out.println("2. Egg Sandwich - ₱20.00");
                        System.out.println("3. Burger with Egg - ₱35.00");
                        System.out.println("4. Burger with Cheese - ₱30.00");
                        System.out.println("5. Burger with Egg & Cheese - ₱45.00");
                        System.out.println("6. Back");

                        System.out.print("Choose Number: ");
                        int burgerChoice = scanner.nextInt();
                        if (burgerChoice == 6) {
                            break;  // Go back to main menu
                        }

                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();

                        switch (burgerChoice) {
                            case 1 -> order.addItem(new Burger("Regular Burger", 25.00), quantity);
                            case 2 -> order.addItem(new Burger("Egg Sandwich", 20.00), quantity);
                            case 3 -> order.addItem(new Burger("Burger with Egg", 35.00), quantity);
                            case 4 -> order.addItem(new Burger("Burger with Cheese", 30.00), quantity);
                            case 5 -> order.addItem(new Burger("Burger with Egg & Cheese", 45.00), quantity);
                            default -> System.out.println("Invalid burger choice.");
                        }
                    }
                    break;

                case 2:
                    // Fries Menu
                    System.out.println("\n--- Fries Menu ---");
                    System.out.println("1. Small CheeseFries - ₱25.00");
                    System.out.println("2. Medium CheeseFries - ₱35.00");
                    System.out.println("3. Large CheeseFries - ₱45.00");
                    System.out.println("4. Back");

                    System.out.print("Choose Fries: ");
                    int friesChoice = scanner.nextInt();
                    if (friesChoice == 4) {
                        continue;
                    }

                    System.out.print("Enter quantity: ");
                    int friesQuantity = scanner.nextInt();

                    switch (friesChoice) {
                        case 1 -> order.addItem(new Fries("Small CheeseFries", 25.00), friesQuantity);
                        case 2 -> order.addItem(new Fries("Medium CheeseFries", 35.00), friesQuantity);
                        case 3 -> order.addItem(new Fries("Large CheeseFries", 45.00), friesQuantity);
                        default -> System.out.println("Invalid fries choice.");
                    }
                    break;

                case 3:
                    // Drinks Menu
                    System.out.println("\n--- Drinks Menu ---");
                    System.out.println("1. BlueLemonade - ₱20.00");
                    System.out.println("2. RedIceTea - ₱20.00");
                    System.out.println("3. PineApple - ₱20.00");
                    System.out.println("4. Back");

                    System.out.print("Choose a drink: ");
                    int drinkChoice = scanner.nextInt();
                    if (drinkChoice == 4) {
                        continue;
                    }

                    System.out.print("Enter quantity: ");
                    int drinkQuantity = scanner.nextInt();

                    switch (drinkChoice) {
                        case 1 -> order.addItem(new Drink("BlueLemonade", 20.00), drinkQuantity);
                        case 2 -> order.addItem(new Drink("RedIceTea", 20.00), drinkQuantity);
                        case 3 -> order.addItem(new Drink("PineApple", 20.00), drinkQuantity);
                        default -> System.out.println("Invalid drink choice.");
                    }
                    break;

                default:
                    System.out.println("Invalid category choice.");
            }
        }

        // Print Receipt
        Receipt receipt = new Receipt(customerName, customerLocation, customerPhone, order);
        receipt.printReceipt();

        scanner.close();  // Close the scanner to prevent resource leaks
    }
}
 