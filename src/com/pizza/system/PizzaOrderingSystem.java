package com.pizza.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Singleton class for the Pizza Ordering System
public class PizzaOrderingSystem {

    // List to hold orders
    private List<Order> orders = new ArrayList<>();

    // Singleton instance
    private static PizzaOrderingSystem instance;

    private PizzaOrderingSystem() {
    }

    public static PizzaOrderingSystem getInstance() {
        if (instance == null) {
            instance = new PizzaOrderingSystem();
        }
        return instance;
    }

    // Main function to interact with the system
    public static void main(String[] args) {
        PizzaOrderingSystem system = PizzaOrderingSystem.getInstance();
        system.start();
    }

    // Starts the application and handles user interaction
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // ANSI escape codes for bold and colored text
            String bold = "\033[1m"; // Bold
            String reset = "\033[0m"; // Reset to normal text

            String blue = "\033[34m"; // Red text
            String green = "\033[32m"; // Yellow text
            String yellow = "\033[33m"; // Yellow text
            String Cyan = "\033[36m"; // Cyan text

            System.out.println(bold + Cyan
                    + "\n*********************************************************************************************************************************************"
                    + reset);
            System.out.println(bold + yellow
                    + "\n================================================ Welcome to the Pizza Ordering System ======================================================="
                    + reset);
            System.out.println(bold + Cyan
                    + "\n*********************************************************************************************************************************************"
                    + reset);
            System.out.println();
            System.out.println(blue + "1. Create Your Order " + reset);
            System.out.println(blue + "2. View Your Profile " + reset);
            System.out.println(blue + "3. View Your Orders " + reset);
            System.out.println(green + "4. Exit " + reset);
            System.out.println();
            System.out.print("Your choice (please enter the number, for an example = '1'): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    placeOrder(scanner);
                    break;
                case 2:
                    viewProfile();
                    break;
                case 3:
                    viewOrders();
                    break;
                case 4:
                    System.out.println("Thank you for using the Pizza Ordering System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    // Function to place an order
    private void placeOrder(Scanner scanner) {

        String bold = "\033[1m"; // Bold
        String reset = "\033[0m"; // Reset to normal text

        String blue = "\033[34m"; // Red text
        String green = "\033[32m"; // Yellow text
        String yellow = "\033[33m"; // Yellow text
        String magenta = "\033[35m"; // Magenta text
        String Cyan = "\033[36m"; // Cyan text
        String red = "\033[31m"; // red text

        // Order options
        System.out.println(bold
                + magenta
                + "\n---------------------------------------------------------------------------------------------------------------------------------------------"
                + reset);
        System.out.println(bold
                + Cyan
                + "\n======================================================== Create Your Order =================================================================="
                + reset);
        System.out.println(bold
                + magenta
                + "\n---------------------------------------------------------------------------------------------------------------------------------------------"
                + reset);
        System.out.println();
        System.out.println("Is this order for:");
        System.out.println();
        System.out.println(blue + "1. Delivery " + reset);
        System.out.println(blue + "2. Take Away " + reset);
        System.out.println();
        System.out.print("Your choice: ");
        int orderType = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Start customizing pizza
        System.out.println(bold
                + red
                + "\n---------------------------------------------------------------------------------------------------------------------------------------------"
                + reset);
        System.out.println(bold
                + magenta
                + "\n============================================================= Customize Your Pizza ==========================================================="
                + reset);
        System.out.println(bold
                + red
                + "\n----------------------------------------------------------------------------------------------------------------------------------------------"
                + reset);
        System.out.println();
        System.out.println("Choose crust:");
        System.out.println();
        System.out.println(blue + "1. THIN" + reset);
        System.out.println(blue + "2. THICK" + reset);
        System.out.println(blue + "3. STUFFED" + reset);
        System.out.println();
        System.out.print("Your choice: ");
        System.out.println();
        int crustChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println();
        System.out.println(bold + "Choose sauce:" + reset);
        System.out.println();
        System.out.println(green + "1. TOMATO " + reset);
        System.out.println(green + "2. CHILI " + reset);
        System.out.println(green + "3. GARLIC " + reset);
        System.out.println();
        System.out.print("Your choice: " + reset);
        int sauceChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println();
        System.out.println(bold + "Choose toppings (type numbers separated by commas):" + reset);
        System.out.println();
        System.out.println(green + "1. BACON  (LKR 70.0)" + reset);
        System.out.println(green + "2. MUSHROOMS  (LKR 50.0)" + reset);
        System.out.println(green + "3. SAUSAGE  (LKR 30.0)" + reset);
        System.out.println(green + "4. EXTRA_CHEESE  (LKR 100.0)" + reset);
        System.out.println(green + "5. CHICKEN  (LKR 60.0)" + reset);
        System.out.println();
        System.out.print("Your choice: ");
        String toppingsInput = scanner.nextLine();

        // Parse toppings
        String[] toppingChoices = toppingsInput.split(",");
        double toppingsPrice = 0.0;
        StringBuilder toppings = new StringBuilder();
        for (String topping : toppingChoices) {
            switch (topping.trim()) {
                case "1":
                    toppings.append("BACON , ");
                    toppingsPrice += 70;
                    break;
                case "2":
                    toppings.append("MUSHROOMS , ");
                    toppingsPrice += 50;
                    break;
                case "3":
                    toppings.append("SAUSAGE , ");
                    toppingsPrice += 30;
                    break;
                case "4":
                    toppings.append("EXTRA_CHEESE , ");
                    toppingsPrice += 100;
                    break;
                case "5":
                    toppings.append("CHICKEN , ");
                    toppingsPrice += 60;
                    break;
                default:
                    System.out.println("Invalid topping option: " + topping.trim());
            }
        }

        if (toppings.length() > 0) {
            toppings.setLength(toppings.length() - 2); // remove last comma
        }

        // Create pizza using Builder pattern
        Pizza pizza = new PizzaBuilder()
                .setCrust(crustChoice == 1 ? "THIN" : crustChoice == 2 ? "THICK" : "STUFFED")
                .setSauce(sauceChoice == 1 ? " TOMATO " : sauceChoice == 2 ? "CHILI" : "GARLIC ")
                .setToppings(toppings.toString())
                .build();

        double pizzaPrice = pizza.getPrice() + toppingsPrice;
        double discount = 0.05 * pizzaPrice;
        double finalPrice = pizzaPrice - discount;

        System.out.println("Your Pizza: " + pizza);
        System.out.println("Toppings: " + toppings);
        System.out.println("Seasonal Discount Applied! Final Price (before extras): LKR " + finalPrice);

        // Add extra options

        System.out.print(yellow + "\nWould you like to add Extra Cheese for LKR 100.0? (yes/no): " + reset);
        String extraCheeseResponse = scanner.nextLine();
        if ("yes".equalsIgnoreCase(extraCheeseResponse)) {
            pizza = new ExtraCheeseDecorator(pizza);
            finalPrice += 100.0;
        }

        System.out.print(yellow + "Would you like Special Packaging for LKR 150.0? (yes/no): " + reset);
        String packagingResponse = scanner.nextLine();
        if ("yes".equalsIgnoreCase(packagingResponse)) {
            pizza = new SpecialPackagingDecorator(pizza);
            finalPrice += 150.0;
        }

        System.out.println("\n--- Final Total Price: LKR " + finalPrice + " ---");

        // Payment method selection using Strategy Pattern
        System.out.println("\nChoose payment method:");
        System.out.println(green + "1. Credit Card " + reset);
        System.out.println(green + "2. Digital Wallet " + reset);
        System.out.print("Your choice: ");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Payment payment = new Payment();
        PaymentStrategy paymentStrategy = PaymentFactory.getPaymentStrategy(paymentChoice);
        payment.setPaymentStrategy(paymentStrategy);
        payment.processPayment(finalPrice);

        // Feedback rate and loyalty points
        System.out.print(green + "Rate your experience (1-5): " + reset);
        int rating = scanner.nextInt();
        int loyaltyPoints = (int) (finalPrice * 0.1);
        loyaltyPoints += rating; // Add rating points to loyalty

        // Displaying the rating with stars
        System.out.print(green + "Your rating: " + reset);
        for (int i = 0; i < rating; i++) {
            System.out.print(bold + green + "" + reset);
        }
        for (int i = rating; i < 5; i++) {
            System.out.print(bold + green + "☆" + reset);
        }
        System.out.println(); // New line after the stars

        System.out.println("You earned " + loyaltyPoints + " loyalty points!");

        // Process order based on the selected type
        System.out.println(yellow + "\n===================== State Messages ====================" + reset);
        if (orderType == 1) {
            System.out.println(bold
                    + "===================== Thank you for choosing Delivery . Your order will arrive soon!======================="
                    + reset);
        } else if (orderType == 2) {
            System.out.println(bold
                    + "===================== Thank you for choosing Take Away . Your order will be ready for pickup! ========================="
                    + reset);
        } else {
            System.out.println("Invalid option. Please try again.");
            return; // Exit the function if the input is invalid
        }

        // Store the order
        // Inside placeOrder method after finalPrice and loyalty points are calculated

        Order order = new Order(pizza, pizzaPrice, loyaltyPoints, discount, finalPrice,
                paymentChoice == 1 ? "Credit Card" : "Digital Wallet");
        orders.add(order);
        order.processOrder();

        class Invoice {
            private int invoiceID;

            // Parameterized constructor
            public Invoice(int invoiceID) {
                this.invoiceID = invoiceID;
            }

            // Getter for invoiceID
            public int getInvoiceID() {
                return invoiceID;
            }

            // Inner RealTimeOrderTracking class
            class RealTimeOrderTracking {
                private int orderID;
                private String currentLocation;
                private String estimatedDeliveryTime;

                public RealTimeOrderTracking(int orderID) {
                    this.orderID = orderID;
                    this.currentLocation = "Preparing at the restaurant";
                    this.estimatedDeliveryTime = "Calculating...";
                }

                public void updateLocation(String location) {
                    this.currentLocation = location;
                    System.out.println("Order " + orderID + " location updated to: " + currentLocation);
                }

                public void calculateETA() {
                    this.estimatedDeliveryTime = "30 minutes";
                    System.out.println("Order " + orderID + " ETA updated to: " + estimatedDeliveryTime);
                }

                public void displayTrackingInfo() {
                    System.out.println("\n--- Real-Time Order Tracking ---");
                    System.out.println("Order ID: " + orderID);
                    System.out.println("Current Location: " + currentLocation);
                    System.out.println("Estimated Delivery Time: " + estimatedDeliveryTime);
                    System.out.println("---------------------------------");
                }
            }
        }

        // Usage in your main method or wherever needed
        Invoice invoice = new Invoice(12345); // Instantiate Invoice with required parameters
        Invoice.RealTimeOrderTracking tracking = invoice.new RealTimeOrderTracking(101); // Pass the order ID
        tracking.updateLocation("Out for Delivery");
        tracking.calculateETA();
        tracking.displayTrackingInfo();

        tracking.updateLocation("Out for Delivery"); // Example: Set initial location
        tracking.calculateETA(); // Calculate and display ETA
        tracking.displayTrackingInfo(); // Show tracking details to the user

        // Notify user via Observer Pattern
        OrderNotification orderNotification = new OrderNotification(order);
        orderNotification.sendNotification("Your order is being processed!");

        System.out.println("\nOrder placed successfully ☺️.");
        order.processOrder();
    }

    // Function to view user profile (including favorite pizzas and reorder)
    private void viewProfile() {

        String bold = "\033[1m"; // Bold
        String reset = "\033[0m"; // Reset to normal text

        String blue = "\033[34m"; // Red text
        String green = "\033[32m"; // Yellow text
        String yellow = "\033[33m"; // Yellow text
        String magenta = "\033[35m"; // Magenta text
        String Cyan = "\033[36m"; // Cyan text
        String red = "\033[31m"; // red text
        System.out.println(bold
                + magenta
                + "\n---------------------------------------------------------------------------------------------------------------------------------------"
                + reset);
        System.out.println(bold
                + Cyan
                + "\n===================================================== Your Profile ===================================================================="
                + reset);
        System.out.println(bold
                + magenta
                + "\n---------------------------------------------------------------------------------------------------------------------------------------"
                + reset);
        System.out.println();
        System.out.println("Your Name: Dulara Lakshan Senevirathna");
        // Display favorite pizzas
        System.out.println("\nFavorite Pizzas:");
        System.out.println("\nAdress: No:161/A, 2 canal road, Polonnaruwa."); // Address to text
        System.out.println("\nEmail: dulara123@mail.com");// Email to text
        for (Order order : orders) {
            System.out.println(order.getPizzaDetails());
        }
    }

    // Function to view all orders and reorder from history
    private void viewOrders() {

        String bold = "\033[1m"; // Bold
        String reset = "\033[0m"; // Reset to normal text

        String blue = "\033[34m"; // Red text
        String green = "\033[32m"; // Yellow text
        String yellow = "\033[33m"; // Yellow text
        String magenta = "\033[35m"; // Magenta text
        String Cyan = "\033[36m"; // Cyan text
        String red = "\033[31m"; // red text

        System.out.println(
                bold + magenta
                        + "\n--------------------------------------------------------------------------------------------------------------------------"
                        + reset);
        System.out.println(
                bold + Cyan
                        + "\n=================================================== Your Orders =========================================================="
                        + reset);
        System.out.println(
                bold + magenta
                        + "\n--------------------------------------------------------------------------------------------------------------------------"
                        + reset);
        for (int i = 0; i < orders.size(); i++) {
            System.out.println((i + 1) + ". " + orders.get(i).getPizzaDetails());
        }
        System.out.print("\nWould you like to reorder a pizza? (yes/no): ");
        Scanner scanner = new Scanner(System.in);
        String reorderResponse = scanner.nextLine();
        if ("yes".equalsIgnoreCase(reorderResponse)) {
            System.out.print("Enter the order number to reorder: ");
            int orderNumber = scanner.nextInt();
            scanner.nextLine(); // consume newline
            Order order = orders.get(orderNumber - 1);
            System.out.println("\nReordering pizza: " + order.getPizzaDetails());
        }
    }
}

// Factory class for Payment Strategy
class PaymentFactory {
    public static PaymentStrategy getPaymentStrategy(int choice) {
        if (choice == 1) {
            return new CreditCardPayment();
        } else {
            return new DigitalWalletPayment();
        }
    }
}

// Abstract Pizza class representing the core pizza
abstract class Pizza {
    String description = "Unknown Pizza";
    double price = 0.0;

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}

// Concrete Pizza class (Base pizza)
class BasicPizza extends Pizza {
    public BasicPizza() {
        description = "Basic Pizza";
        price = 500.0;
    }
}

// Pizza Builder to construct the pizza
class PizzaBuilder {
    private String crust;
    private String sauce;
    private String toppings;

    public PizzaBuilder setCrust(String crust) {
        this.crust = crust;
        return this;
    }

    public PizzaBuilder setSauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    public PizzaBuilder setToppings(String toppings) {
        this.toppings = toppings;
        return this;
    }

    public Pizza build() {
        Pizza pizza = new BasicPizza();
        pizza = new ToppingDecorator(pizza, toppings);
        pizza = new CrustDecorator(pizza, crust);
        pizza = new SauceDecorator(pizza, sauce);
        return pizza;
    }
}

// Decorator classes
class ToppingDecorator extends Pizza {
    private Pizza pizza;
    private String toppings;

    public ToppingDecorator(Pizza pizza, String toppings) {
        this.pizza = pizza;
        this.toppings = toppings;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with " + toppings;
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 50.0 * toppings.split(",").length;
    }
}

class CrustDecorator extends Pizza {
    private Pizza pizza;
    private String crust;

    public CrustDecorator(Pizza pizza, String crust) {
        this.pizza = pizza;
        this.crust = crust;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with " + crust + " crust";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 150.0;
    }
}

class SauceDecorator extends Pizza {
    private Pizza pizza;
    private String sauce;

    public SauceDecorator(Pizza pizza, String sauce) {
        this.pizza = pizza;
        this.sauce = sauce;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with " + sauce + " sauce";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 50.0;
    }
}

class ExtraCheeseDecorator extends Pizza {
    private Pizza pizza;

    public ExtraCheeseDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + "   with Extra Cheese";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 100.0;
    }
}

class SpecialPackagingDecorator extends Pizza {
    private Pizza pizza;

