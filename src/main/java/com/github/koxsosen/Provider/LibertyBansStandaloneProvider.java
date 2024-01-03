package com.github.koxsosen.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import space.arim.injector.Injector;
import space.arim.libertybans.api.LibertyBans;
import space.arim.libertybans.bootstrap.BaseFoundation;
import space.arim.libertybans.env.standalone.ConsoleAudience;
import space.arim.libertybans.env.standalone.ConsoleAudienceToLogger;
import space.arim.libertybans.env.standalone.StandaloneLauncher;
import space.arim.omnibus.DefaultOmnibus;

import java.nio.file.Path;

// Written with help with how to use the standalone module.
// https://github.com/A248/LibertyBans/commit/ed6215b6f72c53906e11eba2ca8e4dd2a39c86a9#diff-cdbcf36423d7fa78db3faef8139ce5486c8e41d7050cc39445735b6533fc7b46
public class LibertyBansStandaloneProvider {
    private static final LibertyBansStandaloneProvider instance = new LibertyBansStandaloneProvider();
    private static LibertyBans api;
    private static BaseFoundation foundation;

    private static final Logger logger = LoggerFactory.getLogger(LibertyBansStandaloneProvider.class);


    private LibertyBansStandaloneProvider(){}
    public void create() {

        Path dataFolder = Path.of("libertybans");
        ConsoleAudience consoleAudience = new ConsoleAudienceToLogger(logger);

        Injector injector = new StandaloneLauncher(
                dataFolder, new DefaultOmnibus()
        ).createInjector(consoleAudience);

        api = injector.request(LibertyBans.class);
        foundation = injector.request(BaseFoundation.class);
    }

    public void startup(BaseFoundation foundation) {
        foundation.startup();
    }
    public void shutdown(BaseFoundation foundation) {
        foundation.shutdown();
    }

    public static LibertyBansStandaloneProvider getInstance() {
        return instance;
    }

    public static LibertyBans getApi() {
        return api;
    }

    public static BaseFoundation getFoundation() {
        return foundation;
    }

    public static Logger getLogger() {
        return logger;
    }

}
