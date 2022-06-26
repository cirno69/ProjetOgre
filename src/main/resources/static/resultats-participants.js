function getResult() {
    var xhr = new XMLHttpRequest();
    email = document.getElementById('email').value;
    xhr.open("GET", '/admin/api/getResult/' + email, true);
    xhr.onreadystatechange = callback;
    xhr.send();

    function callback() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var response = JSON.parse(xhr.responseText);
            console.log(response);
            if (response['success'] === false) {
                alert(response['error']);
                return;
            }
            fillTable1(response.resultat);
            fillTable2(response.conso);
        } else {
            console.log(xhr.statusText);
        }
    }
}

function fillTable1(jsonData) {
    table = document.getElementById("tableResult");
    table.deleteRow(table.rows.length - 1);
    var row = table.insertRow(-1);
    var x = row.insertCell(-1);
    x.innerHTML = jsonData.id;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.prenom;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.email;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.pays;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.voiturePossede;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.voitureKM;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.voitureEnergie;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.voitureConso;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.voitureKMSeul;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.voitureKMTous;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.voitureRemplacement;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.avionKM;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.trainKM;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.logementAdulte;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.logementEnfant;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.logementType;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.logementSurface;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.chauffageEnergie;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.energieKWH;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.energieFacture;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.pompeChaleur;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.temperatureConfort;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.climatisation;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.climatisationPieces;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.climatisationsTemps;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.bainsOUDouches;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.doucheFrequence;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.doucheDuree;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.bouilloire;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.plaqueCuisson;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.four;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.laveLinge;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.secheLinge;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.laveVaisselle;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.refrigirateur;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.congelateur;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.eclairage;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.vegetalien;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.fruitETLegume;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.produitLaitier;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.oeufs;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.viande;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.canette;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.emballage;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.locaux;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.chat;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.chien;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.cheval;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.equipementNumerique;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.internet;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.videos;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.vetements;

    row = table.insertRow(-1);
    x = row.insertCell(-1);
    x.colSpan = "4";
    x.innerHTML = "Moyenne des résultats";
    for(colonneID=4; colonneID<table.rows[1].getElementsByTagName('td').length; colonneID++) {
        var sum = 0;
        for(var ligneID=1; ligneID<table.rows.length - 1; ligneID++) {
            sum += parseFloat(table.rows[ligneID].getElementsByTagName('td')[colonneID].innerHTML);
        }
        var avg = sum / (table.rows.length - 2);
        x = row.insertCell(-1);
        x.innerHTML = Math.round(avg * 100) / 100;
    }
}


function fillTable2(jsonData) {
    table = document.getElementById("consoResult");
    table.deleteRow(table.rows.length - 1);
    var row = table.insertRow(-1);
    var x = row.insertCell(-1);
    x.innerHTML = jsonData.id;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.voiture;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.avion;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.train;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.chauffage;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.clim;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.tache;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.nutrition;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.eclairage;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.produitBruns;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.marchandise;
    x = row.insertCell(-1);
    x.innerHTML = jsonData.servicePublic;

    row = table.insertRow(-1);
    x = row.insertCell(-1);
    x.innerHTML = "Moyenne des résultats";
    for(colonneID=1; colonneID<table.rows[1].getElementsByTagName('td').length; colonneID++) {
        var sum = 0;
        for(var ligneID=1; ligneID<table.rows.length - 1; ligneID++) {
            sum += parseFloat(table.rows[ligneID].getElementsByTagName('td')[colonneID].innerHTML);
        }
        var avg = sum / (table.rows.length - 2);
        x = row.insertCell(-1);
        x.innerHTML = Math.round(avg * 100) / 100;
    }
}