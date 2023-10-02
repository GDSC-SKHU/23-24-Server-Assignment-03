package com.gdsc.soccerapi.repository;

import com.gdsc.soccerapi.domain.Player;
import com.gdsc.soccerapi.dto.PlayerDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository   // 아래 클래스가 레포지토리 layer임을 알려주는 어노테이션  // 도메인과 상호작용하는 레이어라고 이해함.
public class ActualizePlayerRepository implements PlayerRepository{ // 인터페이스를 구현했기에 메소드 정의 필요.

private static Map<Long, Player> playerInformation = new HashMap<>();   // 선수 정보 저장을 위한 해쉬맵 선언
private Long sequence = 0L;  // id를 위한 변수 선언 및 초기화
    @Override
    public void save(Player player) { // 선수의 정보를 전달하는 메소드 / 도메인으로 저장함.
        player.initId(++sequence);  // id / 데이터베이스의 autoIncrement 역할
        playerInformation.put(sequence,player);
    }

    @Override
    public Player findById(Long id) {  // playerInformation맵에서 id를 통해 밸류를 찾는 메소드
        return playerInformation.get(id);  // get(key)를 하면 키에 해당하는 밸류를 반환함.
    }

    @Override
    public List<Player> findAll() { // 맵의 밸류들을 스트림 형식으로 바꾸어 리스트 형식으로 반환.
        return playerInformation.values().stream().toList(); //
    }// 맵의 밸류가 도메인을 참조하고 있음으로 리스트 형식도 도메인이 되어야함. DTO로 하면 오류남.

    @Override
    public void deleteById(Long id) { // id(키)를 통해 맵의 밸류를 삭제하는 메소드
        playerInformation.remove(id);
    } // 도메인 값을 삭제하기 위해 id를 받음.

    @Override
    public void updateById(Long id, Player player) {
        playerInformation.put(id,player); // 맵은 id가 같으면 덮어씌워짐. 고로, id는 냅두고 player 값만 변경.
    } // id에 해당하는 도메인 값을 수정해야 하기 떄문에 domain을 받는다.
}
