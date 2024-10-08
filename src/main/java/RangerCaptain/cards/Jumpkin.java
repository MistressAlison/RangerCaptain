package RangerCaptain.cards;

import RangerCaptain.cards.abstracts.AbstractMultiUpgradeCard;
import RangerCaptain.patches.CustomTags;
import RangerCaptain.util.CardArtRoller;
import RangerCaptain.util.MonsterEnum;
import RangerCaptain.util.Wiz;
import com.megacrit.cardcrawl.cards.tempCards.Miracle;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;
import com.megacrit.cardcrawl.powers.WeakPower;

import static RangerCaptain.MainModfile.makeID;

public class Jumpkin extends AbstractMultiUpgradeCard {
    public final static String ID = makeID(Jumpkin.class.getSimpleName());

    public Jumpkin() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseMagicNumber = magicNumber = 5;
        baseSecondMagic = secondMagic = 1;
        setMonsterData(MonsterEnum.JUMPKIN);
        baseInfo = info = 0;
        tags.add(CustomTags.MAGIC_POISON);
        tags.add(CustomTags.SECOND_MAGIC_WEAK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (info == 0) {
            Wiz.applyToEnemy(m, new PoisonPower(m, p, magicNumber));
            Wiz.applyToEnemy(m, new WeakPower(m, secondMagic, false));
        } else {
            Wiz.forAllMonstersLiving(mon -> {
                Wiz.applyToEnemy(mon, new PoisonPower(mon, p, magicNumber));
                Wiz.applyToEnemy(mon, new WeakPower(mon, secondMagic, false));
            });
        }
    }

    @Override
    public String cardArtCopy() {
        return Miracle.ID;
    }

    @Override
    public CardArtRoller.ReskinInfo reskinInfo(String ID) {
        return new CardArtRoller.ReskinInfo(ID, ORANGE, WHITE, ORANGE, WHITE, false);
    }

    @Override
    public void addUpgrades() {
        addUpgradeData(this::upgrade0);
        addUpgradeData(this::upgrade1);
        setExclusions(0, 1);
    }

    public void upgrade0() {
        baseInfo = info = 1;
        target = CardTarget.ALL_ENEMY;
        name = originalName = cardStrings.EXTENDED_DESCRIPTION[0];
        initializeTitle();
        setMonsterData(MonsterEnum.DRACULEAF);
        tags.add(CustomTags.MAGIC_POISON_AOE);
        tags.remove(CustomTags.MAGIC_POISON);
    }

    public void upgrade1() {
        upgradeMagicNumber(2);
        upgradeSecondMagic(1);
        name = originalName = cardStrings.EXTENDED_DESCRIPTION[1];
        initializeTitle();
        setMonsterData(MonsterEnum.BEANSTALKER);
    }
}