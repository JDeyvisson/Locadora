<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adicionar Carro - Locadora de Carro</title>
    <link rel="icon" href="imagens/caricon.png">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            max-width: 600px;
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

        form {
            display: flex;
            flex-direction: column;
            margin-bottom: 20px;
        }

        label {
            margin: 10px 0 5px;
        }

        input {
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        button[type="submit"] {
            margin-top: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button[type="submit"]:hover {
            background-color: #0056b3;
        }

        .back-link {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Adicionar Carro</h1>
        <form action="adicionar" method="post">
            <label for="placa">Placa:</label>
            <input type="text" id="placa" name="placa" required>

            <label for="ano">Ano:</label>
            <input type="number" id="ano" name="ano" required>

            <label for="cor">Cor:</label>
            <input type="text" id="cor" name="cor" required>

            <label for="marca">Marca:</label>
            <input type="text" id="marca" name="marca" required>

            <label for="modelo">Modelo:</label>
            <input type="text" id="modelo" name="modelo" required>

            <button type="submit">Adicionar</button>
        </form>
        <div class="back-link">
            <a href="menu.jsp" class="action-btn">Voltar para a Lista de Carros</a>
        </div>
    </div>
</body>
</html>
