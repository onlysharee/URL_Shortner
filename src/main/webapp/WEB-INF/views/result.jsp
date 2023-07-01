<!DOCTYPE html>
<html>
<head>
    <title>URL Shortener - Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-top: 50px;
        }

        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }

        .copy-container {
            display: flex;
            align-items: center;
            margin-top: 10px;
        }

        input[type="text"] {
            flex: 1;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-right: 10px;
        }

        .copy-button {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .copy-button:hover {
            background-color: #0056b3;
        }
    </style>
    <script>
        function copyToClipboard() {
            var copyText = document.getElementById("shortUrl");
            copyText.select();
            copyText.setSelectionRange(0, 99999);
            document.execCommand("copy");
            alert("URL copied to clipboard!");
        }
    </script>
</head>
<body>
    <div class="container">
        <h1>Shortened URL</h1>
        <div class="copy-container">
            <input type="text" id="shortUrl" value="${shortUrl}" readonly>
            <button class="copy-button" onclick="copyToClipboard()">Copy</button>
        </div>
    </div>
</body>
</html>
