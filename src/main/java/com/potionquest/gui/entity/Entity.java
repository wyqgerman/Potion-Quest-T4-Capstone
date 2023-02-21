package com.potionquest.gui.entity;

import com.potionquest.game.Game;
import com.potionquest.gui.gamecontrol.GamePanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Entity {

  //  public int sizeX, sizeY;
  //  public int scaleFactor;
  public int worldX, worldY;

  public BufferedImage[] goUp = new BufferedImage[4];
  public BufferedImage[] goDown = new BufferedImage[4];
  public BufferedImage[] goLeft = new BufferedImage[4];
  public BufferedImage[] goRight = new BufferedImage[4];

  public BufferedImage[] combat = new BufferedImage[4];

  public String direction;
  public int speed;
  public boolean collisionOn = false;
  public int spriteCounter = 0;
  public int spriteNum = 1;
  public int actionTimeOut = 0;
  public String[] dialogues = new String[20];
  public int dialogueIndex = 0;
  public boolean firstChat = true;
//  public boolean keyCharacter = false;

  public Rectangle solidArea = new Rectangle();
//  public int solidAreaDefaultX = -20;
  public int solidAreaDefaultX;
//  public int solidAreaDefaultY = -80;
  public int solidAreaDefaultY;

  public BufferedImage imageFetch(String filePath) {

    BufferedImage image = null;
    try (InputStream inputStream = getClass().getResourceAsStream(filePath)) {

      //noinspection ConstantConditions
      image = ImageIO.read(inputStream);

    } catch (Exception e) {
      e.printStackTrace();
    }
    return image;
  }

  public void setBehavior() {
  }

  public void talk() {

    if (dialogues[dialogueIndex] == null) {
      dialogueIndex = 0;
    }
    GamePanel.ui.currentDialogue = dialogues[dialogueIndex];
    dialogueIndex++;

    switch (GamePanel.player.direction) {
      case "up":
        this.direction = "down";
        break;
      case "down":
        this.direction = "up";
        break;
      case "left":
        this.direction = "right";
        break;
      case "right":
        this.direction = "left";
        break;
    }

  }

  public void update() {

    setBehavior();

    collisionOn = false;
    GamePanel.collider.checkTile(this);
    // add object collision detect here later
    GamePanel.collider.checkTargetsCollision(this);

    // IF COLLISION IS FALSE, ENTITY CAN MOVE
    if (!collisionOn) {
      switch (direction) {
        case "up":
          worldY -= speed;
          break;
        case "down":
          worldY += speed;
          break;
        case "left":
          worldX -= speed;
          break;
        case "right":
          worldX += speed;
          break;
      }
    }

    spriteCounter++;
    if (spriteCounter > 12) {
      if (spriteNum == 1) {
        spriteNum = 2;
      } else if (spriteNum == 2) {
        spriteNum = 3;
      } else if (spriteNum == 3) {
        spriteNum = 1;
      }
      spriteCounter = 0;
    }
  }

  public void draw(Graphics2D g2D) {

    BufferedImage image = null;

    int screenX = worldX - GamePanel.player.worldX + GamePanel.player.screenX;
    int screenY = worldY - GamePanel.player.worldY + GamePanel.player.screenY;

    if (worldX + GamePanel.tileSize > GamePanel.player.worldX - GamePanel.player.screenX
        && worldX - GamePanel.tileSize < GamePanel.player.worldX + GamePanel.player.screenX
        && worldY + GamePanel.tileSize * 2 > GamePanel.player.worldY - GamePanel.player.screenY
        && worldY - GamePanel.tileSize * 2 < GamePanel.player.worldY + GamePanel.player.screenY) {

      switch (direction) {
        case "up":
          image = goUp[spriteNum - 1];
          break;
        case "down":
          image = goDown[spriteNum - 1];
          break;
        case "left":
          image = goLeft[spriteNum - 1];
          break;
        case "right":
          image = goRight[spriteNum - 1];
          break;
      }
    }

    g2D.drawImage(image, screenX, screenY, null);
  }
}
