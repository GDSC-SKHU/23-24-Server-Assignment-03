// 재벌2세 축구덕후 이승창은 축구팀을 창단했다. 그 이름은 '지면 영입 없음FC'
// 이승창 구단주는 선수들을 영입할 돈이 없어 모집을 하고 있다. 모집 된 선수들의 포지션과 나이, 신장, 주발, 이름을 요청하고 응답받을 수 있는
// API를 만들고자 한다.
// 요청 -> 컨트롤러 -> 서비스 -> 레포지토리 -> 서비스 -> 컨트롤러 -> 응답.
// ★☆레포지토리에서 꺼낼 때는 도메인으로 받아서 서비스로 주고 서비스에서 DTO로 바꿔서 컨트롤러에 넘겨주자.

// 컨트롤러: 직접적으로 클라이언트와 상호작용 하는 레이어
package com.gdsc.soccerapi.controller;

import com.gdsc.soccerapi.domain.Player;
import com.gdsc.soccerapi.dto.PlayerDto;
import com.gdsc.soccerapi.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   //@Controller와 @ResponseBody가 합쳐졌다고 이해. / ResponseBody는 반환값을 JSON형식으로 바꿔줌
public class PlayerController {
    public final PlayerService playerService;
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @PostMapping("players")  //@PostMapping : 내가 이해한 바로는 등록하는 느낌이라고 보면 됨. 등록을 알려주는 어노테이션
    public void enrollPlayer(@RequestBody PlayerDto playerDto){ // 클라이언트의 요청을 받는 부분, 즉 입력을 받는 부분.
        // ★인자로 도메인을 받으면 도메인과 컨트롤러 사이의 의존성 분리가 어려움.★ 이게 가장 중요한 이유!!
//        PlayerDto playerDto = player.toDto(); //인자로 DTO를 받기 때문에 dto로 변환해 줄 필요 없음.
        playerService.savePlayer(playerDto);
    }

    @GetMapping("players/{id}")  // @PathVariable = 사용자가 URI에 변수를 넣을 수 있게 해줌. 즉, id에 값을 넣을 수 있게 해줌.
    public PlayerDto whoIsThePlayer(@PathVariable Long id){
        return playerService.findPlayerById(id);
    }

    @GetMapping("players")  // @GetMapping : 값을 얻어오는 것. 값을 얻어오겠다는 것을 알려주는 어노테이션
    public List<PlayerDto> wantAllPlayer(){
        return playerService.findAllPlayer();
    }
    //클라이언트가 요청한 것을 응답. 그러나 domain을 넘겨주면 보안상의 이유든, 클라에게 원하는 값을 보여주기 위해서 domain을 넘겨주면 안됨.

    // @DeleteMapping : 값을 지우는 것을 알려주는 어노테이션
    @DeleteMapping("players/{id}")   // @PathVariable = 사용자가 URI에 변수를 넣을 수 있게 해줌.
    public void iWantToDelete(@PathVariable Long id){
        playerService.delete(id);
    }

    //@PatchMapping : 값을 수정하겠다는 것을 알려주는 어노테이션.
    @PatchMapping("players/{id}")   // @PathVariable = 사용자가 URI에 변수를 넣을 수 있게 해줌.
    public void iWantToUpdate(@PathVariable Long id, @RequestBody PlayerDto playerDto){
        playerService.patch(id,playerDto);
    }
}
