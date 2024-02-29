package com.board.board.DTO;


import com.board.board.domain.Member;
import com.board.board.domain.Post;
import com.board.board.domain.Reply;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReplyDTO {
    private Long Reply_num;
    private LocalDate Reply_date;
    private LocalTime Reply_time;
    private String Reply_content;
    private Member member_domain;
    private Post post_domain;

    public static ReplyDTO toReplyDTO(Reply reply_domain){
        ReplyDTO replyDTO = new ReplyDTO();

        replyDTO.setReply_num(reply_domain.getReply_num());
        replyDTO.setReply_date(reply_domain.getReply_date());
        replyDTO.setReply_time(reply_domain.getReply_time());
        replyDTO.setReply_content(reply_domain.getReply_content());
//        replyDTO.setPost_domain(reply_domain.getPost_domain());
//        replyDTO.setMember_domain(reply_domain.getMember_domain());

        return replyDTO;
    }
}