    public SpecialPackagingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + "  with Special Packaging";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 150.0;
    }
}

// Command pattern - Order class to encapsulate order details
class Order {
    private static int nextID = 1; // Static counter for unique IDs
    private int orderID; // Unique ID for each order
    private Pizza pizza;
    private double price;
    private int loyaltyPoints;
    private double discount;
    private double finalPrice;
    private String paymentMethod;

    // Updated Constructor
    public Order(Pizza pizza, double price, int loyaltyPoints, double discount, double finalPrice,
            String paymentMethod) {
        this.orderID = nextID++; // Assign and increment the unique ID
        this.pizza = pizza;
        this.price = price;
        this.loyaltyPoints = loyaltyPoints;
        this.discount = discount;
        this.finalPrice = finalPrice;
        this.paymentMethod = paymentMethod;
    }

    // Getter for orderID
    public int getOrderID() {
        return orderID;
    }

    // Getter for final price
    public double getFinalPrice() {
        return finalPrice;
    }

    // Setter for final price
    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    // Getter for discount
    public double getDiscount() {
        return discount;
    }

    // Setter for discount
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    // Getter for loyalty points
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    // Setter for loyalty points
    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getPizzaDetails() {
        return pizza.getDescription();
    }

    public void processOrder() {
        System.out.println("\nProcessing Order...");
        System.out.println("Order ID: " + orderID); // Display order ID
        System.out.println("Total Price: LKR " + price);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Payment Method: " + paymentMethod);

        // Generate and display the invoice
        Invoice invoice = new Invoice(pizza, price, discount, finalPrice, loyaltyPoints, paymentMethod);
        invoice.generateInvoice();

        // Notify the user
        System.out.println("Order has been successfully processed.");
    }
}

