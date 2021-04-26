public class ClassNameTest {
    public static String[] validClass = new String[]{"C0318G","C0221H","M0318G","P0323A"};
    public static void main(String[] args) {
        ClassNameExample classNameExample = new ClassNameExample();
        for (String className : validClass) {
            boolean isvalid = classNameExample.validate(className);
            System.out.println("Class name is " + className +" is valid: "+ isvalid);
        }
    }
}
