/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Asandile Buthelezi
 */
public class StudentTest {

    public StudentTest() {
    }

    /**
     * Test of SaveStudent method, of class Student.
     */
    @Test
    public void testSaveStudent() {
        ArrayList<Student> studentList = new ArrayList<>();
        Student student = new Student(234, "testStudent", 23, "email.com", "maths");
        AbcCollegeApp.SaveStudent(student, studentList);
        assertEquals(studentList.get(0), student);
    }


    /**
     * Test of searchStudent method, of class Student.
     */
    @Test
    public void testSearchStudent() {
        ArrayList<Student> studentList = new ArrayList<>();
        Student student1 = new Student(234, "testStudent", 23, "email.com", "maths");
        Student student2 = new Student(235, "testStudent", 23, "email.com", "maths");
        AbcCollegeApp.SaveStudent(student1, studentList);
        AbcCollegeApp.SaveStudent(student2, studentList);
        assertEquals(AbcCollegeApp.searchStudent(235, studentList), student2);
    }

    /**
     * Test of checkValidSearchStudent method, of class Student.
     */
    @Test
    public void TestSearchStudent_StudentNotFound() {
        ArrayList<Student> studentList = new ArrayList<>();
        Student student1 = new Student(234, "testStudent", 23, "email.com", "maths");
        Student student2 = new Student(235, "testStudent", 23, "email.com", "maths");
        AbcCollegeApp.SaveStudent(student1, studentList);
        AbcCollegeApp.SaveStudent(student2, studentList);
        assertNull(AbcCollegeApp.searchStudent(230, studentList));
    }

    /**
     * Test of deleteStudent method, of class Student.
     */
    @Test
    public void testDeleteStudent() {
        ArrayList<Student> studentList = new ArrayList<>();
        Student student1 = new Student(234, "testStudent", 23, "email.com", "maths");
        Student student2 = new Student(235, "testStudent", 23, "email.com", "maths");
        AbcCollegeApp.SaveStudent(student1, studentList);
        AbcCollegeApp.SaveStudent(student2, studentList);

        //DELETE THE STUDENT
        AbcCollegeApp.deleteStudent(234, studentList);

        //The searching the student agan should be null
        assertNull(AbcCollegeApp.searchStudent(234, studentList));
    }


    /**
     * Test of TestDeleteStudent_StudentNotFound method, of class Student.
     */
    @Test
    public void TestDeleteStudent_StudentNotFound() {
        ArrayList<Student> studentList = new ArrayList<>();
        Student student1 = new Student(234, "testStudent", 23, "email.com", "maths");
        Student student2 = new Student(235, "testStudent", 23, "email.com", "maths");
        AbcCollegeApp.SaveStudent(student1, studentList);
        AbcCollegeApp.SaveStudent(student2, studentList);

        //DELETE THE STUDENT who doesn't exist
        AbcCollegeApp.deleteStudent(230, studentList);

        //The student list length should remain the same
        assertEquals(studentList.size(),2);
    }


    /**
     * Test of TestStudentAge_StudentAgeValid method, of class Student.
     */
    @Test
    public void TestStudentAge_StudentAgeValid() {
        Student student1 = new Student(234, "testStudent", 23, "email.com", "maths");

        //The age that is passed is int and it is above 16
        assertTrue(AbcCollegeApp.validStudentAge(student1.age));
    }


    /**
     * Test of TestStudentAge_StudentAgeInvalidCharacter() method, of class Student.
     */
    @Test
    public void TestStudentAge_StudentAgeInvalidCharacter() {
        Student student1 = new Student(234, "testStudent", 40, "email.com", "maths");

        //The age that is passed is String
        assertFalse(AbcCollegeApp.validStudentAge(String.valueOf(student1.getAge())));
    }


    /**
     * Test of TestStudentAge_StudentAgeInvalidCharacter() method, of class Student.
     */
    @Test
    public void TestStudentAge_StudentAgeInvalid() {
        Student student1 = new Student(234, "testStudent", 4, "email.com", "maths");

        //The age that is passed is int and it is less than 16
        assertFalse(AbcCollegeApp.validStudentAge(student1.getAge()));
    }



}
