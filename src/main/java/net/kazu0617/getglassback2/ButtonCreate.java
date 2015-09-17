/*
 * @author     kazu0617
 * @license    LGPLv3
 * @copyright  Copyright kazu0617 2015
 */
package net.kazu0617.getglassback2;

import org.bitbucket.ucchy.util.tellraw.ClickEventType;
import org.bitbucket.ucchy.util.tellraw.MessageComponent;
import org.bitbucket.ucchy.util.tellraw.MessageParts;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 *
 * @author kazu0617
 */
public class ButtonCreate {
    @SuppressWarnings("unused")
    private Main plugin;

    public ButtonCreate(Main plugin)
    {
        this.plugin = plugin;
    }
     /**
     * ボタンを作成しやすくする。
     *
     * @param ms メッセージ送信先
     * @param Text 表示するテキスト
     * @param HoverText 表示するホバーテキスト
     * @param Value ボタンを押した時に出てくる文字列(Buttonによって変化)
     * @param Button クリックされた時に行われる動作
     */
    public void ButtonCreate(Player ms,String Text,String[] HoverText,String Value,ClickEventType Button)
    {
        MessageComponent msg = new MessageComponent();
        MessageParts button1 = new MessageParts("["+Text+"]", ChatColor.AQUA);
        int i = HoverText.length;
        if(plugin.DebugMode)
            plugin.cLog.debug("i = "+i);
        for(int i2=0;i2<=i-1;i2++)
        {
            if(plugin.DebugMode)
            {
                plugin.cLog.debug("i2 = " + i2);
                plugin.cLog.debug(HoverText[i2]);
            }
            if(i2==i-1)
            {
                button1.addHoverText(HoverText[i2]);
                break;
            }
            button1.addHoverText(HoverText[i2]+"\n");
        }
        button1.setClickEvent(Button, Value);
        msg.addText(plugin.Pluginprefix);
        msg.addParts(button1);
        msg.send(ms);
    }
    /**
     * ボタンを作成しやすくする。
     *
     * @param ms メッセージ送信先
     * @param Text 表示するテキスト
     * @param Value ボタンを押した時に出てくる文字列(Buttonによって変化)
     * @param Button クリックされた時に行われる動作
     */
    public void ButtonCreate(Player ms,String Text,String Value,ClickEventType Button)
    {
        MessageComponent msg = new MessageComponent();
        MessageParts button1 = new MessageParts("["+Text+"]", ChatColor.AQUA);
        button1.setClickEvent(Button, Value);
        msg.addText(plugin.Pluginprefix);
        msg.addParts(button1);
        msg.send(ms);
    }
    
}
