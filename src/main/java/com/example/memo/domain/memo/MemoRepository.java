package com.example.memo.domain.memo;

import com.example.memo.domain.MemoEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemoRepository {
    @Select("select * from memos")
    List<MemoEntity> findAll();

    @Insert("insert into memos (title, text, edit_time) values (#{title}, #{text}, now())")
    void insert(String title, String text);

    @Select("SELECT id, title, text, edit_time FROM memos WHERE id = #{memoId}")
    MemoEntity findById(@Param("memoId") long id);
}
