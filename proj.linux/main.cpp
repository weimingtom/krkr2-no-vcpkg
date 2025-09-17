#define USE_TVP_APP 1

#if USE_TVP_APP
#if !MY_USE_MINLIB
#include <gtk/gtk.h>
#include <spdlog/spdlog.h>
#include <spdlog/sinks/stdout_color_sinks.h>
#endif
#include "../src/core/environ/cocos2d/AppDelegate.h"
#else
#include "../Classes/AppDelegate.h"
#endif

#include "cocos2d.h"

#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <string>

USING_NS_CC;

int main(int argc, char **argv)
{
    // create the application instance
#if USE_TVP_APP
#if !MY_USE_MINLIB
    gtk_init(&argc, &argv);
    spdlog::set_level(spdlog::level::debug);

    static auto core_logger = spdlog::stdout_color_mt("core");
    static auto tjs2_logger = spdlog::stdout_color_mt("tjs2");
    static auto plugin_logger = spdlog::stdout_color_mt("plugin");

    spdlog::set_default_logger(core_logger);
#endif

	TVPAppDelegate app;
#else
    AppDelegate app;
#endif

    return Application::getInstance()->run();
}
