<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="imagens/caricon.png">
    <title>Login - Locadora de Carros</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 300px;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            margin-bottom: 20px;
            text-align: center;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        .form-group button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            border: none;
            color: #fff;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
        }
        .form-group button:hover {
            background-color: #0056b3;
        }
        .toggle-form {
            text-align: center;
            margin-top: 15px;
        }
        .toggle-form a {
            color: #007bff;
            text-decoration: none;
        }
        .toggle-form a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container" id="login-form">
        <h2>Locadora de Carros</h2>
        <h2>Login</h2>
        <form action="login" method="POST">
            <div class="form-group">
                <label for="login-email">Email:</label>
                <input type="email" id="login-email" name="email" required>
            </div>
            <div class="form-group">
                <label for="login-password">Senha:</label>
                <input type="password" id="login-password" name="password" required>
            </div>
            <div class="form-group">
                <button type="submit">Entrar</button>
            </div>
            <div class="toggle-form">
                <p>Não tem uma conta? <a href="cadastro-usuario.jsp">Cadastre-se</a></p>
            </div>
        </form>
    </div>
</body>
</html>
