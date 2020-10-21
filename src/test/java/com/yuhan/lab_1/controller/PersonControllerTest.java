package com.yuhan.lab_1.controller;

import com.yuhan.lab_1.dao.PersonDao;
import com.yuhan.lab_1.domain.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

/**
 * @author yuhan
 * @date 17.10.2020 - 13:03
 * @purpose
 */
@RunWith(MockitoJUnitRunner.class)
class PersonControllerTest {
    @InjectMocks
    private PersonController personController;
    @Mock
    private PersonDao personDao;

    @Before
    public void setUp(){
        //初始化对象的注解
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll() {
        Person p = new Person();
        /* 创建 Mock 对象 */
        PersonDao personDao = mock(PersonDao.class);
        List<Person> t = new ArrayList<Person>();

        //1、get查一下user列表
        /* 设置预期，当调用 findAll() 方法时返回 "t" */
        when(personDao.findAll()).thenReturn(t);
        /* 设置后返回期望的结果 */
        System.out.println(personDao.findAll());
        /* 验证返回结果 */
        List ret = personDao.findAll();
        Assert.assertEquals(ret, t);
    }

    // 2、get id查一下某个person
    @Test
    void findOnePerson() {
        Optional<Person> p = Optional.of(new Person());
        /* 创建 Mock 对象 */
        PersonDao personDao = mock(PersonDao.class);

        // 2、get id查一下某个person
        when(personDao.findById(1)).thenReturn(p);

        /* 设置后返回期望的结果 */
        System.out.println(personDao.findById(1));
        /* 验证返回结果 */
        Optional<Person> ret = personDao.findById(1);
        Assert.assertEquals(ret, p);

    }

    // 3、创建一个person
    @Test
    void addPerson() {
        Person p = new Person();
        /* 创建 Mock 对象 */
        PersonDao personDao = mock(PersonDao.class);

        // 3、创建一个person
        when(personDao.save(p)).thenReturn(p);

        /* 设置后返回期望的结果 */
        System.out.println(personDao.save(p));
        /* 验证返回结果 */
        Person ret = personDao.save(p);
        Assert.assertEquals(ret, p);
    }

    // 4、更新一个person
    @Test
    void updatePerson() {
        Person p = new Person();
        /* 创建 Mock 对象 */
        PersonDao personDao = mock(PersonDao.class);

        // 4、更新一个person
        when(personDao.save(p)).thenReturn(p);
        /* 设置后返回期望的结果 */
        System.out.println(personDao.save(p));
        /* 验证返回结果 */
        Person ret = personDao.save(p);
        Assert.assertEquals(ret, p);

    }

    @Test
    void delete() {
        Person p = new Person();
        /* 创建 Mock 对象 */
        PersonDao personDao = mock(PersonDao.class);

        // 5、删除一个person
        doNothing().when(personDao).deleteById(isA(Integer.class));
        personDao.deleteById(1);

        /* 验证返回结果 */
        verify(personDao, times(1)).deleteById(1);
    }
}