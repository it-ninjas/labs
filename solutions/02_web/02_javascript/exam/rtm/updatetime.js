export function updateTime(spanId) {
  let hoursMinutes = document.getElementById(spanId);
  let time = new Date(Date.now());
  hoursMinutes.innerHTML = [time.getHours(), ":", time.getMinutes()].join("");
  document.getElementById("headerDateDay").innerHTML = time.getDate();
  document.getElementById("headerDateInfo").innerHTML = [
    (() => {
      let day = time.getDay();
      switch (day) {
        case 1:
          return "Montag";
        case 2:
          return "Dienstag";
        case 3:
          return "Mittwoch";
        case 4:
          return "Donnerstag";
        case 5:
          return "Freitag";
        case 6:
          return "Samstag";
        case 7:
          return "Sonntag";
        default:
          break;
      }
    })(),
    time.getMonth(),
    "KW X",
  ].join(" ");
  let ar = [1, 2]
}
//
