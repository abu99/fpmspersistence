/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aabello
 */
@Local
public interface UserEntityMngrLocal {
    
    public User create(User user);
    public User update(User user);
    public void delete(String userId);
    public User get(String userId);
    public List<User> getAll();
    public int count();
    
    
    
}
