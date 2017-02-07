package com.netcracker.services;

/**
 * Created by dima_2 on 05.02.2017.
 */
public interface ConfigurationService {

    String getOptionValueByKey(String key);
    String getUploadedImageDir();

}
