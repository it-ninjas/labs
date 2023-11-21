function updateTile(tile, data) {
  let title = tile.querySelector(".cardTitle  > *");
  let imageContainer = tile.querySelector(".cardImage");
  let optionalUnit = tile.querySelector(".cardOptionalUnit");

  title.innerHTML = data["title"] ? data["title"] : "";
  while (imageContainer.hasChildNodes()) {
    imageContainer.removeChild(imageContainer.firstChild);
  }
  let newImage = document.createElement("img");
  newImage.setAttribute("src", "img/" + data["icon"]);
  imageContainer.appendChild(newImage);
  let amount = document.createElement("span");
  amount.innerHTML = " " + data.amount;
  imageContainer.appendChild(amount);

  if (data.action !== null && data.action !== undefined) {
    let optional = document.createElement("a");
    optional.setAttribute("href", data.action.action);
    optional.innerHTML = data.action.title ? data.action.title : "";
    while (optionalUnit.hasChildNodes()) {
      optionalUnit.removeChild(optionalUnit.firstChild);
      optionalUnit.appendChild(optional);
    }
  }
}

function setCurrentWorkingHours(data) {
  document.getElementById("headerReasonCode").innerHTML = data.reason;
  document.getElementById("belowHeaderReasonCode").innerHTML =
    data.organization;
  document.getElementById("headerCenterTime").innerHTML =
    data.time.hours + ":" + data.time.minutes;
}

function setUser(data) {
  let status;
  if (data.available) {
    status = "Anwesend";
  } else {
    status = "Abwesend";
  }
  for (let userNameElement of document.getElementsByClassName("userName")) {
    userNameElement.innerHTML = data.displayName;
  }
  for (let userStatusElement of document.getElementsByClassName("userStatus")) {
    userStatusElement.innerHTML = status;
  }
  for (let reasonElement of document.getElementsByClassName(
    "userStatusReason"
  )) {
    reasonElement.innerHTML = data.reason;
  }
  for (let lastSeen of document.getElementsByClassName("userLastSeen")) {
    lastSeen.innerHTML = data.lastSeen;
  }
}

export async function updateUserInfo() {
  let data = fetch(
    "https://raw.githubusercontent.com/it-ninjas/labs/master/static/files/json/dashboard.json"
  )
    .then(async (response) => {
      data = await response.json();
      let count = 0;
      for (let card of document.getElementsByClassName("regularCard")) {
        if (data.tiles.length - 1 < count) {
          updateTile(card, {
            title: "",
            icon: "",
            amount: "",
            action: null,
          });
        } else {
          updateTile(card, data.tiles[count]);
          count++;
        }
      }
      setCurrentWorkingHours(data.currentWorkingHours);
      setUser(data.user);
    })
    .catch((x) => console.log(x));
}
