package com.gdsc.assignment3.service;

import com.gdsc.assignment3.domain.Menu;
import com.gdsc.assignment3.dto.MenuDto;
import com.gdsc.assignment3.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 스프링 빈 등록
public class MenuService {

    private final MenuRepository menuRepository;

    // 객체가 빈으로 등록되어 있기 때문에 @Autowired 생략 가능
    public MenuService(MenuRepository menuRepository){ //  MenuRepository 메소드를 사용하기 위해 인터페이스 의존성 생성자 주입
        this.menuRepository = menuRepository;
    }



    public void saveMenu(MenuDto menuDto) { // menu를 저장하는 메소드
        Menu menu = Menu.builder()
                .menuname(menuDto.getMenuname())
                .custname(menuDto.getCustname())
                .build();

        menuRepository.save(menu); // menuRepository를 통해 menu를 저장
    }

    public MenuDto findMenuById(Long id) { // menuRepository를 통해 id에 해당하는 menu를 찾아서 반환하는 메소드
        Menu menu = menuRepository.findById(id); // menuRepository를 통해 id에 해당하는 menu를 찾아서 반환

       return MenuDto.builder()
               .id(menu.getId())
               .menuname(menu.getMenuname())
               .custname(menu.getCustname())
               .build(); // menuDto 반환

    }

    public List<MenuDto> findAllMenu() { // 모든 menu를 반환하는 메소드
        return menuRepository.findAll()
                .stream()
                .map(menu ->  MenuDto.builder()
                        .id(menu.getId())
                        .menuname(menu.getMenuname())
                        .custname(menu.getCustname())
                        .build())
                .toList(); // menuRepository를 통해 모든 menu를 찾아서 반환

    }
    public void updateMenuById(Long id, MenuDto menuDto){ // id를 통해 menu를 업데이트하는 메소드
        Menu findMenu = menuRepository.findById(id); // menuRepository를 통해 id에 해당하는 menu를 찾아서 반환
        findMenu.updateMenu(menuDto.getMenuname(), menuDto.getCustname()); // menu의 내용을 수정

        menuRepository.updateById(id,findMenu); // menuRepository를 통해 id에 해당하는 menu를 찾아서 내용을 수정

    }
    public void deleteMenuById(Long id){
        menuRepository.deleteById(id); // menuRepository를 통헤 id에 해당하는 menu를 찾아서 삭제
    }
}

