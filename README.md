# SportsNewsViewer
Тестовое приложение для просмотра спортивных новостей.

---
### Примеры работы приложения:
- индикация прокрутки новостей; (внизу списка) 
[indicator_load_bottom_feeds.webm](https://github.com/user-attachments/assets/f4081100-15e3-44ec-98b5-cb80dd1198f7)
- полная работа приложения;
https://drive.google.com/file/d/1_rvk9UdQtawvIzO7yAVbw9v8zFZcTqUu/view?usp=sharing

---
### Экраны приложения:
1) со списком новостей;
2) со списком избранных новостей;
3) настроек;
4) с детальной информацией о новости;
   
---
### Технологический стек:
- Single Activity
- MVI + MVVM
- Single Module (но архитектурно готово для Многомодульного)
- Kotlin 2.0
- Compose
- Compose Type-Safe Navigation
- Koin
- Coil
- Ktor-client
- Jetpack Navigation - TypeSafe;
- KSP
- Room
- Paging
- DataStore
  
---
### Особенности:
- рефреш списка с новостями при протягивании сверху вниз;
- индикация загрузки информации;
- добавлена иконка приложения;
- изменение иконки удалить/добавить новость в список избарнного;
- получение списка избранных новостей в упорядоченном по дате порядке;
- добавлена пагинация на экран "Новости". Так же оставлен метод для не пагинационной загрузки;
- при пагинации новостей - снизу идет индикация подгрузки;
- при переходе на экран Детальной информации новости и возврат обратно - сохраняется положение списка;
- добавлено диалоговое окно при пыпотке полностью очистить список избранного;
- добавлена возможность включения темной темы, с сохранением после перезапуска приложения;
  
---
### Cборка приложения:
- дебаг сборка приложения; 
https://drive.google.com/file/d/1or40QT5hYkeapyT8j_qEoXs93gfmN2nf/view?usp=sharing
---

### WARNING ###
- при копировании к себе учесть, что используется AGP версии 8.7.0-beta01 (версия AS - Ladybug | 2024.2.1 Beta 1);
- проект одномодульный т.к. я делал его один и для ускроения процесса разработки, но его можно легко разбить на многомодульный;
- над темной темой особо не работал, только показал, что она работает и сохраянется выбор при перезапуске приложения;
  
---
### Контакты:
- tg: @Mys_ya
