package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.util.HttpUtil;
import com.example.demo.vo.TickBody;
import com.example.demo.vo.TickHistoryVo;
import com.example.demo.vo.TickVo;
import com.github.pagehelper.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping({"/api/tick/"})
public class GetTickController {
    private static final Logger log = LoggerFactory.getLogger(GetTickController.class);


    //查询股票列表
    @RequestMapping({"getTickList"})
    @ResponseBody
    public Object getTickList(@RequestBody TickBody tickBody) throws IOException {
        Map<String,String> map = new HashMap<>();
        map.put("symbol",tickBody.getSymbol());
        map.put("rout",tickBody.getRout());
        String s = HttpUtil.doGet("http://ht.yufenghy.cn:9009/hq/api/real/massive",map);
        log.info(s.toString());
//        JSONObject jsonObject =  JSONObject.parseObject(s);
        TickVo tickVo = JSONObject.parseObject(s.toString(), TickVo.class);

        System.out.println(tickVo.toString());
        return tickVo;
    }

    //查询股票列表
    @RequestMapping({"getHistoryDataList"})
    @ResponseBody
    public Object getHistoryDataList(String symbol,String period,String datest,String dateed,String withlast) throws IOException {
        Map<String,String> map = new HashMap<>();
        map.put("symbol",symbol);
        map.put("period",period);
//        map.put("datest",datest);
//        map.put("dateed",dateed);
        map.put("withlast",withlast);
        String s = HttpUtil.doGet("http://ht.yufenghy.cn:9009/hq/api/real/massive",map);
        log.info(s.toString());
//        JSONObject jsonObject =  JSONObject.parseObject(s);
        TickVo tickVo = JSONObject.parseObject(s.toString(), TickVo.class);

        System.out.println(tickVo.toString());
        return tickVo;
    }


    //查询历史列表
    @RequestMapping({"getHistoryDataPageList"})
    @ResponseBody
    public Object getHistoryDataPageList(String symbol,String period,String pidx,String psize,String withlast) throws IOException {
        Map<String,String> map = new HashMap<>();
        map.put("symbol",symbol);
        map.put("period",period);
        map.put("pidx",pidx);
        map.put("psize",psize);
        map.put("withlast",withlast);
        String s = HttpUtil.doGet("http://ht.yufenghy.cn:9009/hq/api/kline/page",map);
        log.info(s.toString());
//        JSONObject jsonObject =  JSONObject.parseObject(s);
        TickHistoryVo tickHistoryVo = JSONObject.parseObject(s.toString(), TickHistoryVo.class);

        String data = tickHistoryVo.getData();
        if(StringUtil.isNotEmpty(data)){
            List<TickHistoryVo.Tick> ticks = new ArrayList<>();
            String[] tickList = data.split(";");
            for (String str : tickList){
                TickHistoryVo.Tick tick =  new TickHistoryVo.Tick();
                String[] strings = str.split(",");
//                System.out.println("tick:"+strings[0]);

                tick.setTick(Long.valueOf(strings[0]));
                tick.setIncome(strings[1]);
                tick.setOpen(strings[2]);
                tick.setLow(strings[3]);
                tick.setAmount(strings[4]);
                tick.setVolume(strings[5]);
                ticks.add(tick);
            }
            if(ticks.size()>0){
                tickHistoryVo.setTick(ticks);
            }

        }
        tickHistoryVo.setData(null);
        System.out.println(tickHistoryVo.toString());
        return tickHistoryVo;
    }


}

