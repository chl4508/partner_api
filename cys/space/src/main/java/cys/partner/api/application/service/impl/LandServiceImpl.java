package cys.partner.api.application.service.impl;

import cys.partner.api.application.service.LandService;
import cys.partner.api.entity.Land;
import io.nats.client.JetStream;
import io.nats.client.JetStreamManagement;
import io.nats.client.JetStreamSubscription;
import io.nats.client.Message;
import io.nats.client.api.StreamConfiguration;
import io.nats.streaming.NatsStreaming;
import io.nats.streaming.Options;
import io.nats.streaming.StreamingConnection;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.UUID;

@Service
public class LandServiceImpl implements LandService {
    @Override
    public Land GetLand(UUID landId) throws Exception {
        //
        String clusterId = "meta";
        String clientId = "item";
        String serverUrl = "nats://127.0.0.1:4222";

        Options options = new Options.Builder()
                .clusterId(clusterId)
                .clientId(clientId)
                .natsUrl(serverUrl)
                .build();

       try(StreamingConnection connection = NatsStreaming.connect(clusterId, clientId, options)){
            // JetStream 컨텍스트 생성
           JetStreamManagement jsm = connection.getNatsConnection().jetStreamManagement();

           StreamConfiguration streamConfig = StreamConfiguration.builder()
                   .name("test item")
                   .subjects("item")
                   .build();

           jsm.addStream(streamConfig);

           //메시지 발행
           JetStream jetStream = connection.getNatsConnection().jetStream();
           jetStream.publish("item", "Test item".getBytes());

           //메시지 구독
           JetStreamSubscription sub = jetStream.subscribe("item");
           Message message = sub.nextMessage(Duration.ofSeconds(1));
           //var d = new String(message.getData(), StandardCharsets.UTF_8);
           System.out.println(message.getData());
       }


        return new Land();
    }
}
