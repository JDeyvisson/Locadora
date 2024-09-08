<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="br.com.locadora.model.Veiculo" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirmar Reserva - Locadora de Carro</title>
    <link rel="icon" href="imagens/caricon.png">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #eaeaea;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 450px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        section {
            margin-bottom: 20px;
        }

        p {
            font-size: 16px;
            color: #555;
        }

        input[type="date"] {
            width: 100%;
            padding: 12px;
            margin: 8px 0;
            border-radius: 6px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            font-size: 15px;
        }

        button {
            width: 100%;
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #45a049;
        }

        .vehicle-info {
            background-color: #f9f9f9;
            padding: 15px;
            border-radius: 8px;
            margin-bottom: 20px;
        }
        
        .vehicle-info p {
            margin: 5px 0;
        }
    </style>
</head>
<body>
    <form action="reservar-carro" method="post">
        <h1>Confirmar Reserva</h1>

        <section class="vehicle-info">
            <h2>Detalhes do Veículo</h2>
            <p>
                <% 
                    Veiculo veiculo = (Veiculo) request.getAttribute("veiculo");
                    if (veiculo != null) {
                %>
                    <strong>Placa:</strong> <%= veiculo.getPlaca() %><br>
                    <strong>Marca:</strong> <%= veiculo.getMarca() %><br>
                    <strong>Modelo:</strong> <%= veiculo.getModelo() %><br>
                    <strong>Ano:</strong> <%= veiculo.getAno() %><br>
                    <strong>Cor:</strong> <%= veiculo.getCor() %><br>
                <% 
                    } else { 
                %>
                    <p>Veículo não encontrado.</p>
                <% 
                    } 
                %>
            </p>
        </section>

        <section>
            <h2>Data de Início</h2>
            <input type="date" name="dataInicio" value="<%= request.getAttribute("dataInicio") %>" required>
        </section>

        <section>
            <h2>Data de Término</h2>
            <input type="date" name="dataTermino" required>
        </section>

        <input type="hidden" name="placa" value="<%= veiculo != null ? veiculo.getPlaca() : "" %>">

        <button type="submit">Confirmar Reserva</button>
    </form>
</body>
</html>
