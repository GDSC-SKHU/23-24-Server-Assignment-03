// 서비스// 서비스에서 DTO로 변환할 것.(꼭 이래야 하는 것은 아님. 내가 그렇게 하는 것)
package com.gdsc.soccerapi.service;

import com.gdsc.soccerapi.domain.Player;
import com.gdsc.soccerapi.dto.PlayerDto;
import com.gdsc.soccerapi.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service  // Service layer라는 것을 알려주는 어노테이션
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public void savePlayer(PlayerDto playerDto){// 요청 -> 컨트롤러(@PostMapping) -> 서비스 -> 레포지토리
        Player player = playerDto.toPlayer();  // 저장하기 위해 dto를 도메인으로 전환.
        playerRepository.save(player);
    }

    public PlayerDto findPlayerById(Long id){
        Player player = playerRepository.findById(id);
        return PlayerDto.builder()
                .id(player.getId())
                .name(player.getName())
                .position(player.getPosition())
                .age(player.getAge())
                .preferredFoot(player.getPreferredFoot())
                .height(player.getHeight())
                .build();
    }

    public List<PlayerDto> findAllPlayer(){  // 클라이언트에게 응답을 하기 위해 DTO를 이용. 그래서 반환값으로 DTO값을 넘겨줌
        return playerRepository.findAll()
                .stream()
                .map(Player::toDto) // 플레이어 클래스가 toDto 메서드를 참조하는 메서드 레퍼런스.
                .toList();
    }

    public void delete(Long id){
        playerRepository.deleteById(id);
    }

    public void patch(Long id, PlayerDto playerDto){
        Player player = playerDto.toPlayer();
        playerRepository.updateById(id,player);
    }
}
