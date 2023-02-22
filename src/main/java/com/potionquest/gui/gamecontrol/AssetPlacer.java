package com.potionquest.gui.gamecontrol;

import com.potionquest.gui.entity.NPC_Alchemist;
import com.potionquest.gui.entity.NPC_Alchemist_Brother;
import com.potionquest.gui.entity.NPC_Boatman;
import com.potionquest.gui.entity.NPC_Doctor;
import com.potionquest.gui.entity.NPC_Hermit;
import com.potionquest.gui.entity.NPC_Sister;
import com.potionquest.gui.entity.monsters.MonsterPrototype;
import java.io.IOException;

public class AssetPlacer {

  public AssetPlacer() {

  }

  public void setNPC() {

    try {
      GamePanel.npc[0] = new NPC_Doctor();
    } catch (IOException e) {
      e.printStackTrace();
    }
    GamePanel.npc[0].worldX = GamePanel.tileSize * 9;
    GamePanel.npc[0].worldY = GamePanel.tileSize * 40;

    GamePanel.npc[1] = new NPC_Sister();
    GamePanel.npc[1].worldX = GamePanel.tileSize * 8;
    GamePanel.npc[1].worldY = GamePanel.tileSize * 40;

    GamePanel.npc[2] = new NPC_Hermit();
    GamePanel.npc[2].worldX = GamePanel.tileSize * 22;
    GamePanel.npc[2].worldY = GamePanel.tileSize * 78;

    GamePanel.npc[3] = new NPC_Alchemist_Brother();
    GamePanel.npc[3].worldX = GamePanel.tileSize * 49;
    GamePanel.npc[3].worldY = GamePanel.tileSize * 72;

    GamePanel.npc[4] = new NPC_Alchemist();
    GamePanel.npc[4].worldX = GamePanel.tileSize * 66;
    GamePanel.npc[4].worldY = GamePanel.tileSize * 47;
  }

  public void setMonster() {
    GamePanel.monsters[0] = new MonsterPrototype();
    GamePanel.monsters[0].worldX = GamePanel.tileSize * 12;
    GamePanel.monsters[0].worldY = GamePanel.tileSize * 40;
  }
}
