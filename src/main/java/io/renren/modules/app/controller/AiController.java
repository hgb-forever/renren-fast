package io.renren.modules.app.controller;


import com.alibaba.fastjson.JSON;
import io.renren.modules.app.entity.PaperTopicEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "论文题目Controller", tags = "论文题目控制接口")
public class AiController {

    @ApiOperation(value = "根据关键字生成论文")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 500, message = "失败"),
            @ApiResponse(code = 400, message = "缺少参数") })
    @GetMapping("/getpapertopic")
    public List<PaperTopicEntity> getPaperTopic(String keyword) throws IOException, InterruptedException {
        Process proc;
        List paperTopics = new ArrayList<PaperTopicEntity>();
        try {
            String filepath = "D:\\pythondemo1\\AI\\AipNLP.py";
            String[] statement = new String[]{"F:\\python\\python.exe", filepath, keyword};
            proc = Runtime.getRuntime().exec(statement);
            proc.waitFor();
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(), "gbk"));
            String line = null;
            while ((line = in.readLine()) != null) {
                PaperTopicEntity paperTopic = JSON.parseObject(line, PaperTopicEntity.class);
                paperTopics.add(paperTopic);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.toString();
        }
        return paperTopics;
    }

}
