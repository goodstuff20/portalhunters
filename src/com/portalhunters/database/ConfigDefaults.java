package com.portalhunters.database;

import com.portalhunters.PortalHunters;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigDefaults {

    public static void fillFile(FileConfiguration c) {
        String path = "Weapons.Sword.";
        c.addDefault(path + "Name", "&b&lSword"); //TODO weitere daten in die default config reintun

        c.options().header( //TODO shit entfernen und neu schreiben
                "##### Portal Hunters Configuration #####\n" +
                        "\n" +
                        "How does this work?\n" +
                        "For each game phase (WAITING,VOTING,COOLDOWN,INGAME and DEATHMATHCH) is a scoreboard design.\n" +
                        "If you set \"Enabled\" for a phase to false, no scoreboard will shown!\n" +
                        "The title can be maximal 32 charakters long and cannot contain variables.\n" +
                        "\n" +
                        "In the \"Scores\" part, you can modify the content of the scoreboard. \"//\" splits the line in name and score.\n" +
                        "The left part is the name which can be maximal 48 charalters long.\n" +
                        "The right part is the amount of a score. Here you have to write the variables.\n" +
                        "\n" +
                        "What are the variables?\n" +
                        "You can use many variables. Here is a list:\n" +
                        "\n" +
                        "  %playing% - The current amount of players in a lobby!\n" +
                        "  %requiredplayers% - The amount of required players to start a game automaticly!\n" +
                        "  %death% - The amount of deaths in a round!\n" +
                        "  %spectators% - The amount of spectators in a round!\n" +
                        "  %time% - The remaining time of a game phase!\n" +
                        "  %votecount% - The amount of votes of an arena (Only works in the voting phase)\n" +
                        "  %arena% - The name of the arena (Only works in the score name)\n");


        c.options().copyDefaults(true);
        PortalHunters.saveDataBase();
    }

}
