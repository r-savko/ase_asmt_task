package com.funwithflights.messaging;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.funwithflights.model.FlightRoute;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class QueueSendFlightRouteService implements SendFlightRouteService {

    @Value("${route.queue.url}")
    private String queueUrl;
    private final Gson gson;

    public QueueSendFlightRouteService(Gson gson) {
        this.gson = gson;
    }

    public void send(FlightRoute flightRoute) {
        AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
        SendMessageRequest send_msg_request = new SendMessageRequest()
            .withQueueUrl(queueUrl)
            .withMessageBody(gson.toJson(flightRoute))
            .withDelaySeconds(5);
        sqs.sendMessage(send_msg_request);
    }

}
