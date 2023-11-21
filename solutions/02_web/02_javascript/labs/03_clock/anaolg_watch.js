function createHourMarkings() {
  const hourMarkings = document.getElementById("hourMarkings");
  console.log(document);
  console.log(hourMarkings);
  for (let i = 0; i < 12; i++) {
    const angle = (i * 30 * Math.PI) / 180;
    const x1 = 200 + 130 * Math.sin(angle);
    const y1 = 200 - 130 * Math.cos(angle);
    const x2 = 200 + 160 * Math.sin(angle);
    const y2 = 200 - 160 * Math.cos(angle);

    const line = document.createElementNS("http://www.w3.org/2000/svg", "line");
    line.setAttribute("x1", x1);
    line.setAttribute("y1", y1);
    line.setAttribute("x2", x2);
    line.setAttribute("y2", y2);
    line.classList.add("hour-marking");

    hourMarkings.appendChild(line);
  }
}

function updateClock() {
  const now = new Date();
  const hour = now.getHours() % 12;
  const minute = now.getMinutes();
  const second = now.getSeconds() + now.getMilliseconds() / 1000;

  const hourRotation = ((hour + minute / 60) * 360) / 12;
  const minuteRotation = ((minute + second / 60) * 360) / 60;
  const secondRotation = (second * 360) / 60;

  const hourHand = document.getElementById("hourHand");
  const minuteHand = document.getElementById("minuteHand");
  const secondHand = document.getElementById("secondHand");

  hourHand.setAttribute("transform", `rotate(${hourRotation} 200 200)`);
  minuteHand.setAttribute("transform", `rotate(${minuteRotation} 200 200)`);
  secondHand.setAttribute("transform", `rotate(${secondRotation} 200 200)`);
}

// setTimout because js is executed before content load
setTimeout(() => {
  createHourMarkings();
  setInterval(updateClock, 10);
  updateClock();
}, 1);
