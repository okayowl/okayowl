package ru.colibri.ui.template.settings.ios;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.colibri.ui.core.settings.AppSettings;
import ru.colibri.ui.core.settings.DriversSettings;
import ru.colibri.ui.settings.general.PropertyUtils;
import ru.colibri.ui.settings.loaders.AbsSettingsLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static java.lang.String.format;
import static ru.colibri.ui.core.names.ColibriStartFlags.BUILD_VERSION;
import static ru.colibri.ui.template.names.PropertyNames.*;

/**
 * Класс отвечающий за загрузку настроек приложения и окружения Андроид
 */
@Component
@Qualifier("ios")
public class IOSSettingsLoader extends AbsSettingsLoader {
    private static final String DEFAULT_PATH_TEMPLATE = "src/test/resources/environment/%s/environmentIOS.properties";

    @Override
    public AppSettings loadAppSettings(String userName) {
        String pathSpecificUser = format(PATH_USER, userName);
        Map<String, String> map = convertPropertyToMap(PropertyUtils.readProperty(pathSpecificUser));
        return AppSettings.builder()
                .userProfile(map)
                .build();
    }

    @Override
    public DriversSettings loadDriverSettings(String platformName) {
        String pathDefault = format(DEFAULT_PATH_TEMPLATE, "def");
        String pathSpecificIOS = format(PATH_TEMPLATE, platformName);

        Properties props = PropertyUtils.readProperty(pathDefault, pathSpecificIOS);
        loadArtifactByRemoteRepo(props);
        List<String> packageList = createPackageList();

        return DriversSettings.builder()
                .appiumRemoteUrl(props.getProperty(APPIUM_REMOTE_URL))
                .deviceName(props.getProperty(DEVICE_NAME))
                .filePath(props.getProperty(FILE_PATH))
                .implicitlyWaitInSeconds(20)
                .findingTimeOutInSeconds(20)
                .newCommandTimeoutInSeconds(20)
                .storyTimeoutsInSeconds("7200")
                .stepsPackages(packageList)
                .storyPath(props.getProperty(STORY_PATH))
                .storyToInclude(props.getProperty(STORY_TO_INCLUDE))
                .storyToExclude(props.getProperty(STORY_TO_EXCLUDE))
                .pagesPath(props.getProperty(PAGES_PATH))
                .UDID(props.getProperty(UDID))
                .wdaLocalPort(Integer.parseInt(props.getProperty(WDA_LOCAL_PORT)))
                .build();
    }

    private List<String> createPackageList() {
        List<String> packageList = new ArrayList<>(2);
        packageList.add("ru.colibri.ui.steps.general");
        packageList.add("ru.colibri.ui.steps.ios");
        packageList.add("ru.colibri.ui.template.steps.general");
        packageList.add("ru.colibri.ui.template.steps.ios");
        return packageList;
    }

    private void loadArtifactByRemoteRepo(Properties props) {
        String remoteFilePath = props.getProperty(REMOTE_FILE_PATH);
        remoteFilePath = format(remoteFilePath, System.getProperty(BUILD_VERSION));
        takeArtifact(remoteFilePath, props.getProperty(FILE_PATH));
    }
}
