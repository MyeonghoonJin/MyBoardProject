package com.board.board.domain;

import com.board.board.domain.Enum.BoardType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name="Post")
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Post_num;                              //게시글 번호  (PK)

    private LocalDate Post_date;                        //작성 날짜

    private LocalTime Post_time;                        //작성 시간

    @Column(length = 25)
    private String Post_title;                          //게시글 제목

    @Column(columnDefinition = "TEXT")
    private String Post_content;                        //게시글 내용

    @ColumnDefault("0")
    private Long Post_count;                            //조회수

    @Enumerated(EnumType.STRING)
    private BoardType boardType;                        //게시판 종류

    @ManyToOne(cascade = CascadeType.ALL)               //Member엔티티에서 Post엔티티로 , 회원 1명에 N개의 게시글
    @JoinColumn(name = "Member_name")
    Member member_domain;                               //작성자(회원) 이름

    public Post() {
    }
}