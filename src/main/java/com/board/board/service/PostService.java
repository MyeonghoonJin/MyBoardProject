package com.board.board.service;

import com.board.board.domain.Enum.BoardType;
import com.board.board.domain.Post;
import com.board.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;


    public List<Post> getPostByBoardType(BoardType boardType){
        List<Post> PostByBoardType = this.postRepository.findByBoardType(boardType);
        return PostByBoardType;
    }

}
