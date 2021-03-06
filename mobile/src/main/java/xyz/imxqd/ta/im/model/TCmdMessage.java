package xyz.imxqd.ta.im.model;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import io.rong.imlib.model.MessageContent;
import io.rong.message.TextMessage;

/**
 * Created by imxqd on 17-4-1.
 */

public abstract class TCmdMessage extends TMessage {
    public static final String CMD_SHOCK = "CMD_SHOCK";
    public static final String CMD_GET_STEPS = "CMD_GET_STEPS";
    public static final String CMD_GET_HEART_RATE = "CMD_GET_HEART_RATE";
    public static final String CMD_BIND = "CMD_BIND";
    public static final String CMD_GAME = "CMD_GAME";

    @StringDef({
            CMD_SHOCK,
            CMD_GET_STEPS,
            CMD_GET_HEART_RATE,
            CMD_BIND,
            CMD_GAME
    })
    @Retention(RetentionPolicy.SOURCE)
    @interface Cmd {}


    public TCmdMessage(String targetId, String senderId) {
        super(targetId,senderId);
    }

    @Override
    public MessageContent getContent() {
        TextMessage msg = TextMessage.obtain("");
        msg.setExtra(getCmd());
        return msg;
    }

    @Cmd
    public abstract String getCmd();

    @Override
    public int getMessageType() {
        return TYPE_CMD;
    }

}
