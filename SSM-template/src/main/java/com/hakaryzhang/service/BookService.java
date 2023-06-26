package com.hakaryzhang.service;

import com.hakaryzhang.dao.BookDao;
import com.hakaryzhang.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookService {

    /**
     * save book
     * @param book
     * @return
     */
    public boolean save(Book book);

    public Book getById(Integer id);

    public List<Book> getAll();
}
