package ra.run;



import ra.bussinessImp.Catalog;
import ra.bussinessImp.Product;

import java.util.*;

public class ProductManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Catalog> catalogs = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************");
            System.out.println("1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục");
            System.out.println("2. Nhập số sản phẩm và nhập thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator)");
            System.out.println("4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc bỏ dòng new line

            switch (choice) {
                case 1:
                    inputCatalogs(scanner, catalogs);
                    break;
                case 2:
                    inputProducts(scanner, catalogs, products);
                    break;
                case 3:
                    sortPrice(products);
                    break;
                case 4:
                    searchProductCatalog(scanner, products);
                    break;
                case 5:
                    System.out.println("Chương trình kết thúc.");
                    System.exit(0);
                default:
                    System.out.println("Chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }

    private static void inputCatalogs(Scanner scanner, List<Catalog> catalogs) {
        System.out.print("Nhập số danh mục sản phẩm: ");
        int numCatalogs = scanner.nextInt();
        scanner.nextLine();  // Đọc bỏ dòng new line

        for (int i = 0; i < numCatalogs; i++) {
            Catalog catalog = new Catalog();
            System.out.println("Nhập thông tin danh mục #" + (i + 1) + ":");
            catalog.inputData();
            catalogs.add(catalog);
        }
    }

    private static void inputProducts(Scanner scanner, List<Catalog> catalogs, List<Product> products) {
        System.out.print("Nhập số sản phẩm: ");
        int numProducts = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numProducts; i++) {
            Product product = new Product();
            System.out.println("Nhập thông tin sản phẩm #" + (i + 1) + ":");
            product.inputData();


            System.out.println("Chọn danh mục sản phẩm:");
            displayCatalogs(catalogs);
            int catalogIndex = scanner.nextInt();
            scanner.nextLine();

            if (catalogIndex >= 0 && catalogIndex < catalogs.size()) {
                product.setCatalog(catalogs.get(catalogIndex));
                products.add(product);
            } else {
                System.out.println("Chọn không hợp lệ. Sản phẩm không được thêm vào danh sách.");
            }
        }
    }

    private static void displayCatalogs(List<Catalog> catalogs) {
        for (int i = 0; i < catalogs.size(); i++) {
            System.out.println(i + ". " + catalogs.get(i).getCatalogName());
        }
    }

    private static void sortPrice(List<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Float.compare(p1.getExportPrice(), p2.getExportPrice());
            }
        });

        System.out.println("Danh sách sản phẩm đã được sắp xếp theo giá tăng dần:");
        for (Product product : products) {
            product.displayData();
        }
    }

    private static void searchProductCatalog(Scanner scanner, List<Product> products) {
        System.out.print("Nhập tên danh mục sản phẩm cần tìm: ");
        String searchCatalogName = scanner.nextLine();

        System.out.println("Sản phẩm thuộc danh mục '" + searchCatalogName + "':");
        for (Product product : products) {
            if (product.getCatalog().getCatalogName().equalsIgnoreCase(searchCatalogName)) {
                product.displayData();
            }
        }
    }
}
