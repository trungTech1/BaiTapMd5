package com.example.baitap3.repository.impl;

import com.example.baitap3.model.Accounts;
import com.example.baitap3.repository.IAccountRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class AccountRepositoryImpl implements IAccountRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Accounts> findAll() {
        // sử dụng hql (hibernate query language) để truy vấn dữ liệu
        return entityManager.createQuery("select c from Accounts c", Accounts.class).getResultList();
    }

    @Override
    public Accounts findById(Integer id) {
        return entityManager.find(Accounts.class, id);
    }

    @Override
    public void save(Accounts accounts) {
        if (accounts.getId() == null) {
            // chức năng thêm mới thì sẽ không có id nên sẽ check để biết được khi nào là thêm mới hoặc update
            entityManager.persist(accounts);
        } else {
            // chức năng chỉnh sửa
            entityManager.merge(accounts);
        }
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(findById(id));
    }
}