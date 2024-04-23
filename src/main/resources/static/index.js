$(function (){
    hentAlle();
});

function kjopBillett() {
    let film = $("#film").val();
    let antall = $("#antall").val();
    let fornavn = $("#fornavn").val();
    let etternavn = $("#etternavn").val();
    let epost = $("#epost").val();
    let telefon = $("#telefon").val();

    if (film === ""){
        alert("Velg en film");
        return;
    }
    if (parseInt(antall) <= 0) {
        alert("Antall billetter må være større enn null");
        return;
    }
    if (fornavn === "") {
        alert("Oppgi fornavn");
        return;
    }
    if (etternavn === "") {
        alert("Oppgi etternavn");
        return;
    }

    let telefonRegex = /^\d{8}$/;
    if (!telefonRegex.test(telefon)){
        alert("Oppgi et gyldig telefonnummer");
        return;
    }
    let epostRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!epostRegex.test(epost)){
        alert("Oppgi en gyldig epostadresse");
        return;
    }
    const billett = {
        film: film,
        antall: antall,
        fornavn: fornavn,
        etternavn: etternavn,
        epost: epost,
        telefon: telefon
    };

    $.post("/lagre", billett, function () {
        hentAlle();
    });
    $("#film").val(" ");
    $("#antall").val(" ");
    $("#fornavn").val(" ");
    $("#etternavn").val(" ");
    $("#epost").val(" ");
    $("#telefon").val(" ");
}
function hentAlle() {
    $.get("/hentAlle", function (billett){
        formaterData(billett);
    });
}
function formaterData(billett) {
    let ut = "<table class='table-striped table-bordered'><tr><th>Film</th><th>Antall</th><th>Fornavn</th>" +
        "<th>Etternavn</th><th>E-post</th><th>Telefon</th></tr>"
    for (const bill of billett) {
        ut += "<tr>" +
            "<td>" + bill.film + "</td>" +
            "<td>" + bill.antall + "</td>" +
            "<td>" + bill.fornavn + "</td>" +
            "<td>" + bill.etternavn + "</td>" +
            "<td>" + bill.epost + "</td>" +
            "<td>" + bill.telefon + "</td> + " +
            "<td> <a class='btn btn-primary' href='endre.html?id="+bill.id+"'>Endre</a></td>" +
            "<td> <button class='btn btn-danger' onclick='slettEn("+bill.id+")'>Slett</button></td>" +
            "</tr>";
    }
    ut += "</table>";
    $("#resultat").html(ut);
}
function slett() {
    $.get("/slettAlle", function () {
        hentAlle();
    });
}


function slettEn (id) {
    let url = "/slettEn?id=" +id;
    $.get(url, function (){
        hentAlle();
        window.location.href = "/";
    })
}

