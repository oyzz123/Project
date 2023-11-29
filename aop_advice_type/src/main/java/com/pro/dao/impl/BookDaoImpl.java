package com.pro.dao.impl;

import com.pro.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public int select() {
        System.out.println("BookDao select...");
        return 100;
    }

    @Override
    public void update() {
        System.out.println("BookDao update ...");
    }
}
