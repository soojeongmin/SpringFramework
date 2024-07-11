package com.bit.springboard.service;

import com.bit.springboard.dto.BoardDto;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.time.LocalDateTime;

public class NoticeServiceRun {

    public static void main(String[] args) {
        AbstractApplicationContext factory =
                new GenericXmlApplicationContext("root-context.xml");
        BoardService boardService = factory.getBean("noticeServiceImpl", BoardService.class);

        // 게시글 등록
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle("자유게시글1");
        boardDto.setContent("자유게시글 1번입니다.");
        boardDto.setWRITER_ID(11);

        boardService.post(boardDto);

        // 게시글 수정
        BoardDto modifyBoardDto = new BoardDto();
        modifyBoardDto.setId(9);
        modifyBoardDto.setTitle("자유게시글1 수정");
        modifyBoardDto.setContent("자유시글 1번입니다.-수정됨");
        modifyBoardDto.setModdate(LocalDateTime.now());

        boardService.modify(modifyBoardDto);

        // 게시글 삭제
        boardService.delete(8);

        // 게시글 목록 조회
        boardService.getBoardList().forEach(board -> {
            System.out.println(board);
        });

        // 특정 게시글 조회
        System.out.println(boardService.getBoard(4));

        // 리소스 정리
        factory.close();
    }
}