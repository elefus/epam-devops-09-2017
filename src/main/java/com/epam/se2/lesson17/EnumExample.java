package com.epam.se2.lesson17;

public class EnumExample {

    public static void main(String[] args) {
        Direction.FORWARD.opposite();
        Direction.BACKWARD.opposite();


        System.out.println(Gender.FEMALE);

        System.out.println(Gender.MALE.getComment());
        Gender.MALE.setComment("some comment");
        System.out.println(Gender.MALE.getComment());

        System.out.println(Gender.MALE);

        Gender male = Gender.valueOf("MALE");
        Gender unknown = Gender.valueOf("UNKNOWN");

        Gender[] values = Gender.values();
        Class<Gender> enumType = Gender.class;
        Gender female = Enum.valueOf(enumType, "FEMALE");


        Gender gender = Gender.FEMALE;
        switch (gender) {
            case MALE:
                System.out.println("I'm male");
                break;

            case FEMALE:
                System.out.println("I'm female");
                break;
        }
        System.out.println(Gender.MALE.getGreetings());
        System.out.println(Gender.FEMALE.getGreetings());

    }
}


enum Gender {
    MALE("MR.") {
        @Override
        public void greetings() {
            System.out.println("I'm " + getGreetings());
        }

        @Override
        public String toString() {
            return "123";
        }
    },
    FEMALE("MRS.") {
        @Override
        public void greetings() {
            System.out.println("...");
        }
    };

    private final String greetings;
    private String comment;

    Gender(String greetings) {
        this.greetings = greetings;
    }

    public String getGreetings() {
        return greetings;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public abstract void greetings();

    public static void method() {

    }
}

enum Direction {
    FORWARD {
        public void method() {
            opposite();
        }

        public Direction opposite() {
            return BACKWARD;
        }
    },
    BACKWARD {
        @Override
        public Direction opposite() {
            return null;
        }
    };

    public abstract Direction opposite();
}