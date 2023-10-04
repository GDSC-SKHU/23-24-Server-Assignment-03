package com.gdsc.assignment3.controller;

import com.gdsc.assignment3.domain.Menu;
import com.gdsc.assignment3.dto.MenuDto;
import com.gdsc.assignment3.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    private final MenuService menuService;

    // 객체가 빈으로 등록되어 있기 때문에 @Autowired 생략 가능
    public MenuController(MenuService menuService){ // MenuService 메소드를 사용하기 위해 의존성 생성자 주입
        this.menuService = menuService;
    }
    @PostMapping("menus") // 메뉴 생성
    public void save(@RequestBody MenuDto menuDto){
        menuService.saveMenu(menuDto);
    }
    @GetMapping("menus/{id}") // id로 메뉴 조회
    public MenuDto findMenuById(@PathVariable Long id){
        return menuService.findMenuById(id);
    }
    @GetMapping("menus/list") // 전체 메뉴 조회
    public List<MenuDto> findAllMenu(){
        return menuService.findAllMenu();
    }

    @PatchMapping("menus/{id}") // 수정
    public void updateMenuById(@PathVariable Long id,@RequestBody MenuDto menuDto){
        menuService.updateMenuById(id, menuDto);
    }

    @DeleteMapping("items/{id}") // 삭제
    public void deleteMenuById(@PathVariable Long id){
        menuService.deleteMenuById(id);
    }

}
