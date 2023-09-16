let x = 0;

function buildCards(zone) {

    $(".spinner-border").removeClass("d-none");

    $.ajax({
        success: function (data) {

            for (const i in data) {
                $(".row-cols-1").append($(`
                    <div class="col py-2">
                        <div class="card bg-light">
                            <div class="card-body">
                                <h4 class="card-title">${data[i]["sightName"]}</h4>
                                <p class="card-text">${data[i]["category"]}</p>
                                <p>
                                    <button class="btn btn-info me-2" type="button" data-bs-toggle="collapse"
                                            data-bs-target="#collapseExample-${x}" aria-expanded="false"
                                            aria-controls="collapseExample-${x}">詳細資訊
                                    </button>
                                    <a href="https://www.google.com/maps/search/?api=1&query=${data[i]["sightName"]}"
                                       class="btn btn-primary" target="_blank">地圖
                                    </a>
                                </p>
                                <div class="collapse" id="collapseExample-${x++}">
                                    <div class="card">
                                        <img class="card-img-top" src="${data[i]["photoURL"]}" alt="">
                                        <div class="card-body">
                                            <p class="card-text">${data[i]["description"]}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                `));
            }

            $(".spinner-border").addClass("d-none");
        },
        url: "SightAPI?zone=" + zone
    });
}

$(document).ready(function () {

    buildCards("全部");

    $(".dropdown-item").on("click", function () {

        $("#dropdownMenuButton").text($(this).text());

        $(".row-cols-1").empty();
        buildCards($(this).text());
    });
});