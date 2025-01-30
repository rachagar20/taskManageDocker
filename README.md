<img width="497" alt="image" src="https://github.com/user-attachments/assets/8d2d29f9-6613-49b5-b3d1-4f5c4ca5c1cd" />
<strong>What does your java program do?</strong>
<p>I have created a Spring Boot Application called as Task Management. The spring boot application allows us to add tasks including information about the title, description, status, createdDate as well as dueDate of the task. It also allows us to fetch tasks based on the status of the task.The application makes the use of Postgres db to store the data about tasks.</p>

<strong>What does each docker image do?</strong>
<p>There are two docker images being used in this project:
  <ol>
    <li>postgres-->Which is used to run the postgres database for storing the records or data of the tasks.</li>
    <li>spring boot image-->Which is used to run the desired spring boot application which then further connects and accesses the data from db.</li>
  </ol>
</p>

<strong>APIs exposed and details of API's?</strong>
<p>
  <ol>
    <li>GET /tasks?status=""---> This is used to get the list of all tasks. It also accepts optional param that contains the value of status. With the help of this we can fetch either all the PENDING tasks or all the COMPLETED tasks </li>
    <li>POST /tasks---> This is used to post or add a task. It is used to send data about task such as title,description,status,dueDate and createdAt in the form of JSON. This task info is then collected and stored in the postgres db.</li>
  </ol>
</p>
