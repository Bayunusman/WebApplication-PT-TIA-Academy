<html>
<head>
    <title>Login</title>
    <style>
        @import url(https://fonts.googleapis.com/css?family=Karla);
        @import url(https://fonts.googleapis.com/css?family=Ubuntu:300);

        body {
            font-family: 'Karla', sans-serif;
            background-image: url('img/test.jpg'); /* Mengubah URL gambar background */
            background-size: cover;
        }

        .wrap {
            padding: 120px 0;
            font-size: 62px;
            color: white; /* Mengubah warna tulisan menjadi putih */
            width: 400px;
            margin: 0 auto;
            text-align: center;
        }

        input {
            font-family: 'Ubuntu', sans-serif;
            font-weight: 300;
            border: 0;
            border-bottom: 1px solid #ff5407;
            width: 100%;
            height: 36px;
            margin-top: 10px;
            margin-bottom: 20px;
            font-size: 26px;
            background-color: #F5F8FD;
            padding: 5px;
        }

        input:focus {
            outline: none;
            box-shadow: none;
            background: #FFEAE2;
        }

        button {
            border: 0;
            background: transparent;
            padding: 5px;
            margin-top: 50px;
            position: relative;
            outline: 0;
        }

        .buttonafter:after {
            content: '';
            display: block;
            position: absolute;
            top: 8px;
            left: 100%;
            width: 0;
            height: 0;
            border-color: transparent transparent transparent #14a03d;
            border-style: solid;
            border-width: 5px;
        }

        .login {
            background: #108BE3;
            color: #FFF;
            float: right;
            cursor: pointer;
        }

        p {
            font-size: 16px;
            color: white; /* Mengubah warna tulisan menjadi putih */
        }

        a {
            color: #108BE3;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>
    <div class='wrap'>
        <h1>Login</h1>
        <form action="LoginAuth" method="post">
            <input id="email" type='text' name='email' size="25" placeholder='Email'>
            <input id="password" type='password' name='password' size="25" placeholder='Password'>
            <button type="submit" class='login'>LOG IN</button>
        </form>
        <p>Belum punya akun? <a href="Register">Silahkan Registrasi</a></p>
    </div>
</body>
</html>
