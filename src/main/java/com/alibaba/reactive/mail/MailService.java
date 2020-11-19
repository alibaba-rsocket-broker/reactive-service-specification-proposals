package com.alibaba.reactive.mail;

import reactor.core.publisher.Mono;

/**
 * mail service
 *
 * @author leijuan
 */
public interface MailService {

    Mono<Void> send(Mail mail);
}
