# coding-labs
Spring Boot, H2 DB, JAVA Project
Demonstrating a simple greeting cards templates management system.

How to run via CMD?
mvn spring-boot:run

Operations:

GET templates from catalog:
http://localhost:9009/services/greeting-cards

Response example:

{
    "templates": [
        {
            "id": 1,
            "content": "Happy birthday, %s! from %s."
        },
        {
            "id": 2,
            "content": "Happy holiday to the %s family, from %s and %s."
        },
        {
            "id": 3,
            "content": "Good luck on your %s examine, from %s"
        }
    ]
}

POST create a new card using template:
http://localhost:9009/services/greeting-cards

Request example:

{
    "templateId" : 2,
    "blanksValues" : [ "Cohen", "Avi", "Tzlil" ]
}

Response example:

{
    "card": {
        "content": "Happy holiday to the Cohen family, from Avi and Tzlil."
    }
}

PUT create a new template:
http://localhost:9009/services/greeting-cards

Request example:

{
    "template" : {
        "content" : "hi %s, this is my new template."
    }
}

Response example:

{
    "template": {
        "id": 4,
        "content": "hi %s, this is my new template."
    }
}

Enjoy,
Avi
