package com.aloha.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aloha.board.dto.Board;
import com.aloha.board.mapper.BoardMapper;
import com.aloha.board.service.BoardService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    
    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) throws Exception {
        
        List<Board> boardList = new ArrayList<>();
        //boardList = boardMapper.list();
        model.addAttribute("boardList", boardList);
        return "/board/list";
    }

    @GetMapping("/insert")
    public String insert() throws Exception {
        return "/board/insert";
    }
    
    @PostMapping("/insert")
    public String insertPro(Board board) throws Exception {
        int result = boardService.insert(board);
        if(result == 0) {
            return "redirect:/board/insert?error";  
        }
        return "/board/list";
    }
    
    @GetMapping("/read")
    public String read(@RequestParam("no") int no, Model model) throws Exception {
        // 데이터 요청
        Board board = boardService.select(no);
        // 모델 등록
        model.addAttribute("board", board);
        // 뷰페이지 지정
        return "/board/read";
    }

    @GetMapping("/update")
    public String update(@RequestParam String param) {
        return new String();
    }
    
}
