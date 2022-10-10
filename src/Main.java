import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String[] OPERATIONS = {"Добавить", "Показать", "Удалить", "Найти", "Выход"};
    private static List<String> shoppingList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("Введите номер операции:");
        for (int i = 0; i < OPERATIONS.length; i++) {
            System.out.println((i + 1) + " - " + OPERATIONS[i]);
        }
    }

    public static void show() {
        if (shoppingList.isEmpty()) {
            System.out.println("Список покупок пуст.");
        } else {
            System.out.println("Список покупок:");
            for (int i = 0; i < shoppingList.size(); i++) {
                System.out.println((i + 1) + ". " + shoppingList.get(i));
            }
        }
    }

    public static void add() {
        System.out.println("Какую покупку хотите добавить?");
        String input = scanner.nextLine();
        shoppingList.add(input);
        System.out.println("Итого в списке покупок: " + shoppingList.size());
    }

    public static void remove() {
        String product, input;
        if (shoppingList.isEmpty()) {
            System.out.println("Список покупок пуст.");
        } else {
            show();
            System.out.print("Какую хотите удалить? Введите номер или название: ");
            input = scanner.nextLine();
            try {
                int productNumber = Integer.parseInt(input) - 1;
                product = shoppingList.get(productNumber);
            } catch (NumberFormatException e) {
                product = input;
            }
            shoppingList.remove(product);
            System.out.println("Покупка " + product + " удалена, список покупок:");
            show();
        }
    }

    public static void find() {
        String input, queryLower, itemLower, product;
        System.out.print("Введите текст для поиска: ");
        input = scanner.nextLine();
        queryLower = input.toLowerCase();
        System.out.println("Найдено:");
        for (int i = 0; i < shoppingList.size(); i++) {
            product = shoppingList.get(i);
            itemLower = product.toLowerCase();
            if (itemLower.contains(queryLower)) {
                System.out.println((i + 1) + ". " + product);
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            menu();
            String input = scanner.nextLine();
            int operationNumber = Integer.parseInt(input) - 1;
            if ("Выход".equals(OPERATIONS[operationNumber])) {
                break;
            }
            if ("Показать".equals(OPERATIONS[operationNumber])) {
                show();
                continue;
            }
            if ("Добавить".equals(OPERATIONS[operationNumber])) {
                add();
                continue;
            }
            if ("Удалить".equals(OPERATIONS[operationNumber])) {
                remove();
                continue;
            }
            if ("Найти".equals(OPERATIONS[operationNumber])) {
                find();
                continue;
            }
        }
    }
}
