package com.board.board.DTO;


import com.board.board.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import com.board.board.domain.Post;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostDTO {

    private Long Post_num;                              //게시글 번호  (PK)
    private LocalDate Post_date;                        //작성 날짜
    private LocalTime Post_time;                        //작성 시간
    private String Post_title;                          //게시글 제목
    private String Post_content;                        //게시글 내용
    private Long Post_count;                            //게시글 조회수
    private Member member_domain;
    public static PostDTO toPostDTO(Post post_domain){
        PostDTO postDTO = new PostDTO();

        postDTO.setPost_content(post_domain.getPost_content());
        postDTO.setPost_num(post_domain.getPost_num());
        postDTO.setPost_title(post_domain.getPost_title());
        postDTO.setPost_content(post_domain.getPost_content());
        postDTO.setPost_date(post_domain.getPost_date());
        postDTO.setPost_time(post_domain.getPost_time());
//        postDTO.setMember_domain(post_domain.getMember_domain())

        return postDTO;
    }
}
