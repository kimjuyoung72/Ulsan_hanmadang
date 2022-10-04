public class Test1 {
    public static void method1() {
        System.out.println("method1 호출됨!");
        method2();
    }
    public static void method2() {
        System.out.println("method2 호출됨!");
        method3();
        method1();
    }
    public static void method3() {
        System.out.println("method3 호출됨!");
    }
    public static void main(String[] args) {
        System.out.println("Hello~");
        method1(); //메소드 호출
    }
}
