package in.kodecamp.entities;

import java.util.List;

public class TestEmployee {
    public int id;
    public String name;
    public double billAmount;
    public String month;

    public TestEmployee(int id, String name, double billAmount, String month) {
        this.id = id;
        this.name = name;
        this.billAmount = billAmount;
        this.month = month;
    }

    public String name() {
        return this.name;
    }

    public String month() {
        return this.month;
    }

    public double billAmount() {
        return this.billAmount;
    }

    public String toString() {
        return String.format("{ id = %d, name = %s, amount = %f }", this.id, this.name, this.billAmount);
    }

    public static List<TestEmployee> getAllEmployees() {
        return List.of(
                new TestEmployee(1, "Sunil",  100, "Jan"),
                new TestEmployee(1, "Sunil",  200, "Feb"),
                new TestEmployee(1, "Sunil",  300, "March"),

                new TestEmployee(2, "Rakesh", 400, "Jan"),
                new TestEmployee(2, "Rakesh", 400, "Feb"),
                new TestEmployee(2, "Rakesh", 400, "March"),

                new TestEmployee(3, "Suresh", 500, "Jan"),
                new TestEmployee(3, "Suresh", 500, "Feb"),
                new TestEmployee(3, "Suresh", 500, "March")
                );
    }

}
