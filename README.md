# Rest Template Api
1. Приложение взаимодействует c двумя сторонними сервисами через Rest Template
2. Получает список объектов Пользователь и Вебсайт в формате json через прослойку ДТО
3. Добавляет эти данные в БД, приводя к нужному виду, которые являются сущностями
4. Передаёт через контроллер список Вебсайтов по 10 штук, либо всем списком; список Пользователей


Формат пользователя json:

    "id": 1,
    "name": "Leanne Graham",
    "username": "Bret",
    "email": "Sincere@april.biz",
    "address": {
        "street": "Kulas Light",
        "suite": "Apt. 556",
        "city": "Gwenborough",
        "zipcode": "92998-3874",
        "geo": {
            "lat": "-37.3159",
            "lng": "81.1496"
        }
    },
    "phone": "1-770-736-8031 x56442",
    "website": "hildegard.org",
    "company": {
        "name": "Romaguera-Crona",
        "catchPhrase": "Multi-layered client-server neural-net",
        "bs": "harness real-time e-markets"
    }

Формат вебсайта json:

    "name": "stackoverflow",
    "site_url": "https://stackoverflow.com",
    "favicon_url": "https://cdn.sstatic.net/Sites/stackoverflow/Img/favicon.ico",
    "title": "Stack Overflow",
    "audience": "professional and enthusiast programmers"

