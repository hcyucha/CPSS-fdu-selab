package cn.edu.fudan.selab.smartHomeController.reasoning;

import cn.edu.fudan.selab.smartHomeController.utility.HttpRequest4DeviceStates;
import cn.edu.fudan.selab.smartHomeController.utility.Parameters;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TemperatureReasoning {
    public static void execute(){
        Double currentTemp;
        Double currentHumi;
        List<String> entityList = new ArrayList<String>();
        entityList.add(Parameters.entityId4Temperature);
        entityList.add(Parameters.entityId4Humidity);
        Iterator<String> it = entityList.iterator();
        while(it.hasNext())
        {
            String currentEntityId = it.next();
            JSONObject obj = JSON.parseObject(HttpRequest4DeviceStates.getDeviceStateById(currentEntityId));
            System.out.println(currentEntityId + " " + obj.get("state"));
            if(currentEntityId.equals(Parameters.entityId4Temperature))
            {
                currentTemp = Double.parseDouble(String.valueOf(obj.get("state")));
                System.out.println("目前的温度是：" + currentTemp);
                Parameters.currentTemperature = currentTemp.toString();
                if(currentTemp > 30)
                    System.out.println("室内温度过高。");
            }
            if(currentEntityId.equals(Parameters.entityId4Humidity))
            {
                currentHumi = Double.parseDouble(String.valueOf(obj.get("state")));
                System.out.println("目前的湿度是；" + currentHumi);
                Parameters.currentHumidity = currentHumi.toString();
                if(currentHumi > 80)
                    System.out.println("室内湿度过高。");
            }
        }


//        JSONObject Temperature = JSON.parseObject((HttpRequest4DeviceStates.getDeviceStateById(Parameters.entityId4Temperature)));
//        JSONObject Humidity = JSON.parseObject((HttpRequest4DeviceStates.getDeviceStateById(Parameters.entityId4Humidity)));


    }
}
