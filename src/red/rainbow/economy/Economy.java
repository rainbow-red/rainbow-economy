package red.rainbow.economy;


import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;

import java.nio.file.Path;
import java.util.logging.Logger;

@Plugin(id = "rainbow-economy",
        version = "1.0",
        description = "Economy framework and transaction handler for RainbowRED.",
        url = "https//rainbow.red/",
        authors = {"RainbowSpeedy"},
        dependencies = @Dependency(id = "rainbowcore"))
public class Economy {
    private static ProxyServer server;
    private static Logger logger;
    private static Path dataDir;

    @Inject
    public Economy(ProxyServer pserver, Logger vlogger, @DataDirectory Path dir) {
        Economy.server = pserver;
        Economy.logger = vlogger;
        Economy.dataDir = dir;
    }

    @Subscribe
    public void onProxyInit(ProxyInitializeEvent event) {
        logger.info("§aEconomy UP.");
    }

    @Subscribe
    public void onProxyShutdown(ProxyShutdownEvent event) {
        logger.info("§cEconomy DOWN.");
    }
}
