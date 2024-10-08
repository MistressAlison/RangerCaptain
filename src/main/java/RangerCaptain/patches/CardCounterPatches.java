package RangerCaptain.patches;


import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.actions.common.EnableEndTurnButtonAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import javassist.CtBehavior;

import java.util.ArrayList;

public class CardCounterPatches {
    public static int cardsSurveyedThisTurn;
    public static int cardsSurveyedThisCombat;
    public static int cardsGuidedThisTurn;
    public static int cardsGuidedThisCombat;
    public static int cardsBlessedThisTurn;
    public static int cardsBlessedThisCombat;
    public static int jumpsThisTurn;
    public static AbstractCreature lastAttacker;
    public static final ArrayList<AbstractCard> cardsDrawnThisTurn = new ArrayList<>();
    public static final ArrayList<AbstractCard> cardsDrawnThisCombat = new ArrayList<>();
    public static final ArrayList<AbstractCard> cardsCreatedThisCombat = new ArrayList<>();
    public static final ArrayList<AbstractCard> initialHand = new ArrayList<>();
    public static boolean isInitialDraw;


    @SpirePatch2(clz = GameActionManager.class, method = "clear")
    public static class ResetCounters {
        @SpirePrefixPatch
        public static void reset() {
            cardsSurveyedThisCombat = 0;
            cardsSurveyedThisTurn = 0;
            cardsGuidedThisCombat = 0;
            cardsGuidedThisTurn = 0;
            cardsBlessedThisCombat = 0;
            cardsBlessedThisTurn = 0;
            lastAttacker = null;
            cardsDrawnThisCombat.clear();
            cardsDrawnThisTurn.clear();
            cardsCreatedThisCombat.clear();
            initialHand.clear();
            isInitialDraw = true;
            jumpsThisTurn = 0;
        }
    }

    @SpirePatch2(clz = GameActionManager.class, method = "getNextAction")
    public static class NewTurnCounters {
        @SpireInsertPatch(locator = Locator.class)
        public static void reset() {
            cardsSurveyedThisTurn = 0;
            cardsGuidedThisTurn = 0;
            cardsBlessedThisTurn = 0;
            cardsDrawnThisTurn.clear();
            initialHand.clear();
            isInitialDraw = true;
            jumpsThisTurn = 0;

            for (AbstractMonster m : AbstractDungeon.getMonsters().monsters) {
                AttackCountField.attackedThisTurn.set(m, 0);
            }
        }

        public static class Locator extends SpireInsertLocator {
            @Override
            public int[] Locate(CtBehavior ctBehavior) throws Exception {
                return LineFinder.findInOrder(ctBehavior, new Matcher.MethodCallMatcher(AbstractPlayer.class, "applyStartOfTurnRelics"));
            }
        }
    }

    @SpirePatch2(clz = AbstractPlayer.class, method = "damage")
    public static class GetAttacker {
        @SpirePrefixPatch
        public static void plz(DamageInfo info) {
            if (info.owner instanceof AbstractMonster) {
                lastAttacker = info.owner;
            }
        }
    }


    @SpirePatch2(clz = GameActionManager.class, method = "getNextAction")
    public static class GetInitialDraw {
        @SpireInsertPatch(locator = Locator.class)
        public static void plz() {
            AbstractDungeon.actionManager.addToBottom(new AbstractGameAction() {
                @Override
                public void update() {
                    isInitialDraw = false;
                    this.isDone = true;
                }
            });
        }
        public static class Locator extends SpireInsertLocator {
            @Override
            public int[] Locate(CtBehavior ctBehavior) throws Exception {
                return LineFinder.findInOrder(ctBehavior, new Matcher.NewExprMatcher(EnableEndTurnButtonAction.class));
            }
        }
    }

    @SpirePatch2(clz = AbstractRoom.class, method = "update")
    public static class GetInitialDraw2 {
        @SpireInsertPatch(locator = Locator.class)
        public static void plz() {
            AbstractDungeon.actionManager.addToBottom(new AbstractGameAction() {
                @Override
                public void update() {
                    isInitialDraw = false;
                    this.isDone = true;
                }
            });
        }
        public static class Locator extends SpireInsertLocator {
            @Override
            public int[] Locate(CtBehavior ctBehavior) throws Exception {
                return LineFinder.findInOrder(ctBehavior, new Matcher.MethodCallMatcher(GameActionManager.class, "useNextCombatActions"));
            }
        }
    }

    @SpirePatch2(clz = AbstractMonster.class, method = SpirePatch.CLASS)
    public static class AttackCountField {
        public static SpireField<Integer> attackedThisTurn = new SpireField<>(() -> 0);
        public static SpireField<Integer> attackedThisCombat = new SpireField<>(() -> 0);
    }

    @SpirePatch2(clz = AbstractMonster.class, method = "damage")
    public static class OnDamaged {
        @SpirePrefixPatch
        public static void plz (AbstractMonster __instance, DamageInfo info) {
            if (info.type == DamageInfo.DamageType.NORMAL) {
                AttackCountField.attackedThisTurn.set(__instance, AttackCountField.attackedThisTurn.get(__instance)+1);
                AttackCountField.attackedThisCombat.set(__instance, AttackCountField.attackedThisCombat.get(__instance)+1);
            }
        }
    }
}
