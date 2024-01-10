package com.example.memo.repository.memo;

import com.example.memo.service.memo.MemoEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemoRepository {
    @Select("select * from memos")
    List<MemoEntity> findAll();

    @Insert("insert into memos (title, text, edit_time) values (#{entity.title}, #{entity.text}, #{entity.edit_time})")
    void insert(@Param("entity") MemoEntity entity);

    @Select("SELECT id, title, text, edit_time FROM memos WHERE id = #{memoId}")
    MemoEntity findById(@Param("memoId") long id);

    @Update("""
            UPDATE memos
            SET
                title     = #{entity.title},
                text      = #{entity.text},
                edit_time =  #{entity.edit_time}
            WHERE id = #{entity.id}
            """)
    void update(@Param("entity") MemoEntity entity);

    @Delete("DELETE FROM memos WHERE id = #{memoId}")
    void delete(@Param("memoId") long memoId);
}
