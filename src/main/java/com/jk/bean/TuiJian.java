package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TuiJian {

    private Integer id;
    private String tname;
    private String tlink;
    private String tauthor;
    private String blogaddr;//图片
    private String pindao;
    private Integer lanmu;
    private Integer state;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date tuitime;
    private Integer userid;
}
