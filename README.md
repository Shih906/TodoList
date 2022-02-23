## 簡介
本專案為針對前後端分離專案實際練習項目，因在網路上看到SpringBoot + Vue的相關技術文章，因此透過實作代辦事項管理系統做為練習。

---

## Backend
本專案以 SpringBoot 作為核心框架，搭建了 Restful Api ，並以 Spring Data JPA + Hibernate 框架實現 CRUD ； 資料庫則選用 MySQL

### 專案建置
透過 Spring Initializr : https://start.spring.io/ 
![image](https://user-images.githubusercontent.com/88469902/145811430-3d7c4503-ed96-4ef8-9edf-cdc0cf8fb511.png)

### application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/todolist?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=mysqlpassword


## Hibernate Properties
# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.naming.physical-strategy= org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl

## sql log
logging.level.org.hibernate.SQL=debug
logging.level.org.hibernate.type=TRACE
logging.level.org.hibernate.type.descriptor.sql=trace

## Server port
server.port=9000
```

### 
---
## FrontEnd
前端部分以 Vue CLI 快速搭建

### 安裝及啟動
* #### 安裝Node.js npm　:　https://nodejs.org/en/
* #### 安裝Vue CLI　:　`npm install -g @vue/cli`
* #### 建立專案　:　`vue create FrontEnd`
* #### 進入該專案目錄　:　`cd FrontEnd`
* #### 啟動Server　:　`npm run serve`

---
## Demo
### 選擇代辦事項
![image](https://github.com/Shih906/TodoList/blob/master/gif/select.gif)

### 新增代辦內容
![image](https://github.com/Shih906/TodoList/blob/master/gif/add.gif)

### 編輯代辦內容
![image](https://github.com/Shih906/TodoList/blob/master/gif/edit.gif)

### 更改代辦至完成
![image](https://github.com/Shih906/TodoList/blob/master/gif/changeStatus.gif)

### 刪除代辦事項
![image](https://github.com/Shih906/TodoList/blob/master/gif/delete.gif)

---
## 開發工具
### Eclipse
連結 : https://www.eclipse.org/downloads/
![image](https://user-images.githubusercontent.com/88469902/145811248-b7b3679d-1675-462a-93a8-d4965be09e01.png)
### VS Code
連結 : https://code.visualstudio.com/
![image](https://user-images.githubusercontent.com/88469902/145811670-29c07a02-36f4-478b-a280-f85c8c01f12b.png)
