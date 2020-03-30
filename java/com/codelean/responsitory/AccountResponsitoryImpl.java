package com.codelean.responsitory;

import com.codelean.model.Account;
import com.codelean.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class AccountResponsitoryImpl implements AccountResponsitory {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Account findByUsernameAndPassword(String user, String pass) {
        try {
            String query = "Select c from Account c where c.userName = :user and c.passWord = :pass";
            TypedQuery<Account> accountTypedQuery=entityManager.createQuery(query.toString(),Account.class);
            accountTypedQuery.setParameter("user",user);
            accountTypedQuery.setParameter("pass",pass);
            return accountTypedQuery.getSingleResult();
        }
        catch (NoResultException nre){
            return null;
        }
    }
//    @Override
//    public List<Post> findAllPostByTrangThai() {
//        String query = "Select c from Post c where c.status = :status";
//        TypedQuery<Post> BaiVietTypedQuery=entityManager.createQuery(query.toString(),Post.class);
//        BaiVietTypedQuery.setParameter("trangThai",true);
//        return BaiVietTypedQuery.getResultList();
//    }



    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Account findById(Long id) {
        return null;
    }

    @Override
    public void save(Account model) {
        entityManager.persist(model);

    }

    @Override
    public void remove(Account id) {

    }

    @Override
    public void update(Long id, Account model) {

    }




}
