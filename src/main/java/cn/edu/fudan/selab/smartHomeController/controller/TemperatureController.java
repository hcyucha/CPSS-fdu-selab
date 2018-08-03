package cn.edu.fudan.selab.smartHomeController.controller;

import cn.edu.fudan.selab.smartHomeController.reasoning.TemperatureReasoning;
import cn.edu.fudan.selab.smartHomeController.utility.Parameters;
import com.alibaba.fastjson.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureController {
    @RequestMapping(value = Parameters.TemperatureApiDouble, method = RequestMethod.GET)
    @ResponseBody
    public String temperature(){
        TemperatureReasoning.execute();
        JSONArray arr = new JSONArray();
        arr.add("temperature");
        arr.add(Parameters.currentTemperature);
        arr.add("humidity");
        arr.add(Parameters.currentHumidity);
        System.out.println("temperature(" + arr.toString() + ")");
        return "temperature(" + arr.toString() + ")";
    }


}
