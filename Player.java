

package com.gdsc.soccerapi.domain;

import com.gdsc.soccerapi.dto.PlayerDto;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Player {
    private Long id; // 구분을 위한 id/ 데이터베이스의 프라이머리키 느낌.
    private String name;  // 선수의 이름
    private String position; // 선수의 포지션
    private Integer age;  // 선수의 나이
    private String preferredFoot; // 선수의 주발
    private Integer height; // 선수의 키

@Builder
    public Player(Long id, String name, String position, Integer age, String preferredFoot,Integer height){
        this.id = id;
        this.name = name;
        this.position = position;
        this.age = age;
        this.preferredFoot = preferredFoot;
        this.height = height;
    }
    public void initId(Long id){
        this.id = id;
    }

    public PlayerDto toDto(){  // 도메인의 값을 DTO로 전환하기 위한 메소드 생성 및 구현
        return PlayerDto.builder()
                .id(id)
                .name(name)
                .position(position)
                .age(age)
                .preferredFoot(preferredFoot)
                .height(height)
                .build();

    }
    public int sortAge(){
    return age;
    } // 나이 순으로 정렬하기 위한 인트 반환형 메소드
}
