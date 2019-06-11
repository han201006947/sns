package com.temquare.base.service;

import com.temquare.base.dao.LabelDao;
import com.temquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/22.
 */
@Service
@Transactional
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll() {
        return labelDao.findAll();
    }

    public Label findId(String labelId) {
        return labelDao.findById(labelId).get();
    }

    public void save(Label label) {
        label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    public void update(Label label) {
        labelDao.save(label);
    }

    public void delete(String id) {
        labelDao.deleteById(id);
    }

    public List<Label> findSearch(Label label) {
       return labelDao.findAll(new Specification<Label>() {
           /**
            *
            * @param root 根对象，也就是要把条件封装到那个对象中，where类名=label.getid
            * @param query 封装的都是查询关键字，比如group by、order by
            * @param cb 用来封装条件对象的，如果直接返回null，表示不需要任何条件
            * @return
            */
           @Override
           public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
               //new一个list集合存放左右的条件
               List<Predicate> list = new ArrayList<>();
               if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                   Predicate predicate = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                   list.add(predicate);
               }

               if (label.getState() != null && !"".equals(label.getState())) {
                   Predicate predicate = cb.equal(root.get("state").as(String.class), label.getState());
                   list.add(predicate);
               }
               //new 一个数组作为最终返回值的条件
               Predicate[] parr = new Predicate[list.size()];
               list.toArray(parr);
               return cb.and(parr);
           }
        });
    }

    public Page<Label> pageQuery(Label label, Integer page, Integer size) {
        //封装分页对象
        Pageable pageable = PageRequest.of(page-1,size);
        return labelDao.findAll(new Specification<Label>() {
            /**
             *
             * @param root 根对象，也就是要把条件封装到那个对象中，where类名=label.getid
             * @param query 封装的都是查询关键字，比如group by、order by
             * @param cb 用来封装条件对象的，如果直接返回null，表示不需要任何条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //new一个list集合存放左右的条件
                List<Predicate> list = new ArrayList<>();
                if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                    Predicate predicate = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    list.add(predicate);
                }

                if (label.getState() != null && !"".equals(label.getState())) {
                    Predicate predicate = cb.equal(root.get("state").as(String.class), label.getState());
                    list.add(predicate);
                }

                //new 一个数组作为最终返回值的条件
                Predicate[] parr = new Predicate[list.size()];
                list.toArray(parr);
                return cb.and(parr);
            }
        }, pageable);
    }
}