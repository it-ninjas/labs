export function toggleCollapse(containerId) {
  let ele = document.getElementById(containerId);
  if (ele !== null && ele !== undefined) {
    if (ele.classList.contains("collapse_")) {
      ele.classList.toggle("collapse_", false);
      ele.classList.toggle("uncollapse_", true);
    } else {
      ele.classList.toggle("uncollapse_", false);
      ele.classList.toggle("collapse_", true);
    }
  }
}

export function toggleRotate(objectId) {
  let ele = document.getElementById(objectId);
  if (ele !== null && ele !== undefined) {
    ele.classList.toggle("rotateHalf_");
  }
}
