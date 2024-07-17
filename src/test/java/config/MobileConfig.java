package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:${deviceHost}.properties",
        "classpath:browserstack.properties"
})

public interface MobileConfig extends Config {

    String mobileUser();
    String mobilePass();
    String mobileApp();
    String deviceName();
    String mobilePlatform();
    String mobileProject();
    String mobileBuild();
    String mobileName();
    String mobileUrl();
    String remoteUrl();
    String appPackage();
    String appActivity();
    String mobileLanguage();
    String mobileLocale();
    String deviceType();
}