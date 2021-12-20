package uz.teda.appOnlineShop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.teda.appOnlineShop.entity.User;
import uz.teda.appOnlineShop.entity.User;

import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("api/v1/Users")
public class UserController {






        private static final List<User> Users= Arrays.asList(
                new User(4,"Sardor  jo'ra  Bobojonov "),
                new User(2,"Odamboy jo'ra Egamberdiyev"),
                new User(3,"Azizbek jo'ra Jumaboyev "),
                new User(1,"Jumaniyozov Nizomjon jo'ra ")

        );


        @GetMapping(path = "/{UserId}")
        public User getUser(@PathVariable Integer UserId){

            return Users.stream().filter(User -> UserId.equals(User.getUserId()))
                    .findAny()
                    .orElseThrow(()->new IllegalStateException("User "+ UserId+" doesn't exist" ));

        }



}