// Observer pattern - Sending order notification
class OrderNotification {
    private Order order;

    public OrderNotification(Order order) {
        this.order = order;
    }

    public void sendNotification(String message) {
        System.out.println("\n--- Notification ---");
        System.out.println("Order ID: " + order.getPizzaDetails());
        System.out.println("Message: " + message);
    }
}

// Strategy pattern - Payment methods interface and implementations
interface PaymentStrategy {
    void processPayment(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of LKR " + amount);
    }
}

class DigitalWalletPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing digital wallet payment of LKR " + amount);
    }
}

// Payment class to delegate payment processing
class Payment {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        paymentStrategy.processPayment(amount);
    }
}

class Invoice {
    private Pizza pizza;
    private double price;
    private double discount;
    private double finalPrice;
    private int loyaltyPoints;
    private String paymentMethod;

    public Invoice(Pizza pizza, double price, double discount, double finalPrice, int loyaltyPoints,
            String paymentMethod) {
        this.pizza = pizza;
        this.price = price;
        this.discount = discount;
        this.finalPrice = finalPrice;
        this.loyaltyPoints = loyaltyPoints;
        this.paymentMethod = paymentMethod;
    }

    public void generateInvoice() {

        String bold = "\033[1m"; // Bold
        String reset = "\033[0m"; // Reset to normal text

        String blue = "\033[34m"; // Red text
        String green = "\033[32m"; // Yellow text
        String yellow = "\033[33m"; // Yellow text
        String magenta = "\033[35m"; // Magenta text
        String Cyan = "\033[36m"; // Cyan text
        String red = "\033[31m"; // red text

        // Adding a decorative top line with a box border
        System.out.println(yellow + "\n" + "-".repeat(50)); // A line of dashes at the top
        System.out.println(bold + yellow
                + "============================================== INVOICE ================================================"
                + reset); // Title with space
        System.out.println("-".repeat(50)); // A line of dashes after the title

        // Pizza and price information section
        System.out.println("Pizza: " + pizza.getDescription());
        System.out.println("-".repeat(50)); // Line separator

        System.out.println("Discount: LKR " + discount);

        // Display pricing details
        System.out.printf("%-25s: LKR %-10.2f\n", "Price ", price);
        System.out.printf("%-25s: LKR %-10.2f\n", "Discount %", discount);
        System.out.printf("%-25s: LKR %-10.2f\n", "Final Price ", finalPrice);
        System.out.println("-".repeat(50)); // Line separator

        // Display payment method and loyalty points earned
        System.out.printf("%-25s: %-10s\n", "Payment Method", paymentMethod);
        System.out.printf("%-25s: %-10d\n", "Loyalty Points Earned", loyaltyPoints);

        // Bottom line to close the invoice
        System.out.println("-".repeat(50)); // Line separator
        System.out.println("            ----------- THANK YOU FOR YOUR ORDER!!!! ------------           ");
        System.out.println("-".repeat(50) + reset); // Closing line

    }

