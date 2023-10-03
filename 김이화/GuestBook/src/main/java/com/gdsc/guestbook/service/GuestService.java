package com.gdsc.guestbook.service;

import com.gdsc.guestbook.domain.Guest;
import com.gdsc.guestbook.dto.GuestDto;
import com.gdsc.guestbook.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    // 의존성 생성자 주입
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    //@Builder 사용하여 Service 코드 간결
    public void insertGuest(GuestDto guestDto) {
        Guest guest = Guest.builder()
                .name(guestDto.getName())
                .regdate(guestDto.getRegdate())
                .build();

        guestRepository.insert(guest); // guestRepository를 통해 guest 객체 등록
    }

    public GuestDto findGuestById(Long id) {
        Guest guest = guestRepository.findById(id); // guestRepository를 통해 id에 해당하는 guest 객체를 찾아서 반환

        return GuestDto.builder()
                .id(guest.getId())
                .name(guest.getName())
                .regdate(guest.getRegdate())
                .build(); //guestDto 반환
    }

    public List<GuestDto> findAllGuest() {
        return guestRepository.findAll()
                .stream()
                .map(guest -> GuestDto.builder()
                            .id(guest.getId())
                            .name(guest.getName())
                            .regdate(guest.getRegdate())
                            .build())
                .toList(); // guestRepository를 통해 모든 guest 객체를 찾아서 반환
    }

    public void updateGuestById(Long id, GuestDto guestDto) {
        Guest findGuest = guestRepository.findById(id); // guestRepository를 통해 id에 해당하는 guest 객체를 찾아서 반환
        findGuest.updateGuest(guestDto.getName(), guestDto.getRegdate()); // key값은 새로 덮어씌어지기 때문에 guest 객체의 내용만 수정

        guestRepository.updateById(id, findGuest); //guestRepository를 통해 id에 해당하는 guest 객체를 찾아서 내용을 수정
    }

    public void deleteGuestById(Long id) {
        guestRepository.deleteById(id); //guestRepository를 통해 id에 해당하는 guest 객체를 찾아서 삭제
    }
}
