package com.aloha.board.dto;

import java.util.Date;
import lombok.Data;

@Data
public class Board {
/*
    `no` int NOT NULL AUTO_INCREMENT,
    `title` varchar(100) NOT NULL,
    `writer` varchar(100) NOT NULL,
    `content` text,
    `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `upd_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `views` int NOT NULL DEFAULT '0',
 */
    private int no;
    private String title;
    private String writer;
    private String content;  
    private Date regDate;
    private Date updDate;
    private int views;
    
}
