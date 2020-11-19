RSSP: Reactive Service Specification Proposals
==============================================

Reactive化的服务接口草案定义，标准化后方便服务实现和调用，可以和RSocket Broker无缝对接。

### 统一Reactive Service API后有什么好处？

* 首先是Reactive友好，方便对接Reactive生态
* SDK依赖小，客户端调用这些服务接口，几乎不涉及具体的产品SDK等，RSocket支持就可以啦，当然可能有一定的工具包
* 多语言支持: 如Messaging，C++语言不需要什么Kafka C++ SDK，直接就可以消费Kafka的消息，数据处理方便多啦
* 创新成为可能且成本低：给后续想创新的同学提供空间，现在API都是绑死的，SDK特别大，即便有同学想开发一个新的产品，业务线应用也不给他们机会。后续好产品开发出来后，Broker的Routing调整一下就可以啦，应用无感知。

## Proposals List
各种服务Reactive接口草案列表，一定有非常不到位而的地方，希望大家多提 [issue](https://github.com/alibaba-rsocket-broker/reactive-service-specification-proposals/issues)。

### Database

数据库的Reactive化，请参考R2DBC http://r2dbc.io/ 。

* H2
* PostgreSQL
* ADBA(Oracle): Asynchronous Database Access
* Microsoft SQL Server
* MySQL: https://github.com/mariadb-corporation/mariadb-connector-r2dbc

### Reactive Health check

```java
public interface ReactiveHealth {
    /**
     * health status: 0:unknown, 1: serving, 2: not serving
     *
     * @param serviceName service name
     * @return health status
     */
    Mono<Integer> check(String serviceName);
}
```

### Cache
Cache的Reactive API，主要参考 https://github.com/jsr107/jsr107spec/tree/master/src/main/java/javax/cache 。
处理空值判断请参考： Mono.switchIfEmpty() 和 Mono.defaultIfEmpty()

[Cache Reactive接口](https://github.com/alibaba-rsocket-broke/reactive-service-specification-proposals/blob/master/src/main/java/com/alibaba/reactive/cache/Cache.java)
适配的产品列表包括：

* Memcached
* Tair
* Redis
* caffeine: https://github.com/ben-manes/caffeine

### Duplex Connection
双向通讯的标准接口，和Channel类似，可以同时发送和接收消息。

[Duplex Connection](https://github.com/alibaba-rsocket-broker/reactive-service-specification-proposals/blob/master/src/main/java/com/alibaba/reactive/connection/DuplexConnection.java)

适配的产品包括：

* Reactor Netty
* RSocket

### Messaging
已经有非常多的人将Topic定义为一个有名字的Flux，请注意处理complete和error，同时有back pressure的要求。其实Reactor已经开始对接各种MQ产品啦。

[Messaging Reactive接口](https://github.com/alibaba-rsocket-broker/reactive-service-specification-proposals/blob/master/src/main/java/com/alibaba/reactive/messaging/MessagingService.java)
适配的产品列表包括：

* Kafka: reactor-kafka
* NATS
* RocketMQ
* RabbitMQ: reactor-rabbitmq
* AMQP
* MQTT
* Pub/Sub from Cloud vendors

### Mail
Email发送的通用接口，目前暂不支持附件发送。
[Mail Reactive接口](https://github.com/alibaba-rsocket-broker/reactive-service-specification-proposals/blob/master/src/main/java/com/alibaba/reactive/mail/MailService.java)


### Event

Cloud Event的Protobuf绑定请参考： [cloud event protobuf](src/main/proto/cloudevent.proto)

##### Event Bus
EventBus是为多个组件基于publish-subscribe通讯的能力，主要是解决实时情况下时间触发和消费的机制。如果在Reactor下，可能就是一个Processor。
该Event Bus主要是基于Cloud Event规范实现。https://cloudevents.io/
[Cloud Event Bus Reactive接口](https://github.com/alibaba-rsocket-broker/reactive-service-specification-proposals/blob/master/src/main/java/com/alibaba/reactive/event/CloudEventBus.java)
适配的产品列表包括：

* Kafka
* RocketMQ

##### Event Sourcing
EventSourcing是保证每一次状态变更都会被积累下来，更像一个版本控制系统。

对比版本控制系统（时间线），我们列举一下EventSourcing的常见功能，主要就是存储和回放：

* 事件保存
* 查询某一事件
* 从某一时间段的所有事件
* 某一种类型的事件(包含时间段) : 如VCS中的新增、删除等。
* 某一源头触发的所有事件：如 pom.xml文件触发的所有事件

##### Event Store

提供事件的存储和查询功能，包括能基于时间段、类型和触发源的查询等。

##### Event Reply

在某些场景下，事件发送出去后，可能希望事件的处理者在处理完后，回发(Reply)一下处理的结果，如配置推送的场景，配置变更事件发送出去后，希望知道多少人做出了响应，结果如何，这些信息对事件源非常重要，可能要进行重新推送。

### Configuration service
这里 Configuration = KV + Watch，可以很方便地实现配置推送服务。

[Configuration Service接口](https://github.com/alibaba-rsocket-broker/reactive-service-specification-proposals/blob/master/src/main/java/com/alibaba/reactive/kv/ConfigurationService.java)
适配的产品列表包括：

* etcd
* Consul
* ZooKeeper: 3.5.5正式版
* Nacos


### Registry
这里 registry = 服务注册  + 服务发现， 可以方便查询服务的信息

适配的产品列表包括:

* Consul
* Nacos
* ZooKeeper
* Eureka

### KV Blob Service
二进制的Blob存储，如图片，日志等等。

[KV Blob Service接口](https://github.com/alibaba-rsocket-broker/reactive-service-specification-proposals/blob/master/src/main/java/com/alibaba/reactive/kv/KVBlobService.java)
适配的产品列表包括：

* level DB
* RocksDB
* AWS S3
* Aliyun OSS


### Secret Store
秘钥服务接口，方便程序获取敏感数据，在Spring Boot中，对应的配置项一定要以token, password, secret结尾，这样敏感信息会以多个星号代替，防止信息泄露。

[Secret Service接口](https://github.com/alibaba-rsocket-broker/reactive-service-specification-proposals/blob/master/src/main/java/com/alibaba/reactive/security/SecretService.java)
适配的产品列表包括：
* Vault
* Envoy Secret Discovery Service

### Authentication Service
各种接入的认证服务，如JWT, basic, SAML等

[Authenticate Service接口](https://github.com/alibaba-rsocket-broker/reactive-service-specification-proposals/blob/master/src/main/java/com/alibaba/reactive/security/AuthenticateService.java)

* Basic: username & password
* JWT
* SAML

### RPC
方便Reactive System访问之前的RPC服务。由于并发模型不一样，这个应用和Broker分开部署。

[RPC Proxy接口](https://github.com/alibaba-rsocket-broker/reactive-service-specification-proposals/blob/master/src/main/java/com/alibaba/reactive/rpc/RpcProxy.java)

注意事项：

* 有返回值： Mono.fromCallable()
* void返回: Mono.fromRunnable()
* 空值处理: Mono.justOrEmpty(null)

适配的产品列表包括：

* Dubbo
* HSF
* gRPC
* Thrift

### Observability
主要包括 metrics, tracing & logging

##### Metrics

Metrics流式采集接口，通过反向反向流式接口访问。 定时采集的话，可以考虑interval，防止数据发送的太多。

[Metrics Stream接口](https://github.com/alibaba-rsocket-broker/reactive-service-specification-proposals/blob/master/src/main/java/com/alibaba/reactive/observability/MetricsStream.java)

Formats:
* text format: https://github.com/prometheus/docs/blob/master/content/docs/instrumenting/exposition_formats.md
* protobuf format: https://github.com/OpenObservability/OpenMetrics/blob/master/protos/prometheus.proto

适配的产品列表包括：

* Prometheus
* HiTSDB

### Feature Toggle Manager
Feature Toggle是一些产品非常看重的特性，如A/B测试，分流测试等。

[FeatureToggleManager](https://github.com/alibaba-rsocket-broker/reactive-service-specification-proposals/blob/master/src/main/java/com/alibaba/reactive/toggle/FeatureToggleManager.java)

适配的产品列表包括：

* FF4J(积极): https://ff4j.github.io/
* Togglz(停止): https://www.togglz.org/
* ConfigCat(商业): https://configcat.com/

### References

* Confluent Connectors https://www.confluent.io/hub/
* Alpakka: https://doc.akka.io/docs/alpakka/current/
* Camel Components: http://camel.apache.org/components.html
* Spring Integration: https://docs.spring.io/spring-integration/docs/5.1.2.RELEASE/reference/html/
* Liiklus: Reactive (RSocket/gRPC) Gateway for the event-based systems https://github.com/bsideup/liiklus
