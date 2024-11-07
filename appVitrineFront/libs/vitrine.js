var urlVitrine = "http://localhost:8090/vitrines";

$(document).ready(function() {
    pesquisarVitrines();
})

function pesquisarVitrines() {
    escreverLoadAction();
    $.get(urlVitrine, function (json, status) {
        $("#listaVitrines").html(escreverTabelaVitrine(json));
        removerLoadAction();
    })
}

function escreverTabelaVitrine(json) {
    var html = "";
    html += '<br>';
    html += '<div class="row">';
    html += '<div class="col s6 l4"><label>ID</label></div>';
    html += '<div class="col s6 l3"><label>Data de Início</label></div>';
    html += '<div class="col s6 l3"><label>Data de Finalização</label></div>';
    html += '<div class="col s6 l1"><label>Editar</label></div>';
    html += '<div class="col s6 l1"><label>Excluir</label></div>';
    html += '</div>';
    for (var i = 0; i < json.length; i++) {
        html += '<div class="row">';
        html += '<div class="col s6 l4">' + json[i].id + '</div>';        
        html += '<div class="col s6 l3">' + parseDate(json[i].dataInicio.split("-")) + '</div>';
        html += '<div class="col s6 l3">' + parseDate(json[i].dataFim.split("-")) + '</div>';
        html += '<div class="col s6 l1">';
        html += '<i class="small material-icons blue-text text-darken-2';
        html += ' cursorPointer selectNone" ';
        html += ' onclick="editar(\'' + json[i].id + '\')">edit</i>';
        html += '</div>';
        html += '<div class="col s6 l1">';
        html += '<i class="small material-icons red-text text-darken-2';
        html += ' cursorPointer selectNone" ';
        html += ' onclick="excluir(\'' + json[i].id + '\')">delete_forever</i>';
        html += '</div>';
        html += '</div>';
    }
    return html;
}

function parseDate(arrDate) {
    var ano = parseInt(arrDate[0]);
    var mes = parseInt(arrDate[1]);
    var dia = parseInt(arrDate[2]);

    return dia + '/' + mes + '/' + ano;
}

function editar(id) {
    escreverLoadAction();
    $.get(urlVitrine + "/" + id, function (json, status) {
        preencherFromVitrine(json);
        removerLoadAction();
    })
}

function preencherFromVitrine(json) {
    $("#id").val(json.id);
    $("#dataInicio").val(json.dataInicio);
    $("#dataInicio").focus();
    $("#dataFim").val(json.dataFim);
    $("#dataFim").focus();
}

function excluir(id) {
    escreverLoadAction();
    $.ajax({
        type: "DELETE",
        url: urlVitrine + "/" + id,
        success: function() {
            exibirMensagem("Vitrine " + id + " excluída.");
        },
        complete: function() {
            removerLoadAction();
        }
    })

    location.reload();
}

function salvar() {
    escreverLoadAction();
    var tipo ="POST";
    var url = urlVitrine;
    if($("#id").val().length > 3) {
        tipo = "PUT";
        url = urlVitrine+"/"+$("#id").val();
    }
   
    var dados = JSON.stringify({
        "dataInicio":$("#dataInicio").val(),
        "dataFim":$("#dataFim").val()
    });

    $.ajax({
        type: tipo,
        url: url,
        data: dados,
        contentType: 'application/json',
        success: function (dados) {
            location.reload();
            pesquisarVitrines();
        },
        complete: function () {
            removerLoadAction();
        }
    });
}