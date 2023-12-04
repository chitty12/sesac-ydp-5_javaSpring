package sesac.mybatis.sesacmybatis.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardDTO {
  private String no;
  private int id;
  private String title;
  private String content;
  private String writer;
  private String registered;
}
