package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    //p74 gradle 다운그레이드 필요
    //alt+F12(터미널 open)에서
    //gradlew wrapper --gradle-version 4.10.2 실행
    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        //assertThat : assertj라는 테스트 검증 라이브러리의 검증 메소드입니다.
        //검증하고 싶은 대상을 메소드 인자로 받습니다ㅏㅏ.
        //메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용할 수 있습니다.
        //isEqualTo : assertj의 동등 비교 메소드입니다.
        //assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공입니다.
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}
