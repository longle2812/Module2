import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Request request = new Request();
        Service service = new Service();
        System.out.println("Action:");
        request.setAction(sc.next());
        switch (request.getAction()){
            case "lookup":
                    request.setKeyword(sc.nextLine());
                    service.lookup(request.getKeyword());
        }
    }
}
