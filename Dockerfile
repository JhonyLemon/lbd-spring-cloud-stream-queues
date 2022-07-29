FROM rabbitmq:management-alpine

COPY ./rabbitmq_delayed_message_exchange-3.10.2.ez /opt/rabbitmq/plugins/
RUN rabbitmq-plugins enable rabbitmq_delayed_message_exchange