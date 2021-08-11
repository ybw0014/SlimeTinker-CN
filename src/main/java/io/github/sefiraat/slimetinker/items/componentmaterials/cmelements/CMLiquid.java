package io.github.sefiraat.slimetinker.items.componentmaterials.cmelements;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.componentmaterials.ComponentMaterial;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmelteryMolten;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.enums.ThemeItemType;
import lombok.Getter;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import net.guizhanss.minecraft.slimetinker.utils.LangUtils;
import org.bukkit.inventory.ItemStack;

@Getter
public class CMLiquid {

    private ComponentMaterial parent;
    private final String texture;
    private SlimefunItemStack itemStack;
    private SlimefunItem item;

    public CMLiquid(String texture) {
        this.texture = texture;
    }

    public void setupLiquid(ComponentMaterial parent) {
        this.parent = parent;
        String titName = LangUtils.getMaterialName(parent.getId());
        this.itemStack = ThemeUtils.themedItemStack(
                parent.getId() + "_LIQUID",
                texture,
                ThemeItemType.MOLTEN_METAL,
                "熔融" + titName,
                ThemeUtils.PASSIVE + "熔融态" + titName
        );

        this.item = new SlimefunItem(Categories.MOLTEN_METALS, itemStack, DummySmelteryMolten.TYPE, new ItemStack[] {
                null, null,                             null,
                null, parent.getRepresentativeStack(),  null,
                null, null,                             null
        });
        item.register(SlimeTinker.inst());
    }

}
