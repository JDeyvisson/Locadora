<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="br.com.locadora.model.Veiculo" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirmar Reserva</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f5;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h1, h2 {
            color: #333;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        p {
            margin: 10px 0;
            font-size: 16px;
        }

        input[type="date"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 4px;
            border: 1px solid #ccc;
            font-size: 16px;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <form action="reservar-carro" method="post">
        <h1>Confirmar Reserva</h1>

        <h2>Detalhes do Veículo</h2>
        <p>
            <% 
                Veiculo veiculo = (Veiculo) request.getAttribute("veiculo");
                if (veiculo != null) {
                    out.println("Placa: " + veiculo.getPlaca() + "<br>");
                    out.println("Marca: " + veiculo.getMarca() + "<br>");
                    out.println("Modelo: " + veiculo.getModelo() + "<br>");
                    out.println("Ano: " + veiculo.getAno() + "<br>");
                    out.println("Cor: " + veiculo.getCor() + "<br>");
                }
            %>
        </p>

        <h2>Data de Início</h2>
        <input type="date" name="dataInicio" value="<%= request.getAttribute("dataInicio") %>" required>

        <h2>Data de Término</h2>
        <input type="date" name="dataTermino" required>

        <input type="hidden" name="placa" value="<%= veiculo != null ? veiculo.getPlaca() : "" %>">

        <button type="submit">Confirmar Reserva</button>
    </form>
</body>
</html>
