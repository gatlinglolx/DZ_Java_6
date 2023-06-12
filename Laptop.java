// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. 
// Реализовать в java.
// Создать множество ноутбуков (Set).
// Написать метод, который будет запрашивать у пользователя критерий 
// (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. 
// Критерии фильтрации можно хранить в Map или в Сет. Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - цвет
// 2 - бренд

import java.util.*;

public class Laptop {

    private String brand;
    private String model;
    private String color;
    private double price;
    private int ram;
    private String processor;
    private int storage;

    public Laptop(String brand, String model, String color, double price, int ram, String processor, int storage) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.ram = ram;
        this.processor = processor;
        this.storage = storage;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    public String getProcessor() {
        return processor;
    }

    public int getStorage() {
        return storage;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand = '" + brand + '\'' +
                ", model = '" + model + '\'' +
                ", color = " + color + 
                ", price = " + price +
                ", ram = " + ram +
                ", processor = '" + processor + '\'' +
                ", storage = " + storage +
                '}';
    }

    public static void main(String[] args) {

        Laptop laptop1 = new Laptop("HP", "Pavilion", "black", 500.99, 8, "Intel Core i5", 512);
        Laptop laptop2 = new Laptop("Lenovo", "Thinkpad", "white",  480.50, 4, "AMD Ryzen 5", 1000);
        Laptop laptop3 = new Laptop("Asus", "Vivobook", "gray", 660.90, 16, "Intel Core i7",  1000);

        Set<Laptop> laptops = new HashSet<>();
        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);

        System.out.println("Laptop list: ");
        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }

        Map<String, String> filters = Map.of("brand", "model", "color", "ram", "processor", "storage");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter filter key (" + String.join(", ", filters.values()) + "): ");
        String key = scanner.nextLine();
        while (!filters.containsKey(key)) {
        System.out.print("Invalid filter key. Enter filter key (" + String.join(", ", filters.values()) + "): ");
        key = scanner.nextLine();
    

        System.out.print("Enter filter value: ");
        String value = scanner.nextLine();

        for (Laptop laptop : laptops) {
            switch (key) {
                case "brand":
                    if (laptop.getBrand().equalsIgnoreCase(value)) {
                        System.out.println(laptop.getBrand() + " " + laptop.getModel());
                    }
                    break;
                case "price":
                    if (laptop.getPrice() <= Integer.parseInt(value)) {
                        System.out.println(laptop.getBrand() + " " + laptop.getModel() + " ($" + laptop.getPrice() + ")");
                    }
                    break;
                case "color":
                    if (laptop.getColor().equalsIgnoreCase(value)) {
                        System.out.println(laptop.getBrand() + " " + laptop.getModel() + laptop.getColor());
                    }
                    break;
                case "ram":
                    if (laptop.getRam() == Integer.parseInt(value)) {
                        System.out.println(laptop.getBrand() + " " + laptop.getModel() + laptop.getRam());
                    }
                case "processor":
                    if (laptop.getProcessor().equalsIgnoreCase(value)) {
                        System.out.println(laptop.getBrand() + " " + laptop.getModel() + laptop.getProcessor());
                    }
                case "storage":
                    if (laptop.getStorage() == Integer.parseInt(value)) {
                        System.out.println(laptop.getBrand() + " " + laptop.getModel() + laptop.getStorage());
                    }
                }
            }
        }
    }
}