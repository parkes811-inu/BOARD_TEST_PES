package com.aloha.board.service;

import java.util.List;

import com.aloha.board.dto.Board;

public interface BoardService {

    // insert
    public int insert(Board board) throws Exception;
    
    // list
    public List<Board> list() throws Exception;

    // select
    public Board select(int no) throws Exception;

    // update
    public int update(Board board) throws Exception;

    // delete
    public int delete(int no) throws Exception;
} 