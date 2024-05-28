

// Selecciona todas las estrellas
var stars = document.querySelectorAll('.star');

// Para cada estrella
stars.forEach(function(star) {
  // Genera valores aleatorios
  var topOffset = Math.random() * 100;
  var fallDelay = Math.random() * 2;
  var fallDuration = Math.random() * 3 + 2;

  // Asigna los valores aleatorios a las propiedades CSS de la estrella
  star.style.setProperty('--top-offset', topOffset + '%');
  star.style.setProperty('--fall-delay', fallDelay + 's');
  star.style.setProperty('--fall-duration', fallDuration + 's');
});