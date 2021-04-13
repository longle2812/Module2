import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @org.junit.jupiter.api.Test
    void typeOfTriangle() {
        double a = 2;
        double b = 2;
        double c = 2;
        String expected = "tam giác đều";
        String result = Triangle.typeOfTriangle(a, b, c);
        assertEquals(expected, result);
    }
    @org.junit.jupiter.api.Test
    void typeOfTriangle1() {
        double a = 2;
        double b = 2;
        double c = 3;
        String expected = "tam giác cân";
        String result = Triangle.typeOfTriangle(a, b, c);
        assertEquals(expected, result);
    }
    @org.junit.jupiter.api.Test
    void typeOfTriangle2() {
        double a = 3;
        double b = 4;
        double c = 5;
        String expected = "tam giác thường";
        String result = Triangle.typeOfTriangle(a, b, c);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void typeOfTriangle3() {
        double a = 8;
        double b = 2;
        double c = 3;
        String expected = "không phải là tam giác";
        String result = Triangle.typeOfTriangle(a, b, c);
        assertEquals(expected, result);
    }
    @org.junit.jupiter.api.Test
    void typeOfTriangle4() {
        double a = -1;
        double b = 2;
        double c = 1;
        String expected = "không phải là tam giác";
        String result = Triangle.typeOfTriangle(a, b, c);
        assertEquals(expected, result);
    }
    @org.junit.jupiter.api.Test
    void typeOfTriangle5() {
        double a = 0;
        double b = 1;
        double c = 1;
        String expected = "không phải là tam giác";
        String result = Triangle.typeOfTriangle(a, b, c);
        assertEquals(expected, result);
    }
}