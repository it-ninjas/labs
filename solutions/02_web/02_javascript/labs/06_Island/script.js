import Island from "./island.js";

export const islands = [
  new Island({ name: "Atlantis" }),
  new Island({
    name: "Maldives",
    country: "Maldives",
    imageUrl:
      "https://www.planetware.com/photos-large/SEY/best-islands-maldives.jpg",
  }),
  new Island({
    name: "Bora Bora",
    country: "French Polynesia",
    imageUrl:
      "https://www.planetware.com/photos-large/SEY/best-islands-bora-bora.jpg",
  }),
  new Island({
    name: "Seychelles",
    country: "Seychelles",
    imageUrl:
      "https://www.planetware.com/photos-large/SEY/best-islands-seychelles.jpg",
  }),
  new Island({
    name: "Diomede",
    imageUrl:
      "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Little_Diomede_Island_village.jpeg/1280px-Little_Diomede_Island_village.jpeg",
  }),
];

for (const island of islands) {
  console.info(
    `Explore the island ${island.name} in ${
      island.country ?? "an unknown country"
    }: ${island.imageUrl ?? "no image available :/"}`
  );
}
