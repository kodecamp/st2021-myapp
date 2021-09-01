package in.kodecamp.entities;

// Every student is a person
public interface Student extends Person {
  public String rollNo();
  public Course course();
  public String college();
}
