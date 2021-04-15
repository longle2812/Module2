import java.lang.reflect.Array;
import java.util.*;

public class Demerging {
    public static void main(String[] args) {
        Queue nam = new LinkedList();
        Queue nu = new LinkedList();
        Queue result = new LinkedList();
        Object[] array = new Object[10];
        array[0] = new Nam("a");
        array[1] = new Nu("b");
        array[2] = new Nam();
        array[3] = new Nam("c");
        array[4] = new Nu();
        array[5] = new Nam("d");
        array[6] = new Nam();
        array[7] = new Nu("f");
        array[8] = new Nam();
        for (Object person :
                array) {
            if (person instanceof Nam) {
                nam.add(person);
            } else if (person instanceof Nu) {
                nu.add(person);
            }
        }
        result.addAll(nu);
        result.addAll(nam);
        System.out.println(result);
    }

    public static class Nam {
        private String name;

        public Nam(String name) {
            this.name = name;
        }

        public Nam() {
        }

        @Override
        public String toString() {
            return "Nam{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class Nu {
        private String name;

        public Nu(String name) {
            this.name = name;
        }

        public Nu() {
        }

        @Override
        public String toString() {
            return "Nu{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
