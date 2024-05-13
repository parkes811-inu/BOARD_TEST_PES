package com.aloha.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.board.dto.Board;
import com.aloha.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
    
    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<Board> list() throws Exception {
        List<Board> boardList = boardMapper.list();
        return boardList;
    }

    @Override
    public Board read(int no) throws Exception {
        Board board = boardMapper.read(no);
        return board;
    }

    @Override
    public int insert(Board board) throws Exception {
        return boardMapper.insert(board);
    }

    @Override
    public int update(Board board) throws Exception {
        return boardMapper.update(board);
    }

    @Override
    public int delete(int no) throws Exception {
        return boardMapper.delete(no);
    }
}
