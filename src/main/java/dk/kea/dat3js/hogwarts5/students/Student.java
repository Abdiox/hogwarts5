package dk.kea.dat3js.hogwarts5.students;

import dk.kea.dat3js.hogwarts5.house.House;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Entity
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String firstName;
  private String middleName;
  private String lastName;
  @ManyToOne
  private House house;
  private Integer schoolYear; // 1-7

  public Student() {
  }

  public Student(String firstName, String lastName, House house, int schoolYear) {
    this(firstName, null, lastName, house, schoolYear);
  }

  public Student(String firstName, String middleName, String lastName, House house, int schoolYear) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.house = house;
    this.schoolYear = schoolYear;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }



  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = capitalize(firstName);
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    if (middleName == null || middleName.trim().isEmpty()) {
      this.middleName = middleName;
    } else {
      this.middleName = Arrays.stream(middleName.split(" "))
              .map(this::capitalize)
              .collect(Collectors.joining(" "));
    }
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = capitalize(lastName);
  }

  public House getHouse() {
    return house;
  }

  public void setHouse(House house) {
    this.house = house;
  }

  public Integer getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(Integer schoolYear) {
    this.schoolYear = schoolYear;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return Objects.equals(getFirstName(), student.getFirstName()) && Objects.equals(getMiddleName(), student.getMiddleName()) && Objects.equals(getLastName(), student.getLastName()) && Objects.equals(getHouse().getName(), student.getHouse().getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getMiddleName(), getLastName(), getHouse().getName());
  }


  public String getFullName() {
    return firstName + " " + (middleName != null ? middleName +" " :"") + (lastName!=null ? lastName +" " : "");
  }

  public void setFullName(String fullName){
    if (fullName == null) {
      setFirstName(null);
      setMiddleName(null);
      setLastName(null);
      return;
    }

    if (fullName.trim().isEmpty()) {
      setFirstName("");
      setMiddleName("");
      setLastName("");
      return;
    }

    String[] nameParts = fullName.split(" ");

    setFirstName(nameParts[0]);

    if (nameParts.length > 1) {
      StringBuilder middleNames = new StringBuilder();
      for (int i = 1; i < nameParts.length - 1; i++) {
        middleNames.append(nameParts[i]).append(" ");
      }
      setMiddleName(middleNames.toString().trim());
    } else {
      setMiddleName("");
    }

    if (nameParts.length > 2) {
      setLastName(nameParts[nameParts.length - 1]);
    } else {
      setLastName("");
    }
  }

  private String capitalize(String name) {
    if (name == null) {
      return null;
    }

    if (name.length() < 2) {
      return name.toUpperCase();
    }

    if(name.contains(" ")){
      int space = name.indexOf(" ");
      return capitalize(name.substring(0, space))+ " " + capitalize(name.substring(space+1));
    }

    return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
  }


}
