<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Currency Converter</title>
    <link rel="icon" type="image/x-icon" href="cc.ico">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<style>
    body {
        background: rgb(255,201,225);
        background: -moz-radial-gradient(circle, rgba(255,201,225,1) 0%, rgba(221,221,221,1) 51%, rgba(185,217,255,1) 100%);
        background: -webkit-radial-gradient(circle, rgba(255,201,225,1) 0%, rgba(221,221,221,1) 51%, rgba(185,217,255,1) 100%);
        background: radial-gradient(circle, rgba(255,201,225,1) 0%, rgba(221,221,221,1) 51%, rgba(185,217,255,1) 100%);
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr="#ffc9e1",endColorstr="#b9d9ff",GradientType=1);
    }
</style>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<div class="container-fluid">
    <header>
        <nav class="navbar navbar-expand">
            <div class="container-fluid" style="justify-content: center;">
                <a class="navbar-brand" style="display: flex;" href="#">
                    <img src="cc.png" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
                    <h2>Currency Converter</h2>
                </a>
            </div>
        </nav>
    </header>
    <br>
    <main>
        <form method="get" id="myform" action="Servlet">
            <div class="container" style="width:50%;">
                <div class="card">
                    <div class="card-header">
                        From $
                    </div>
                    <div class="card-body">
                        <div class="input-group mb-3">
                            <input type="text" name="dinput1" id="dinput" class="form-control" aria-label="Dollar amount (with dot and two decimal places)">
                            <button type="submit" id="dbtn" class="btn btn-outline-secondary">Convert</button>
                        </div>

                    </div>
                </div>
                <br>
                <div class="card">
                    <div class="card-header">
                        To
                    </div>
                    <div class="card-body" style="display: grid;">
                        <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                            <input type="radio" class="btn-check" value="Rupees" name="btnradio" id="btnradio1" autocomplete="off" checked>
                            <label class="btn btn-outline-primary" for="btnradio1">Rupees</label>

                            <input type="radio" class="btn-check" value="Yuan" name="btnradio" id="btnradio2" autocomplete="off">
                            <label class="btn btn-outline-primary" for="btnradio2">Yuan</label>

                            <input type="radio" class="btn-check" value="Euro" name="btnradio" id="btnradio3" autocomplete="off">
                            <label class="btn btn-outline-primary" for="btnradio3">Euro</label>
                        </div>
                        <div class="input-group">
                            <input type="text" readonly id="answer" class="form-control">

                        </div>
                    </div>
                </div>
            </div>
        </form>


    </main>
    <footer>

    </footer>
</div>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<script>
    $("#myform").on('submit',function(e){
        e.preventDefault();
        var f =$(this).serialize();
        console.log(f);

        $.ajax({
            url:"Servlet",
            data: f,
            type:'GET',
            success: function (data,textStatus,jqXHR) {

                let y =data.toString();

                    $('#answer').val(y);


            },
            error: function (jqXHR,textStatus,errorThrown){
                //console.log(data);
                //console.log("error");
            }
        })


    })
</script>
</body>
</html>