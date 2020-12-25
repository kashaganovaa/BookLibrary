package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByName(String name);

    @Modifying// to mark delete or update query
    @Query(value = "DELETE FROM Book b WHERE b.name = :name")// it will delete all the record with specific name
    void deleteByName(@Param("name") String name);
}