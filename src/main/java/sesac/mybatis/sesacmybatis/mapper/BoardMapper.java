package sesac.mybatis.sesacmybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import sesac.mybatis.sesacmybatis.domain.Board;

import java.util.List;

@Mapper
public interface BoardMapper {
  List<Board> getAll();
  void insertBoard(Board board);
  void patchBoard(Board board);
  void deleteBoard(int id);
  List<Board> searchBoard(String word);
}
