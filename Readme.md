# 📩 Notification Service

The **notification-service** is a Kafka **consumer microservice** that listens for order events from the `order-events` Kafka topic. When a new order is published by the `order-service`, this service reads the message, logs the order details, and sends a notification email to a configured Gmail address.

---

## 🚀 Features

- 📥 **Consumes messages** from Apache Kafka topic `order-events`
- 📝 **Logs** the order information to console
- 📧 **Sends email** notifications using Gmail SMTP

---

## 🧱 Tech Stack

- Java 17
- Spring Boot
- Apache Kafka
- Spring Kafka
- JavaMailSender (SMTP via Gmail)
- Maven
- Docker & Docker Compose

---

## ⚙️ Configuration

The service uses **Gmail SMTP** to send emails. In `application.yml`, configure your Gmail credentials:

⚠️ You must use a Gmail App Password if 2FA is enabled on your account.
```yaml
spring:
  mail:
    host: smtp.gmail.com
    port: 587
    username: your_email@gmail.com
    password: your_gmail_app_password
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true