    // RealTimeOrderTracking class to manage order tracking details
    class RealTimeOrderTracking {
        private int orderID; // Unique ID of the order being tracked
        private String currentLocation; // Current location of the order
        private String estimatedDeliveryTime; // Estimated delivery time in a readable format

        // Constructor to initialize tracking details
        public RealTimeOrderTracking(int orderID) {
            this.orderID = orderID;
            this.currentLocation = "Preparing at the restaurant"; // Default location
            this.estimatedDeliveryTime = "Calculating..."; // Default message for ETA
        }

        // Updates the current location of the order
        public void updateLocation(String location) {
            this.currentLocation = location;
            System.out.println("Order " + orderID + " location updated to: " + currentLocation);
        }

        // Calculates and sets the estimated delivery time
        public void calculateETA() {
            // For simplicity, assuming a fixed time for delivery
            // In real scenarios, this would involve maps and route optimization APIs
            this.estimatedDeliveryTime = "30 minutes";
            System.out.println("Order " + orderID + " ETA updated to: " + estimatedDeliveryTime);
        }

        // Displays the tracking information
        public void displayTrackingInfo() {
            System.out.println("\n--- Real-Time Order Tracking ---");
            System.out.println("Order ID: " + orderID);
            System.out.println("Current Location: " + currentLocation);
            System.out.println("Estimated Delivery Time: " + estimatedDeliveryTime);
            System.out.println("---------------------------------");
        }

    }
}

