package com.gdsc.soccerapi.repository;

import com.gdsc.soccerapi.domain.Player;

import java.util.List;

public interface PlayerRepository { // 인터페이스
    void save(Player player);  // 선수를 데이터베이스에 저장할 것이기 때문에, 반환값 없음, 도메인을 넘겨줌.
    Player findById(Long id);  // id를 가지고 선수를 찾을 예정.
    List<Player> findAll(); // 데이터베이스에 있는 모든 선수를 리스트 형태로 표현할 것임.
    void updateById(Long id, Player player); // 데이터를 해쉬맵 형태로 저장할 것이기 때문에, 인자로 id와 player객체를 넘김.
    void deleteById(Long id);  // id를 가지고 데이터를 삭제할 것.
}
