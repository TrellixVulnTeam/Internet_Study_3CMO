package com.example.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App2 {
    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", true));

        List<List<OnlineClass>> junhanEvents = new ArrayList<>();
        junhanEvents.add(springClasses);
        junhanEvents.add(javaClasses);

        System.out.println("spring 으로 시작하는 수업의 ID");
        springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .forEach(oc -> System.out.println(oc.getId()));
        /**
         * spring 으로 시작하는 수업의 ID
         * 1
         * 2
         * 3
         * 4
         */

        System.out.println("close 되지 않은 수업");
        springClasses.stream()
//                .filter(oc -> !oc.isClosed())
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(oc -> System.out.println(oc.getId()));
        /**
         * 3
         * 4
         * 5
         */

        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream()
//                .map(oc -> oc.getTitle())
                .map(OnlineClass::getTitle)
//                .forEach(s -> System.out.println(s));
                .forEach(System.out::println);
        /**
         * spring boot
         * spring data jpa
         * spring mvc
         * spring core
         * rest api development
         */

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        junhanEvents.stream()
                .flatMap(list -> list.stream())
                .forEach(oc -> System.out.println(oc.getId()));
        /**
         * 1
         * 2
         * 3
         * 4
         * 5
         * 6
         * 7
         * 8
         */

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);
        /**
         * 20
         * 21
         * 22
         * 23
         * 24
         * 25
         * 26
         * 27
         * 28
         * 29
         */

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean test = javaClasses.stream()
                .anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println(test);
        // true

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기");
        List<String> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().contains("spring"))
                .map(oc -> oc.getTitle())
                .collect(Collectors.toList());
        spring.forEach(System.out::println);
        /**
         * spring boot
         * spring data jpa
         * spring mvc
         * spring core
         */

    }
}
