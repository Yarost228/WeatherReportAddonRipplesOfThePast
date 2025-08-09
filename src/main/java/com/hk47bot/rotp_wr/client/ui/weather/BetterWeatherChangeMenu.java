package com.hk47bot.rotp_wr.client.ui.weather;

import com.github.standobyte.jojo.client.InputHandler;
import com.google.common.collect.Lists;
import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import com.hk47bot.rotp_wr.network.AddonPackets;
import com.hk47bot.rotp_wr.network.BetterWeatherChangePacket;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;


import java.util.List;
import java.util.Optional;

public class BetterWeatherChangeMenu extends Screen {
    private Optional<WeatherType> currentlyHovered = Optional.empty();
    private static final int ALL_SLOTS_WIDTH = WeatherType.values().length * 30 - 5;
    private int firstMouseX;
    private int firstMouseY;
    private boolean setFirstMousePos;
    private final List<SelectorWidget> slots = Lists.newArrayList();
    private static final ITextComponent SELECT_WEATHER_TYPE = new TranslationTextComponent("rotp_wr.select_weather_type", (new TranslationTextComponent("rotp_wr.select_weather_type")).withStyle(TextFormatting.AQUA));
    public static final ResourceLocation WEATHER_CHANGE_MENU = new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "textures/gui/better_weather_change_gui.png");
    public BetterWeatherChangeMenu(){
        super(NarratorChatListener.NO_TITLE);
    }

    public static void openWindowOnClick(LivingEntity user) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.screen == null && user == mc.player) {
            Screen screen = new BetterWeatherChangeMenu();
            mc.setScreen(screen);
        }
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
    @Override
    public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers) {
        InputHandler.MouseButton button = InputHandler.MouseButton.getButtonFromId(pKeyCode);
        if (button == InputHandler.MouseButton.LEFT){
            return true;
        }
        return super.keyPressed(pKeyCode, pScanCode, pModifiers);
    }
    protected void init() {
        super.init();
        this.currentlyHovered = WeatherType.getFromWeatherType(WeatherType.CLEAR);
        for (int i = 0; i < WeatherType.VALUES.length; ++i) {
            WeatherType type = WeatherType.VALUES[i];
            this.slots.add(new SelectorWidget(type, this.width / 2 - ALL_SLOTS_WIDTH / 2 + i * 30, this.height / 2 - 30));
        }
    }


    public void render(MatrixStack matrixStack, int x, int y, float p_230430_4_) {
            matrixStack.pushPose();
            RenderSystem.enableBlend();
            this.minecraft.getTextureManager().bind(WEATHER_CHANGE_MENU);
            matrixStack.popPose();
            super.render(matrixStack, x, y, p_230430_4_);
            this.currentlyHovered.ifPresent((weatherType) -> drawCenteredString(matrixStack, this.font, weatherType.getName(), this.width / 2, this.height / 2 - 30 - 20, -1));
            drawCenteredString(matrixStack, this.font, SELECT_WEATHER_TYPE, this.width / 2, this.height / 2 + 5, 16777215);
            if (!this.setFirstMousePos) {
                this.firstMouseX = x;
                this.firstMouseY = y;
                this.setFirstMousePos = true;
            }

            boolean flag = this.firstMouseX == x && this.firstMouseY == y;

            for(SelectorWidget selectorWidget : this.slots) {
                selectorWidget.render(matrixStack, x, y, p_230430_4_);
                this.currentlyHovered.ifPresent((type) -> selectorWidget.setSelected(type == selectorWidget.icon));
                if (!flag && selectorWidget.isHovered()) {
                    this.currentlyHovered = Optional.of(selectorWidget.icon);
                }
            }
        }
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int buttonId) {
        if (super.mouseClicked(mouseX, mouseY, buttonId)) {
            return true;
        }
        InputHandler.MouseButton button = InputHandler.MouseButton.getButtonFromId(buttonId);
        if (button == InputHandler.MouseButton.LEFT){
            switchToHoveredWeatherTypeAndClose(this.minecraft, this.currentlyHovered);
        }
        return false;
    }
    private void switchToHoveredWeatherTypeAndClose(Minecraft minecraft, Optional<WeatherType> hovered) {
        if (hovered.isPresent()) {
            AddonPackets.sendToServer(new BetterWeatherChangePacket(hovered.get().getWeatherType()));
            minecraft.setScreen(null);
        }
    }
    public enum WeatherType {
        CLEAR(new TranslationTextComponent("weatherType.clear"), "betterweather-none"),
        RAIN(new TranslationTextComponent("weatherType.rain"), "betterweather-rain"),
        THUNDERING(new TranslationTextComponent("weatherType.thundering"), "betterweather-thundering"),
        CLOUDY(new TranslationTextComponent("weatherType.cloudy"), "betterweather-cloudy"),
        CLOUDY_THUNDERING(new TranslationTextComponent("weatherType.cloudy_thundering"), "betterweather-cloudy_thundering"),
        BLIZZARD(new TranslationTextComponent("weatherType.blizzard"), "betterweather-blizzard"),
        BLIZZARD_THUNDERING(new TranslationTextComponent("weatherType.blizzard_thundering"), "betterweather-blizzard_thundering"),
        ACID_RAIN(new TranslationTextComponent("weatherType.acid_rain"), "betterweather-acid_rain"),
        ACID_RAIN_THUNDERING(new TranslationTextComponent("weatherType.acid_rain_thundering"), "betterweather-acid_rain_thundering");

        public static final BetterWeatherChangeMenu.WeatherType[] VALUES = values();
        final ITextComponent name;
        final String weatherType;

        private void drawIcon(WeatherType type, MatrixStack matrixStack, int x, int y) {
            WeatherIcon.renderIcon(type, matrixStack , x, y);
        }
        WeatherType(ITextComponent name, String weatherType){
            this.name = name;
            this.weatherType = weatherType;
        }
        public ITextComponent getName() {
            return this.name;
        }

        public String getWeatherType() {
            return this.weatherType;
        }

        private static Optional<WeatherType> getFromWeatherType(WeatherType type) {
            switch(type) {
                case CLEAR:
                    return Optional.of(CLEAR);
                case RAIN:
                    return Optional.of(RAIN);
                case THUNDERING:
                    return Optional.of(THUNDERING);
                case CLOUDY:
                    return Optional.of(CLOUDY);
                case CLOUDY_THUNDERING:
                    return Optional.of(CLOUDY_THUNDERING);
                case BLIZZARD:
                    return Optional.of(BLIZZARD);
                case BLIZZARD_THUNDERING:
                    return Optional.of(BLIZZARD_THUNDERING);
                case ACID_RAIN:
                    return Optional.of(ACID_RAIN);
                case ACID_RAIN_THUNDERING:
                    return Optional.of(ACID_RAIN_THUNDERING);
                default:
                    return Optional.empty();
            }
        }
    }
    public class SelectorWidget extends Widget {
        private final WeatherType icon;
        private boolean isSelected;
        public SelectorWidget(WeatherType type, int x, int y) {
            super(x, y, 25, 25, type.getName());
            this.icon = type;
        }
        public void renderButton(MatrixStack matrixStack, int x, int y, float p_230431_4_) {
            Minecraft minecraft = Minecraft.getInstance();
            this.drawSlot(matrixStack, minecraft.getTextureManager());
            this.icon.drawIcon(icon, matrixStack, this.x, this.y);
            if (this.isSelected) {
                this.drawSelection(matrixStack, minecraft.getTextureManager());

            }

        }

        public boolean isHovered() {
            return super.isHovered() || this.isSelected;
        }

        public void setSelected(boolean selected) {
            this.isSelected = selected;
            this.narrate();
        }

        private void drawSlot(MatrixStack matrixStack, TextureManager textureManager) {
            textureManager.bind(WEATHER_CHANGE_MENU);
            matrixStack.pushPose();
            matrixStack.translate(this.x, this.y, 0.0D);

            blit(matrixStack, 0, 0, 0.0F, 0.0F, 25, 25, 128, 128);
            matrixStack.popPose();
        }

        private void drawSelection(MatrixStack matrixStack, TextureManager textureManager) {
            textureManager.bind(WEATHER_CHANGE_MENU);
            matrixStack.pushPose();
            matrixStack.translate(this.x, this.y, 0.0D);
            blit(matrixStack, 0, 0, 25.0F, 0.0F, 25, 25, 128, 128);
            matrixStack.popPose();
        }
    }
}
