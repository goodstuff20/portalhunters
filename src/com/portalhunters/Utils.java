package com.portalhunters;

import org.bukkit.ChatColor;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Utils {

    private ScriptEngineManager mgr;
    private ScriptEngine engine;

    public Utils() {
        mgr = new ScriptEngineManager();
        engine = mgr.getEngineByName("JavaScript");
    }

    // String formulaString = PortalHunters.config.getString("classes.levelUpExpFormula").replace("%curlvl%", Integer.toString(currentLevel));
    // int expNeeded = PortalHunters.instance.utils.calculateStringFormula(formulaString);
    public int calculateStringFormula(String infix) {
        String stringResult;
        try {
            stringResult = engine.eval(infix).toString();
            double doubleResult = Double.parseDouble(stringResult);
            int result = (int) doubleResult;
            return result;
        } catch (ScriptException ex) {
            System.err.println("String can't be calculated");
        }
        return(1);
    }

    public static String replaceColors(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
