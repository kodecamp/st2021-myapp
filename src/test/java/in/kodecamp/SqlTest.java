package in.kodecamp;

import static in.kodecamp.commons.Logger.log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.sql2o.Sql2o;

import in.kodecamp.commons.DbConfig;
import in.kodecamp.commons.H2DbConfig;


public class SqlTest{
    private DbConfig h2dbConfig = new H2DbConfig();
    private String url = h2dbConfig.url();
    private String username = h2dbConfig.username();
    private String password = h2dbConfig.password();

    private final String FETCH_ALL_STUDENTS = "SELECT * FROM STUDENT";

    public void testSql2o() {
        log("#################### start : testSql2o");
        Sql2o sqlo = new Sql2o(url, username, password);
        org.sql2o.Connection conn = sqlo.beginTransaction();
        log("Connection", conn);
        List<Student> students = conn.createQuery(FETCH_ALL_STUDENTS).executeAndFetch(Student.class);
        students.forEach(System.out::println);
        conn.commit();
        log("#################### end : testSql2o");
    }

    public void testJdbc() {
        log("#################### start : testJdbc");
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = conn.prepareStatement("select * from student");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                log("id", rs.getObject("id"));
                log("name", rs.getObject("name"));
                log("address", rs.getObject("address"));
            }

        } catch (Exception ex) {

        }
        log("#################### end : testJdbc");
    }
}

class Student {
    private int id;
    private String name;
    private String address;

    Student(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }

    public String address() {
        return this.address;
    }

    public String toString() {
        return String.format("[id = %d, name = %s, address = %s]", this.id, this.name, this.address);

    }
}
