package com.example.application2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository2 extends JpaRepository<UserEntity2, Integer> {

  @Query(
    value = "SELECT * FROM user ORDER BY id DESC", //←SQL文
    nativeQuery = true //直接SQLを実行する機能
  )
  public List<UserEntity2> findAllOrderByIdDesc(); //idを降順で表示させる
}