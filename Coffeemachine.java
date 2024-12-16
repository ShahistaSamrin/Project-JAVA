import java.util.Scanner;

public class CoffeeMachine{
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }

    public void makeCoffee(String coffeeType) {
        int waterRequired = 0;
        int milkRequired = 0;
        int coffeeBeansRequired = 0;
        int cost = 0;

        switch (coffeeType.toLowerCase()) {
            case "espresso":
                waterRequired = 250;
                coffeeBeansRequired = 16;
                cost = 4;
                break;
            case "latte":
                waterRequired = 350;
                milkRequired = 75;
                coffeeBeansRequired = 20;
                cost = 7;
                break;
            case "cappuccino":
                waterRequired = 200;
                milkRequired = 100;
                coffeeBeansRequired = 12;
                cost = 6;
                break;
            default:
                System.out.println("Invalid coffee type.");
                return;
        }

        if (water >= waterRequired && milk >= milkRequired && coffeeBeans >= coffeeBeansRequired && cups > 0) {
            water -= waterRequired;
            milk -= milkRequired;
            coffeeBeans -= coffeeBeansRequired;
            cups--;
            money += cost;
            System.out.println("I have enough resources, making your " + coffeeType + "...");
        } else {
            if (water < waterRequired) {
                System.out.println("Sorry, not enough water!");
            }
            if (milk < milkRequired) {
                System.out.println("Sorry, not enough milk!");
            }
            if (coffeeBeans < coffeeBeansRequired) {
                System.out.println("Sorry, not enough coffee beans!");
            }
            if (cups <= 0) {
                System.out.println("Sorry, not enough cups!");
            }
        }
    }

    public void refill() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the amount of water to refill (in ml): ");
        water += scanner.nextInt();
        
        System.out.println("Enter the amount of milk to refill (in ml): ");
        milk += scanner.nextInt();
        
        System.out.println("Enter the amount of coffee beans to refill (in grams): ");
        coffeeBeans += scanner.nextInt();
        
        System.out.println("Enter the number of cups to refill: ");
        cups += scanner.nextInt();
        
        System.out.println("Machine refilled!");
    }

    public void showStatus() {
        System.out.println("\nCoffee Machine Status:");
        System.out.println("Water: " + water + " ml");
        System.out.println("Milk: " + milk + " ml");
        System.out.println("Coffee Beans: " + coffeeBeans + " g");
        System.out.println("Cups: " + cups);
        System.out.println("Money: $" + money);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 200, 100, 10, 0);
    }
}

  
