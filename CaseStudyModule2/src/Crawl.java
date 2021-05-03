import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawl {
    List<String> classification = new ArrayList<>();
    List<String> definition = new ArrayList<>();
    public Crawl(String keyword) throws IOException {
        String newURL = "https://vdict.com/"+keyword+",1,0,0.html";
        URL url = new URL(newURL);
        Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
        scanner.useDelimiter("\\Z");
        String content = scanner.next();
        // close scanner
        scanner.close();
        // remove all new lines & tabs
        content = content.replaceAll("\\n+", "");
        content = content.replaceAll("\\t+", "");
        // find Content
        checkValid(content);
        getPronouce(content);
        getDefiniton(content);
    }

    private void checkValid(String content) {
        String validRegex = "<h2>Không tìm thấy từ. Gợi ý:</h2>";
        Pattern validPattern = Pattern.compile(validRegex);
        Matcher validMatcher = validPattern.matcher(content);
        while (validMatcher.find()){
            String suggestRegex = "<a href=\"/(.*?),1,0,0.html\">";
            System.out.println("Không tìm thấy từ");
            Pattern suggestPattern = Pattern.compile(suggestRegex);
            Matcher suggestMatcher = suggestPattern.matcher(content);
//            while (suggestMatcher.find()) {
//                System.out.println(suggestMatcher.group(1));
//            }
        }
    }

    private void getDefiniton(String content) {
        String classRegex = "class=\"phanloai\">(.*?)</div>(.*?)</li></ul><div";
        Pattern classPattern = Pattern.compile(classRegex);
        Matcher classMatcher = classPattern.matcher(content);
        while (classMatcher.find()) {
            System.out.println("- " + classMatcher.group(1));
            String definitionContent = String.valueOf(classMatcher);
            String definitionRegex = "<b>(.*?)</b>";
            Pattern definitionPattern = Pattern.compile(definitionRegex);
            Matcher definitionMatcher = definitionPattern.matcher(definitionContent);
            while (definitionMatcher.find()){
                System.out.println("+ "+definitionMatcher.group(1));
            }
            System.out.println();
        }
    }

    private void getPronouce(String content) {
        String pronounceRegex = "<div class=\"pronounce\">(.*?)</div>";
        Pattern pronouncePattern = Pattern.compile(pronounceRegex);
        Matcher pronounceMatcher = pronouncePattern.matcher(content);
        while (pronounceMatcher.find()) {
            System.out.println("- Phát âm: "+pronounceMatcher.group(1));
        }
        System.out.println();
    }
}
