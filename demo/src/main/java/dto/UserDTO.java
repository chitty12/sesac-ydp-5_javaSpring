package dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder // 객체를 생성하는 방법 중 하나
//1) set 함수를 이용하는 방법
//2) 생성자에 주입하는 방법
// 필드가 여러개면 생성자를 통한 필드값 주입을 이용하면 가독성 x
// 순서를 명확하게 넣기 어려워짐.
public class UserDTO {
    private int id;
    private String name, nickname;
    private int no;
}
