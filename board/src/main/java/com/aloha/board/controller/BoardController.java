package com.aloha.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aloha.board.dto.Board;
import com.aloha.board.service.BoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/board")
public class BoardController {
    
    @Autowired
    private BoardService boardService;
    
    @GetMapping("/list")
    public String list(Model model) throws Exception {
        List<Board> boardList = boardService.list();
        model.addAttribute("boardList", boardList);
        return "/board/list";
    }
    
    @GetMapping("/read")
    public String read(@RequestParam("no") int no, Model model) throws Exception {
        Board board = boardService.read(no);
        model.addAttribute("board", board);
        return "/board/read";
    }
    
    @GetMapping("/insert")
    public String insert() {
        return "/board/insert";
    }
    
    @PostMapping("/insert")
    public String insert(Board board) throws Exception {
        int result = boardService.insert(board);
        return "redirect:/board/list";
    }
    
    @GetMapping("/update")
    public String update(@RequestParam("no") int no, Model model) throws Exception {
        Board board = boardService.read(no);
        model.addAttribute("board", board);
        return "/board/update";
    }
    
    @PostMapping("/update")
    public String update(Board board) throws Exception {
        int result = boardService.update(board);
        return "redirect:/board/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("no") int no) throws Exception {
        int result = boardService.delete(no);
        return "redirect:/board/list";
    }
    
}
