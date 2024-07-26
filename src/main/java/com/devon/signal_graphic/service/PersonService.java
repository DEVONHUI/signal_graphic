package main.java.com.devon.signal_graphic.service;

import main.java.com.devon.signal_graphic.bean.Person;
import main.java.com.devon.signal_graphic.dao.impl.PersonDAO;

import java.util.List;
import java.util.Map;

public class PersonService {
    private final PersonDAO personDAO = new PersonDAO();

    public int save(Person person) {
        return personDAO.save(person);
    }

    public Person findById(Integer id) {
        return personDAO.findById(id);
    }

    public List<Person> findAll() {
        return personDAO.findAll();
    }

    public void update(Integer id, Map<String, Object> updates) { //String是指欄位名稱,Object是指欄位值
        personDAO.update(id, updates);
    }

    public void delete(Integer id) {
//        if (id == 1){
//            System.out.println("不能刪除");
//        } else {
            personDAO.delete(id);
//        }
    }
}
