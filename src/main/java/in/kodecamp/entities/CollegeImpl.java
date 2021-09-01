package in.kodecamp.entities;

// CollegeImpl is a college
public class CollegeImpl implements College {

  private String regNo;
  private String address;
  private Course[] courses;
  private Student[] students;

  public CollegeImpl(String regNo, String address, Course[] courses, Student[] students) {
    this.regNo = regNo;
    this.address = address;
    this.courses = courses;
    this.students = students;
  }

  @Override
  public String regNo() {
    return this.regNo;
  }

  @Override
  public Course[] courses() {
    return this.courses;
  }

  @Override
  public String address() {
    return this.address;
  }

  @Override
  public Student[] students() {
    return this.students;
  }

}
