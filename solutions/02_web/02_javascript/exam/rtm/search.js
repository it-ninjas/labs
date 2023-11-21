const USER_DATA_URL =
  "https://raw.githubusercontent.com/it-ninjas/labs/master/static/files/json/chat.json";

async function getUserList() {
  let data = fetch(USER_DATA_URL)
    .then((response) => response.json())
    .catch((e) => {
      console.log(e);
      return { available: [], unavailable: [] };
    });
  return data;
}

export async function buildUsersForChatSelection() {
  let users = await getUserList();
  let unavailableContainer = document.getElementById("rightOut");
  let availableContainer = document.getElementById("rightHere");
  for (let user of users.unavailable) {
    unavailableContainer.appendChild(buildSearchProfileContainer(user, 0));
  }
  for (let user of users.available) {
    availableContainer.appendChild(buildSearchProfileContainer(user, 0));
  }
}

export function hideUsersByTerm(term) {
  for (let user of document.getElementsByClassName("rightProfileContainer")) {
    if (
      user.querySelector(".rightName").innerHTML.toLowerCase().includes(term.toLowerCase())
    ) {
      user.classList.toggle("hidden", false);
    } else {
      user.classList.toggle("hidden", true);
    }
  }
}

function buildSearchProfileContainer(name, hours) {
  let avatarContainer = document.createElement("div");
  avatarContainer.classList.add("smallAvatarContainer");
  let avatar = document.createElement("img");
  avatar.setAttribute("src", "img/avatar.svg");
  avatar.classList.add("clip-circle", "smallAvatar");
  avatarContainer.appendChild(avatar);

  let nameContainer = document.createElement("div");
  nameContainer.classList.add("rightNameContainer");
  let nameDiv = document.createElement("div");
  nameDiv.classList.add("rightName");
  nameDiv.innerHTML = name;
  nameContainer.appendChild(nameDiv);
  let hoursDiv = document.createElement("div");
  hoursDiv.classList.add("timeWorked");
  hoursDiv.innerHTML = "Arbeitszeit (" + hours + ")";
  nameContainer.appendChild(hoursDiv);

  let clockContainer = document.createElement("div");
  let clockImg = document.createElement("img");
  clockImg.setAttribute("src", "img/clock.svg");
  clockImg.classList.add("rightClock");
  clockContainer.appendChild(clockImg);

  let container = document.createElement("div");
  container.classList.add("rightProfileContainer", "d-flex", "flex-row", "p-0");
  container.appendChild(avatarContainer);
  container.appendChild(nameContainer);
  container.appendChild(clockContainer);
  return container;
}
