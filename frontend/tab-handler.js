window.tabHandler = (field, value, targetField) => {
  field.addEventListener("keydown", event => {
    if (event.keyCode !== 9) {
      // 9 == tab
      return;
    }

    if (field.value == value) {
      event.preventDefault();
      targetField.focus();
    }
  });
};
