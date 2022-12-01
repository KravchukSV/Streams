package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        userList.add(new User("Sam", 22));
        userList.add(new User("Jon", 41));
        userList.add(new User("Ana", 31));
        userList.add(new User("Will", 45));
        userList.add(new User("Adam", 23));
        userList.add(new User("Mia", 27));
        userList.add(new User("Kate", 20));

        List<String> userName = userList.stream()                                     //отримання потоку даних
                                        .filter(x -> x.getAge() < 40)                 //користувачі молодше 40
                                        .sorted(Comparator.comparing(User::getName))  //сортування за іменем
                                        .limit(3)                              //перші 3 користувачі
                                        .map(x -> x.getName())                        //перетворення в Stream<String>
                                        .toList();                                    //перетворення в List<String>

        userName.forEach(System.out::println);
    }
}