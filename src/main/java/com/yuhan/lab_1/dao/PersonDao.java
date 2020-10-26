package com.yuhan.lab_1.dao;

import com.yuhan.lab_1.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yuhan
 * @date 03.10.2020 - 18:58
 * @purpose
 *
 * Person 资源
 */
@Repository
public interface PersonDao extends JpaRepository<Person, Integer> {


}
