package com.example.springinitializer.Controller;

import com.example.springinitializer.userInfo.UserService;
import com.example.springinitializer.userInfo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomePageController {


    private UserService userService;

    @Autowired
    public HomePageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/homePage")
    public String HomePage(@ModelAttribute("myuser") Users myuser, Model model) {
        System.out.println(myuser.toString());
        return "homePage";
    }

  @PostMapping ("/signup")
    public Users LoginInfo(@RequestBody Users user) {
       return userService.save(user);
    }

    /*@PostMapping ("/signup")
    public String LoginInfo(Users user)
    {
        userService.save(user);
        return "redirect:/usersList";
    }*/

    @GetMapping("/usersList")
    public String getUsers( Model model)
    {
        List<Users> listUsers = userService.listAll();
        System.out.println(listUsers);
        model.addAttribute("listUsers",listUsers);
        return "usersList";
    }
   /* @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUpUser(@ModelAttribute("user") Users user) {
        System.out.println(user.toString());
        userService.save(user);
        return "Login";
    }
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String LoginInfo(@ModelAttribute("Home") Users Home) {
        System.out.println(Home.toString());
        userService.save(Home);
        return "usersList";
    }
    */

    /*@RequestMapping("/Login")
    public String LoginControllers(@ModelAttribute Users login) {
        System.out.println(login.toString());

        return "Login";
    }*/

 /*  @RequestMapping("/submitBtn")
    public String SubmitInfo(@ModelAttribute("Home") Users Home) {
        System.out.println(Home.toString());
        return "UsersList";
    }
*/
   /* @RequestMapping(value="/submitBtn", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password")String password, ModelMap modelMap){
        Users users = userService.findByUsername(username);
        if(users.getUsername().equals(username)){
            return "UsersList";
        }
        else{
            modelMap.addAttribute("msg", "Invalid Username or Password. Please try again");
        }
        return "Login";
    }*/

}
