package com.temquare.base.dao;

import com.temquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2019/5/22.
 */
public interface LabelDao extends JpaRepository<Label,String>,JpaSpecificationExecutor<Label>{
}
