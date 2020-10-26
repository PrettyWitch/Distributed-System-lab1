package com.yuhan.lab_1.controller;

import com.yuhan.lab_1.dao.PersonDao;
import com.yuhan.lab_1.domain.Person;
import com.yuhan.lab_1.exception.InvalidRequestException;
import com.yuhan.lab_1.exception.ResourceNoFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;


/**
 * @author yuhan
 * @date 02.10.2020 - 20:19
 * @purpose
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonDao personDao;

    @GetMapping()
    public HttpEntity<?> getAllPerson(){ //HttpEntity其实相当于一个消息实体，用来发送或接收,内容是http传送的报文（这里可以说是html，css等等文件）
        List<Person> personList = personDao.findAll();
        if(personList == null || personList.isEmpty()){
            throw new ResourceNoFoundException("Not Found persons",404);
        }
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> findOnePerson(@PathVariable Integer id){
        return new ResponseEntity<>(personDao.findById(id).orElseThrow(()->
                new ResourceNoFoundException(String.format("Person by id %s not found", id),404)),
                HttpStatus.OK);
    }


    @PostMapping()
    public HttpEntity<Void> addPerson(@Valid @RequestBody Person person, BindingResult bindingResult){
//        int id = person.getId();

        if (bindingResult.hasErrors()) {
            throw new InvalidRequestException("Invalid parameter",400,bindingResult);
        }
        person.setId(null);
        Person p = personDao.save(person);
        int id = p.getId();
//        return new ResponseEntity<Void>(HttpStatus.CREATED);

        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id).toUri()).build();
    }


    @PatchMapping ("/{id}")
    @Modifying(clearAutomatically = true)
    public HttpEntity<?> updatePerson(@PathVariable Integer id, @Valid @RequestBody Person person, BindingResult bindingResult){
        Person exist = personDao.findById(id).orElseThrow(() ->
                new ResourceNoFoundException(String.format("Person by id %s not found", id),404));
        if(bindingResult.hasErrors()){
            throw new InvalidRequestException("Invalid parameter",400,bindingResult);
        }
        person.setId(exist.getId());
        return new ResponseEntity<>(personDao.save(person), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        Person exist = personDao.findById(id).orElseThrow(() ->
                new ResourceNoFoundException(String.format("Person by id %s not found", id),404));
        personDao.deleteById(exist.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
