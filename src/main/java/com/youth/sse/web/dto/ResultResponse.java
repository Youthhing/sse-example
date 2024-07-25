package com.youth.sse.web.dto;

import com.youth.sse.domain.entity.Reply;

public record ResultResponse(
        Boolean isCorrect,
        Long ticketNumber
) {
    public static ResultResponse from(Reply reply) {
        return new ResultResponse(
                reply.getIsCorrect(),
                reply.getTicketNumber()
        );
    }
}
