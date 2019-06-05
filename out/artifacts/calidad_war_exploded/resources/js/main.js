console.log("hello");

$(function(){

    $("#disponibilidad td").click(function () {
        //console.log($(this).attr("class"));
        //console.log($(this).data("day"));
        //console.log($(this).data("hour"));

        var day = $(this).data("day");
        var hour = $(this).data("hour");

        var selected = $(".selected").length;

        if(selected == 0){
            //Recien se selecciona 1
            $(this).addClass("selected");

        }else if (selected == 1){
            //Ya se selecciono un segundo
            var prev = $(".selected").eq(0);
            console.log("fake");
            console.log(prev.data("hour"));
            console.log(hour);

            if(prev.data("hour") == hour){

                $('#confirmacion-texto').text("Selecciona horas adecuadas");
                $('#confirmacion').modal('show');

            }else{
                console.log(prev.data("hour"));
                console.log(prev.data("day"));
                if(prev.data("day")!=day){
                    $('#confirmacion-texto').text("Selecciona el mismo dia");
                    $('#confirmacion').modal('show');
                }else{


                    if(prev.data("hour") < hour){
                        $(".day-"+day).each(function( index, element ) {
                            if(index > prev.data("hour") && index <= hour) {
                                $(element).addClass("selected");
                            }
                        });
                    }else{
                        $(".day-"+day).each(function( index, element ) {
                            if(index < prev.data("hour") && index >= hour){
                                $(element).addClass("selected");
                            }
                        });
                    }
                    console.log($(".selected").length);
                    $(".selected").addClass("asignado");
                    console.log($(".asignado").length);
                    $(".selected").removeClass("selected");




                }

            }

            //$('#confirmacion').modal('show');

        }else{


        }

        //$(this).addClass("selected");


    });

    $('#confirmacion').on('click', '#ok', function(e) {

        $('#confirmacion').modal('hide');

        /*$.ajax({
            url: "../account/edit/profileimage",
            type: "POST",
            dataType: "json",
            data: {
                "action": 'delete',
                "csrf_token": '<?= $this->e($Csrf_Token); ?>'
            },
            success: function(data) {
                if (data.status === 'error') {
                    // fade modal using ur code
                    $('#confirmDelete').animate({
                        scrollTop: $('#deleteError').offset().top
                    }, 500);
                } else {
                    alert('error found');
                }
            }
        });*/
    });

    $("#guardar").click(function(){
        alert($(".asignado").length);

        if($('.asignado').length > 20) {

            $('#confirmacion-texto').text("Selecciono mas del limite de (20) horas");
            $('#confirmacion').modal('show');
        }


        var arySel = [];

        for (var i = 0; i < $(".asignado").length; i++) {

            var selDay = ($(".asignado").eq(i).data("day"));
            var selHour = ($(".asignado").eq(i).data("hour"));
            if(Array.isArray(arySel[selHour])){
                arySel[selHour].push(selDay);
            }else {
                arySel[selHour] = [];
                arySel[selHour].push(selDay);
            }
        }
        console.log(arySel);

        var usuario_id= 1;
        var categoria_id = 1;
        var horas = 20;
        var intervalos = JSON.stringify(arySel);

        $.ajax({
            url: "/disponibilidad",
            type: "POST",
            dataType: "json",
            data: {
                "usuario": usuario_id,
                "categoria": categoria_id,
                "horas": horas,
                "intervalos": intervalos
            },
            success: function(data) {
                if (data.status === 'error') {
                    // fade modal using ur code

                } else {
                    alert('error found');
                }
            }
        });
    });

});