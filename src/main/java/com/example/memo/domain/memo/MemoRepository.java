package com.example.memo.domain.memo;

import com.example.memo.domain.MemoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemoRepository {
    @Select("select * from memos")
    List<MemoEntity> findAll();
}
