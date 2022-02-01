package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class CRUDController {

    private UserService userService;

    @GetMapping()
    public String getAll(ModelMap model){
        model.addAttribute("users",userService.getAllUser());
        return "users/AllUsers";
    }

    @GetMapping("/{id}")
    public String getUserById(Model model, @PathVariable("id") long id){
        model.addAttribute("user", userService.getUser(id));
            return "users/oneById";
    }
    @GetMapping("/new")
    public String newUserForm(Model model){
        model.addAttribute("user", new User());
        return "users/newForm";
    }
    @GetMapping("/{id}/edit")
    public String editUserForm(Model model, @PathVariable("id") long id){
        model.addAttribute("user", userService.getUser(id));
        return "users/edit";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "users/newForm";
        userService.saveUser(user);
        return "redirect:/users";
    }
    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "users/edit";
        userService.updateUser(user);
        return "redirect:/users";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@ModelAttribute("user") User user){
        userService.deleteUser(user);
        return "redirect:/users";
    }

    public CRUDController(UserService userService) {
        this.userService = userService;
    }
}
