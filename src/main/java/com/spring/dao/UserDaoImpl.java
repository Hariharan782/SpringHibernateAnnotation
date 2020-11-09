package com.spring.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.spring.model.User;
 
@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao{
 
    public void saveUser(User usr) {
        persist(usr);
    }
 
    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = getSession().createCriteria(User.class);
        return (List<User>) criteria.list();
    }
 
    public void deleteUserById(int id) {
        Query query = getSession().createSQLQuery("delete from User where userId = :userId");
        query.setInteger("userId", id);
        query.executeUpdate();
    }
 
     
    public User findById(int id){
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("userId",id));
        return (User) criteria.uniqueResult();
    }
     
    public void updateUser(User usr){
        getSession().update(usr);
    }
}