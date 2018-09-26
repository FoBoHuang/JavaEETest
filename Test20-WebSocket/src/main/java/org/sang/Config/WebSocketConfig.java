package org.sang.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by sang on 16-12-22.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /*/*
     * @功能描述 表示注册STOMP协议的节点，并指定映射的URL
     *
     * @author Huang
     * @date 2018/9/26 11:06
     * @param [stompEndpointRegistry]
     * @return void
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        /*注册STOMP协议节点，同时指定使用SockJS协议*/
        stompEndpointRegistry.addEndpoint("/endpointSang").withSockJS();
    }

    /*/*
     * @功能描述 配置消息代理，由于我们是实现推送功能，这里的消息代理是/topic
     *
     * @author Huang
     * @date 2018/9/26 11:06
     * @param [registry]
     * @return void
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }
}
