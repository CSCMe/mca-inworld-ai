package mca.api;

import com.google.common.base.Charsets;
import com.sun.istack.internal.NotNull;
import mca.api.types.APIButton;
import mca.api.types.Gift;
import mca.api.types.SkinsGroup;
import mca.client.gui.component.GuiButtonEx;
import mca.core.MCA;
import mca.entity.EntityVillagerMCA;
import mca.enums.EnumConstraint;
import mca.enums.EnumGender;
import mca.util.Util;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StringUtils;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import org.apache.commons.io.IOUtils;

import javax.annotation.Nullable;
import java.io.InputStream;
import java.util.*;

/**
 * Class API handles interaction with MCA's configurable options via JSON in the resources folder
 */
public class API {
    private static Map<String, Gift> giftMap = new HashMap<>();
    private static Map<String, APIButton[]> buttonMap = new HashMap<>();
    private static List<String> maleNames = new ArrayList<>();
    private static List<String> femaleNames = new ArrayList<>();
    private static List<SkinsGroup> skinGroups = new ArrayList<>();
    private static Random rng;

    /**
     * Performs initialization of the API
     */
    public static void init() {
        rng = new Random();

        //Load skins
        SkinsGroup[] skins = Util.readResourceAsJSON("api/skins.json", SkinsGroup[].class);
        Collections.addAll(skinGroups, skins);

        //Read data from non-JSON files
        loadNames();

        //Read in buttons
        buttonMap.put("main", Util.readResourceAsJSON("api/gui/main.json", APIButton[].class));
        buttonMap.put("interact", Util.readResourceAsJSON("api/gui/interact.json", APIButton[].class));
        buttonMap.put("debug", Util.readResourceAsJSON("api/gui/debug.json", APIButton[].class));

        //Load gifts and assign to the appropriate map with a key value pair and print warnings on potential issues
        Gift[] gifts = Util.readResourceAsJSON("api/gifts.json", Gift[].class);
        for (Gift gift : gifts) {
            if (!gift.exists()) {
                MCA.getLog().warn("Could not find gift item or block in registry: " + gift.getName());
            } else {
                giftMap.put(gift.getName(), gift);
            }
        }
    }

    /**
     * Returns a random skin based on the profession and gender provided.
     *
     * @param profession The VillagerRegistry.VillagerProfession using the skin
     * @param gender     The EnumGender of the skin
     * @return String location of the random skin
     */
    public static String getRandomSkin(VillagerRegistry.VillagerProfession profession, EnumGender gender) {
        // Loop through all skin groups to find the target group
        for (SkinsGroup group : skinGroups) {
            if (group.getGender().equals(gender.getStrName()) && group.getProfession().equals(profession.getRegistryName().toString())) {
                return group.getPaths()[rng.nextInt(group.getPaths().length - 1)];
            }
        }

        MCA.getLog().warn("No skin found for profession: `" + profession.getRegistryName() + "`. A random skin will be generated.");
        SkinsGroup randGroup = skinGroups.get(rng.nextInt(skinGroups.size() - 1));
        while (randGroup.getGender().equals(gender.getStrName())) {
            randGroup = skinGroups.get(rng.nextInt(skinGroups.size() - 1));
        }
        return randGroup.getPaths()[rng.nextInt(randGroup.getPaths().length - 1)];
    }

    /**
     * Returns an API button based on its ID
     *
     * @param id String id matching the targeted button
     * @return Instance of APIButton matching the ID provided
     */
    public static APIButton getButtonById(String id) {
        for (Map.Entry<String, APIButton[]> entry : buttonMap.entrySet()) {
            for (APIButton button : entry.getValue()) {
                if (button.getLangId().equals(id)) {
                    return button;
                }
            }
        }
        return null;
    }

    /**
     * Returns the value of a gift from an ItemStack
     *
     * @param stack ItemStack containing the gift item
     * @return int value determining the gift value of a stack
     */
    public static int getGiftValueFromStack(ItemStack stack) {
        String name = stack.getItem().getRegistryName().toString();
        return giftMap.containsKey(name) ? giftMap.get(name).getValue() : -5;
    }

