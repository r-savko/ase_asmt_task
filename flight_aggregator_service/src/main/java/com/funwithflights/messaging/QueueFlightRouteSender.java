package com.funwithflights.messaging;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.funwithflights.model.FlightRoute;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class QueueFlightRouteSender implements FlightRouteSender {

    private final AmazonSQS amazonSQS;
    private final Gson gson;
    @Value("${route.queue.url}")
    private String queueUrl;

    public QueueFlightRouteSender(Gson gson, AmazonSQS amazonSQS) {
        this.gson = gson;
        this.amazonSQS = amazonSQS;
    }

    public void send(FlightRoute flightRoute) {
        SendMessageRequest request = new SendMessageRequest()
            .withQueueUrl(queueUrl)
            .withMessageBody(gson.toJson(flightRoute))
            .withDelaySeconds(5);
        amazonSQS.sendMessage(request);
    }

}
