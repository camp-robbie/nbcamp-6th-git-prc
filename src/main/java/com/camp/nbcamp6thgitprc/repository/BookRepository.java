package com.camp.nbcamp6thgitprc.repository;

import com.camp.nbcamp6thgitprc.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
// 커스텀 메서드 필요 시 추가
}