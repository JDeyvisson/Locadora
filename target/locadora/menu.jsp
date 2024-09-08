<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.locadora.model.Veiculo" %>
<% List<Veiculo> carros = (List<Veiculo>) request.getAttribute("carros"); %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="imagens/caricon.png">
    <title>Menu - Locadora de Carros</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        .action-btn {
            display: block;
            width: 100%;
            max-width: 200px;
            margin: 10px auto;
            padding: 10px;
            border: none;
            border-radius: 4px;
            color: #fff;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            transition: background-color 0.3s;
        }

        
        .btn-add-car {
            background-color: #28a745;
        }

        .btn-add-car:hover {
            background-color: #218838;
        }

        .table-container {
            max-height: 300px;
            overflow-y: auto;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f4f4f4;
        }

        td {
            background-color: #fff;
        }

        
        .btn-remove {
            background-color: #dc3545;
        }

        .btn-remove:hover {
            background-color: #c82333;
        }

       
        .btn-reserve {
            background-color: #007bff;
        }

        .btn-reserve:hover {
            background-color: #0056b3;
        }

       
        .btn-logout {
            background-color: #6c757d;
        }

        .btn-logout:hover {
            background-color: #5a6268;
        }

        .action-links {
            display: flex;
            gap: 10px;
        }

        form {
            margin: 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Lista de Carros</h1>
        
        <a href="adicionar-carro.jsp" class="action-btn btn-add-car">Adicionar Carro</a>
        <div class="table-container">
            <table id="car-table">
                <thead>
                    <tr>
                        <th>Placa</th>
                        <th>Ano</th>
                        <th>Cor</th>
                        <th>Marca</th>
                        <th>Modelo</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody id="car-list">
                   <% for (int i = 0; i < carros.size(); i++) { %>
                        <tr>
                            <td><%=carros.get(i).getPlaca()%></td>
                            <td><%=carros.get(i).getAno()%></td>
                            <td><%=carros.get(i).getCor()%></td>
                            <td><%=carros.get(i).getMarca()%></td>
                            <td><%=carros.get(i).getModelo()%></td>
                            <td class="action-links">
                                
                                <form action="remover-carro" method="get">
                                    <input type="hidden" name="placa" value="<%= carros.get(i).getPlaca() %>">
                                    <button type="submit" class="action-btn btn-remove">Remover</button>
                                </form>
                                
                                <form action="reservar-carro" method="get">
                                    <input type="hidden" name="placa" value="<%= carros.get(i).getPlaca() %>">
                                    <button type="submit" class="action-btn btn-reserve">Reservar</button>
                                </form>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
        
        <a href="login.jsp" class="action-btn btn-logout">Sair</a>
    </div>
</body>
</html>
