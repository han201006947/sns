package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{

    /*SELECT * FROM tb_problem where id in (SELECT problemid from tb_pl WHERE labelid =1)*/
    @Query(value = "SELECT * FROM tb_problem ,tb_pl where id = problemid and labelid =? ORDER BY replytime desc",nativeQuery = true)
	public Page<Problem> newList(String labelid, Pageable pageable);

    @Query(value = "SELECT * FROM tb_problem ,tb_pl where id = problemid and labelid =? ORDER BY reply desc",nativeQuery = true)
    public Page<Problem> hotList(String labelid, Pageable pageable);

    @Query(value = "SELECT * FROM tb_problem ,tb_pl where id = problemid and labelid =? and reply = 0 ORDER BY createtime desc",nativeQuery = true)
    public Page<Problem> waitList(String labelid, Pageable pageable);
}
