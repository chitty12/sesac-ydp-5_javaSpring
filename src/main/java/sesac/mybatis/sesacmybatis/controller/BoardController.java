package sesac.mybatis.sesacmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sesac.mybatis.sesacmybatis.domain.Board;
import sesac.mybatis.sesacmybatis.dto.BoardDTO;
import sesac.mybatis.sesacmybatis.service.BoardService;

import java.util.List;

@Controller
public class BoardController {
  @Autowired
  BoardService boardService;

  @GetMapping("/board")
  public String getBoards(Model model){
    // 1. 전부 select
    List<BoardDTO> list = boardService.getAll();
    model.addAttribute("list", list);
    return "board";
  }

  @GetMapping("/board/search")
  @ResponseBody
  public int searchBoard(@RequestParam String word){
    return boardService.searchBoard(word);
  }

  @PostMapping("/board")
  @ResponseBody
  public void postBoard(@RequestBody Board board){
    // 3. 게시글 작성 - insert
    boardService.insertBoard(board);
  }

  @PatchMapping("/board")
  @ResponseBody
  public void patchBoard(@RequestBody Board board){
    // 4. 게시글 수정 - update
    boardService.patchBoard(board);
  }

  @DeleteMapping("/board")
  @ResponseBody
  public void deleteBoard(@RequestParam int id){
    // 5. 게시글 삭제 - delete
    boardService.deleteBoard(id);
  }
}

