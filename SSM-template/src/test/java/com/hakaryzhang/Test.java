package com.hakaryzhang;

import com.hakaryzhang.config.SpringConfig;
import com.hakaryzhang.dao.BookDao;
import com.hakaryzhang.domain.Book;
import com.hakaryzhang.service.BookService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class Test {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookDao bookDao;

    @org.junit.Test
    public void testFindById() {
        System.out.println(bookDao.getById(3));
    }

    @org.junit.Test
    public void testInsert() {
        Book book = new Book();
        book.setId(3);
        book.setTitle("abc");
        bookDao.save(book);
        System.out.println();
    }
}
