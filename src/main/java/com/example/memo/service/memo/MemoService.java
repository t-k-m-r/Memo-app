package com.example.memo.service.memo;

import com.example.memo.repository.memo.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;
    public List<MemoEntity> findAll() {
        return memoRepository.findAll();
    }

    @Transactional
    public void create(MemoEntity entity) {
        memoRepository.insert(entity);
    }

    public MemoEntity findById(long memoId) {
        return memoRepository.findById(memoId);
    }

    public void update(MemoEntity entity) {
        memoRepository.update(entity);
    }
}
