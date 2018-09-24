# Исходники для статьи на Хабре 'Абстрактный CRUD от репозитория до контроллера: что ещё можно сделать при помощи Spring + Generics'
Оригинал статьи находится тут: https://habr.com/post/423741/

Статья описывает архитектуру доступа к репозиторию через REST, при которой для добавления сервисных бинов новой сущности достаточно создать эти бины и переопределить в них один конструктор.

Для этого в каждом слое создаётся один общий интерфейс и одна общая абстракция, параметризированная общей абстрактной сущностью.
