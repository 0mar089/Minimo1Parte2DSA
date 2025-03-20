
$(document).ready(GetInfo);

function GetInfo(){
    let url = "/dsaApp/tracks";
    $.get(url, SaveData);

}

function SaveData(data){

    let tbody = $("#Tabla tbody")

    for (let i = 0; i < data.length; i++) {
        let name = data[i].singer;
        let id = data[i].id;
        let title = data[i].title;

        let row = `<tr>
                <td>${name}</td>
                <td>${id}</td>
                <td>${title}</td>
              </tr>`;

        tbody.append(row);
    }
}

