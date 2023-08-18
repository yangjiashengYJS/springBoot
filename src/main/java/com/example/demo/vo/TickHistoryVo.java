package com.example.demo.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class TickHistoryVo {

    private String State;
    private String Msg;
    private String Data;
    private List<Tick> tick;

    @lombok.Data
    @ToString
    public static class Tick{
        private Long tick;
        private String income;
        private String open;
        private String high;
        private String low;
        private String amount;
        private String volume;

    }

}
