package com.aloha.board.service;

import java.util.ArrayList;
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
    public int insert(Board board) throws Exception {

        int result = boardMapper.insert(board);

        if(result > 0) {
            return result;
        } 
        return 0;
    }

    @Override
    public List<Board> list() throws Exception {
        List<Board> boardList = new ArrayList<>();
        boardList = boardMapper.list();
        return boardList;
    }

    @Override
    public Board select(int no) throws Exception {
        Board board = boardMapper.select(no);
        if(board != null) {
            return board;
        }
        return null;
    }

    @Override
    public int update(Board board) throws Exception {
        int result = boardMapper.update(board);
        return result;
    }

    @Override
    public int delete(int no) throws Exception {
        int result = boardMapper.delete(no);
        return result;
    }
}
