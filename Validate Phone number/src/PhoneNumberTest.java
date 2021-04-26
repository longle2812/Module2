public class PhoneNumberTest {
    public static PhoneNumberExample phoneNumberExample = new PhoneNumberExample();
    public static String[] validPhone = new String[] {"(84)-(0978489648)", " (a8)-(22222222)"};
    public static void main(String[] args) {
        for (String phone:
             validPhone) {
            System.out.println("Phone is" + phone+" is " +phoneNumberExample.validate(phone));
        }
    }
}
