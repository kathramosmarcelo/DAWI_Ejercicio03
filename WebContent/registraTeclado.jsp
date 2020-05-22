<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>
<title>Registra Teclado</title>
</head>
<body> 

<div class="container">
<h1>Registra Teclado</h1>
	
	<c:if test="${sessionScope.MENSAJE != null }">
			<div class="alert alert-success" id="success-alert">
	 		   <button type="button" class="close" data-dismiss="alert">x</button>
				${sessionScope.MENSAJE}				
			</div>
	</c:if>
	<c:remove var="MENSAJE"/>

	<form action="registraTecla" id="id_form"> 
			<input type="hidden" name="metodo" value="registra">	
			<div class="form-group">
				<label class="control-label" for="nombre_te">Nombres</label>
				<input class="form-control" type="text" id="nombre_te" name="teclado.nombre_te" placeholder="Ingrese el nombre">
			</div>
			<div class="form-group">
				<label class="control-label" for="color_te">Color</label>
				<input class="form-control" type="text" id="color_te" name="teclado.color_te" placeholder="Ingrese el precio">
			</div>
			<div class="form-group">
				<label class="control-label" for="forma_te">Forma</label>
				<input class="form-control" type="text" id="forma_te" name="teclado.forma_te" placeholder="Ingrese el stock">
			</div>
			<div class="form-group">
				<label class="control-label" for="id_Categoria">Categoria</label>
				<select id="id_Categoria" name="teclado.categoria.idCategoria" class='form-control'>
					<option value=" ">[Seleccione]</option>    
				</select>
		    </div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary" >Crea Producto</button>
			</div>
	</form>
</div>

<script type="text/javascript">
$("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
    $("#success-alert").slideUp(500);
});
</script>

<script type="text/javascript">
	$.getJSON("cargaCategoria",{}, function(data,q,txt){
		$.each(data.lstCategoria, function(key,value){
			$("#id_Categoria").append("<option value='" + value.idCategoria +  "'>" + value.nombre + "</option>")
		})
	});
</script>
	
<script type="text/javascript">
$(document).ready(function() {
    $('#id_form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	nombre_te: {
        		selector :"#nombre_te",
        		validators: {
                    notEmpty: {
                        message: 'El nombre es un campo obligatorio'
                    },
                    stringLength :{
                    	message:'El nombre es de 5 a 100 caracteres',
                    	min : 3,
                    	max : 100
                    }
                }
            },
        	color_te: {
        		selector :"#color_te",
                validators: {
                    notEmpty: {
                        message: 'El color es un campo obligatorio'
                    },
                    stringLength :{
                    	message:'El color es de 5 a 100 caracteres',
                    	min : 3,
                    	max : 100
                    }
                }
            },
            forma_te: {
            	selector :"#forma_te",
                validators: {
                    notEmpty: {
                        message: 'El forma es un campo obligatorio'
                    },
                    stringLength :{
                    	message:'El forma es de 5 a 100 caracteres',
                    	min : 3,
                    	max : 100
                    },
                }
            },
            idCategoria: {
            	selector :"#id_Categoria",
                validators: {
                    notEmpty: {
                        message: 'La categoria es un campo obligatorio'
                    }
                }
            },
          
        }   
    });

    // Validate the form manually
    $('#validateBtn').click(function() {
        $('#id_form').bootstrapValidator('validate');
    });
});
</script>
</body>
</html>




