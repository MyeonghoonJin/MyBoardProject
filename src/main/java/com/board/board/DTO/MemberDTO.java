package com.board.board.DTO;



import com.board.board.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDTO {
    private Long num;
    private String id;
    private String pwd;
    private String name;


    public static MemberDTO toMemberDTO(Member member){
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setNum(member.getNum());
        memberDTO.setId(member.getId());
        memberDTO.setPwd(member.getPwd());
        memberDTO.setName(member.getName());

        return memberDTO;
    }
}
