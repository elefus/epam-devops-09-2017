package com.epam.se1.lesson13;

public class CourseHelperExample {

    public static void main(String[] args) {
//        CourseFactory courseFactory = new CourseFactory();
//
//        Course course1 = courseFactory.createCourse();
//        Course course2 = courseFactory.createCourse();
//
//        CourseFactory factory = new EnglishCourseFactory();
//        EnglishCourse englishCourse = (EnglishCourse) factory.createCourse();


        Integer value = new Integer(1);
//        value = (Integer) "123";
        Number number = value;
        Object object = number;

        Number anotherNumber = (Number) object;
        if (anotherNumber instanceof Integer) {
            System.out.println("Yes I'm integer");
        }

        if (anotherNumber instanceof Number) {
            System.out.println("Yes I'm number");
        }

        Integer intValue = (Integer) anotherNumber;
        if (anotherNumber instanceof Long) {
            Long longValue = (Long) anotherNumber;
        }

//        String str = (String)intValue;
    }
}

class Course {
    private int cost;
    private int hours;
}

class EnglishCourse extends Course {
    private int level;
}

class CourseFactory {

    public Course createCourse() {
        return new Course();
    }
}

class EnglishCourseFactory extends CourseFactory {

    @Override
    public EnglishCourse createCourse() {
        return new EnglishCourse();
    }
}