// Promotion class to handle discounts dynamically
class Promotion {
    private String promoCode; // Unique promo code
    private String description; // Description of the promotion
    private double discountPercentage; // Discount percentage
    private boolean isActive; // Whether the promotion is active

    // Constructor to initialize promotion details
    public Promotion(String promoCode, String description, double discountPercentage, boolean isActive) {
        this.promoCode = promoCode;
        this.description = description;
        this.discountPercentage = discountPercentage;
        this.isActive = isActive;
    }

    // Applies the promotion to the given order
    public boolean applyPromotion(Order order) {
        if (isActive) { // Only apply if the promotion is active
            double originalPrice = order.getFinalPrice();
            double discount = originalPrice * (discountPercentage / 100);
            order.setDiscount(discount); // Set the discount amount in the order
            order.setFinalPrice(originalPrice - discount); // Update the final price
            System.out.println("\nPromotion applied: " + description);
            System.out.println("Discount: LKR " + discount + " (" + discountPercentage + "%)");
            System.out.println("Final Price after Promotion: LKR " + order.getFinalPrice());
            return true;
        } else {
            System.out.println("\nThe promotion is no longer active.");
            return false;
        }
    }

    // Deactivates the promotion
    public void deactivatePromotion() {
        this.isActive = false;
    }

