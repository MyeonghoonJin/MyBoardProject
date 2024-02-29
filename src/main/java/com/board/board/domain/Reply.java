package com.board.board.domain;

import com.board.board.domain.Enum.BoardType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name="Reply")
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Reply_num;

    private LocalDate Reply_date;
    private LocalTime Reply_time;

    @Column(length = 200)
    private String Reply_content;

    @ManyToOne(cascade = CascadeType.ALL)   //작성자 1명에 N개의 댓글, (작성자가 사라지면 댓글도 사라짐?)
    @JoinColumn(name = "Member_name")
    private Member member_domain;

    @ManyToOne(cascade = CascadeType.ALL)    //한 사람에게 여러개의 댓글이 가능
    @JoinColumn(name = "Post_num")
    private Post post_domain;
    
    @Enumerated(EnumType.STRING)           //Post_domain에서 찾아볼 수 있지 않을까?
    private BoardType boardType;

    public Reply() {

    }
}