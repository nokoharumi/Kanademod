package Kanade;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import java.awt.Color;
import java.nio.charset.StandardCharsets;

import Kanade.cards.AngelPlayer.AttackSkill;
import Kanade.cards.AngelPlayer.GuardSkill;
import Kanade.cards.AngelPlayer.HandSonicVer1;
import Kanade.cards.Defend_Kanade;
import Kanade.cards.Strike_Kanade;
import Kanade.characters.TachibanaKanade;
import Kanade.patches.AbstractCardEnum;
import Kanade.patches.CharacterEnum;
import Kanade.relics.AngelPlayer;
import basemod.BaseMod;
import basemod.DevConsole;
import basemod.ModPanel;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.EditKeywordsSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.ISubscriber;
import basemod.interfaces.PostDungeonInitializeSubscriber;
import basemod.interfaces.PostInitializeSubscriber;

@SpireInitializer
public class Kanade implements EditCardsSubscriber,EditCharactersSubscriber,PostInitializeSubscriber,EditRelicsSubscriber,EditStringsSubscriber,EditKeywordsSubscriber,PostDungeonInitializeSubscriber {
    private static final String MODNAME = "Kanade";
    private static final String AUTHOR = "Nokoharumi";
    private static final String DESCRIPTION = "2018.08.15";

    private static final com.badlogic.gdx.graphics.Color ORANGE = CardHelper.getColor(255, 139, 23);

    public static String kanadeCardImage(final String id) {
        return "images/cards/" + id + ".png";
    }

    public static String kanadeRelicImage(final String id) {
        return "images/relics/" + id + ".png";
    }

    public static String kanadeRelicOutlineImage(final String id) {
        return "images/relics//outline/" + id + ".png";
    }

    public static void initialize(){
        DevConsole.logger.info("=========================初始化角色Mod数据=========================");

        @SuppressWarnings("unused")
        Kanade CharacterName = new Kanade();//初始化角色mod，必备。

        DevConsole.logger.info("===========================角色Mod初始化成功===========================");
    }

    public Kanade(){
        DevConsole.logger.info("============================ 监听初始化事件 ============================");
        BaseMod.subscribe((ISubscriber) this);
        DevConsole.logger.info("============================ 监听初始化事件成功 ============================");
        DevConsole.logger.info("========================正在注入新卡片相关信息========================");
        DevConsole.logger.info("creating the color" + AbstractCardEnum.Kanade.toString());
        BaseMod.addColor(
                AbstractCardEnum.Kanade.toString(),
                ORANGE,
                ORANGE,
                ORANGE,
                ORANGE,
                ORANGE,
                ORANGE,
                ORANGE,
                "images/cards/ui/512/bg_attack_purple.png",
                "images/cards/ui/512/bg_skill_purple.png",
                "images/cards/ui/512/bg_power_purple.png",
                "images/cards/ui/512/card_purple_orb.png",
                "images/cards/ui/1024/bg_attack_purple.png",
                "images/cards/ui/1024/bg_skill_purple.png",
                "images/cards/ui/1024/bg_power_purple.png",
                "images/cards/ui/1024/card_purple_orb.png"
        );
        DevConsole.logger.info("========================注入新卡片相关信息成功========================");
    }

    @SuppressWarnings("deprecation")
    @Override
    public void receivePostInitialize(){
        Texture badgeTexture = new Texture("images/FRelicBadge.png");
        ModPanel settingsPanel = new ModPanel();
        settingsPanel.addLabel("Kanade does not have any settings!", 400.0f, 700.0f, (me) -> {});
        BaseMod.registerModBadge(badgeTexture, MODNAME, AUTHOR, DESCRIPTION, settingsPanel);

        Settings.isDailyRun = false;
        Settings.isTrial = false;
        Settings.isDemo = false;
    }

    @Override
    public void receiveEditCharacters(){
        DevConsole.logger.info("========================正在注入Mod人物信息========================");
        DevConsole.logger.info("add" + CharacterEnum.TachibanaKanade.toString());
        BaseMod.addCharacter(
                (Class) TachibanaKanade.class, "立华奏", "CharacterName class string",
                AbstractCardEnum.Kanade.toString(), "立华奏", "images/ui/charSelect/kanadeButton.png", "images/ui/charSelect/kanadePortrait.jpg",
                CharacterEnum.TachibanaKanade.toString()
        );
        DevConsole.logger.info("========================注入Mod人物信息成功========================");
    }

    @Override
    public void receiveEditRelics(){
        DevConsole.logger.info("=========================正在加载新的遗物内容=========================");
        BaseMod.addRelicToCustomPool(new AngelPlayer(), AbstractCardEnum.Kanade.toString());
//        RelicLibrary.add((AbstractRelic)new AngelPlayer());
        DevConsole.logger.info("=========================加载新的遗物内容成功=========================");
    }

    @Override
    public void receiveEditCards() {
        DevConsole.logger.info("=========================正在加载新的卡牌内容=========================");
        BaseMod.addCard((AbstractCard)new Strike_Kanade());
        UnlockTracker.unlockCard("Strike_Kanade");
        BaseMod.addCard((AbstractCard)new Defend_Kanade());
        UnlockTracker.unlockCard("Defend_Kanade");
        BaseMod.addCard((AbstractCard)new AttackSkill());
        UnlockTracker.unlockCard("AttackSkill");
        BaseMod.addCard((AbstractCard)new GuardSkill());
        UnlockTracker.unlockCard("GuardSkill");
        BaseMod.addCard((AbstractCard)new HandSonicVer1());
        UnlockTracker.unlockCard("HandSonicVer1");
        DevConsole.logger.info("=========================加载新的卡牌内容成功=========================");
    }

    @Override
    public void receiveEditStrings(){
        DevConsole.logger.info("=========================正在加载文本信息=========================");

        // RelicStrings
        String relicStrings = Gdx.files.internal("localization/Relics.json").readString(
                String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);
        // CardStrings
        String cardStrings = Gdx.files.internal("localization/Cards.json").readString(
                String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(CardStrings.class, cardStrings);

        DevConsole.logger.info("=========================加载文本信息成功========================");
    }

    @Override
    public void receiveEditKeywords() {
        DevConsole.logger.info("==========================正在注入新的关键字==========================");
        DevConsole.logger.info("==========================注入新的关键字成功==========================");
    }

    @Override
    public void receivePostDungeonInitialize() {
    }
}
