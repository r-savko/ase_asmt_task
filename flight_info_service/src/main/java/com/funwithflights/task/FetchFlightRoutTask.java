package com.funwithflights.task;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.funwithflights.repository.model.FlightRoute;
import com.funwithflights.service.FlightRouteService;
import com.google.gson.Gson;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FetchFlightRoutTask {

    @Value("${route.queue.url}")
    private String queueUrl;
    private final AmazonSQS sqs;
    private final Gson gson;
    private final FlightRouteService flightRouteService;

    public FetchFlightRoutTask(FlightRouteService flightRouteService, Gson gson, AmazonSQS sqs) {
        this.flightRouteService = flightRouteService;
        this.gson = gson;
        this.sqs = sqs;
    }

    @Scheduled(fixedRate = 5000)
    public void sendRoutes() {

        final ReceiveMessageRequest receiveMessageRequest =
            new ReceiveMessageRequest(queueUrl)
                .withMaxNumberOfMessages(10)
                .withWaitTimeSeconds(1);
        final List<Message> messages =
            sqs.receiveMessage(receiveMessageRequest).getMessages();

        messages.forEach(m -> {
            flightRouteService.addFlightRoute(gson.fromJson(m.getBody(), FlightRoute.class));
            sqs.deleteMessage(queueUrl, m.getReceiptHandle());
        });

    }

}
