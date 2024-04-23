$(function(){
    console.log("Siden lastes...");
    const id = window.location.search.substring(1);
    const url = "/hentEnBillett?"+id;
    $.get(url,function(billett){
        console.log("Data mottatt:", billett);
        $("#id").val(billett.id);
        $("#film").val(billett.film);
        $("#antall").val(billett.antall);
        $("#fornavn").val(billett.fornavn);
        $("#etternavn").val(billett.etternavn);
        $("#epost").val(billett.epost);
        $("#telefon").val(billett.telefon);
    });
});

function endreBillett() {
    console.log("Endre-knappen klikket");
    const billett = {
        id : $("#id").val(),
        film : $("#film").val(),
        antall : $("#antall").val(),
        fornavn : $("#fornavn").val(),
        etternavn : $("#etternavn").val(),
        epost : $("#epost").val(),
        telefon : $("#telefon").val()
    };
    console.log("Data for endring:", billett);
    $.post("/endreBillett", billett ,function(){
        console.log("Endring fullført");
        window.location.href = 'index.html';
    });
}