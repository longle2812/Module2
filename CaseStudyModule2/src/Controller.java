import java.io.IOException;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Request request = new Request();
        Service service = new Service();
        do {
            service.readFile();
            System.out.println("Action:");
            request.setAction(sc.next());
            switch (request.getAction()) {
                case "lookup":
                    request.setKeyword(sc.nextLine());
                    service.lookup(request.getKeyword());
                    break;
                case "define":
                    request.setParams(sc.next());
                    request.setKeyword(sc.nextLine());
                    service.define(request.getParams(), request.getKeyword());
                    service.writeToFile();
                    break;
                case "show":
                    service.display();
                    break;
                case "drop":
                    request.setKeyword(sc.nextLine());
                    service.drop(request.getKeyword());
                    service.writeToFile();
                    break;
                case "online":
                    request.setKeyword(sc.nextLine());
                    new Crawl(request.getKeyword());
                    break;
            }
        }
        while (!request.getAction().equals("exit"));
    }
}
