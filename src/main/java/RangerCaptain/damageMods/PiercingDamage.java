package RangerCaptain.damageMods;

import com.evacipated.cardcrawl.mod.stslib.damagemods.AbstractDamageModifier;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class PiercingDamage extends AbstractDamageModifier {

    @Override
    public boolean ignoresBlock(AbstractCreature target) {
        return true;
    }

    @Override
    public boolean isInherent() {
        return true;
    }

    @Override
    public AbstractDamageModifier makeCopy() {
        return new PiercingDamage();
    }
}
