package com.aloha.board.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.aloha.board.dto.Board;

@Mapper
public interface BoardMapper {

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
