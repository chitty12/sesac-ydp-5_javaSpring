package sesac.mybatis.sesacmybatis.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.mybatis.sesacmybatis.domain.Board;
import sesac.mybatis.sesacmybatis.dto.BoardDTO;
import sesac.mybatis.sesacmybatis.mapper.BoardMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
  @Autowired
  BoardMapper boardMapper;

  public List<BoardDTO> getAll(){
    // getAll()함수는 "select * from board" sql을 실행하는 친구
    List<Board> result = boardMapper.getAll();
    List<BoardDTO> list = new ArrayList<BoardDTO>();

    for ( Board board : result ) {
      // BoardDTO boardDTO = new BoardDTO();
      BoardDTO boardDTO = BoardDTO.builder()
          .id(board.getId())
          .title(board.getTitle())
          .content(board.getContent())
          .writer(board.getWriter())
          .registered(board.getRegistered())
          .no(board.getWriter() + board.getId())
          .build();
      list.add(boardDTO);
    }

    return list;
  }

  public void insertBoard(Board board) {
    boardMapper.insertBoard(board);
  }

  public void patchBoard(Board board) {
    boardMapper.patchBoard(board);
  }

  public void deleteBoard(int id) {
    boardMapper.deleteBoard(id);
  }

  public int searchBoard(String word) {
//    select sql 문을 이용해서 검색할 때
//  1. select*from board => 검색된 list의 size()
//  2. select count(*) from board;


    // select 문 자체를 count로 동작시킬 수도 있고
    // v List 로 받아와서 그에 대한 길이를 전달할 수도 있다.
    List<Board> result = boardMapper.searchBoard(word);
    return result.size();
  }
}
