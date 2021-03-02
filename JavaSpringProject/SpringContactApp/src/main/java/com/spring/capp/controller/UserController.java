package com.spring.capp.controller;

import com.spring.capp.command.LoginCommand;
import com.spring.capp.command.UserCommand;
import com.spring.capp.domain.User;
import com.spring.capp.exception.UserBlockedException;
import com.spring.capp.service.UserService;
import javax.servlet.http.HttpSession;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Zahra
 */

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/", "/index"})
    public String index(Model m) {//you need to bind your command then it is accessible in jsp page
        m.addAttribute("command", new LoginCommand());//now it is accessible in jsp page
        return "index";//JSP  -/WEB-INF/view/indes.jsp
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
        try {//Model accessible in the form
            User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());
            if (loggedInUser == null) {
                m.addAttribute("err", "Login Failed! Enter valid credential.");
                return "index";//JSP  -/WEB-INF/view/indes.jsp

            } else {
                //SUCCESS
                //Check the role and redirect to a appropriate dashboard
                if (loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
                    addUserInSession(loggedInUser, session);
                    return "redirect:admin/dashboard";
                } else if (loggedInUser.getRole().equals(UserService.ROLE_USER)) {
                    addUserInSession(loggedInUser, session);
                    return "redirect:user/dashboard";
                } else {
                    //add error message and go back to login-form
                    m.addAttribute("err", "Invalid User ROLE");
                    return "index";
                }
            }
        } catch (UserBlockedException ex) {
            m.addAttribute("err", ex.getMessage());
            return "index";//JSP  -/WEB-INF/view/index.jsp
        }
    }
    
     @RequestMapping(value = {"/logout"})
    public String logout(HttpSession session) {
        session.invalidate();//you have to terminate user session
        return "redirect:index?act=lo";//JSP  -/WEB-INF/view/index.jsp
    }

    @RequestMapping(value = {"user/dashboard"})
    public String userDashbord() {
        return "dashboard_user";//JSP  -/WEB-INF/view/index.jsp
    }

    @RequestMapping(value = {"admin/dashboard"})
    public String adminDashbord() {
        return "dashboard_admin";//JSP  -/WEB-INF/view/index.jsp
    }
    
     @RequestMapping(value = {"admin/users"})
    public String getUserList(Model m) {
        m.addAttribute("userList",userService.getUserList());
        
        return "users";//JSP  -/WEB-INF/view/index.jsp
    }
    
    
    @RequestMapping(value="/reg_form")//registration form
    public String registrationForm(Model m){
        UserCommand cmd=new UserCommand();
        m.addAttribute("command",cmd);
         return "reg_form";//JSP
    }

     @RequestMapping(value="/register")//registration form
    public String registerUser(@ModelAttribute("command")UserCommand cmd,Model m){
        
         try {
             User user = cmd.getUser();
             user.setRole(UserService.ROLE_USER);
             user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
             userService.register(user);
             return "redirect:index?act=reg";//login Page
         } catch (DuplicateKeyException e) {
             e.printStackTrace();
             m.addAttribute("err","Username is already registered.Please select another username.");
             return "reg_form";//JSP
         }
    }
    private void addUserInSession(User u, HttpSession session) {
        session.setAttribute("user", u);
        session.setAttribute("userId", u.getUserId());
        session.setAttribute("role", u.getRole());
    }

    
     @RequestMapping(value="/admin/change_status")//change status by admin
     @ResponseBody
    public String changeLoginStatus(@RequestParam Integer userId,@RequestParam Integer loginStatus){
         try {
             userService.changeLoginStatus(userId, loginStatus);
             return "SUCCESS:Status Changed";
         } catch (Exception e) {
           e.printStackTrace();
           return "ERROR:Unable to change status";
         }
    }
    
    @RequestMapping(value="/check_avail")//user Availability
     @ResponseBody
    public String checkAvailability(@RequestParam String username){
      if(userService.isUsernameExist(username)){
          return "This username is already taken.choose another name";
      }else{
          return "Yes! You can take this";
      }
        
    }
}
