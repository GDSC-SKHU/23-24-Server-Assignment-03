// DTO : 내가 이해한 바: 데이터 전달을 위한 매개체, 즉 내 맘대로 전해주고 싶은 필드 설정 가능.
// 입맛에 따라 변경 가능.

package com.gdsc.soccerapi.dto;

import com.gdsc.soccerapi.domain.Player;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data  // 이 어노테이션을 사용하면, Getter, Setter, equals(), hashcode(), toString() 메소드 자동 생성.
public class PlayerDto {
    private Long id; // 구분을 위한 id/ 데이터베이스의 프라이머리키 느낌.
    private String name;  // 선수의 이름
    private String position; // 선수의 포지션
    private Integer age;  // 선수의 나이
    private String preferredFoot; // 선수의 주발
    private Integer height; // 선수의 키

    @Builder
    public PlayerDto(Long id, String name, String position, Integer age, String preferredFoot,Integer height){
        this.id = id;
        this.name = name;
        this.position = position;
        this.age = age;
        this.preferredFoot = preferredFoot;
        this.height = height;
    } // 의존성 생성자.
    public Player toPlayer(){   // DTO를 domain으로 변환하기 위한 메소드 선언 및 구현
        return Player.builder()
                .id(id)
                .name(name)
                .position(position)
                .age(age)
                .preferredFoot(preferredFoot)
                .height(height)
                .build();
    }

}
