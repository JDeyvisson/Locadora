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
            background-color: #007bff;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            transition: background-color 0.3s;
        }

        .action-btn:hover {
            background-color: #0056b3;
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
    </style>
</head>
<body>
    <div class="container">
        <h1>Lista de Carros</h1>
        <a href="adicionar-carro.jsp" class="action-btn">Adicionar Carro</a>
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
                   <%for (int i = 0; i < carros.size(); i++) { %>
                        <tr>
                            <td><%=carros.get(i).getPlaca()%></td>
                            <td><%=carros.get(i).getAno()%></td>
                            <td><%=carros.get(i).getCor()%></td>
                            <td><%=carros.get(i).getMarca()%></td>
                            <td><%=carros.get(i).getModelo()%></td>
                            <td><a href="remover-carro?placa=<%= carros.get(i).getPlaca() %>">Remover</a></td>
                        </tr>
                    <%} %>
                </tbody>
            </table>
        </div>
        <a href="login.jsp" class="action-btn">Sair</a>
    </div>
    
</body>
</html>
