int scale = 40;
int margin = scale-0;
int rounding = 0;
int countx = 0;
int county = 0;
color[][] pixelColor;
void setup() {
  size(1600, 1600);
  //fullScreen();
  drawGrid();
  noStroke();
}
void draw() {
  int x = (mouseX/scale)*scale+margin;
  int y = (mouseY/scale)*scale+margin;
  if (mousePressed && (mouseButton == LEFT)) {
    int indexX = constrain((mouseX/scale), 0, countx-1);
    int indexY = constrain((mouseY/scale), 0, county-1);
    fill(pixelColor[indexX][indexY]);
    rect(x, y, scale-(margin*2), scale-(margin*2), rounding);
  }
  if (mousePressed && (mouseButton == RIGHT)) {
    stroke(0);
    fill(255);
    rect(x, y, scale-(scale*2), scale-(scale*2));
    noStroke();
  }
  if (mousePressed && (mouseButton == CENTER)) {
    drawGrid();
  }
}

void drawGrid() {
  background(255);
  strokeWeight(1);
  stroke(0, 0, 0);
  for (int y = 0; y < height; y+=scale) {
    line(0, y, width, y);
    county++;
  }
  stroke(0, 0, 0);
  for (int x = 0; x < width; x+=scale) {
    line(x, 0, x, height);
    countx++;
  }
  pixelColor = new color[countx][county];
  for (int i = 0; i < pixelColor.length; i++) {
    for (int j = 0; j < pixelColor[i].length; j++) {
      pixelColor[i][j] = color(random(255), random(255), random(255));
    }
  }
}
