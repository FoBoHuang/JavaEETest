package org.sang.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Created by sang on 16-12-22.
 */
@Controller
public class WsController {

    /*SimpMessagingTemplate实现向浏览器发送消息的功能*/
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /*在Spring MVC中，可以直接在参数中获取Principal，Principal中包含有当前用户的用户名*/
    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {

        /*convertAndSendToUser方法是向用户发送一条消息，第一个参数是目标用户用户名，第二个参数是浏览器中订阅消息的地址，第三个参数是消息本身*/
        if (principal.getName().equals("sang")) {
            messagingTemplate.convertAndSendToUser("lenve", "/queue/notifications", principal.getName() + "给您发来了消息：" + msg);
        }else{
            messagingTemplate.convertAndSendToUser("sang", "/queue/notifications", principal.getName() + "给您发来了消息：" + msg);
        }
    }
}
