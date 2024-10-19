# rabbitmq

RabbitMQ Exchange Tiplerinin çalışma stilini anlamak için sırasıyla yapılan işlemleri gerçekleştiriniz.

1- -producer projelerinde terminalden "docker compose up" komutu ile ilgili image oluşturulur. 
2- Ardından -consumer projeleri ayağa kaldırılır.

Örnek postman collection curl : ( ilgili portlar -consumer projelerinden alınmalıdır. )

curl --location 'localhost:8080/sendToA' \
--header 'Content-Type: application/json' \
--data '{
    "id": "3",
    "message": "Sending to A"
}'


![image](https://github.com/user-attachments/assets/748eda83-8f1d-40cc-904e-a4548c69bc73)


![image](https://github.com/user-attachments/assets/b92dbc69-27c2-4a19-ab56-41559b46edb6)

http://localhost:15672/#/ adresine gidin.
guest - guest ile giriş yapın.
Ardından

![image](https://github.com/user-attachments/assets/46ee6cdc-d496-40ea-ba2a-fda92c0cf088)

tıklayınız.

![image](https://github.com/user-attachments/assets/833aa1b9-c944-4ced-850e-84b1c728093d)

![image](https://github.com/user-attachments/assets/7e960bec-728c-48ff-a2fd-1cd830612dae)

![image](https://github.com/user-attachments/assets/66aca052-26e2-4da8-8820-3103e03d1ba1)

![image](https://github.com/user-attachments/assets/52df26db-5a65-4f67-be66-383b5c0b55be)






