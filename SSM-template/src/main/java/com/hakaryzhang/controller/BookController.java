package com.hakaryzhang.controller;

import com.hakaryzhang.dao.BookDao;
import com.hakaryzhang.domain.Book;
import com.hakaryzhang.exception.SystemException;
import com.hakaryzhang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/test")
    public Result test() {
        return new Result(Code.GET_OK, 1, "test msg");
    }

    @PostMapping("/ex-test/{code}")
    public void exTest(@PathVariable int code) {
        if (code == 1) {
            try {
                int t = 1/0;
            } catch (Exception e) {
                // 交由 ProjectExceptionAdvice 反馈到前端
                throw new SystemException(Code.SYSTEM_ERR, "System error", e);
            }
        }
    }

    // json 格式获取
    @PostMapping()
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR);
    }

    // 路径参数获取
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        String msg = book != null ? "" : "get error";
        return new Result(code, book, msg);
    }

    @GetMapping
    public Result getAll() {
        List<Book> bookList = bookService.getAll();
        Integer code = bookList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bookList != null ? "" : "get error";
        return new Result(code, bookList, msg);
    }

}
