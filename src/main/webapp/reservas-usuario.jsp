<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.locadora.model.Reserva" %>
<% 
    List<Reserva> reservas = (List<Reserva>) request.getAttribute("reservas"); 
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="imagens/caricon.png">
    <title>Minhas Reservas - Locadora de Carros</title>
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

        .btn-cancelar {
            background-color: #dc3545;
        }

        .btn-cancelar:hover {
            background-color: #c82333;
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
        .btn-voltar {
            background-color: #007bff;
        }

        .btn-voltar:hover {
            background-color: #0056b3;
        }

    </style>
</head>
<body>
    <div class="container">
        <h1>Minhas Reservas</h1>
        
        <div class="table-container">
            <table id="reservation-table">
                <thead>
                    <tr>
                        <th>Placa</th>
                        <th>Veículo</th>
                        <th>Data de Início</th>
                        <th>Data de Término</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody id="reservation-list">
                    <% if (reservas != null && !reservas.isEmpty()) {
                        for (Reserva reserva : reservas) { %>
                            <tr>
                                <td><%= reserva.getVeiculo().getPlaca() %></td>
                                <td><%= reserva.getVeiculo().getModelo() %></td>
                                <td><%= reserva.getDataInicio() %></td>
                                <td><%= reserva.getDataTermino() %></td>
                                <td>
                                    <form action="cancelar-reserva" method="post">
                                        <input type="hidden" name="reservaId" value="<%= reserva.getId() %>">
                                        <button type="submit" class="action-btn btn-cancelar">Cancelar</button>
                                    </form>
                                </td>
                            </tr>
                        <% }
                    } else { %>
                        <tr>
                            <td colspan="5">Nenhuma reserva encontrada.</td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
        
        <a href="menu" class="action-btn btn-voltar">Voltar</a>
    </div>
</body>
</html>
