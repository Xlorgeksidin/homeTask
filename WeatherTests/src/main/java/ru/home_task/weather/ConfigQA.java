package ru.home_task.weather;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.Getter;
import ru.home_task.weather.services.ServiceData;
import ru.home_task.weather.services.IPathEnum;
import ru.home_task.weather.services.ServiceEnum;

import java.util.HashMap;
import java.util.Map;

public class ConfigQA {
  @Getter
  private final Map<IPathEnum, String> serviceMethodPath = new HashMap<>();
  @Getter
  private final Map<ServiceEnum, ServiceData> serviceData = new HashMap<>();

  private static ConfigQA instance;

  public static ConfigQA getInstance(){
    if(instance == null){
      instance = new ConfigQA();
    }
    return instance;
  }

  private ConfigQA(){
    String target = System.getProperty("target", "local");
    Config config = ConfigFactory.parseResources(String.format("%s.conf", target));

    for (ServiceEnum value : ServiceEnum.values()) {
      Config conf = config.getConfig("service")
        .getConfig(value.name().toLowerCase());
      readPath(value, conf);
    }
  }



  private void readPath(ServiceEnum value, Config conf) {
    ServiceData serviceData = new ServiceData();
    String port, host, accessKey;
    host = conf.getString("host");
    port = conf.getString("port");
    accessKey = conf.getString("access_key");
    serviceData.setAccessKey(accessKey);
    serviceData.setHost(host);
    serviceData.setPort(port);
    this.serviceData.put(value,serviceData);
    Config pathsConf = conf.getConfig("path");
    for (IPathEnum iPathEnum : value.getPathEnumList()) {
      String path = pathsConf.getString(iPathEnum.name().toLowerCase());
      serviceMethodPath.put(iPathEnum, generateFullPath(host, port, path));
    }
  }

  public String generateFullPath(String host, String port, String path) {
    return host + ":" + port + "/" + path;
  }}
