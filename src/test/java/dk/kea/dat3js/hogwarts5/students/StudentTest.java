package dk.kea.dat3js.hogwarts5.students;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getFullNameWithMiddleName() {

        //arrange
        Student student1 = new Student("Harry", "James", "Potter", null, 5);

        //act
        var fullName = student1.getFullName();

        //assert
        assertEquals("Harry James Potter", fullName);

    }

    @Test
    void getFullNameWithoutMiddleName() {

            //arrange
            Student student = new Student("Cho", "Chang", null, 5);

            //act
            var fullName = student.getFullName();

            //assert
            assertEquals("Cho Chang", fullName);
    }


    @Test
    void setFullNameWithoutLastName(){

            //arrange
            Student student = new Student("first", "middle", "last", null, 5);

            //act
            student.setFullName("Hermione Jean");

            //assert
            assertEquals("Hermione", student.getFirstName());
            assertEquals("Jean", student.getMiddleName());
            assertEquals(null, student.getLastName());
    }

    @Test
    void setFullNameWithMultipleMiddleNames() {

        //arrange
        Student student = new Student("first", "middle", "last", null, 5);

        //act
        student.setFullName("Hermione Jean Granger");

        //assert
        assertEquals("Hermione", student.getFirstName());
        assertEquals("Jean", student.getMiddleName());
        assertEquals("Granger", student.getLastName());
    }

    @Test
    void setFullNameWithEmptyString(){

            //arrange
            Student student = new Student("first", "middle", "last", null, 5);

            //act
            student.setFullName("");

            //assert
            assertEquals("", student.getFirstName());
            assertEquals("", student.getMiddleName());
            assertEquals("", student.getLastName());
    }

    @Test
    void setFullNameWithNull(){

                //arrange
                Student student = new Student("first", "middle", "last", null, 5);

                //act
                student.setFullName(null);

                //assert
                assertEquals(null, student.getFirstName());
                assertEquals(null, student.getMiddleName());
                assertEquals(null, student.getLastName());
    }
        @Test
    void setFullName() {

        //arrange
        Student student = new Student("first", "middle", "last", null, 5);

        //act
        student.setFullName("Hermione Jean Granger");

        //assert
        assertEquals("Hermione", student.getFirstName());
        assertEquals("Jean", student.getMiddleName());
        assertEquals("Granger", student.getLastName());
    }
}