import { islands } from "./script.js";

function displayIslands() {
  const islandsContainer = document.getElementById("islands");
  islands?.forEach((island) => {
    const islandChild = document.createElement("div");
    islandChild.className = "island";
    if (island.name) {
      const nameHeading = document.createElement("h2");
      nameHeading.appendChild(document.createTextNode(island.name));
      islandChild.appendChild(nameHeading);
    }
    if (island.country) {
      const countryHeading = document.createElement("h3");
      countryHeading.appendChild(document.createTextNode(island.country));
      islandChild.appendChild(countryHeading);
    }
    if (island.imageUrl) {
      const islandImage = document.createElement("img");
      islandImage.src = island.imageUrl;
      islandChild.appendChild(islandImage);
    }

    islandsContainer.appendChild(islandChild);
  });
}

displayIslands();
