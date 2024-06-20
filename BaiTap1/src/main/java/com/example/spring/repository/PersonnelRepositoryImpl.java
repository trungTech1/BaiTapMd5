package com.example.spring.repository;

import com.example.spring.model.Personnel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PersonnelRepositoryImpl implements IPersonnelRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Personnel> findAll() {
        // sử dụng hql (hibernate query language) để truy vấn dữ liệu
        return entityManager.createQuery("select c from Personnel c", Personnel.class).getResultList();
    }

    @Override
    public Personnel findById(Integer id) {
        return entityManager.find(Personnel.class, id);
    }

    @Override
    public void save(Personnel customers) {
        if (customers.getId() == null) {
            // chức năng thêm mới thì sẽ không có id nên sẽ check để biết được khi nào là thêm mới hoặc update
            entityManager.persist(customers);
        } else {
            // chức năng chỉnh sửa
            entityManager.merge(customers);
        }
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(findById(id));
    }
}