    // Checks if the promotion is still valid
    public boolean isValid() {
        return isActive;
    }
}

// Abstract Handler class for processing discounts or promotions
abstract class DiscountHandler {
    protected DiscountHandler nextHandler;

    // Set the next handler in the chain
    public void setNextHandler(DiscountHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // Abstract method to handle the discount, to be implemented by concrete classes
    public abstract void handleDiscount(Order order);
}

// Concrete handler for applying seasonal discounts
class SeasonalDiscountHandler extends DiscountHandler {

    @Override
    public void handleDiscount(Order order) {
        // Apply seasonal discount if applicable
        double seasonalDiscount = 0.10 * order.getFinalPrice(); // For example, 10% discount
        order.setDiscount(order.getDiscount() + seasonalDiscount);
        order.setFinalPrice(order.getFinalPrice() - seasonalDiscount);
        System.out.println("Seasonal discount applied: LKR " + seasonalDiscount);

        // If there is a next handler, pass the order
        if (nextHandler != null) {
            nextHandler.handleDiscount(order);
        }
    }
}

// Concrete handler for applying loyalty discounts
class LoyaltyDiscountHandler extends DiscountHandler {

    @Override
    public void handleDiscount(Order order) {
        // Apply loyalty discount if applicable
        int loyaltyPoints = order.getLoyaltyPoints();
        double loyaltyDiscount = loyaltyPoints * 0.05; // For example, 5 LKR per loyalty point
        order.setDiscount(order.getDiscount() + loyaltyDiscount);
        order.setFinalPrice(order.getFinalPrice() - loyaltyDiscount);
        System.out.println("Loyalty discount applied: LKR " + loyaltyDiscount);

        // If there is a next handler, pass the order
        if (nextHandler != null) {
            nextHandler.handleDiscount(order);
        }
    }
}

// Concrete handler for applying promotional code discounts
class PromoCodeDiscountHandler extends DiscountHandler {

    private String promoCode; // Promo code to be applied

    public PromoCodeDiscountHandler(String promoCode) {
        this.promoCode = promoCode;
    }

    @Override
    public void handleDiscount(Order order) {
        // Check if the promo code is valid and apply the discount
        if ("SUMMER2024".equals(promoCode)) { // Example promo code
            double promoDiscount = 0.15 * order.getFinalPrice(); // 15% off
            order.setDiscount(order.getDiscount() + promoDiscount);
            order.setFinalPrice(order.getFinalPrice() - promoDiscount);
            System.out.println("Promo code discount applied: LKR " + promoDiscount);
        } else {
            System.out.println("Invalid or expired promo code.");
        }

        // If there is a next handler, pass the order
        if (nextHandler != null) {
            nextHandler.handleDiscount(order);
        }
    }
}
