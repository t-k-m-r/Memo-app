package com.example.memo.domain.memo;

import com.example.memo.domain.MemoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;
    public List<MemoEntity> findAll() {
        return memoRepository.findAll();
    }
}
