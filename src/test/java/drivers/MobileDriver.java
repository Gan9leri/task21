package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.MobileConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class MobileDriver implements WebDriverProvider {

    private static final MobileConfig config =
            ConfigFactory.create(
                    MobileConfig.class,
                    System.getProperties()
            );


    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        if (config.isDevice().equals("emulate")) {
            return getEmulateDriver();
        } else if (config.isDevice().equals("real")) {
            return getRealDriver();
        }
        return getBrowserStackDriver();
    }


    public AndroidDriver getRealDriver() {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setDeviceName(config.deviceName())
                .setApp(getAppPath())
                .setAppPackage(config.appPackage())
                .setAppActivity(config.appActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public AndroidDriver getEmulateDriver() {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(config.mobilePlatform())
                .setDeviceName(config.deviceName())
                .setApp(getAppPath())
                .setAppPackage(config.appPackage())
                .setAppActivity(config.appActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(config.mobileUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAppPath() {
        String appVersion = "app-alpha-universal-release.apk";
        String appUrl = "https://github.com/wikimedia/apps-android-wikipedia" +
                "/releases/download/latest/" + appVersion;
        String appPath = "src/test/resources/apps/" + appVersion;

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app.getAbsolutePath();
    }

    public RemoteWebDriver getBrowserStackDriver() {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", config.mobileUser());
        caps.setCapability("browserstack.key", config.mobilePass());
        caps.setCapability("app", config.mobileApp());
        caps.setCapability("device", config.deviceName());
        caps.setCapability("os_version", config.mobilePlatform());
        caps.setCapability("project", config.mobileProject());
        caps.setCapability("build", config.mobileBuild());
        caps.setCapability("name", config.mobileName());
        caps.setCapability("language",config.mobileLanguage());
        caps.setCapability("locale",config.mobileLocale());

        try {
            return new RemoteWebDriver(
                    new URL(config.remoteUrl()), caps);
        } catch (
                MalformedURLException e) {
            throw new RuntimeException(e);
        }


    }

}