    /**
     * Returns the proper response type based on a gift provided
     *
     * @param stack ItemStack containing the gift item
     * @return String value of the appropriate response type
     */
    public static String getResponseForGift(ItemStack stack) {
        int value = getGiftValueFromStack(stack);
        return "gift." + (value <= 0 ? "bad" : value <= 5 ? "good" : value <= 10 ? "better" : "best");
    }

    /**
     * Loads names from the names.lang file into the appropriate male or female names list
     */
    private static void loadNames() {
        InputStream inStream = StringUtils.class.getResourceAsStream("/assets/mca/lang/names.lang");

        try {
            // read in all names and process into the correct list
            List<String> lines = IOUtils.readLines(inStream, Charsets.UTF_8);
            lines.stream().filter((l) -> l.contains("name.male")).forEach((l) -> maleNames.add(l.split("\\=")[1]));
            lines.stream().filter((l) -> l.contains("name.female")).forEach((l) -> femaleNames.add(l.split("\\=")[1]));
        } catch (Exception e) {
            MCA.getLog().fatal(e);
            throw new RuntimeException("Failed to load all NPC names from file", e);
        }
    }

    /**
     * Gets a random name based on the gender provided.
     *
     * @param gender The gender the name should be appropriate for.
     * @return A gender appropriate name based on the provided gender.
     */
    public static String getRandomName(@NotNull EnumGender gender) {
        if (gender == EnumGender.MALE) {
            return maleNames.get(rng.nextInt(maleNames.size()));
        } else if (gender == EnumGender.FEMALE) {
            return femaleNames.get(rng.nextInt(femaleNames.size()));
        }

        return "";
    }

    /**
     * Adds API buttons to the GUI screen provided.
     *
     * @param guiKey   String key for the GUI's buttons
     * @param villager Optional EntityVillagerMCA the GuiScreen has been opened on
     * @param player   EntityPlayer who has opened the GUI
     * @param screen   GuiScreen instance the buttons should be added to
     */
    public static void addButtons(String guiKey, @Nullable EntityVillagerMCA villager, EntityPlayer player, GuiScreen screen) {
        // Get the private buttonList from the GuiScreen
        List<GuiButton> buttonList = ObfuscationReflectionHelper.getPrivateValue(GuiScreen.class, screen, "buttonList");

        // Add all buttons found for the provided key
        for (APIButton b : buttonMap.get(guiKey)) {
            GuiButtonEx guiButton = new GuiButtonEx(screen, b);
            buttonList.add(guiButton);

            // Ensure that if a constraint is attached to the button
            if (villager == null && b.getConstraints().size() > 0) {
                MCA.getLog().error("No villager provided for list of buttons with constraints! Button ID:" + b.getLangId());
                continue;
            }

            // Remove the button if we specify it should not be present on constraint failure
            // Otherwise we just mark the button as disabled.
            boolean isValid = b.isValidForConstraint(villager, player);
            if (!isValid && b.getConstraints().contains(EnumConstraint.HIDE_ON_FAIL)) {
                buttonList.remove(guiButton);
            } else if (!isValid) {
                guiButton.enabled = false;
            }
        }
    }

    /**
     * Returns an instance of the button linked to the given ID on the provided GuiScreen
     *
     * @param id     String id of the button desired
     * @param screen GuiScreen containing the button
     * @return GuiButtonEx matching the provided id
     */
    public static Optional<GuiButtonEx> getButton(String id, GuiScreen screen) {
        List<GuiButton> buttonList = ObfuscationReflectionHelper.getPrivateValue(GuiScreen.class, screen, "buttonList");
        Optional<GuiButton> button = buttonList.stream().filter(
                (b) -> b instanceof GuiButtonEx && ((GuiButtonEx) b).getApiButton().getLangId().equals(id)).findFirst();

        if (button.isPresent()) {
            return Optional.of((GuiButtonEx) button.get());
        }
        return Optional.empty();
    }
}