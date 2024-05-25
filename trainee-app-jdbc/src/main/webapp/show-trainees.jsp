<%@ page import="com.wiley.traineesapp.dto.TraineeDto" %>
<%@ page import="java.util.List" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
   <div>
       <h2>Trainees</h2>
       <table>
           <thead>
           <tr>
               <th>ID</th>
               <th>Name</th>
               <th>Email</th>
               <th>Location</th>
           </tr>
           </thead>
           <tbody>
           <% List<TraineeDto> trainees =(List<TraineeDto>)request.getAttribute("trainees"); %>
          <% for (TraineeDto trainee : trainees) { %>
               <tr>
                   <td><%= trainee.id()%></td>
                   <td><%= trainee.name() %></td>
                   <td><%= trainee.email() %></td>
                   <td><%= trainee.location() %></td>
                    <td><button onclick="deleteTrainee(<%= trainee.id() %>)" class="btn btn-danger">Delete</a></td>
               </tr>
           <% } %>
           </tbody>
       </table>
       </div>
       </body>
       <script>
         let deleteTrainee = (id)=>{
                   if(confirm("Deleting trainee with id: "+id)){
                       window.location.href = "delete-trainee?id=" + id;
                   }
               }               </script>
</html>