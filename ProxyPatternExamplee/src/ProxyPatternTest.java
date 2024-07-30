// ProxyPatternTest.java
public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Image will be loaded and displayed
        image1.display();
        System.out.println();

        // Image is cached, so it will be displayed directly
        image1.display();
        System.out.println();

        // Image will be loaded and displayed
        image2.display();
    }
}
