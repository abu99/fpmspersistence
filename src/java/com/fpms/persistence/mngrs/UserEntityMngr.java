/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.User;
import com.fpms.util.crud.CrudServiceProviderLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author aabello
 */
@Stateless
public class UserEntityMngr implements UserEntityMngrLocal{
    
    @EJB
    private CrudServiceProviderLocal crudServiceProvider;

    @Override
    public User create(User user) {
        return crudServiceProvider.create(user);
    }

    @Override
    public User update(User user) {
        return crudServiceProvider.update(user);
    }

    @Override
    public void delete(String userId) {
        User user = get(userId);
        crudServiceProvider.delete(user);
    }

    @Override
    public User get(String userId) {
       return crudServiceProvider.find(userId, User.class);
    }

    @Override
    public List<User> getAll() {
        return crudServiceProvider.findByNamedQuery("User.findAll", User.class);
    }

    @Override
    public int count() {
        return getAll().size();
    }
    
    
    
}
