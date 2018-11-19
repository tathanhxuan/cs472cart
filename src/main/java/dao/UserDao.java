package dao;

import domain.User;
import java.util.*;

public class UserDao {
  private Map<String, User> usersDB = new HashMap<>();
  {
    usersDB.put("tta@mum.edu", new User(1,"tta@mum.edu","123", "Thanh Xuan Ta", "5154438935", "1000 N 4th"));
    usersDB.put("taxuanus@gmail.com", new User(2,"taxuanus@gmail.com","1234", "Thanh Xuan", "5154438936", "2000 N 4th"));
  }

  public boolean checkExistUser(String email, String password){
    if(usersDB.containsKey(email) && usersDB.get(email).getPassword().equals(password)){
      return true;
    }
    return false;
  }
  public User getUserByEmail(String email){
      return usersDB.get(email);
  }
  public User getUser(String email){
    return usersDB.get(email);
  }
  public boolean checkExistEmail(String email){
    if (usersDB.containsKey(email)){
      return true;
    }
    return false;
  }
  public int getMaxID(){
    return usersDB.entrySet().stream().max((entry1, entry2) -> entry1.getValue().getId() > entry2.getValue().getId() ? 1 : -1).get().getValue().getId();
  }
  public boolean addUser(String email, String pw,String fullname,String telephone,String address)
  {
    if (checkExistEmail(email)) {
      return false;
    }
    else {
      int newId = getMaxID() + 1;
      usersDB.put(email,new User(newId,email, pw, fullname, telephone, address));
      return true;
    }
  }

  public List<User> getUsersDB(){
    return new ArrayList<User>(usersDB.values());
  }
}
