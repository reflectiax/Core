package me.chemorris.core;

import me.chemorris.core.handler.ColourHandler;

public class Messages {
    public static final String PLUGIN_TAG = new ColourHandler().translate("&6Core » &7");
    public static final String SERVER_NAME = new ColourHandler().translate(Main.getInstance().getConfig().getString("servername"));
    public static final String SERVER_TAG = new ColourHandler().translate("&c&l" + Main.getInstance().getConfig().getString("servername") + " &7» &c");
    public static final String STAFF_TAG = new ColourHandler().translate("&9Staff » &7");
    public static final String ADMIN_TAG = new ColourHandler().translate("&cAdmin &7» &c");
    public static final String NO_PERMS = new ColourHandler().translate(PLUGIN_TAG + "You do not have permission for this command!");
}
