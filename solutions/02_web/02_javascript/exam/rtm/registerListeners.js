import { toggleCollapse, toggleRotate } from "./collapse.js";
import { updateUserInfo } from "./dashboard.js";
import { buildUsersForChatSelection, hideUsersByTerm } from "./search.js";
import { updateTime } from "./updatetime.js";

export default (() => {
  updateUserInfo();
  (async () => await buildUsersForChatSelection())();
  document
    .getElementById("leftNavbarDropdownButtonAbfragen")
    .addEventListener("click", () => toggleCollapse("abfragen-dropdown"));
  document
    .getElementById("leftNavbarDropdownButtonAbfragen")
    .addEventListener("click", () =>
      toggleRotate("leftNavbarDropdownButtonAbfragen")
    );
  updateTime("headerClockTime");
  setInterval(() => updateTime("headerClockTime"), 10000);
  let refreshButton = document.getElementById("headerSpinnerSymbol");
  refreshButton.addEventListener("click", () => updateUserInfo());
  refreshButton.addEventListener("click", () => updateTime());

  let rightSearchBar = document.getElementById("rightSearch");
  console.log(rightSearchBar);
  rightSearchBar.addEventListener("input", (e) =>
    hideUsersByTerm(document.getElementById("rightSearchInput").value)
  );
})();
