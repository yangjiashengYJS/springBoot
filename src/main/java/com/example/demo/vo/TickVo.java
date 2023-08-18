package com.example.demo.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class TickVo {

    private String State;
    private String Msg;
    private List<Data> Data;

    @lombok.Data
    @ToString
    private class Data{
        private String code;
        private String price;
        private String up;
        private String name;
        private String market;
//        private String varieties;
//        private String contract;
//        private String open;

    }

}
