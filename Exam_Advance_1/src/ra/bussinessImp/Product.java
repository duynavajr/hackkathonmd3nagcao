package ra.bussinessImp;

import ra.bussiness.IShop;

import java.util.Scanner;

public class Product implements IShop {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private Boolean productStatus;


    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, Boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.productStatus = productStatus;
        this.exportPrice = importPrice * RATE;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public Boolean getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Boolean productStatus) {
        this.productStatus = productStatus;
    }


    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã sản phẩm: ");
        this.productId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        this.productName = scanner.nextLine();

        System.out.print("Nhập tiêu đề sản phẩm: ");
        this.title = scanner.nextLine();

        System.out.print("Nhập mô tả sản phẩm: ");
        this.descriptions = scanner.nextLine();


        System.out.print("Nhập giá nhập sản phẩm: ");
        this.importPrice = scanner.nextFloat();
        scanner.nextLine();


        this.exportPrice = this.importPrice * RATE;

        System.out.print("Nhập trạng thái sản phẩm (true/false): ");
        this.productStatus = scanner.nextBoolean();
    }

    @Override
    public void displayData() {
        System.out.println("Mã sản phẩm: " + this.productId);
        System.out.println("Tên sản phẩm: " + this.productName);
        System.out.println("Tên danh mục sản phẩm: " + this.catalog.getCatalogName()); // Giả sử Catalog có một phương thức getCatalogName
        System.out.println("Giá bán sản phẩm: " + this.exportPrice);
        System.out.println("Trạng thái sản phẩm: " + this.productStatus);
    }}
