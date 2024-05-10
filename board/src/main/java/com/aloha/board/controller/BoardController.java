package com.aloha.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aloha.board.dto.Board;
import com.aloha.board.mapper.BoardMapper;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    
    @Autowired
    private BoardMapper boardMapper;

    @GetMapping("/list")
    public String list(Model model) throws Exception {
        
        List<Board> boardList = new ArrayList<>();
        //boardList = boardMapper.list();
        model.addAttribute("boardList", boardList);
        return "/board/list";
    }

    @GetMapping("/insert")
    public String intsert() throws Exception {
        return "/board/insert";
    }
    
    @PostMapping("/insert")
    public String insertPro(Board board) throws Exception {
        int result = boardMapper.insert(board);
        if(result == 0) {
            return "error:/board/list";
        }
        return "/board/insert";
    }
    
    @GetMapping("/read/{no}")
    public String read(Model model, int no) throws Exception {
        Board board = new Board();
        board = boardMapper.select(no);

        if(board != null) {

            model.addAttribute("board", board);
            return "/board/read/${no}";
        }
        return "redircet:/board/list";   
    }
}
