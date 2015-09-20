package com.mviniciuspimenta.marketshoppinglist.database;

import java.util.List;

/**
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 17/09/15 16:25
 */
public interface DBControler<T> {

    void insert(T t);

    void delete(T t);

    void update(T t);

    List<T> selectAll();

    void deleteAll();

}
