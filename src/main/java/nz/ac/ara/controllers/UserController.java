package nz.ac.ara.controllers;

import nz.ac.ara.models.User;
import nz.ac.ara.models.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/user")
public class UserController {

  @Autowired
  private UserDao _userDao;
  
  @RequestMapping(value="/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      User user = new User(id);
      _userDao.delete(user);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully deleted!";
  }
  
  @RequestMapping(value="/get-by-email", method=RequestMethod.GET)
  public @ResponseBody User getByEmail(String email) {
    User user = null;
    try {
      user = _userDao.getByEmail(email);
      //userId = String.valueOf(user.getId());
    }
    catch(Exception ex) {
      return user;
    }
    return user;
  }

  @RequestMapping(value="/save")
  @ResponseBody
  public String create(String email, String name) {
    try {
      User user = new User(email, name);
      _userDao.save(user);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully saved!";
  }

} // class UserController
