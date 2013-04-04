package de.wavecom_web.chat;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EcomChat extends JavaPlugin
{
  private int msglength;
  private boolean send;
  private String[] message = new String[20];
  private String result = "";

  public void onDisable()
  {
    System.out.println("[EcomChat] Ecomchat ausgeschaltet!");
  }

  public void onEnable()
  { //Raquilem Chat
    getCommand("s").setExecutor(new CommandExecutor() {
      public boolean onCommand(CommandSender cs, Command cmnd, String alias, String[] args) {
        Player player = (Player)cs;
        Server server = EcomChat.this.getServer();
        String safenick = player.getName().toLowerCase().replaceAll("'", "\"");
        String safenick1 = safenick.replaceAll("Â§f", "");
        if (player.hasPermission("wavecom.stadt.raquilem"))
        {
          if (args.length <= 0)
          {
            player.sendMessage(ChatColor.RED + "Stadtchat Benutzung: /s <message>");
            EcomChat.this.send = false;
          }
          else {
            EcomChat.this.msglength = args.length;
            for (int i = 0; i < EcomChat.this.msglength; i++)
            {
              EcomChat.this.message[i] = args[i];
            }
            EcomChat.this.result = EcomChat.this.message[0];
            for (int i = 1; i < EcomChat.this.msglength; i++) {
              EcomChat.this.result = (EcomChat.this.result + " " + EcomChat.this.message[i]);
            }
            EcomChat.this.send = true;
          }
          if (EcomChat.this.send == true)
          {
            Player[] online = server.getOnlinePlayers();
            for (int o = 0; o < online.length; o++)
            {
              Player name = online[o];
              if (name.hasPermission("wavecom.stadt.raquilem"))
              {
                name.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_PURPLE + "Raquilem" + ChatColor.WHITE + "] " + safenick1 + ": " + ChatColor.DARK_GREEN + EcomChat.this.result);
              }
            }
          }
        } else if (player.hasPermission("wavecom.stadt.armedanien"))
        {
            if (args.length <= 0)
            {
              player.sendMessage(ChatColor.RED + "Stadtchat Benutzung: /s <message>");
              EcomChat.this.send = false;
            }
            else {
              EcomChat.this.msglength = args.length;
              for (int i = 0; i < EcomChat.this.msglength; i++)
              {
                EcomChat.this.message[i] = args[i];
              }
              EcomChat.this.result = EcomChat.this.message[0];
              for (int i = 1; i < EcomChat.this.msglength; i++) {
                EcomChat.this.result = (EcomChat.this.result + " " + EcomChat.this.message[i]);
              }
              EcomChat.this.send = true;
            }
            if (EcomChat.this.send == true)
            {
              Player[] online = server.getOnlinePlayers();
              for (int o = 0; o < online.length; o++)
              {
                Player name = online[o];
                if (name.hasPermission("wavecom.stadt.armedanien"))
                {
                  name.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_PURPLE + "Armedanien" + ChatColor.WHITE + "] " + safenick1 + ": " + ChatColor.DARK_GREEN + EcomChat.this.result);
                }
              }
            }
          } else if (player.hasPermission("wavecom.stadt.karafiliem"))
          {
              if (args.length <= 0)
              {
                player.sendMessage(ChatColor.RED + "Stadtchat Benutzung: /s <message>");
                EcomChat.this.send = false;
              }
              else {
                EcomChat.this.msglength = args.length;
                for (int i = 0; i < EcomChat.this.msglength; i++)
                {
                  EcomChat.this.message[i] = args[i];
                }
                EcomChat.this.result = EcomChat.this.message[0];
                for (int i = 1; i < EcomChat.this.msglength; i++) {
                  EcomChat.this.result = (EcomChat.this.result + " " + EcomChat.this.message[i]);
                }
                EcomChat.this.send = true;
              }
              if (EcomChat.this.send == true)
              {
                Player[] online = server.getOnlinePlayers();
                for (int o = 0; o < online.length; o++)
                {
                  Player name = online[o];
                  if (name.hasPermission("wavecom.stadt.karafiliem"))
                  {
                    name.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_PURPLE + "Karafiliem" + ChatColor.WHITE + "] " + safenick1 + ": " + ChatColor.DARK_GREEN + EcomChat.this.result);
                  }
                }
              }
            } else { player.sendMessage(ChatColor.RED + "Du gehörst zu keiner Stadt!"); }
        return true;
      }
    });
    System.out.println("[EcomChat] Ecomchat erfolgreich geladen");
  }
}